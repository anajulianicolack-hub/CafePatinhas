package view;

import java.util.Scanner;

public class PedidoView {
    /*Classe responsável por todas as interações visuais no console*/
    /*Relacionado ao fluxo de pedidos, comidas e mesas*/
    private final Scanner scanner = new Scanner(System.in);
    public int exibirMenu() {
        System.out.println("\n===== CAFÉ PATINHAS =====");
        System.out.println("1 - Cadastrar Comida");
        System.out.println("2 - Cadastrar Mesa");
        System.out.println("3 - Cadastrar Pedido");
        System.out.println("4 - Listar Pedidos");
        System.out.println("5 - Sair");

        System.out.print("Escolha: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void mostrarMensagem(String msg) {
        System.out.println(msg);
    }
}

