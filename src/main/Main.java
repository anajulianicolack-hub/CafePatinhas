package main;

import java.util.Scanner;

// Importações dos Controllers
import controller.ClienteController;
import controller.PedidoController;
import controller.PagamentoController;
// import controller.PetController; // Descomente quando a Naty passar o dela!

// Importações das Views
import view.ClienteView;
import view.PedidoView;
import view.PagamentoView;
// import view.PetView; // Descomente quando a Naty passar o dela!

// Importações dos Models necessários para o fluxo
import model.Mesa;
import model.Comida;
import model.Pedido;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // -----------------------------------------------------------------
        // 1. INSTANCIANDO AS VIEWS (TELAS)
        // -----------------------------------------------------------------
        ClienteView clienteView = new ClienteView();
        PedidoView pedidoView = new PedidoView();
        PagamentoView pagamentoView = new PagamentoView();
        // PetView petView = new PetView(); // Módulo da Naty

        // -----------------------------------------------------------------
        // 2. INSTANCIANDO OS CONTROLLERS PRINCIPAIS
        // -----------------------------------------------------------------
        ClienteController clienteController = new ClienteController(clienteView);

        // -----------------------------------------------------------------
        // 3. OBJETOS DE FLUXO (Para integrar Isa e Ana em tempo real)
        // -----------------------------------------------------------------
        // Simulando que o cliente sentou na Mesa 4 e pediu um Muffin
        Mesa mesaExemplo = new Mesa(4);
        Pedido pedidoAtual = new Pedido(102, mesaExemplo);
        Comida comidaPedida = new Comida("Muffin de Blueberry", 14.90, "Farinha, blueberry, açúcar", false);

        PedidoController pedidoController = new PedidoController(pedidoAtual, pedidoView);
        PagamentoController pagamentoController = new PagamentoController(pagamentoView, pedidoAtual, comidaPedida);

        int opcao = -1;

        // -----------------------------------------------------------------
        // 4. MENU PRINCIPAL INTERATIVO
        // -----------------------------------------------------------------
        do {
            System.out.println("\n=========================================");
            System.out.println("      ☕ SISTEMA CAFÉ PATINHAS 🐾        ");
            System.out.println("=========================================");
            System.out.println(" [1] Gerenciar Clientes (Módulo Ste)");
            System.out.println(" [2] Iniciar Comanda / Pedido (Módulo Isa)");
            System.out.println(" [3] Módulo de Adoção de Pets (Módulo Naty)");
            System.out.println(" [4] Fechar Conta e Pagamento (Módulo Ana)");
            System.out.println(" [0] Sair do Sistema");
            System.out.println("=========================================");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        // Abre o menu interno de CRUD de clientes que a Ste fez
                        System.out.println("\n--- Entrando no Módulo de Clientes ---");
                        clienteController.iniciar();
                        break;

                    case 2:
                        // Inicia o fluxo de comanda eletrônica da Isa
                        System.out.println("\n--- Processando Pedido na Mesa ---");
                        pedidoController.executar();
                        // Mostra o resumo do que foi consumido
                        pedidoView.exibirResumoPedido(pedidoAtual, comidaPedida, comidaPedida.getPreco());
                        break;

                    case 3:
                        // Espaço reservado para o menu ou método da Naty
                        System.out.println("\n--- Entrando no Módulo de Adoção ---");
                        System.out.println("🐾 [Naty] Buscando pets disponíveis para adoção...");
                        // petController.iniciarAdocao();
                        break;

                    case 4:
                        // Chama a sua tela de pagamento puxando os dados reais do pedido da Isa!
                        System.out.println("\n--- Direcionando ao Caixa ---");
                        pagamentoController.renderizarTela();
                        break;

                    case 0:
                        System.out.println("\n🐾 Finalizando o sistema do Café Patinhas. Até mais! ☕");
                        break;

                    default:
                        System.out.println("\n⚠️ Opção inválida! Escolha um número de 0 a 4.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\n⚠️ Erro: Por favor, digite apenas números inteiros.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}