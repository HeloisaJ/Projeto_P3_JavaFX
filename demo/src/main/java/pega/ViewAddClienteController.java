package pega;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import Exceptions.DataException;
import Sistema.SistemaRecepcionista;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ViewAddClienteController {
    @FXML
    private Button btRegistrar;
    @FXML
    private Button btVoltarlogin;
    @FXML
    private TextField txtnome;
    @FXML
    private TextField txttelefone;
    @FXML
    private TextField txtCPF;
    @FXML
    private TextField txtQuantidadeDias;
    @FXML
    private TextField txtDia;
    @FXML
    private TextField txtMes;
    @FXML
    private TextField txtAno;

    @FXML
    private void btRegistrar() throws IOException{
        try{ // Falta os extras
            int chave = ViewControllerQuarto.getChave();// usar get na classe controllerquarto pra pegar
            boolean tipoCama = ViewControllerQuarto.getTipoDaCama();
            String nome = txtnome.getText();
            String telefone = txttelefone.getText();
            String cpf = txtCPF.getText();
            String quantidadeDiasSTR = txtQuantidadeDias.getText();
            int quantidadeDiasNum = Integer.parseInt(quantidadeDiasSTR);
            System.out.println(quantidadeDiasNum);
            String diaSTR = txtDia.getText();
            int diaNum = Integer.parseInt(diaSTR);
            System.out.println(diaNum);
            if(diaNum < 1 || diaNum > 31){
                throw new DataException("Dia inválido! Digite um número entre 1 e 31 !");
            }
            String mesSTR = txtMes.getText();
            int mesNum = Integer.parseInt(mesSTR);
            if(mesNum < 1 || mesNum > 12){
                throw new DataException("Mês inválido! Digite um número entre 1 e 12 !");
            }
            mesNum--;
            String anoSTR = txtAno.getText();
            int anoNum = Integer.parseInt(anoSTR);
            System.out.println(anoNum);
            Calendar diaDoCheckIn = new GregorianCalendar(anoNum, mesNum, diaNum);
            SistemaRecepcionista.reserva(nome, cpf, telefone, quantidadeDiasNum, diaDoCheckIn, tipoCama, chave, 'S');
            ThrowAlerta.exibirAlertaConfirmacao("SUCESSO", "Novo cliente adicionado com sucesso !");
        }
        catch(Exception e){
            //toda vez que quiser lancar um alerta, chamar a classe e a funcao, depois digitar o titulo e a mensagem que querem
            ThrowAlerta.exibirAlertaErro("ERRO", e.getMessage());
        }
    }
    

    @FXML
    private void btVoltarlogin() throws IOException{
        App.stage.setTitle("Tela do cliente");
        App.setRoot("viewcliente");
    }
        
}