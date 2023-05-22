package pega;
import java.io.IOException;

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
        String nomeFuncionario = txtNome.getText();
        String senhaFuncionario = txtSenha.getText();
        //funcao mudar de tela fica na logica do login quando for certo ir pra area cliente
        App.setRoot("viewcliente");
        

    }

    @FXML
    private void btVoltarlogin() throws IOException{
        App.setRoot("viewinicial");

    }
}