package view;

import java.util.Scanner;

public class FuncionarioView {
    private final Scanner scan = new Scanner(System.in);

    public int exibirMenu() {
        System.out.println("\n===== 🧑‍💼 MENU FUNCIONÁRIOS =====");
        System.out.println(" | [1] Cadastrar Funcionário");
        System.out.println(" | [2] Listar Funcionários");
        System.out.println(" | [3] Voltar ao Menu Principal");
        System.out.print(">>> Escolha uma opção: ");
        return Integer.parseInt(scan.nextLine());
    }

    public int lerId() {
        System.out.print("Digite o ID (Código) do Funcionário: ");
        return Integer.parseInt(scan.nextLine());
    }

    public String lerNome() {
        System.out.print("Digite o Nome do Funcionário: ");
        return scan.nextLine();
    }

    public String lerTelefone() {
        System.out.print("Digite o Telefone: ");
        return scan.nextLine();
    }

    public String lerCargo() {
        System.out.print("Digite o Cargo: ");
        return scan.nextLine();
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
