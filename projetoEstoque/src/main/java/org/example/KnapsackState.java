package org.example;

public class KnapsackState {
    private int capacidadeAtual;
    private float valorTotal;

    public KnapsackState(int capacidadeAtual) {
        this.capacidadeAtual = capacidadeAtual;
        this.valorTotal = 0;
    }

    public int getCapacidadeAtual() {
        return capacidadeAtual;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        if (quantidade > capacidadeAtual) {
            throw new IllegalArgumentException("Quantidade excede a capacidade restante!");
        }

        this.capacidadeAtual -= quantidade;
        this.valorTotal += produto.getPreco() * quantidade;
    }
}
