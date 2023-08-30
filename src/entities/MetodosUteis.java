package entities;

import java.util.ArrayList;

import entities.Produto;

public class MetodosUteis {

    public ArrayList<Produto> pegarListaProdutos() {
        ArrayList<Produto> listaProdutos = new ArrayList<>();

        listaProdutos.add(new Produto("G4-1", "Teclado", 40.0, 10));
        listaProdutos.add(new Produto("G4-2", "Mouse", 5.0, 10));
        listaProdutos.add(new Produto("G4-3", "Cadeira", 100.0, 10));
        listaProdutos.add(new Produto("G4-4", "Gabinete", 110.0, 10));
        listaProdutos.add(new Produto("G4-5", "Memória RAM", 45.0, 10));
        listaProdutos.add(new Produto("G4-6", "Monitor", 600.0, 10));
        listaProdutos.add(new Produto("G4-7", "Headset", 40.0, 10));
        listaProdutos.add(new Produto("G4-8", "Suporte para Notebook", 80.0, 10));
        listaProdutos.add(new Produto("G4-9", "Mousepad", 10.0, 10));
        listaProdutos.add(new Produto("G4-10", "Notebook", 2000.0, 10));

        return listaProdutos;
    }

    public void imprimirTabelaDeProdutos(ArrayList<Produto> listaProdutosAtualizada) {
        System.out.println("\nLista de Produtos da Loja devStore");
        System.out.println("\nA loja do desenvolvedore!\n");

        for (Produto produtoIterado : listaProdutosAtualizada) {
            System.out.println(produtoIterado.toString());
        }
    }

    public Produto buscaProdutoPorCodigo(String codigoProduto, ArrayList<Produto> listaProdutosParaBusca) {
        for (Produto produtoIterado : listaProdutosParaBusca) {
            if (codigoProduto.equals(produtoIterado.getCodigo())) {
                return produtoIterado;
            }
        }
        return null;
    }

    public double calcularValorTotalCompra(ArrayList<Produto> listaProdutosParaCalcular) {
        double valorTotal = 0.0;

        for (Produto produtoIterado : listaProdutosParaCalcular) {
            valorTotal += produtoIterado.getValor();
        }

        return valorTotal;
    }
}
