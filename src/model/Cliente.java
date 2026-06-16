package model;

public class Cliente extends Pessoa{
    private int pontosFidelidade;

    public Cliente(int id, String nome, String telefone, int pontosFidelidade) {
        super(id, nome, telefone);
        this.pontosFidelidade = pontosFidelidade;
    }
    public int getPontosFidelidade() {
        return pontosFidelidade;
    }

    public void setPontosFidelidade(int pontosFidelidade) {
        this.pontosFidelidade = pontosFidelidade;
    }
    public void exibirInformacoes() {
        System.out.println("Cliente: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Pontos: " + pontosFidelidade);
    }
}

