package controller;

import model.Comida;
import model.Pedido;
import view.PedidoView;

public class PedidoController {

    /*O controlador gerencia a model e a View*/
    private Pedido model;
    private PedidoView view;

    /*Construtorzão*/
    public PedidoController(Pedido model, PedidoView view) {
        this.model = model;
        this.view = view;
    }

    /*Metódo que calcula o valor total(método que chama em pagamento(ana))*/
    public double calcularTotal(Comida comida){
        return comida.getPreco();
    }

    /*Metodo que inicia as ações do pedido*/
    public void executar(){
        /*Quando é iniciado um novo pedido o status da mesa altera para ocuapada*/
        model.getMesa().setOcupada(true);

        /*Chama a view para iniciar uma comanda*/
        view.exibirPedidoIniciado(model.getId(), model.getMesa().getNumero());
    }
}

