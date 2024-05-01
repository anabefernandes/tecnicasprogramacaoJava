package br.edu.fatec.models;

public class Cupom {
	private double valor;
	private int cod;
	
	public Cupom(double valor, int cod) {
		super();
		this.valor = valor;
		this.cod = cod;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	
}
