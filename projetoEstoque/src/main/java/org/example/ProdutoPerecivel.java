package org.example;

import java.time.LocalDate;

public class ProdutoPerecivel extends Produto {
    private LocalDate dataValidade;

    public ProdutoPerecivel(String nome, int codigo, float preco, int quantidade, LocalDate dataValidade) {
        super(nome, codigo, preco, quantidade);
        this.dataValidade = dataValidade;
    }

    public LocalDate getDataValidade() { return dataValidade; }

    // Sobrescrevendo o método para exibir detalhes adicionais
    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();  // Chama o método da classe pai
        System.out.println("Data de Validade: " + dataValidade);
    }
}
