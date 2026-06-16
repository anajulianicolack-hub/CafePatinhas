package model;

public class Pedido {

    private int id;
    private Mesa mesa;
    private Comida comida;

    public Pedido(int id, Mesa mesa, Comida comida) {
        this.id = id;
        this.mesa = mesa;
        this.comida = comida;
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
}
