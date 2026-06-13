package controller;

import model.Pedido;
import model.Pagamento;
import view.PagamentoView;
import java.util.ArrayList;

public class PagamentoController {
    private Pagamento model;
    private PagamentoView view;
    private ArrayList<Pedido> listaDePedidos;

    public PagamentoController(PagamentoView view, ArrayList<Pedido> listaDePedidos) {
        this.view = view;
        this.listaDePedidos = listaDePedidos;
    }

    public void renderizarTela() {
        if (listaDePedidos.isEmpty()) {
            System.out.println("⚠️ Não há nenhum pedido em aberto no sistema para ser pago!");
            return;
        }

        int idProcurado = view.lerIdPedido();

        double totalAcumulado = 0.0;
        boolean encontrouPeloMenosUm = false;

        for (Pedido p : listaDePedidos) {
            if (p.getId() == idProcurado) {
                totalAcumulado += p.getComida().getPreco();
                encontrouPeloMenosUm = true;
            }
        }

        if (!encontrouPeloMenosUm) {
            System.out.println("❌ Pedido com ID " + idProcurado + " não foi encontrado!");
            return;
        }

        view.exibirConfirmacaoDePagamento(idProcurado, totalAcumulado);

        atualizarDados(idProcurado, totalAcumulado);
    }

    public void atualizarDados(int idReal, double totalReal) {
        String formaEscolhida = view.selecionarFormaPagamento();

        this.model = new Pagamento(idReal, formaEscolhida, totalReal);

        view.mostrarRecibo(model.getFormaPagamento(), model.getValorPago());
    }
}