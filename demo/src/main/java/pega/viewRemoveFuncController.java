package pega;
import java.io.IOException;

import Funcionario.ListaFuncionarios;
import javafx.fxml.FXML;
//import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//import javafx.scene.control.Alert.AlertType;

public class viewRemoveFuncController {
    @FXML
    private Button btVoltarlogin;
    @FXML
    private Button btRemoverFunc;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtSenha;


    @FXML
    private void onBtRemoverFunc() throws IOException{
        try{
            String nomeFuncionario = txtNome.getText();
            String senhaFuncionario = txtSenha.getText();
            ListaFuncionarios.removerFuncionario(nomeFuncionario, senhaFuncionario);
        }
        catch(Exception e){
            ThrowAlerta.exibirAlertaErro("ERRO", e.getMessage());
        }
    }

    @FXML
    private void btVoltarlogin() throws IOException{
        App.setRoot("viewinicial");

    }
}