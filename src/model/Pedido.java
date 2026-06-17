package model;

public class Pedido {

    private int id;
    private Mesa mesa;
    private Comida comida;
    private Bebida bebida; // <-- ADICIONEI

    public Pedido(int id, Mesa mesa, Comida comida, Bebida bebida /*<-- ADICIONEI*/) {
        this.id = id;
        this.mesa = mesa;
        this.comida = comida;
        this.bebida = bebida; // <--- ADICIONEI
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Mesa getMesa() {
        return mesa;
    }
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    public Comida getComida() {
        return comida;
    }
    public void setComida(Comida comida) {
        this.comida = comida;
    }
    public Bebida getBebida() { return bebida; } // <-- ADICIONEI
    public void setBebida(Bebida bebida) { this.bebida = bebida; } // <-- ADICIONEI
}
