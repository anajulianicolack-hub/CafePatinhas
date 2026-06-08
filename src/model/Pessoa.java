package model;

public abstract class Pessoa {
    /*Atributos comuns às classes filhas.*/
    protected int id;
    protected String nome;
    protected String telefone;

    /*Construtor utilizado para inicializar os dados da pessoa.*/
    public Pessoa(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    /*Gets para acessar os atributos.*/
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    /*Setters para alterar os atributos.*/
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /*Método abstrato que será implementado nas classes filhas.*/
    public abstract void exibirInformacoes();
}
