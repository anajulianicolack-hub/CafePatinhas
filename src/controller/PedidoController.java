package Controller;

import Model.Comida;
import Model.PedidoModel;
import View.PedidoView;

public class PedidoController implements BaseController {


   /*O controlador gerencia a model e a View*/
   private PedidoModel model;
   private PedidoView view;


   /*Construtorzão*/
   public PedidoController(PedidoModel model, PedidoView view) {
       this.model = model;
       this.view = view;
   }


   /*Metódo que calcula o valor total(método que chama em pagamento(ana))*/
   public double calcularTotal(Comida comida){
       return comida.getPreco();
   }


   /*Método obrigatório da interface BaseController*/
   @Override
   public void executar() {
       // 1. Quando o pedido inicia, o controlador muda o status da mesa para ocupada
       model.getMesa().setOcupada(true);


       // 2. Aciona a view para avisar na tela que a comanda eletrônica abriu
       view.exibirPedidoIniciado(model.getId(), model.getMesa());
   }
}

