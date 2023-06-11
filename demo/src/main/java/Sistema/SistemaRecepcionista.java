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
        Cliente novo = new Cliente.ClienteBuilder()
            .nome(nome)
            .cpf(cpf)
            .celular(celular)
            .diasDeHospedagem(diasHospedagem)
            .diaDoCheckIn(diaDoCheckIn)
            .tipoCama(tipoCama)
            .chave(chave)
            .extras(extras)
            .build();
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

    public static LinkedList<Cliente> exibirClientesParaCheckInHoje() throws IndexOutOfBoundsException, DataException{
        int size = clientesParaCheckIn.size();
        LinkedList<Cliente> listaExibir = new LinkedList<>();
        for(int i = 0; i < size; i++){ 
            if(compareData(clientesParaCheckIn.get(i).getDiaCheckIn())){ 
                listaExibir.add(clientesParaCheckIn.get(i));
            }
        }
        return listaExibir;
    }

    public static LinkedList<Cliente> exibirClientesHospedados() throws ClienteException{
        LinkedList<Cliente> listaExibir = new LinkedList<>();
        percorrerLista(clientesHospedados, listaExibir);
        return listaExibir;
    }

    public static LinkedList<Cliente> exibirClientesParaCheckOutHoje() throws IndexOutOfBoundsException, DataException{ 
        int size = clientesHospedados.size();
        LinkedList<Cliente> listaExibir = new LinkedList<>();
        for(int i = 0; i < size; i++){
            if(compareData(clientesHospedados.get(i).getDiaDoCheckOut())){ 
                listaExibir.add(clientesHospedados.get(i));
            }
        }
        return listaExibir;
    }

    public static LinkedList<Cliente> exibirTodosOsClientes() throws ClienteException{
        LinkedList<Cliente> listaExibir = new LinkedList<>();
        percorrerLista(clientesParaCheckIn, listaExibir);
        percorrerLista(clientesHospedados, listaExibir);
        return listaExibir;
    }

    private static void percorrerLista(LinkedList<Cliente> lista, LinkedList<Cliente> exibir){
        int size = lista.size();
        for(int i = 0; i < size; i++){
            exibir.add(lista.get(i));
        }
    }
}
