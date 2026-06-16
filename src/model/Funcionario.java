package model;

public class Funcionario extends Pessoa{
    private final String cargo;

    public Funcionario(int id, String nome, String telefone, String cargo) {
        super(id, nome, telefone);
        this.cargo = cargo;
    }
    public String getCargo() {
        return cargo;
    }
    public void exibirInformacoes() {
        System.out.println("Funcionário: " + nome);
        System.out.println("Cargo: " + cargo);
    }
}

