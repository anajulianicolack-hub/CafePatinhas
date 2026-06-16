package view;

import java.util.Scanner;

public class PagamentoView {

    private Scanner scan = new Scanner(System.in);

    public int lerIdPedido() {
        System.out.print("Digite o ID do pedido que deseja pagar: ");
        return Integer.parseInt(scan.nextLine());
    }

    public void exibirConfirmacaoDePagamento(int idPedido, double total){
        System.out.println("\n===== 💳 FECHAMENTO DE CAIXA =====");
        System.out.println("Pedido ID: #" + idPedido);
        System.out.printf("Valor Total a Pagar: R$ %.2f\n", total);
        System.out.println("------------------------------");
    }

    public String selecionarFormaPagamento(){
        System.out.println("Escolha a forma de pagamento:");
        System.out.println(" | [1] ❖ PIX");
        System.out.println(" | [2] 💳 Cartão de Crédito/Débito");
        System.out.println(" | [3] 💵 Dinheiro");
        System.out.print("Opção: ");

        String opcao = scan.nextLine();
        switch (opcao) {
            case "1": return "PIX";
            case "2": return "Cartão";
            case "3": return "Dinheiro";
            default: return "Não Informado";
        }

    }

    public void mostrarRecibo(String forma, double valor){
        System.out.println("\n===== ✨ Pagamento processado com sucesso! ✨ =====");
        System.out.printf(" | Recebido: R$ %.2f via %s.\n", valor, forma);
        System.out.println(">>> O Café Patinhas agradece a preferência! 🐾 <<<\n");
    }
}