package pega;
import java.io.IOException;

import Funcionario.ListaFuncionarios;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ViewLoginController {
    @FXML
    private Button btVoltarlogin;
    @FXML
    private Button btLoginLogin;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtSenha;


    @FXML
    private void onBtLoginLogin() throws IOException{
        try{
            String nomeFuncionario = txtNome.getText();
            String senhaFuncionario = txtSenha.getText();
            ListaFuncionarios.loginFuncionario(nomeFuncionario, senhaFuncionario);
            App.setRoot("viewcliente");
        }
        catch (Exception e) {
            ThrowAlerta.exibirAlertaErro("ERRO", e.getMessage());
        } 
    }

    @FXML
    private void btVoltarlogin() throws IOException{
        App.setRoot("viewinicial");

    }
}