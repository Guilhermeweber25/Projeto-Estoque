package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Produto {
    private String nome;
    private int codigo;
    private float preco;
    private int quantidade;

    // Lista para armazenar os produtos cadastrados
    private static List<Produto> produtos = new ArrayList<>();

    public Produto() {}

    public Produto(String nome, int codigo, float preco , int quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void cadastrarProduto() {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();

        System.out.println("Digite o código do produto:");
        int codigo = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer

        System.out.println("Digite quantidade do produto:");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o preço do produto (use ponto para decimais):");
        String precoStr = scanner.nextLine();

        try {
            float preco = Float.parseFloat(precoStr);

            // Cria um novo objeto Produto e o adiciona à lista
            Produto novoProduto = new Produto(nome, codigo, preco, quantidade);
            produtos.add(novoProduto);
            System.out.println("Produto cadastrado com sucesso!");

        } catch (NumberFormatException e) {
            System.out.println("Erro: Formato de preço inválido. Use ponto como separador decimal.");
        }
    }

    public void exibirProdutos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nLista de produtos cadastrados:");
        System.out.println("Digite o nome do produto: ");
        String nomeBuscar = scanner.nextLine();


        for (Produto p : produtos) {
            System.out.println("Nome: " + p.getNome() + " valor: " + p.getPreco() + " código: " + p.getCodigo() + " Quantidade: " + p.getQuantidade());
            System.out.println();
        }
    }


    public String getNome() { return nome; }
    public int getCodigo() { return codigo; }
    public float getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }
}