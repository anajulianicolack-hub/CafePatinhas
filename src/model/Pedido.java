package Model;


public class PedidoModel {
   /*Atributos privados (segurança do sistema)*/
   private int id;
   private int mesa;


   /*Construtor: todo pedido nasce com um número d eID e uam Mesa*/


   public PedidoModel(int id, int mesa) {
       this.id = id;
       this.mesa = mesa;
   }


   public int getId() {
       return id;
   }


   public void setId(int id) {
       this.id = id;
   }


   public int getMesa() {
       return mesa;
   }


   public void setMesa(int mesa) {
       this.mesa = mesa;
   }
}
