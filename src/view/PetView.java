package view;

import model.Pet;

import java.util.Scanner;

public class PetView {

    private Scanner scan = new Scanner(System.in);

    public int exibirPet() {
        while (true) {
            try {
                System.out.println();
                System.out.println("╔═══════════════════════════════════╗");
                System.out.println("║         🐾 CAFÉ PATINHAS 🐾       ║");
                System.out.println("╠═══════════════════════════════════╣");
                System.out.println("║ 🐶 [1] Cadastrar Pet              ║");
                System.out.println("║ 🔎 [2] Consultar Pet              ║");
                System.out.println("║ 📋 [3] Status de Adoção           ║");
                System.out.println("║ ❤️ [4] Adotar Pet                 ║");
                System.out.println("║ 🐾 [5] Pets Disponíveis           ║");
                System.out.println("║ 🗑  [6] Remover Pet                ║");
                System.out.println("║ 🏠 [7] Pets Adotados              ║");
                System.out.println("║ 🚪 [0] Voltar                     ║");
                System.out.println("╚═══════════════════════════════════╝");

                System.out.print("Digite a ação desejada: ");
                int opcao = scan.nextInt();
                return opcao;

            } catch (Exception e) {
                System.out.println("⚠️ Digite apenas números.");
                scan.nextLine();
            }
        }
    }

}