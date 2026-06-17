package controller;
import java.util.ArrayList;
import model.Cliente;
import view.ClienteView;

public class ClienteController {
    
    private final ArrayList<Cliente> clientes;
    private final ClienteView view;
    public ClienteController(ClienteView view) {
        this.view = view;
        this.clientes = new ArrayList<>();
    }
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
    public void cadastrar() {
        try {
            int id = view.lerId();
            if (buscarPorId(id) != null) {
                view.mostrarMensagem("Erro: Já existe um cliente cadastrado com este ID!");
                return;
            }
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
    public void cadastrar(Cliente cliente) {
        if (buscarPorId(cliente.getId()) == null) {
            clientes.add(cliente);
        } else {
            view.mostrarMensagem("Erro: ID já existente.");
        }
    }
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
    public void atualizar() {
        int id = view.lerId();
        Cliente cliente = buscarPorId(id);
        if (cliente != null) {
            cliente.setNome(view.lerNome());
            cliente.setTelefone(view.lerTelefone());
            view.mostrarMensagem("Cliente atualizado!");
        } else {
            view.mostrarMensagem("Cliente não encontrado.");
        }
    }
    public void excluir() {
        int id = view.lerId();


        Cliente cliente = buscarPorId(id);


        if (cliente != null) {
            clientes.remove(cliente);
            view.mostrarMensagem("Cliente removido.");
        } else {
            view.mostrarMensagem("Cliente não encontrado.");
        }
    }
   public Cliente buscarPorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}
