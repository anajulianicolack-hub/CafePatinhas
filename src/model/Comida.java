package model;

/*Classe que representa uma comida no Café
Herda os atributos e o construtor da classe abstrata Produto*/

public class Comida extends Produto {
    /*Atributos especificos da classe Comida*/
    private String ingredientes;
    private boolean contemGluten;

/*O construtor recebe nome e preço obrigatoriamente(herança da classe mãe)
* além dos atributos da própria classe*/

    public Comida(String nome, double preco, String ingredientes, boolean contemGluten) {
        super(nome, preco);
        this.ingredientes = ingredientes;
        this.contemGluten = contemGluten;
    }
    /*Gets e setters especificos para Comida*/

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public boolean isContemGluten() {
        return contemGluten;
    }

    public void setContemGluten(boolean contemGluten) {
        this.contemGluten = contemGluten;
    }
}
