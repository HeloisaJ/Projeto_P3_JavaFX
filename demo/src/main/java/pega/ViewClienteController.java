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
        App.stage.setTitle("Checagem de quarto");
        App.setRoot("viewquarto");
    }
    @FXML
    public void btSairConta() throws IOException{
        App.stage.setTitle("Tela inicial");
        App.setRoot("viewinicial");
    }

    @FXML
    private void btCheckin() throws IOException{
        App.stage.setTitle("Check in");
        App.setRoot("viewcheckin");

    }
    @FXML
    private void btCheckout() throws IOException{
        App.stage.setTitle("Check out");
        App.setRoot("viewcheckout");

    }

    @FXML
    private void btExibirCheckin() throws IOException{
        App.stage.setTitle("Clientes para check in");
        App.stage.setWidth(800);
        App.stage.setHeight(500);
        App.setRoot("viewexibircheckin");

    }
    @FXML
    private void btExibirCheckout() throws IOException{
        App.stage.setTitle("Clientes para check out");
        App.stage.setWidth(800);
        App.stage.setHeight(500);
        App.setRoot("viewexibircheckout");

    }
    @FXML
    private void btExibirTodos() throws IOException{
        App.stage.setTitle("Todos clientes");
        App.stage.setWidth(800);
        App.stage.setHeight(500);
        App.setRoot("viewexibirtodos");

    }
    @FXML
    public void onbtExibirHospedados() throws IOException{
        App.stage.setTitle("Hospedes");
        App.stage.setWidth(800);
        App.stage.setHeight(500);
        App.setRoot("viewexibirhospedes");
    }
    @Override
    public void initialize() {
        System.out.println("Inicializado sistema");
    }
}