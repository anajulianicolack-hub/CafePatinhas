package model;

/*Classe Funcionario que herda de Pessoa.*/
public class Funcionario extends Pessoa{

    /*Cargo ocupado pelo funcionário.*/
    private final String cargo;

    /*Construtor utilizado para criar um funcionário com seus dados.*/
    public Funcionario(int id, String nome, String telefone, String cargo) {
        super(id, nome, telefone);
        this.cargo = cargo;
    }

    /*Get para acessar o cargo.*/
    public String getCargo() {
        return cargo;
    }

    /*Implementação do método abstrato da classe Pessoa.*/
    @Override
    public void exibirInformacoes() {
        System.out.println("Funcionário: " + nome);
        System.out.println("Cargo: " + cargo);
    }
}

