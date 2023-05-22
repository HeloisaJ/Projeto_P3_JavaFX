package pega;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class viewExibirTodosController {


    @FXML
    private Button btVoltarCliente;

    @FXML
    private void btVoltarCliente() throws IOException{
        App.setRoot("viewcliente");

    }

    
}
