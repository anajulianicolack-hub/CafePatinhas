package controller;

import model.Funcionario;
import model.Pedido;
import model.Pagamento;
import view.PagamentoView;
import java.util.ArrayList;

public class PagamentoController {
    private Pagamento model;
    private PagamentoView view;
    private ArrayList<Pedido> listaDePedidos;
    private FuncionarioController funcionarioController;

    public PagamentoController(PagamentoView view, ArrayList<Pedido> listaDePedidos, FuncionarioController funcionarioController) {
        this.view = view;
        this.listaDePedidos = listaDePedidos;
        this.funcionarioController = funcionarioController; // Salva o controlador
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
                encontrouPeloMenosUm = true;

                if (p.getComida() != null){
                    totalAcumulado = totalAcumulado + p.getComida().getPreco();
                }

                if (p.getBebida() != null){
                    totalAcumulado = totalAcumulado + p.getBebida().getPreco();
                }
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

        int idFuncio = view.lerIdFuncionario();
        Funcionario funcioSelecionado = null;

        for (Funcionario f : funcionarioController.getFuncionarios()) {
            if (f.getId() == idFuncio) {
                funcioSelecionado = f;
                break;
            }
        }

        if (funcioSelecionado == null) {
            System.out.println("❌ Funcionário não encontrado! Operação de pagamento cancelada.");
            return;
        }
        String formaEscolhida = view.selecionarFormaPagamento();

        this.model = new Pagamento(idReal, formaEscolhida, totalReal, funcioSelecionado);

        view.mostrarRecibo(model.getFormaPagamento(), model.getValorPago(), funcioSelecionado.getNome());
    }
}