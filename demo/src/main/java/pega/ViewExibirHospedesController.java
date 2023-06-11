package pega;
import javafx.fxml.Initializable;
import Sistema.SistemaRecepcionista;
import TipoPessoa.Cliente.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class ViewExibirHospedesController implements Initializable{


     @FXML
    private TableView<Cliente> tabelaClientes;
    @FXML
    private TableColumn<Cliente, String> colunaNome;
    @FXML
    private TableColumn<Cliente, String> colunaCPF;
    @FXML
    private TableColumn<Cliente, String> colunaTelefone;
    @FXML
    private TableColumn<Cliente, String> colunaQuarto;
    @FXML
    private TableColumn<Cliente, String> colunaDiaDoCheckIn;
    @FXML
    private TableColumn<Cliente, String> colunaDiaDoCheckOut;
    @FXML
    private TableColumn<Cliente, String> colunaSituacao;
    @FXML
    private Button btVoltarCliente;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //associa as colunas aos atributos da classe Funcionario
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("celular"));
        colunaQuarto.setCellValueFactory(new PropertyValueFactory<>("chave"));
        colunaDiaDoCheckIn.setCellValueFactory(new PropertyValueFactory<>("diaDoCheckIn"));
        colunaDiaDoCheckOut.setCellValueFactory(new PropertyValueFactory<>("diaDoCheckOut"));
        colunaSituacao.setCellValueFactory(new PropertyValueFactory<>("situacao"));

        //adiciona os objetos da lista encadeada ao TableView
        LinkedList<Cliente> clientes = SistemaRecepcionista.exibirClientesParaCheckOutHoje();
        ObservableList<Cliente> clienteObservable = FXCollections.observableArrayList(clientes);
        tabelaClientes.setItems(clienteObservable);
    }


    @FXML
    private void voltarParaViewCliente() throws IOException{
        App.setRoot("viewcliente");
    }
}
