package pega;
import java.io.IOException;

import javafx.fxml.FXML;
//import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//import javafx.scene.control.Alert.AlertType;

public class ViewCheckinController {
    @FXML
    private Button btVoltarCliente;
    @FXML
    private Button btCheckin;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCPF;


    @FXML
    private void btCheckin() throws IOException{
        String nomeCliente = txtNome.getText();
        String cpfCliente = txtCPF.getText();

    }

    @FXML
    private void btVoltarCliente() throws IOException{
        App.setRoot("viewcliente");

    }
}