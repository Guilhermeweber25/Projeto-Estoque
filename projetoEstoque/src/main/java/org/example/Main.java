package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int escolha;
        Scanner scanner = new Scanner(System.in);

        Estoque estoque = new Estoque();

        do {
            System.out.println("\n--- Sistema de Controle de Estoque ---");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Exibir todos os produtos");
            System.out.println("3 - Atualizar produto");
            System.out.println("4 - Remover produto");
            System.out.println("5 - Buscar produto");
            System.out.println("6 - Resolver mochila (otimização de estoque)");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");

            escolha = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (escolha) {
                case 1:
                    // Cadastrar produto
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o código do produto: ");
                    int codigo = scanner.nextInt();

                    System.out.print("Digite a quantidade do produto: ");
                    int quantidade = scanner.nextInt();

                    System.out.print("Digite o preço do produto (use ponto para decimais): ");
                    float preco = scanner.nextFloat();

                    Produto novoProduto = new Produto(nome, codigo, preco, quantidade);
                    estoque.adicionarProduto(novoProduto);
                    break;

                case 2:
                    // Exibir todos os produtos
                    estoque.listarProdutos();
                    break;

                case 3:
                    // Atualizar produto
                    System.out.print("Digite o código do produto a ser atualizado: ");
                    int codigoAtualizar = scanner.nextInt();
                    Produto produtoAtualizar = estoque.buscarProduto(codigoAtualizar);

                    if (produtoAtualizar != null) {
                        System.out.print("Digite a nova quantidade: ");
                        int novaQuantidade = scanner.nextInt();

                        System.out.print("Digite o novo preço: ");
                        float novoPreco = scanner.nextFloat();

                        produtoAtualizar.setQuantidade(novaQuantidade);
                        produtoAtualizar.setPreco(novoPreco);

                        System.out.println("Produto atualizado com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;

                case 4:
                    // Remover produto
                    System.out.print("Digite o código do produto a ser removido: ");
                    int codigoRemover = scanner.nextInt();
                    estoque.removerProduto(codigoRemover);
                    break;

                case 5:
                    // Buscar produto
                    System.out.print("Digite o código do produto a ser buscado: ");
                    int codigoBuscar = scanner.nextInt();
                    Produto produtoBuscado = estoque.buscarProduto(codigoBuscar);

                    if (produtoBuscado != null) {
                        produtoBuscado.exibirDetalhes();
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;

                case 6:
                    // Resolver mochila
                    System.out.print("Digite a capacidade máxima da mochila: ");
                    int capacidadeMochila = scanner.nextInt();
                    estoque.resolverMochila(capacidadeMochila);
                    break;

                case 7:
                    // Sair
                    System.out.println("Encerrando programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (escolha != 7);

        scanner.close();
    }
}
