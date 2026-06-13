package model;

public class Pagamento {

    private int idPedido;
    private String formaPagamento;
    private double valorPago;

    public Pagamento(int idPedido, String formaPagamento, double valorPago) {
        this.idPedido = idPedido;
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
    }

    public int getIdPedido() { return idPedido; }
    public String getFormaPagamento() { return formaPagamento; }
    public double getValorPago() { return valorPago; }
}
