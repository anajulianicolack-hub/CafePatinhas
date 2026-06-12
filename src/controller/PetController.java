package controller;

import model.Pet;
import view.PetView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetController {

    private Scanner scan = new Scanner(System.in);

    //lista que armazenar os pest
    List<Pet> petzinhos = new ArrayList<>();

    //pets iniciais (para vizualização)
    Pet pet = new Pet(1, "Luna", "Persa", 6, "F", false);
    Pet pet2 = new Pet(2, "Mingau", "Siamês", 4, "M", false);
    Pet pet3 = new Pet(3, "José", "Vira-lata", 5, "F", false);

    public PetController() {
        petzinhos.add(pet);
        petzinhos.add(pet2);
        petzinhos.add(pet3);
    }

    //função para escolha das ações
    public void iniciar() {
        PetView view = new PetView();
        int opcao;

        do {
            opcao = view.exibirPet();

            switch (opcao) {
                case 1:
                    CadastrarPet();
                    break;
                case 2:
                    ConsultarPet();
                    break;
                case 3:
                    StatusPet();
                    break;
                case 4:
                    adotar();
                    break;
                case 5:
                    RemoverPet();
                    break;
            }

        } while (opcao != 0);

    }

    public int ColetarPetId() {
        while (true) {
            try {
                System.out.println("Digite o número de identificação do Pet: ");
                int id = scan.nextInt();
                scan.nextLine();
                return id;

            } catch (Exception e) {
                System.out.println("Erro: digite apenas números.");
                scan.nextLine();
            }
        }
    }

    //função para cadastrar pet
    public void CadastrarPet() {
        System.out.println("--- ☕ [Café Patinhas] --- Cadastro Pet ---");
        System.out.print("Número de identificação do Pet: ");
        int id = scan.nextInt();
        scan.nextLine();

        System.out.print("Nome do Pet: ");
        String nome = scan.nextLine();

        System.out.print("Raça do Pet: ");
        String raca = scan.nextLine();

        System.out.print("Peso do Pet: ");
        int peso = scan.nextInt();
        scan.nextLine();

        System.out.print("Sexo (F/M): ");
        String sexo = scan.nextLine();

        System.out.print("Está adotado? (sim/não): ");
        String resposta = scan.nextLine();
        boolean adotado = resposta.equalsIgnoreCase("sim");

        Pet petzinho = new Pet(id, nome, raca, peso, sexo, adotado);
        petzinhos.add(petzinho);

        System.out.println("Cadastrado!!");

    }

    //função para consultar dados do pet
    public void ConsultarPet() {
        int petId = ColetarPetId();

        for (Pet pet : petzinhos) {
            if (petId == pet.getId()) {
                System.out.println("ID: " + pet.getId());
                System.out.println("Nome: " + pet.getNome());
                System.out.println("Raça: " + pet.getRaca());
                System.out.println("Peso: " + pet.getPeso());
                System.out.println("Sexo: " + pet.getSexo());

                return;
            }
        }

        System.out.println("Pet não encontrado.");
    }

    //função para adotar pet
    public void adotar() {
        int petId = ColetarPetId();

        for (Pet pet : petzinhos) {
            if (pet.getId() == petId) {
                pet.realizarAdocao();
                return;
            }
        }

        System.out.println("Pet não encontrado.");
    }

    //função para verificação do status de adoção
    public void StatusPet() {
        int petId = ColetarPetId();

        for (Pet pet : petzinhos) {
            if (pet.getId() == petId) {
                if (pet.isAdotado()) {
                    System.out.println("Status: Adotado!");
                } else {
                    System.out.println("Status: Disponível");
                }
                return;
            }
        }

        System.out.println("Pet não encontrado.");
    }

    //função para remover pet da lista
    public void RemoverPet() {
        int petId = ColetarPetId();

        for (int i = 0; i < petzinhos.size(); i++) {
            if (petzinhos.get(i).getId() == petId) {
                petzinhos.remove(i);
                System.out.println("Pet removido.");
                return;
            }
        }
        System.out.println("Pet não encontrado.");
    }
}