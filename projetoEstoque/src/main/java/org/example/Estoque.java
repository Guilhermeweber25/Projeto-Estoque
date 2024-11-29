package org.example;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos = new ArrayList<>();


    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto adicionado ao estoque com sucesso!");
    }

    public void removerProduto(int codigo) {
        Produto produtoRemover = buscarProduto(codigo);
        if (produtoRemover != null) {
            produtos.remove(produtoRemover);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    public Produto buscarProduto(int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        System.out.println("Produto com código " + codigo + " não encontrado.");
        return null;
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }
        System.out.println("Lista de produtos no estoque:");
        for (Produto p : produtos) {
            p.exibirDetalhes();
            System.out.println("-----------------------");
        }
    }

    public void atualizarQuantidade(int codigo, int novaQuantidade) {
        Produto produto = buscarProduto(codigo);
        if (produto != null) {
            produto.setQuantidade(novaQuantidade);
            System.out.println("Quantidade do produto atualizada com sucesso!");
        }
    }
}
