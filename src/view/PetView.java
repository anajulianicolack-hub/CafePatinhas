package view;

import model.Pet;

import java.util.Scanner;

public class PetView {

    private Scanner scan = new Scanner(System.in);

    public int exibirPet() {
        System.out.println("Digite o número da ação desejada: ");
        System.out.println("[1] Cadastrar Pet");
        System.out.println("[2] Consultar dados do pet");
        System.out.println("[3] Consultar se o pet é adotado");
        System.out.println("[4] Adotar pet");
        System.out.println("[5] Remover pet");

        System.out.print("Opção: ");
        int opcao = scan.nextInt();

        return opcao;
    }

}