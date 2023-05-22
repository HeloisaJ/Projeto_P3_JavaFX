package pega;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ViewExibirFuncController {


    @FXML
    private Button btVoltarlogin;

    @FXML
    private void btVoltarlogin() throws IOException{
        App.setRoot("viewinicial");

    }

    
}
