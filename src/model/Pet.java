package model;

import interfaces.Adotavel;

public class Pet implements Adotavel {

    protected int id;
    protected String nome;
    protected String raca;
    protected int peso;
    protected String sexo;
    protected boolean adotado;

    public Pet(int id, String nome, String raca, int peso, String sexo, boolean adotado) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.peso = peso;
        this.sexo = sexo;
        this.adotado = adotado;
    }

    @Override
    public void realizarAdocao() {
        if (this.adotado == false) {
            adotado = true;
            System.out.println("Pet " + nome + " foi adotado!!");
        }else{
            System.out.println("Não é possivel adotar o pet " + nome);
        }
    }

    @Override
    public boolean isAdotado() {
        if(adotado == true){
            System.out.println("Pet " + nome + " foi adotado!!");
        }else{
            System.out.println("Pet " + nome + " não está adotado!!");
        }

        return this.adotado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaça(String raca) {
        this.raca = raca;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setAdotado(boolean adotado) {
        this.adotado = adotado;
    }
}