package pega;
import java.io.IOException;

import javafx.fxml.FXML;
//import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//import javafx.scene.control.Alert.AlertType;

public class viewRemoveFuncController {
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
        String nomeFuncionario = txtNome.getText();
        String senhaFuncionario = txtSenha.getText();

    }

    @FXML
    private void btVoltarlogin() throws IOException{
        App.setRoot("viewinicial");

    }
}