package pega;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ViewInicialController implements inface{
    @FXML
    private Button btLoginFunc;
    @FXML
    private Button btAddFunc;
    @FXML
    private Button btRemoveFunc;
    @FXML
    private Button btExibirFunc;

    @FXML
    public void btLoginFunc() throws IOException{
        App.stage.setTitle("Tela de login");
        App.setRoot("viewlogin");

    }
    @FXML
    private void onbtremoveFunc() throws IOException{
        App.stage.setTitle("Tela de remoção");
        App.setRoot("viewremovefunc");

    }
    @FXML
    private void btAddFunc() throws IOException{
        App.stage.setTitle("Tela de registro");
        App.setRoot("viewaddfunc");

    }

    @FXML
    private void btExibirFunc() throws IOException{
        App.stage.setTitle("Tela de Exibição");
        App.setRoot("viewexibirfunc");

    }

    //@Override
    public void initialize(){
        System.out.println("comando inicial");

    }
}