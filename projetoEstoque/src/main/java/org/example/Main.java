package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int escolha;
        Scanner scanner = new Scanner(System.in);

        Produto produto = new Produto();

        do {
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Exibir Produtos");
            System.out.println("3 - Sair.");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    produto.cadastrarProduto();
                    break;
                case 2:
                    produto.exibirProdutos();
                    break;
                case 3:
                    System.out.println("Encerrando programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (escolha != 3);

        scanner.close();
    }
}
