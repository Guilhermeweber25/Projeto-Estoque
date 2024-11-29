package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int escolha;
        Scanner scanner = new Scanner(System.in);

        Produto produto = new Produto();
        Estoque estoque = new Estoque();

        do {
            System.out.println("\n--- Sistema de Controle de Estoque ---");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Exibir todos os produtos");
            System.out.println("3 - Atualizar produto");
            System.out.println("4 - Remover produto");
            System.out.println("5 - Buscar produto");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            escolha = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (escolha) {
                case 1:
                    produto.cadastrarProduto();
                    break;
                case 2:
                    estoque.listarProdutos();
                    break;
                case 3:
                    produto.atualizarProduto();
                    break;
                case 4:
                    System.out.print("Digite o código do produto a ser removido: ");
                    int codigoRemover = scanner.nextInt();
                    estoque.removerProduto(codigoRemover);
                    break;
                case 5:
                    System.out.print("Digite o código do produto a ser buscado: ");
                    int codigoBuscar = scanner.nextInt();
                    estoque.buscarProduto(codigoBuscar);
                    break;
                case 6:
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (escolha != 6);

        scanner.close();
    }
}
