package model;

/*Contém apenas a estrutura dos dados da mesa*/
public class Mesa {

    /*Atributos privados*/
    private int numero;
    private boolean ocupada;

    /*Construtor: inicia o num e define a mesa como livre(false)*/

    public Mesa(int numero, boolean ocupada) {
        this.numero = numero;
        this.ocupada = false;
    }

    /*Getters e Setters para o controller utilizar dps*/

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
