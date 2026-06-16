package model;

public class Comida extends Produto {

    private String ingredientes;
    private boolean contemGluten;

    public Comida(String nome, double preco, String ingredientes, boolean contemGluten) {
        super(nome, preco);
        this.ingredientes = ingredientes;
        this.contemGluten = contemGluten;
    }

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
