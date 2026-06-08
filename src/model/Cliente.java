package model;

public class Cliente extends Pessoa{
    /*Quantidade de pontos acumulados pelo cliente.*/
    private int pontosFidelidade;

    /*Construtor utilizado para criar um cliente com seus dados.*/
    public Cliente(int id, String nome, String telefone, int pontosFidelidade) {
        super(id, nome, telefone);
        this.pontosFidelidade = pontosFidelidade;
    }

    /*Get e Set dos pontos de fidelidade.*/
    public int getPontosFidelidade() {
        return pontosFidelidade;
    }

    public void setPontosFidelidade(int pontosFidelidade) {
        this.pontosFidelidade = pontosFidelidade;
    }

    /*Implementação do método abstrato da classe Pessoa.*/
    public void exibirInformacoes() {
        System.out.println("Cliente: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Pontos: " + pontosFidelidade);
    }
}

