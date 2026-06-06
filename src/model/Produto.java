package model;

public abstract class Produto { /*classe abstrata, pois é a mãe das classes Bebida e Comida*/

    /*Criamos como protegido para que apenas a Classe Produto e suas filhas (Bebida e Comida) tenham acesso a essas variáveis*/
    protected String nome;
    protected double preco;

    /*O construtor serve para que toda vez que criarmos um objeto do tipo protudo, ele ter que especificar essas
    coisas no seu "nascimento"*/
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    /*gets e setters utilizados para garantir mais segurança no sistema, mostrando (get) e alterando (setter) com segurança*/
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
}
