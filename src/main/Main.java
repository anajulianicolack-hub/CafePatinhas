package main;

import controller.ClienteController;
import controller.PedidoController;
import controller.PetController;
import controller.PagamentoController;
import controller.FuncionarioController;

import view.ClienteView;
import view.PedidoView;
import view.PagamentoView;
import view.FuncionarioView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ClienteView clienteView = new ClienteView();
        PedidoView pedidoView = new PedidoView();
        PagamentoView pagamentoView = new PagamentoView();
        FuncionarioView funcionarioView = new FuncionarioView();

        ClienteController clienteController = new ClienteController(clienteView);
        PedidoController pedidoController = new PedidoController(pedidoView);
        PetController petController = new PetController(clienteController);
        FuncionarioController funcionarioController = new FuncionarioController(funcionarioView);

        PagamentoController pagamentoController = new PagamentoController(
                pagamentoView,
                pedidoController.getPedidos(),
                funcionarioController
        );

        int opcao = 0;
        do {
            System.out.println("\n====================================");
            System.out.println("     🐾 CAFÉ PATINHAS - SISTEMA 🐾   ");
            System.out.println("====================================");
            System.out.println(" | [1] Gerenciar Clientes");
            System.out.println(" | [2] Gerenciar Pedidos, Mesas, Comidas e Bebidas");
            System.out.println(" | [3] Menu de Adoção e Pets");
            System.out.println(" | [4] Realizar Pagamento de um Pedido");
            System.out.println(" | [5] Gerenciar Funcionários");
            System.out.println(" | [0] Sair do Sistema");
            System.out.print(">>> Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        clienteController.iniciar();
                        break;
                    case 2:
                        pedidoController.iniciar();
                        break;
                    case 3:
                        petController.iniciar();
                        break;
                    case 4:
                        pagamentoController.renderizarTela();
                        break;
                    case 5:
                        funcionarioController.iniciar();
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