package controller;

import model.Comida;
import model.Mesa;
import model.Pedido;
import model.Pedido;
import view.PedidoView;

import java.util.ArrayList;
import java.util.Scanner;

public class PedidoController {
    private PedidoView view;

    private ArrayList<Comida> comidas = new ArrayList<>();
    private ArrayList<Mesa> mesas = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    private final Scanner scanner = new Scanner(System.in);

    public PedidoController(PedidoView view){
        this.view = view;
    }

    public void iniciar(){
        int op;
        do{
            op = view.exibirMenu();
            switch (op){
                case 1:
                    cadastrarComida();
                    break;
                case 2:
                    cadastrarMesa();
                    break;
                case 3:
                    cadastrarPedido();
                    break;
                case 4:
                    listarPedidos();
                    break;
                case 5:
                    view.mostrarMensagem("Encerrando..");
                    break;
                default:
                    view.mostrarMensagem("Opção inválida!");
            }
        }while (op != 5);
    }

    private void cadastrarComida(){
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = Double.parseDouble(scanner.nextLine());

        System.out.print("Ingredientes: ");
        String ingredientes = scanner.nextLine();

        System.out.print("Contém glúten (true/false): ");
        boolean gluten = Boolean.parseBoolean(scanner.nextLine());

        comidas.add(new Comida(nome, preco,ingredientes, gluten));

        System.out.println("🧁Comida cadastrada!");
    }

    private void cadastrarMesa(){
        System.out.print("Número da mesa: ");
        int numero = Integer.parseInt(scanner.nextLine());
        
        mesas.add(new Mesa(numero));
        
        System.out.println("🪑Mesa cadastrada!");
    }

    private void cadastrarPedido(){
        if (mesas.isEmpty() || comidas.isEmpty()){
            System.out.println("Cadastre ao menos uma mesa e uma comida");
            return;
        }

        System.out.print("ID do pedido: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Número da mesa: ");
        int numeroMesa = Integer.parseInt(scanner.nextLine());

        Mesa mesaSelecionada = null;

        for(Mesa mesa : mesas){
            if (mesa.getNumero() == numeroMesa){
                mesaSelecionada = mesa;
                break;
            }
        }

        if(mesaSelecionada == null){
            System.out.println("Mesa não encontrada!");
            return;
        }
        System.out.println("🧁 Comidas cadastradas:");

        for (int i = 0; i < comidas.size(); i++) {
            System.out.println((i + 1) + " - " + comidas.get(i).getNome());
        }

        System.out.print("Escolha uma comida: ");
        int escolha = Integer.parseInt(scanner.nextLine());

        Comida comida = comidas.get(escolha - 1);

        Pedido pedido = new Pedido(id, mesaSelecionada, comida);
        pedidos.add(pedido);

        System.out.println("Pedido cadastrado!");
    }

    private void listarPedidos(){

        if(pedidos.isEmpty()){
            System.out.println(" ❌ Nenhum pedido cadastrado");
            return;
        }
        for ( Pedido pedido : pedidos){
            System.out.println("\nPedido: " + pedido.getId());
            System.out.println("Mesa: " + pedido.getMesa().getNumero());
            System.out.println("Comida: " + pedido.getComida().getNome());
            System.out.println("Valor: R$ " + pedido.getComida().getPreco());
        }
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
