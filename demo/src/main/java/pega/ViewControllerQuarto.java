package pega;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewControllerQuarto {
    @FXML
    private Button btVoltarlogin;
     @FXML
    private Button chequeDisponibilidade;
    @FXML
    private TextField tipoCama;
    @FXML
    private Button registrarClient;
    @FXML 
    private Label Chave;

    
    @FXML
    public void onBtchequeDisponibilidade() {
        String tipoCamaStr = tipoCama.getText();
        int tipoCamaNum = Integer.parseInt(tipoCamaStr);

        if (tipoCamaNum != -1 && tipoCamaNum != -2) {
            registrarClient.setVisible(true);
            Chave.setText("tipoCamaNum");
        } else {
            registrarClient.setVisible(false);
        }
    }
    @FXML
    private void onBtregistrarClient() throws IOException{
        
    }

    @FXML
    private void btVoltarlogin() throws IOException{
        App.setRoot("viewinicial");

    }

    
}
