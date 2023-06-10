package Sistema;

import java.util.Calendar;
import java.util.LinkedList;

import Exceptions.CelularException;
import Exceptions.ClienteException;
import Exceptions.CpfException;
import Exceptions.DataException;
import Exceptions.NomeException;
import Exceptions.OpcaoExtrasException;
import Quarto.SistemaDeQuartos;
import TipoPessoa.Cliente.Cliente;

public class SistemaRecepcionista { 
    
    private static LinkedList<Cliente> clientesParaCheckIn = new LinkedList<Cliente>();
    private static LinkedList<Cliente> clientesHospedados = new LinkedList<Cliente>();

    /*public SistemaRecepcionista(){
        this.clientesParaCheckIn = new LinkedList<Cliente>();
        this.clientesHospedados = new LinkedList<Cliente>();
    }*/

    public static void reserva(String nome, String cpf, String celular, int diasHospedagem, Calendar diaDoCheckIn, boolean tipoCama, int chave, char extras) throws CpfException, NomeException, DataException, OpcaoExtrasException, CelularException{
        Cliente novo = new Cliente(nome, cpf, celular, diasHospedagem, diaDoCheckIn, tipoCama, chave, extras);
        clientesParaCheckIn.addLast(novo);
    }

    public static void checkIn(Cliente n) throws IndexOutOfBoundsException, DataException, ClienteException{ // n só terá nome e cpf
        int posicao = buscarCliente(n, clientesParaCheckIn);
        if(posicao == -1){
            throw new ClienteException("Cliente não encontrado, tente novamente !");
        }
        else if(!compareData(clientesParaCheckIn.get(posicao).getDiaCheckIn())){
            throw new DataException("Hoje não é o dia do check-in deste cliente !");
        }
        else{
            Cliente novoClienteHospedado = clientesParaCheckIn.get(posicao);
            novoClienteHospedado.setSituacao();
            clientesHospedados.addLast(novoClienteHospedado);
            clientesParaCheckIn.remove(novoClienteHospedado);
        }
    }

    public static double checkOut(Cliente n) throws IndexOutOfBoundsException, DataException, ClienteException{
        int posicao = buscarCliente(n, clientesHospedados);
        if(posicao == -1){
            throw new ClienteException("Cliente não encontrado, tente novamente !");
        }
        else if(!compareData(clientesHospedados.get(posicao).getDiaDoCheckOut())){
            throw new DataException("Hoje não é o dia do check-out deste cliente !");
        }
        else{
            Cliente clienteParaCheckOut = clientesHospedados.get(posicao);
            SistemaDeQuartos.checkOutDoCliente(clienteParaCheckOut.getChave()); 
            clientesHospedados.remove(clienteParaCheckOut); 
            return clienteParaCheckOut.custoTotal();
        }
    }

    private static boolean compareData(Calendar data){
        Calendar hoje = Calendar.getInstance();
        return data.get(Calendar.YEAR) == hoje.get(Calendar.YEAR) && data.get(Calendar.MONTH) == hoje.get(Calendar.MONTH) && data.get(Calendar.DAY_OF_MONTH) == hoje.get(Calendar.DAY_OF_MONTH);
    }

    private static int buscarCliente(Cliente n, LinkedList<Cliente> lista) throws IndexOutOfBoundsException{
        int size = lista.size();
        for(int i = 0; i < size; i++){
            if(lista.get(i).equals(n)){
                return i;
            }
        }
        return -1;
    }

    public static void exibirClientesParaCheckInHoje() throws IndexOutOfBoundsException, DataException{
        int size = clientesParaCheckIn.size();
        if(size == 0){
            throw new IndexOutOfBoundsException("Nenhum cliente para realizar o check-in no momento.");
        }
        else{
            boolean vazio = true;
            for(int i = 0; i < size; i++){ 
                if(compareData(clientesParaCheckIn.get(i).getDiaCheckIn())){ 
                    System.out.println(clientesParaCheckIn.get(i));
                    vazio = false;
                }
            }

            if(vazio){
                throw new DataException("Nenhum cliente com check-in marcado para hoje.");
            }
        }
    }

    public static void exibirClientesHospedados() throws ClienteException{
        if(clientesHospedados.size() == 0){
            throw new ClienteException("Nenhum cliente hospedado no momento.");
        }
        else{
            percorrerLista(clientesHospedados);
        }
    }

    public static void exibirClientesParaCheckOutHoje() throws IndexOutOfBoundsException, DataException{ 
        int size = clientesHospedados.size();
        if(size == 0){
            throw new IndexOutOfBoundsException("Nenhum cliente hospedado no momento.");
        }
        else{
            boolean vazio = true;
            for(int i = 0; i < size; i++){
                if(compareData(clientesHospedados.get(i).getDiaDoCheckOut())){ 
                    System.out.println(clientesHospedados.get(i));
                    vazio = false;
                }
            }

            if(vazio){
                throw new DataException("Nenhum cliente com check-out marcado para hoje.");
            }
        }
    }

    public static void exibirTodosOsClientes() throws ClienteException{
        if(clientesParaCheckIn.size() == 0){
            throw new ClienteException("Nenhum cliente para realizar o check-in no momento.");
        }
        else{
            percorrerLista(clientesParaCheckIn);
        }
        
        exibirClientesHospedados();
    }

    private static void percorrerLista(LinkedList<Cliente> lista){
        int size = lista.size();
        for(int i = 0; i < size; i++){
            System.out.println(lista.get(i));
        }
    }
}
