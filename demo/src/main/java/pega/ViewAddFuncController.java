package pega;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ViewAddFuncController {
    @FXML
    private Button btRegistrar;
    @FXML
    private Button btVoltarlogin;
    @FXML
    private TextField txtnome;
        @FXML
    private TextField txttelefone;
            @FXML
    private TextField txtcpf;
        @FXML
    private TextField txtsenha;
            @FXML
    private TextField txtturno;
    


        @FXML
    private void btRegistrar() throws IOException{
        //logica do registrar aqui
        String nome=txtnome.getText();
        String telefone=txttelefone.getText();
        String cpf=txtcpf.getText();
        String senha=txtsenha.getText();
        String turno=txtturno.getText();

    }

    @FXML
    private void btVoltarlogin() throws IOException{
        App.stage.setTitle("Tela inicial");
        App.setRoot("viewinicial");
    }
        
}