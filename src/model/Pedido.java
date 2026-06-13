package model;

public class Pedido {
    /*Atributos privados (segurança do sistema)*/
    private int id;
    private Mesa mesa;

    /*Construtor: todo pedido nasce com um número d eID e uam Mesa*/
    public Pedido(int id, Mesa mesa) {
        this.id = id;
        this.mesa = mesa;
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
}
