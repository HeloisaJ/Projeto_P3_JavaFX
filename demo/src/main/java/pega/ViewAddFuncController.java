package pega;
import java.io.IOException;

import Exceptions.CelularException;
import Exceptions.CpfException;
import Exceptions.NomeException;
import Exceptions.SenhaException;
import Exceptions.TurnoException;
import Funcionario.ListaFuncionarios;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import pega.ThrowAlerta;

public class ViewAddFuncController {
    @FXML
    private Button btRegistrar;
    @FXML
    private Button btVoltarlogin;
    @FXML
    private TextField txtnome;
    @FXML
    private TextField txttelefone;
    @FXML
    private TextField txtcpf;
    @FXML
    private TextField txtsenha;
    @FXML
    private TextField txtturno;

    @FXML
    private void btRegistrar() throws IOException{
        try{
            String nome = txtnome.getText();
            String cpf = txtcpf.getText();
            String telefone = txttelefone.getText();
            String senha = txtsenha.getText();
            String turno = txtturno.getText();
            turno = turno.toLowerCase();

            ListaFuncionarios.cadastrarFuncionario(nome, cpf, telefone, turno, senha);
        }
        catch(Exception e){
            //toda vez que quiser lancar um alerta, chamar a classe e a funcao, depois digitar o titulo e a mensagem que querem
            ThrowAlerta.exibirAlertaErro("ERRO", e.getMessage());
        }
    }

    @FXML
    private void btVoltarlogin() throws IOException{
        App.stage.setTitle("Tela inicial");
        App.setRoot("viewinicial");
    }
        
}