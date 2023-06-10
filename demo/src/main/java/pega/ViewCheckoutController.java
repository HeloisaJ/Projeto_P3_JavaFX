package pega;
import java.io.IOException;

import Sistema.SistemaRecepcionista;
import TipoPessoa.Cliente.Cliente;
import javafx.fxml.FXML;
//import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//import javafx.scene.control.Alert.AlertType;

public class ViewCheckoutController {
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
        try{
            String nomeCliente = txtNome.getText();
            String cpfCliente = txtCPF.getText();
            Cliente n = new Cliente(nomeCliente, cpfCliente);
            double custo = SistemaRecepcionista.checkOut(n);
            ThrowAlerta.exibirAlertaConfirmacao("SUCESSO", "Check out do cliente realizado com sucesso !\nCusto total da estadia desse cliente no hotel: " + custo);
        }
        catch(Exception e){
            ThrowAlerta.exibirAlertaErro("ERRO", e.getMessage());
        }
    }

    @FXML
    private void btVoltarCliente() throws IOException{
        App.setRoot("viewcliente");

    }
}