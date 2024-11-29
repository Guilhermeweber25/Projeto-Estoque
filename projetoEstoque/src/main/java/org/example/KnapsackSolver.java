package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KnapsackSolver {
    private int capacidadeMaxima;

    public KnapsackSolver(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public List<Produto> resolver(List<Produto> produtos) {
        if (produtos == null || produtos.isEmpty()) {
            System.out.println("Nenhum produto disponível para otimização.");
            return new ArrayList<>();
        }

        // Ordenar por valor unitário decrescente (preço / quantidade)
        produtos.sort(Comparator.comparingDouble(
                p -> -((double) p.getPreco() / p.getQuantidade())));

        List<Produto> selecionados = new ArrayList<>();
        int capacidadeRestante = capacidadeMaxima;

        for (Produto produto : produtos) {
            if (capacidadeRestante <= 0) {
                break;
            }

            if (produto.getQuantidade() <= capacidadeRestante) {
                // Adiciona o produto inteiro
                selecionados.add(produto);
                capacidadeRestante -= produto.getQuantidade();
            } else {
                // Adiciona apenas a fração do produto que cabe
                int quantidadeParcial = capacidadeRestante;
                float precoParcial = produto.getPreco() / produto.getQuantidade() * quantidadeParcial;

                Produto parcial = new Produto(
                        produto.getNome(),
                        produto.getCodigo(),
                        precoParcial,
                        quantidadeParcial
                );
                selecionados.add(parcial);
                capacidadeRestante = 0; // Mochila cheia
            }
        }

        // Exibe os produtos selecionados
        System.out.println("Produtos selecionados para a mochila:");
        for (Produto p : selecionados) {
            System.out.println("Nome: " + p.getNome());
            System.out.println("Código: " + p.getCodigo());
            System.out.println("Preço Total: " + p.getPreco());
            System.out.println("Quantidade Selecionada: " + p.getQuantidade());
            System.out.println("-----------------------");
        }

        System.out.println("Capacidade restante: " + capacidadeRestante);

        return selecionados;
    }
}
