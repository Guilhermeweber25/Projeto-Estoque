package org.example;
import java.util.*;

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

        System.out.println("Digite o preço do produto (use ponto.para decimais):");
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
        System.out.println("Digite o nome do produto: ");
        String nomeBuscar = scanner.nextLine();
        boolean ProdutoEncontrado = false;
        System.out.println("\nLista de produtos cadastrados:");
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nomeBuscar)){
                System.out.println("Nome: " + p.getNome() + " valor: " + p.getPreco() + " código: " + p.getCodigo() + " Quantidade: " + p.getQuantidade());
                System.out.println();
                ProdutoEncontrado = true;
            }
        }
        if (!ProdutoEncontrado){
            System.out.println("Produto não encontrado!");
        }
    }

    public void atualizarProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do produto que deseja atualizar:");
        int codigoAtualizar = scanner.nextInt();

        boolean encontrado = false;
        for (Produto p : produtos) {
            if (p.getCodigo() == codigoAtualizar) {
                encontrado = true;
                System.out.println("Produto encontrado: " + p.getNome());

                System.out.println("Digite a nova quantidade:");
                int novaQuantidade = scanner.nextInt();
                p.quantidade = novaQuantidade;

                System.out.println("Digite o novo preço:");
                float novoPreco = scanner.nextFloat();
                p.preco = novoPreco;

                System.out.println("Produto atualizado com sucesso!");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Produto não encontrado!");
        }
    }

    public void removerProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do produto que deseja remover:");
        int codigoRemover = scanner.nextInt();

        Iterator<Produto> iterator = produtos.iterator();
        boolean encontrado = false;

        while (iterator.hasNext()) {
            Produto p = iterator.next();
            if (p.getCodigo() == codigoRemover) {
                iterator.remove();
                encontrado = true;
                System.out.println("Produto removido com sucesso!");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Produto não encontrado!");
        }
    }

    public void buscarProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do produto que deseja buscar:");
        int codigoBuscar = scanner.nextInt();

        boolean encontrado = false;
        for (Produto p : produtos) {
            if (p.getCodigo() == codigoBuscar) {
                System.out.println("\nProduto encontrado:");
                System.out.println("Nome: " + p.getNome());
                System.out.println("Código: " + p.getCodigo());
                System.out.println("Preço: " + p.getPreco());
                System.out.println("Quantidade: " + p.getQuantidade());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Produto não encontrado!");
        }
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Preço: " + preco);
        System.out.println("Quantidade: " + quantidade);
    }

    public String getNome() { return nome; }
    public int getCodigo() { return codigo; }
    public float getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}