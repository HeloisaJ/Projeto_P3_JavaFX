package pega;
import java.io.IOException;

import Funcionario.ListaFuncionarios;
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
        try{
            int chave;// usar get na classe controllerquarto pra pegar
            String nome = txtnome.getText();
            String telefone = txttelefone.getText();
            String cpf = txtCPF.getText();
            String quantidadeDiasSTR = txtQuantidadeDias.getText();
            int quantidadeDiasNum = Integer.parseInt(quantidadeDiasSTR);
            String diaSTR = txtDia.getText();
            int diaNum = Integer.parseInt(diaSTR);
            String mesSTR = txtMes.getText();
            int mesNum = Integer.parseInt(mesSTR);
            String anoSTR = txtAno.getText();
            int anoNum = Integer.parseInt(anoSTR);
            

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