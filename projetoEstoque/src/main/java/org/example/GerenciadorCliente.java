package org.example;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorCliente {
    private List<Cliente> clientes = new ArrayList<>();

    // Método para adicionar cliente
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    // Método para listar todos os clientes
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("Lista de clientes:");
        for (Cliente c : clientes) {
            c.exibirDetalhesCliente();
            System.out.println("-----------------------");
        }
    }

    // Método para buscar cliente pelo CPF
    public Cliente buscarCliente(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        System.out.println("Cliente não encontrado com CPF: " + cpf);
        return null;
    }

    // Método para remover cliente pelo CPF
    public void removerCliente(String cpf) {
        Cliente cliente = buscarCliente(cpf);
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente removido com sucesso!");
        }
    }
}
