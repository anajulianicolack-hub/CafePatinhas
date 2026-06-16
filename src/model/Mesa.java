package model;

public class Mesa {

    private int numero;
    private boolean ocupada;

    public Mesa(int numero) {
        this.numero = numero;
        this.ocupada = false;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public boolean isOcupada() {
        return ocupada;
    }
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}
