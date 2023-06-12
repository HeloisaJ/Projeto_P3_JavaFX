package pega;

import Funcionario.Funcionario;
import Funcionario.ListaFuncionarios;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class ViewExibirFuncController implements Initializable {
    @FXML
    private TableView<Funcionario> tabelaFuncionarios;
    @FXML
    private TableColumn<Funcionario, String> colunaNome;
    @FXML
    private TableColumn<Funcionario, String> colunaCPF;
    @FXML
    private TableColumn<Funcionario, String> colunaTelefone;
    @FXML
    private TableColumn<Funcionario, String> colunaTurno;
     @FXML
    private Button btVoltar;

@Override
public void initialize(URL location, ResourceBundle resources) {
    //associa as colunas aos atributos da classe Funcionario
    colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    colunaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("celular"));
    colunaTurno.setCellValueFactory(new PropertyValueFactory<>("turno"));

//adiciona os objetos da lista encadeada ao TableView
LinkedList<Funcionario> funcionarios = ListaFuncionarios.getFuncionarios();
ObservableList<Funcionario> funcionariosObservable = FXCollections.observableArrayList(funcionarios);
tabelaFuncionarios.setItems(funcionariosObservable);
}

@FXML
private void onbtVoltar() throws IOException{
    App.stage.setWidth(500);
    App.stage.setHeight(500);
    App.setRoot("viewinicial");

}
}