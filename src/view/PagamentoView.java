package view;

import java.util.Scanner;

public class PagamentoView {

    /*Criamos um scanner privado, assim garantimos que ele será exclusivo apenas desta tela*/
    private Scanner scan = new Scanner(System.in);

    // Metodo para exibir o cabeçalho da conta:
    // Recebe o ID e o valor total e usa o System.out.println para desenhar na tela do usuário.
    public void exibirConfirmacaoDePagamento(int idPedido, double total){
        System.out.println("\n--- 💳 FECHAMENTO DE CAIXA ---");
        System.out.println("Pedido ID: #" + idPedido);
        System.out.printf("Valor Total a Pagar: R$ %.2f\n", total);
        System.out.println("------------------------------");
    }

    // Metodo que mostra o menu de opções e lê o que o usuário escolheu:
    public String selecionarFormaPagamento(){
        System.out.println("Escolha a forma de pagamento:");
        System.out.println("[1] PIX");
        System.out.println("[2] Cartão de Crédito/Débito");
        System.out.println("[3] Dinheiro");
        System.out.print("Opção: ");

        String opcao = scan.nextLine();
        switch (opcao) {
            case "1": return "PIX";
            case "2": return "Cartão";
            case "3": return "Dinheiro";
            default: return "Não Informado";
        }
        /*IMPORTANTE: O switch não está dentro do controller, pois não a necessidade,
        visto qu ele só quer uma confirmação para poder imprimir para o usuário, ele
        não está gerenciando uma regra de negócio, se estivesse, aí sim o switch precisaria
        obrigatoriamente estar dentro do Controller*/
    }

    // Metodo simples para exibir o recibo final de sucesso na tela.
    public void mostrarRecibo(String forma, double valor){
        System.out.println("\n✨ Pagamento processado com sucesso! ✨");
        System.out.printf("Recebido: R$ %.2f via %s.\n", valor, forma);
        System.out.println("O Café Patinhas agradece a preferência! 🐾\n");
    }

}
