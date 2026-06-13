package main;

import controller.ClienteController;
import controller.PedidoController;
import controller.PetController;
import controller.PagamentoController;

import view.ClienteView;
import view.PedidoView;
import view.PagamentoView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner exclusivo para o menu principal
        Scanner scanner = new Scanner(System.in);

        // 1. Instanciamos todas as Views (as telas)
        ClienteView clienteView = new ClienteView();
        PedidoView pedidoView = new PedidoView();
        PagamentoView pagamentoView = new PagamentoView();

        // 2. Instanciamos os controladores de Cliente, Pedido e Pet
        ClienteController clienteController = new ClienteController(clienteView);
        PedidoController pedidoController = new PedidoController(pedidoView);
        PetController petController = new PetController();

        // 3. CONEXÃO DINÂMICA: Instanciamos o PagamentoController passando a lista REAIS de pedidos.
        // O método pedidoController.getPedidos() passa a REFERÊNCIA da lista viva para o pagamento.
        PagamentoController pagamentoController = new PagamentoController(pagamentoView, pedidoController.getPedidos());

        int opcao = 0;
        do {
            System.out.println("\n====================================");
            System.out.println("     🐾 CAFÉ PATINHAS - SISTEMA 🐾   ");
            System.out.println("====================================");
            System.out.println("[1] Gerenciar Clientes");
            System.out.println("[2] Gerenciar Pedidos, Mesas e Comidas");
            System.out.println("[3] Menu de Adoção e Pets");
            System.out.println("[4] Realizar Pagamento de um Pedido");
            System.out.println("[0] Sair do Sistema");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        // Passa o controle para o menu de Clientes (CRUD)
                        clienteController.iniciar();
                        break;
                    case 2:
                        // Passa o controle para o menu de Pedidos.
                        // Aqui você vai cadastrar comidas, mesas e os pedidos reais.
                        pedidoController.iniciar();
                        break;
                    case 3:
                        // Passa o controle para o menu de Pets e Adoção
                        petController.iniciar();
                        break;
                    case 4:
                        // Aciona o fluxo de pagamento que buscará o ID digitado
                        // direto na lista de pedidos reais que você criou na opção 2!
                        pagamentoController.renderizarTela();
                        break;
                    case 0:
                        System.out.println("\nSistema encerrado. Obrigado por usar o Café Patinhas! 🐾");
                        break;
                    default:
                        System.out.println("⚠️ Opção inválida! Tente novamente.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Por favor, digite um número válido.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}