package pega;
import java.io.IOException;

import Exceptions.CelularException;
import Exceptions.CpfException;
import Exceptions.NomeException;
import Exceptions.SenhaException;
import Exceptions.TurnoException;
import Funcionario.ListaFuncionarios;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    

    public void initialize(){

    }

    @FXML
    private void btRegistrar() throws IOException{
        try{
            String nome = txtnome.getText();
            String telefone = txttelefone.getText();
            String cpf = txtcpf.getText();
            String senha = txtsenha.getText();
            String turno = txtturno.getText();
            turno = turno.toLowerCase();

            ListaFuncionarios.cadastrarFuncionario(nome, telefone, cpf, senha, turno);
        }
        catch (NomeException | CpfException | CelularException | TurnoException | SenhaException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro no cadastro");
            alerta.setHeaderText("Erro nos dados do cadastro");
            alerta.setContentText(e.getMessage());
            alerta.showAndWait();
        }

    }

    @FXML
    private void btVoltarlogin() throws IOException{
        App.stage.setTitle("Tela inicial");
        App.setRoot("viewinicial");
    }
        
}