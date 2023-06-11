package Funcionario;

import java.util.LinkedList;

import Exceptions.CelularException;
import Exceptions.CpfException;
import Exceptions.FuncionarioException;
import Exceptions.NomeException;
import Exceptions.SenhaException;
import Exceptions.TurnoException;

public class ListaFuncionarios {

private static LinkedList<Funcionario> funcionarios = new LinkedList<>();

    public static void cadastrarFuncionario(String nome, String cpf, String celular, String turno, String senha) throws CpfException, NomeException, CelularException, TurnoException, SenhaException{
        Funcionario novo = new Funcionario(nome, cpf, celular, turno, senha);
        funcionarios.add(novo);
    }

    public static void loginFuncionario(String nome, String senha) throws NomeException, FuncionarioException, SenhaException{
        Funcionario funcionarioParaLogin = new Funcionario(nome, senha);
        int x = buscarFuncionario(funcionarioParaLogin);
        if(x == -2){
            throw new FuncionarioException("A lista de funcionários está vazia, não foi possível realizar esta ação.");
        }
        else if(x == -1){
            throw new FuncionarioException("Funcionário não encontrado, tente novamente.");
        }
    }

    private static int buscarFuncionario(Funcionario x){
        int size = funcionarios.size();
        if(size == 0){
            return -2;
        }
        for(int i = 0; i < size; i++){
            if(funcionarios.get(i).equals(x)){ // preciso por aqui
                return i;
            }
        }
        return -1;
    }

    public static void removerFuncionario(String nome, String senha) throws NomeException, FuncionarioException, SenhaException{
        Funcionario removido = new Funcionario(nome, senha); // Preciso ver isso com Pedro
        int x = buscarFuncionario(removido);
        if(x == -2){
            throw new FuncionarioException("A lista de funcionários está vazia, não foi possível realizar esta ação.");
        }
        else if(x == -1){
            throw new FuncionarioException("Funcionário não encontrado, tente novamente.");
        }
        else{
            funcionarios.remove(x);
        }
    }

    public static LinkedList<Funcionario> getFuncionarios(){
        return funcionarios;
    }
}