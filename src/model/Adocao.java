package model;

import java.time.LocalDate;

public class Adocao {
    protected int clienteId;
    protected int petId;
    private LocalDate dataAdocao;

    public Adocao(int clienteId, int petId) {
        this.clienteId = clienteId;
        this.petId = petId;
        this.dataAdocao = LocalDate.now();
    }

    public int getClienteId() {
        return clienteId;
    }

    public int getPetId() {
        return petId;
    }

    public LocalDate getDataAdocao() {
        return dataAdocao;
    }
}
