package model;


public class Bebida extends Produto{

    private String tamanho;
    private boolean gelado;
    private String tipo;

    public Bebida(String nome, double preco, String tipo, String tamanho, boolean gelado) {
        super(nome, preco);
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.gelado = gelado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isGelado() {
        return gelado;
    }

    public void setGelado(boolean gelado) {
        this.gelado = gelado;
    }
}
