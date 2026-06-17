package model;

public class Pagamento {

    private int idPedido;
    private String formaPagamento;
    private double valorPago;
    private Funcionario funcionario;

    public Pagamento(int idPedido, String formaPagamento, double valorPago, Funcionario funcionario) {
        this.idPedido = idPedido;
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
        this.funcionario = funcionario;
    }

    public int getIdPedido() { return idPedido; }
    public String getFormaPagamento() { return formaPagamento; }
    public double getValorPago() { return valorPago; }
    public Funcionario getFuncionario() { return funcionario; }
}
