package br.edu.fatec.models;

public class Disciplina {
	Aluno aluno;
	private String nome;
	private int cod;

	public Disciplina(String nome, int cod) {
	this.nome = nome;
	this.cod = cod;
	}
	public String getNome() {
	return nome;
	}
	public void setNome(String nome) {
	this.nome = nome;
	}
	public int getCod() {
	return cod;
	}
	public void setCod(int cod) {
	this.cod = cod;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
	return "Disciplina [nome=" + nome + ", cod=" + cod + " " + aluno + "]";
	}
}
