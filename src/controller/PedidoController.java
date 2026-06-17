package controller;

import model.*;
import model.Pedido;
import view.PedidoView;

import java.util.ArrayList;
import java.util.Scanner;

public class PedidoController {
    private PedidoView view;

    private ArrayList<Comida> comidas = new ArrayList<>();
    private ArrayList<Bebida> bebidas = new ArrayList<>();
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
                    cadastrarBebida();
                    break;
                case 3:
                    cadastrarMesa();
                    break;
                case 4:
                    cadastrarPedido();
                    break;
                case 5:
                    listarPedidos();
                    break;
                case 6:
                    view.mostrarMensagem("Encerrando..");
                    break;
                default:
                    view.mostrarMensagem("Opção inválida!");
            }
        }while (op != 6);
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

    private void cadastrarBebida(){
        System.out.print("Nome da bebida: ");
        String nome = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = Double.parseDouble(scanner.nextLine());

        System.out.print("Tipo (Cha/Café/Suco/Refrigerante): ");
        String tipo = scanner.nextLine();

        System.out.print("Tamanho (Pequeno/Médio/Grande): ");
        String tamanho = scanner.nextLine();

        System.out.print("É gelado (true/false): ");
        boolean gelado = Boolean.parseBoolean(scanner.nextLine());

        bebidas.add(new Bebida(nome, preco, tipo, tamanho, gelado));

        System.out.println("☕ Bebida cadastrada com sucesso!");
    }

    private void cadastrarMesa(){
        System.out.print("Número da mesa: ");
        int numero = Integer.parseInt(scanner.nextLine());
        
        mesas.add(new Mesa(numero));
        
        System.out.println("🪑Mesa cadastrada!");
    }

    private void cadastrarPedido(){
        if (mesas.isEmpty() || (comidas.isEmpty() && bebidas.isEmpty())){
            System.out.println("Cadastre ao menos uma mesa, uma comida e uma bebida");
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

        if (mesaSelecionada.isOcupada() == true) {
            System.out.println("❌ Esta mesa já está ocupada por outro cliente!");
            return;
        }

        System.out.println("🧁 Comidas cadastradas:");

        for (int i = 0; i < comidas.size(); i++) {
            System.out.println((i + 1) + " - " + comidas.get(i).getNome());
        }
        System.out.println("0 - nenhuma comida");
        System.out.print("Escolha uma comida: ");
        int escolha = Integer.parseInt(scanner.nextLine());

        Comida comidaSelecionada = null;
        if (escolha != 0){
            comidaSelecionada = comidas.get(escolha - 1); //
        }

        System.out.println("\n☕ Bebidas cadastradas:");
        for (int i = 0; i < bebidas.size(); i++){
            System.out.println((i + 1) + " - " + bebidas.get(i).getNome());
        }
        System.out.println("0 - nenhuma bebida");
        System.out.print("Escolha uma bebida: ");
        int escolhaBebida = Integer.parseInt(scanner.nextLine());

        Bebida bebidaSelecionada = null;
        if (escolhaBebida != 0) {
            bebidaSelecionada = bebidas.get(escolhaBebida - 1);
        }

        Pedido pedido = new Pedido(id, mesaSelecionada, comidaSelecionada, bebidaSelecionada);
        pedidos.add(pedido);

        mesaSelecionada.setOcupada(true);

        System.out.println("Pedido cadastrado!");
    }

    private void listarPedidos(){
        if(pedidos.isEmpty()){
            System.out.println(" ❌ Nenhum pedido cadastrado");
            return;
        }
        for (Pedido pedido : pedidos){
            System.out.println("\nPedido: " + pedido.getId());
            System.out.println("Mesa: " + pedido.getMesa().getNumero());

            double valorTotalDoPedido = 0.0;

            if (pedido.getComida() != null) {
                System.out.println("Comida: " + pedido.getComida().getNome());
                valorTotalDoPedido = valorTotalDoPedido + pedido.getComida().getPreco();
            } else {
                System.out.println("Comida: Nenhuma");
            }

            if (pedido.getBebida() != null) {
                System.out.println("Bebida: " + pedido.getBebida().getNome());
                valorTotalDoPedido = valorTotalDoPedido + pedido.getBebida().getPreco();
            } else {
                System.out.println("Bebida: Nenhuma");
            }

            System.out.println("Valor Total: R$ " + valorTotalDoPedido);
            System.out.println("------------------------");
        }
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
