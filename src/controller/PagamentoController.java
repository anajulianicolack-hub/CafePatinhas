package controller;

import model.Pagamento;
import view.PagamentoView;

public class PagamentoController {
    /*O nosso controller precisa saber quais classes ele vai gerenciar*/
    private Pagamento model;
    private PagamentoView view;

    private int idPedidoAtual = 101; // valor fictício para testar o código
    private double totalPedidoAtual = 45.90; // valor fictício para testar o código

    // Construtor do Controller:
    // Quando o controlador é criado, ele obrigatoriamente recebe a View que foi instanciada na Main.
    public PagamentoController(PagamentoView view){
        this.view = view;
    }

    // Metodo que inicia o fluxo do caso de uso:
    public void renderizarTela() {
        /*Ele aciona a view e manda eka desenhar os dados do pedido na tela*/
        view.exibirConfirmacaoDePagamento(idPedidoAtual, totalPedidoAtual);

        /*Logo em seguida, ele pula para o próximo metodo abaixo, para processar os dados*/
        atualizarDados();
    }

    // Metodo responsável pela lógica de capturar e salvar as informações:
    public void atualizarDados() {
        // 1. O controlador pede para a View coletar a forma de pagamento do usuário.
        // A View faz o switch-case dela lá, devolve o texto (ex: "PIX") e o controlador guarda na variável 'formaEscolhida'.
        String formaEscolhida = view.selecionarFormaPagamento();

        // 2. Com todas as informações em mãos (ID, forma e total), o controlador dá um 'new'
        // e cria o objeto Model 'Pagamento', salvando o registro oficial no sistema.
        this.model = new Pagamento(idPedidoAtual, formaEscolhida, totalPedidoAtual);

        // 3. Por fim, o controlador pega os dados salvos de dentro do Model
        // e envia de volta para a View exibir o recibo formatado para o cliente.
        view.mostrarRecibo(model.getFormaPagamento(), model.getValorPago());
    }
}
