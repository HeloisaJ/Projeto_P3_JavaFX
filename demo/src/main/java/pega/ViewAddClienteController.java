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
    private TextField txtextra;
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
            String extra = txtextra.getText();
            System.out.println(extra);
            extra = extra.toLowerCase();
            String telefone = txttelefone.getText();
            String cpf = txtCPF.getText();
            String quantidadeDiasSTR = txtQuantidadeDias.getText();
            int quantidadeDiasNum = Integer.parseInt(quantidadeDiasSTR);
            String diaSTR = txtDia.getText();
            int diaNum = Integer.parseInt(diaSTR);
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
            Calendar diaDoCheckIn = new GregorianCalendar(anoNum, mesNum, diaNum);
            SistemaRecepcionista.reserva(nome, cpf, telefone, quantidadeDiasNum, diaDoCheckIn, tipoCama, chave, extra);
            ThrowAlerta.exibirAlertaConfirmacao("SUCESSO", "Novo cliente adicionado com sucesso !");
        }
        catch(NumberFormatException e){
            ThrowAlerta.exibirAlertaErro("ERRO", "Um ou mais campos estão vazios ou com valores inválidos.");
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