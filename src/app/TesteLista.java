package app;

import entities.Produto;
import entities.MetodosUteis;
import java.util.ArrayList;
import java.util.Scanner;

public class TesteLista {

    public static void main(String[] args) {
        double imposto = 0.0;
        int opcaoPag = 0;
        double parcelas = 0.0;
        int quantidadeSelecionada = 0;

        MetodosUteis objMetodosUteis = new MetodosUteis();
        Scanner leitor = new Scanner(System.in);

        ArrayList<Produto> listaProdutos = objMetodosUteis.pegarListaProdutos();
        ArrayList<Produto> listaCarrinhoComrpas = new ArrayList<>();

        int continuarCompras = 1;

        do {
            objMetodosUteis.imprimirTabelaDeProdutos(listaProdutos);

            System.out.print("\nDigite o código do produto que você deseja comprar: ");
            String codigoProdutoSelecionado = leitor.next().toUpperCase();

            Produto produtoSelecionado = objMetodosUteis.buscaProdutoPorCodigo(codigoProdutoSelecionado, listaProdutos);

            if (produtoSelecionado != null) {
                System.out.printf("\nProduto selecionado:\n %s \n", produtoSelecionado.toString());
                System.out.print("\nInforme a quantidade que deseja comprar: ");
                quantidadeSelecionada = leitor.nextInt();

                if (quantidadeSelecionada <= produtoSelecionado.getQuantidade()) {
                    int resultadoBaixaEstoque = (produtoSelecionado.getQuantidade() - quantidadeSelecionada);
                    produtoSelecionado.setQuantidade(resultadoBaixaEstoque);

                    listaCarrinhoComrpas.add(new Produto(
                            produtoSelecionado.getCodigo(),
                            produtoSelecionado.getNome(),
                            produtoSelecionado.getValor(),
                            quantidadeSelecionada
                    ));

                    System.out.printf("\nProduto %s foi adicionado ao carrinho!", produtoSelecionado.getNome());
                } else {
                    System.out.printf("\nA quantidade informada é inválida. Você solicitou %d, mas nosso estoque contém apenas %d unidades do produto %s",
                            quantidadeSelecionada,
                            produtoSelecionado.getQuantidade(),
                            produtoSelecionado.getNome());
                }
            } else {
                System.out.printf("\nNenhum produto encontrado com o código = %s", codigoProdutoSelecionado);
            }

            System.out.print("\nDeseja continuar comprando? [1 = SIM / 2 = NÃO]: ");
            continuarCompras = leitor.nextInt();
        } while (continuarCompras == 1);

        System.out.print("\nResumo total da compra:\n ITENS SELECIONADOS:\n");
        for (Produto produto : listaCarrinhoComrpas) {
            System.out.println(produto.toString());
        }

        double valorTotal = objMetodosUteis.calcularValorTotalCompra(listaCarrinhoComrpas);
        valorTotal = valorTotal * quantidadeSelecionada;
        System.out.printf("\nO valor total da compra foi de: R$ %.2f", valorTotal);
        imposto = valorTotal * 0.09;

        System.out.println("\nDIGITE SUA OPÇÃO DE PAGAMENTO:\n");
        System.out.println("1- À VISTA (10% DE DESCONTO) | 2 - CARTÃO (10% DE ACRÉSCIMO) | 3 - DUAS VEZES NO CARTÃO (15% DE ACRÉSCIMO)");
        opcaoPag = leitor.nextInt();

        handlePayment(opcaoPag, valorTotal, imposto, parcelas);
    }

    private static void handlePayment(int opcaoPag, double valorTotal, double imposto, double parcelas) {
        if (opcaoPag == 1) {
            valorTotal = valorTotal - (valorTotal * 0.1);
        } else if (opcaoPag == 2) {
            valorTotal = valorTotal + (valorTotal * 0.1);
        } else if (opcaoPag == 3) {
            valorTotal = valorTotal + (valorTotal * 0.15);
            parcelas = valorTotal / 2;
        }

        displayInvoice(valorTotal, imposto, parcelas);
    }

    private static void displayInvoice(double valorTotal, double imposto, double parcelas) {
        System.out.println("\n------------NOTA FISCAL-----------\n");
        System.out.println("Total pago: R$" + valorTotal);
        System.out.println("9% de impostos sobre os produtos: R$ " + imposto);

        if (parcelas > 0) {
            System.out.println("Valor das parcelas (Dividido em duas vezes): R$" + parcelas);
        }

        System.out.println("\nObrigado e volte sempre!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
