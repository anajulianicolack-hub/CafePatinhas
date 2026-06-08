package main;

import controller.ClienteController;
import view.ClienteView;

public class main {
    public static void main(String[] args) {

        System.out.println("☕ [Café Patinhas] Módulo de Clientes 🐾");

        ClienteView view = new ClienteView();

        ClienteController controller =
                new ClienteController(view);

        controller.iniciar();
    }
}
