package view;

import model.Comida;
import model.Mesa;
import model.Pedido;

public class PedidoView {
    /*Classe responsável por todas as interações visuais no console*/
    /*Relacionado ao fluxo de pedidos, comidas e mesas*/

    /*Novo, função de exibir os dados detalhados de uma comida especifíca*/
    public void exibirDadosComida(Comida comida) {
        System.out.println("===================");
        System.out.println(" 🐾CAFÉ PATINHAS🐾 ");
        System.out.println("===================");
        System.out.println("🧁 Seu pedido de " + comida.getNome() + " foi recebido com sucesso!!");
        System.out.println("💵 Preço: R$" + comida.getPreco());
        System.out.println("===================");
        System.out.println("Detalhes: " + comida.getIngredientes());
        System.out.println("Contém glúten: " + (comida.isContemGluten() ? "⚠️ Contém glutén" : "🍃 Livre de glutén"));
    }

    /*Exibe o status atual de uma mesa*/
    public void exibirDadosMesa(Mesa mesa) {
        System.out.println("\n 🪑 [STATUS DA MESA]");
        System.out.println(" - Número da mesa: " + mesa.getNumero());
        System.out.println(" - Status: " + (mesa.isOcupada() ? "❌ Ocupada" : "✔️ Livre"));
    }

    public void exibirPedidoIniciado(int idPedido, int numeroMesa) {
        System.out.println("===============================================");
        System.out.println("🐾 [Café Patinhas] Comanda eletrônica iniciada!");
        System.out.println("📝 Pedido Nº: " + idPedido + " | Mesa: " + numeroMesa);
        System.out.println("===============================================");
    }

    public void exibirItemAdicionado(String nomeProduto) {
        System.out.println(nomeProduto + " foi lançado na comanda da mesa");
    }

    /*Mostra o resumo do pedido com a comida e a mesa e o valor*/
    public void exibirResumoPedido(Pedido pedido, Comida comida, double valorTotal) {
        System.out.println("======================");
        System.out.println("  RESUMO DO PEDIDO   ");
        System.out.println("======================");
        System.out.println("📝 Pedido ID: " + pedido.getId());
        System.out.println("🪑 Mesa do cliente: " + pedido.getMesa().getNumero());
        System.out.println("🧁 Item Consumido: " + comida.getNome() + "R$ " + comida.getPreco());
        System.out.println("💵 Total do pedido: R$ " + valorTotal);
        System.out.println("======================");
    }
}

