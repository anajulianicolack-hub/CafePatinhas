package controller;

import model.Funcionario;
import view.FuncionarioView;
import java.util.ArrayList;

public class FuncionarioController {
    private FuncionarioView view;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public FuncionarioController(FuncionarioView view) {
        this.view = view;
    }

    public void iniciar() {
        int op;
        do {
            try {
                op = view.exibirMenu();
                switch (op) {
                    case 1:
                        cadastrarFuncionario();
                        break;
                    case 2:
                        listarFuncionarios();
                        break;
                    case 3:
                        view.mostrarMensagem("Voltando ao menu principal...");
                        break;
                    default:
                        view.mostrarMensagem("⚠️ Opção inválida!");
                }
            } catch (NumberFormatException e) {
                view.mostrarMensagem("⚠️ Por favor, digite um número válido.");
                op = 0;
            }
        } while (op != 3);
    }

    private void cadastrarFuncionario() {
        int id = view.lerId();
        String nome = view.lerNome();
        String telefone = view.lerTelefone();
        String cargo = view.lerCargo();

        Funcionario novo = new Funcionario(id, nome, telefone, cargo);
        funcionarios.add(novo);

        view.mostrarMensagem("🧑‍💼 Funcionário cadastrado com sucesso!");
    }

    private void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            view.mostrarMensagem("⚠️ Nenhum funcionário cadastrado no sistema.");
            return;
        }

        System.out.println("\n--- LISTA DE FUNCIONÁRIOS ---");
        for (Funcionario f : funcionarios) {
            f.exibirInformacoes();
            System.out.println("-----------------------------");
        }
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}