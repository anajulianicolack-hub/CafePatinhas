package controller;

import java.util.ArrayList;

import model.Cliente;
import view.ClienteView;

/*Controller responsável por gerenciar o CRUD de clientes.*/
public class ClienteController {


    /*Lista que armazena os clientes cadastrados.*/
    private final ArrayList<Cliente> clientes;

    /*View utilizada para interação com o usuário.*/
    private final ClienteView view;

    public ClienteController(ClienteView view) {
        this.view = view;
        this.clientes = new ArrayList<>();
    }

    /*Inicia o menu principal do CRUD.*/
    public void iniciar() {

        int opcao;

        do {

            opcao = view.exibirMenu();

            switch (opcao) {

                case 1:
                    cadastrar();
                    break;

                case 2:
                    listar();
                    break;

                case 3:
                    atualizar();
                    break;

                case 4:
                    excluir();
                    break;

                case 0:
                    view.mostrarMensagem("Encerrando...");
                    break;

                default:
                    view.mostrarMensagem("Opção inválida!");
            }

        } while (opcao != 0);
    }

    /*Cadastra um novo cliente.*/
    public void cadastrar() {

        try {

            int id = view.lerId();
            String nome = view.lerNome();
            String telefone = view.lerTelefone();
            int pontos = view.lerPontos();

            Cliente cliente = new Cliente(id, nome, telefone, pontos);

            clientes.add(cliente);

            view.mostrarMensagem("Cliente cadastrado!");

        } catch (Exception e) {

            view.mostrarMensagem("Erro ao cadastrar cliente.");
        }
    }

    /*Sobrecarga do método cadastrar.*/
    public void cadastrar(Cliente cliente) {
        clientes.add(cliente);
    }

    /*Lista todos os clientes cadastrados.*/
    public void listar() {

        if (clientes.isEmpty()) {

            view.mostrarMensagem("Nenhum cliente cadastrado.");
            return;
        }

        for (Cliente cliente : clientes) {
            cliente.exibirInformacoes();
            System.out.println("----------------");
        }
    }

    /*Atualiza os dados de um cliente.*/
    public void atualizar() {

        int id = view.lerId();

        for (Cliente cliente : clientes) {

            if (cliente.getId() == id) {

                cliente.setNome(view.lerNome());
                cliente.setTelefone(view.lerTelefone());

                view.mostrarMensagem("Cliente atualizado!");
                return;
            }
        }

        view.mostrarMensagem("Cliente não encontrado.");
    }

    /*Remove um cliente da lista.*/
    public void excluir() {

        int id = view.lerId();

        clientes.removeIf(cliente -> cliente.getId() == id);

        view.mostrarMensagem("Cliente removido.");
    }
}

