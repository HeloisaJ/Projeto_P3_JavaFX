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
        App.stage.setTitle("Tela do login");
        App.setRoot("viewlogin");

    }
    @FXML
    private void onbtremoveFunc() throws IOException{
        App.stage.setTitle("Remoção de funcionario");
        App.setRoot("viewremovefunc");

    }
    @FXML
    private void btAddFunc() throws IOException{
        App.stage.setTitle("Registro de funcionario");
        App.setRoot("viewaddfunc");

    } 


    @FXML
    private void btExibirFunc() throws IOException{
        App.stage.setTitle("Exibição de funcionarios");
        App.setRoot("viewexibirfunc");

    }

    //@Override
    public void initialize(){
        System.out.println("comando inicial");

    }
}