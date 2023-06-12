package pega;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ViewClienteController implements inface{
    @FXML
    private Button btSairConta;
    @FXML
    private Button btChequeQuarto;
    @FXML
    private Button btCheckin;
    @FXML
    private Button btCheckout;
    @FXML
    private Button btExibirCheckin;
    @FXML
    private Button btExibirCheckout;
    @FXML
    private Button btExibirTodos;
    @FXML
    private Button btExibirHospedados;
    


    @FXML
    public void onbtChequeQuarto() throws IOException{
        App.setRoot("viewquarto");
    }
    @FXML
    public void btSairConta() throws IOException{
        App.setRoot("viewinicial");
    }

    @FXML
    private void btCheckin() throws IOException{
        App.setRoot("viewcheckin");

    }
    @FXML
    private void btCheckout() throws IOException{
        App.setRoot("viewcheckout");

    }

    @FXML
    private void btExibirCheckin() throws IOException{
        App.stage.setWidth(800);
        App.stage.setHeight(500);
        App.setRoot("viewexibircheckin");

    }
    @FXML
    private void btExibirCheckout() throws IOException{
        App.stage.setWidth(800);
        App.stage.setHeight(500);
        App.setRoot("viewexibircheckout");

    }
    @FXML
    private void btExibirTodos() throws IOException{
        App.stage.setWidth(800);
        App.stage.setHeight(500);
        App.setRoot("viewexibirtodos");

    }
    @FXML
    public void onbtExibirHospedados() throws IOException{
        App.stage.setWidth(800);
        App.stage.setHeight(500);
        App.setRoot("viewexibirhospedes");
    }
    @Override
    public void initialize() {
        System.out.println("Inicializado sistema");
    }
}