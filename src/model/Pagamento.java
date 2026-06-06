package model;

public class Pagamento {

    /*criamos atributos privados para armazenar esse dados sensíveis, assim garantindo
    que outra classe não mexa neles com facilidade*/
    private int idPedido;
    private String formaPagamento;
    private double valorPago;

    // Construtor: Exige os 3 dados para criar o registro do pagamento de uma vez só.
    public Pagamento(int idPedido, String formaPagamento, double valorPago) {
        this.idPedido = idPedido;
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
    }

    // Uma vez que um pagamento é feito, o valor e a forma não devem ser alterados para evitar fraudes no caixa.
    // por isso, não colocamos nenhum setter
    public int getIdPedido() { return idPedido; }
    public String getFormaPagamento() { return formaPagamento; }
    public double getValorPago() { return valorPago; }
}
