package Funcionario;
import Exceptions.CelularException;
import Exceptions.CpfException;
import Exceptions.NomeException;
import Exceptions.SenhaException;
import Exceptions.TurnoException;
import TipoPessoa.Pessoa;

public class Funcionario extends Pessoa implements FuncionarioInterface{

private String turno;
private String senha;

public Funcionario(String nome, String cpf, String celular, String turno, String senha) throws CpfException, NomeException, TurnoException, SenhaException, CelularException{
    super(nome, cpf, celular);
    ValidacaoFuncionario.validarTurno(turno);
    ValidacaoFuncionario.validarSenha(senha);
    this.turno = turno;
    this.senha = senha;
}

public Funcionario(String nome, String senha) throws NomeException, SenhaException{ //Relacionado a parte de login, criação de uma instância de funcionário para comparar com a lista de funcionários
    super(nome);
    ValidacaoFuncionario.validarSenha(senha);
    this.senha = senha;
}

@Override
public boolean equals(Object n){
    if(this == n){
        return true;
    }
    if(n instanceof Funcionario){
        Funcionario x = (Funcionario) n;
        if(this.nome.equals(x.nome) && this.senha.equals(x.senha)){
            return true;
        }
        else{
            return false;
        }
    }
    else{
        return false;
    }
}

@Override
public String toString(){
    return "Nome do Funcionário: " + this.nome + ", CPF: " + this.cpf + ", Celular: " + this.celular + ", Turno: " + this.turno;
}

public String getNome(){
    return this.nome;
}

public String getCpf(){
    return this.cpf;
}

public String getCelular(){
    return this.celular;
}

public String getTurno(){
    return this.turno;
}
}