package main;

import controller.ClienteController;
import controller.PagamentoController;
import view.ClienteView;
import view.PagamentoView;

public class Main {
    public static void main(String[] args){

        /*TESTANDO A MINHA PARTE (Nicolack)*/
        System.out.println("☕ [Café Patinhas] Inicializando Módulo de Pagamento da Nicolack... 🐾\n");

        PagamentoView viewAna = new PagamentoView();
        PagamentoController controllerAna = new PagamentoController(viewAna);
        controllerAna.renderizarTela();

        ClienteView view = new ClienteView();

        ClienteController controller =
                new ClienteController(view);

        controller.iniciar();
    }
}
