package entities;

public class Produto {

    private String codigo;
    private String nome;
    private double valor;
    private int quantidade;

    public Produto() {
    }

    public Produto(String codigo, String nome, double valor, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String toString() {
        return "COD " + codigo + "\t" + nome + 
               "\tVALOR " + valor + 
               "\tQUANTIDADE " + quantidade;
    }
}
