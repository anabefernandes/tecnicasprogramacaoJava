package br.edu.fatec.models;

public class Compra {
	private String produto;
	private double preco;
	private int quantidade;
	
	public Compra(String produto, double preco, int quantidade) {
		super();
		this.produto = produto;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public String getProduto() {
		return produto;
	}
	
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void finalizar(Cupom cupom) {
		this.preco -= cupom.getValor();
		finalizar(this.preco);
	}
	private void finalizar(double preco) {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "Compra [produto=" + produto + ", preco=" + preco + ", quantidade=" + quantidade + "]";
	}
}

