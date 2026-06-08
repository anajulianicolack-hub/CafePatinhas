package view;

import java.util.Scanner;

/*Classe responsável pela interação com o usuário.*/
public class ClienteView {

    /*Scanner utilizado para ler os dados digitados.*/
    private final Scanner scanner = new Scanner(System.in);

    /*Métodos para capturar os dados do cliente.*/
    public int lerId() {
        System.out.print("ID: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String lerNome() {
        System.out.print("Nome: ");
        return scanner.nextLine();
    }

    public String lerTelefone() {
        System.out.print("Telefone: ");
        return scanner.nextLine();
    }

    public int lerPontos() {
        System.out.print("Pontos de Fidelidade: ");
        return Integer.parseInt(scanner.nextLine());
    }

    /*Exibe o menu de opções do CRUD.*/
    public int exibirMenu() {

        System.out.println("\n===== CLIENTES =====");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar"); //esse listar aquiiii slaaaa
        System.out.println("3 - Atualizar");
        System.out.println("4 - Excluir");
        System.out.println("0 - Sair");

        System.out.print("Escolha: ");

        return Integer.parseInt(scanner.nextLine());
    }

    /*Exibe mensagens para o usuário.*/
    public void mostrarMensagem(String msg) {
        System.out.println(msg);
    }
}
