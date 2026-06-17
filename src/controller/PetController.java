package controller;

import model.Adocao;
import model.Cliente;
import model.Pet;
import view.PetView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetController {

    private Scanner scan = new Scanner(System.in);
    private PetView view = new PetView();
    private ClienteController clienteController;

    //lista que armazena os pets
    private List<Pet> listaPets = new ArrayList<>();

    //lista que armazena os Clientes que realizaram adoção, e o seu pet adotado
    private List<Adocao> adocoes = new ArrayList<>();

    //pets iniciais (para visualização)
    public PetController(ClienteController clienteController) {
        this.clienteController = clienteController;
        listaPets.add(new Pet(1, "Luna", "Persa", 6, "F", false));
        listaPets.add(new Pet(2, "Mingau", "Siamês", 4, "M", false));
        listaPets.add(new Pet(3, "José", "Vira-lata", 5, "F", false));
    }

    //função para escolha das ações
    public void iniciar() {
        int opcao;

        do {
            opcao = view.exibirPet();

            switch (opcao) {
                case 1:
                    cadastrarPet();
                    break;
                case 2:
                    consultarPet();
                    break;
                case 3:
                    statusPet();
                    break;
                case 4:
                    adotar();
                    break;
                case 5:
                    listarPetsDisponiveis();
                    break;
                case 6:
                    removerPet();
                    break;
                case 7:
                    listarPetsAdotados();
                    break;
            }

        } while (opcao != 0);

    }

    // funçao que coleta numero inteiro, caso necessário trata erro
    public int coletarInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int num = scan.nextInt();
                scan.nextLine();
                return num;

            } catch (Exception e) {
                System.out.println("⚠️ Erro: digite apenas números.");
                scan.nextLine();
            }
        }
    }

    // função que realiza a busca de um pet pelo id
    public Pet buscarPetPorId(int petId) {
        for (Pet pet : listaPets) {
            if (pet.getId() == petId) {
                return pet;
            }
        }
        return null;
    }

    //função para cadastrar pet
    public void cadastrarPet() {
        System.out.println();
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║        🐶 CADASTRO DE PET          ║");
        System.out.println("╚════════════════════════════════════╝");

        int id = coletarInteiro("Número de identificação do Pet: ");

        if (buscarPetPorId(id) != null) {
            System.out.println("⚠️ Já existe um pet com esse ID.");
            return;
        }

        System.out.print("Nome do Pet: ");
        String nome = scan.nextLine();

        System.out.print("Raça do Pet: ");
        String raca = scan.nextLine();

        int peso = coletarInteiro("Peso do Pet: ");

        System.out.print("Sexo (F/M): ");
        String sexo = scan.nextLine();

        Pet pet = new Pet(id, nome, raca, peso, sexo, false);
        listaPets.add(pet);

        System.out.println();
        System.out.println("✅ Pet cadastrado com sucesso! ₍^. .^₎⟆ ");
        System.out.println();

    }

    //função para consultar dados do pet
    public void consultarPet() {
        System.out.println();
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║         🔎 CONSULTAR PET           ║");
        System.out.println("╚════════════════════════════════════╝");

        int petId = coletarInteiro("Digite o número de identificação do Pet: ");

        Pet pet = buscarPetPorId(petId);

        if (pet == null) {
            System.out.println("⚠️ Pet não encontrado! Tente novamente.");
            return;
        }

        System.out.println("┌────────────────────────────────────");
        System.out.println("│ ID: " + pet.getId());
        System.out.println("│ Nome: " + pet.getNome());
        System.out.println("│ Raça: " + pet.getRaca());
        System.out.println("│ Peso: " + pet.getPeso());
        System.out.println("│ Sexo: " + pet.getSexo());
        System.out.println("└────────────────────────────────────");
    }

    //função para adotar pet
    public void adotar() {
        System.out.println();
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║          ❤️ ADOÇÃO DE PET          ║");
        System.out.println("╚════════════════════════════════════╝");

        int clienteId = coletarInteiro("Digite o ID do cliente: ");

        Cliente cliente = clienteController.buscarPorId(clienteId);

        if (cliente == null) {
            System.out.println("⚠️ Cliente não encontrado!");
            return;
        }

        int petId = coletarInteiro("Digite o número de identificação do Pet: ");

        Pet pet = buscarPetPorId(petId);

        if (pet == null) {
            System.out.println("⚠️ Pet não encontrado! Tente novamente.");
            return;
        }

        if (!pet.estaAdotado()) {
            pet.realizarAdocao();

            Adocao adocao = new Adocao(clienteId, petId);
            adocoes.add(adocao);

            System.out.println();
            System.out.println("✅ Adoção registrada com sucesso!");
            System.out.println("🏠 " + cliente.getNome() + " adotou " + pet.getNome() + "!");
        } else {
            System.out.println("⚠️ Esse pet já foi adotado.");
        }

    }

    //função para verificação do status de adoção
    public void statusPet() {
        System.out.println();
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║        📋 STATUS DO PET            ║");
        System.out.println("╚════════════════════════════════════╝");

        int petId = coletarInteiro("Digite o número de identificação do Pet: ");

        Pet pet = buscarPetPorId(petId);

        if (pet == null) {
            System.out.println("⚠️ Pet não encontrado! Tente novamente.");
            return;
        }

        if (pet.estaAdotado()) {
            System.out.println("🏠 Status: Adotado");
        } else {
            System.out.println("🐾 Status: Disponível para Adoção!");
        }

    }

    //função para remover pet da lista
    public void removerPet() {
        System.out.println();
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║         🗑 REMOVER PET             ║");
        System.out.println("╚════════════════════════════════════╝");

        int petId = coletarInteiro("Digite o número de identificação do Pet: ");

        Pet pet = buscarPetPorId(petId);

        if (pet == null) {
            System.out.println("⚠️ Pet não encontrado!");
            return;
        }

        listaPets.remove(pet);
        System.out.println("✅ Pet removido com sucesso.");
    }


    //função para listar todos os pets disponíveis para adoção
    public void listarPetsDisponiveis() {
        System.out.println();
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║       🐾 PETS DISPONÍVEIS          ║");
        System.out.println("╚════════════════════════════════════╝");

        boolean encontrou = false;

        for (Pet pet : listaPets) {

            if (!pet.estaAdotado()) {
                encontrou = true;

                System.out.println("┌────────────────────────────────────");
                System.out.println("│ ID: " + pet.getId());
                System.out.println("│ Nome: " + pet.getNome());
                System.out.println("│ Raça: " + pet.getRaca());
                System.out.println("│ Peso: " + pet.getPeso());
                System.out.println("│ Sexo: " + pet.getSexo());
                System.out.println("└────────────────────────────────────");
                System.out.println();

            }

        }

        if (!encontrou) {
            System.out.println("Nenhum pet está disponível.");
        }
    }


    public void listarPetsAdotados() {
        System.out.println();
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║        🏠 PETS ADOTADOS            ║");
        System.out.println("╚════════════════════════════════════╝");

        if (adocoes.isEmpty()) {
            System.out.println("Nenhum pet foi adotado.");
            return;
        }

        for (Pet pet : listaPets) {

            if (pet.estaAdotado()) {
                Cliente cliente = null;

                for (Adocao adocao : adocoes) {
                    if (adocao.getPetId() == pet.getId()) {
                        cliente = clienteController.buscarPorId(adocao.getClienteId());
                        break;
                    }
                }

                System.out.println("┌────────────────────────────────────");
                System.out.println("│ ID: " + pet.getId());
                System.out.println("│ Nome: " + pet.getNome());
                System.out.println("│ Raça: " + pet.getRaca());
                System.out.println("│ Sexo: " + pet.getSexo());
                System.out.println("│ ");
                System.out.println("│ - Adotado por - ");
                if (cliente != null) {
                    System.out.println("│ Cliente ID: " + cliente.getId());
                    System.out.println("│ Cliente Nome: " + cliente.getNome());
                }
                System.out.println("└────────────────────────────────────");
                System.out.println();
            }
        }
    }
}