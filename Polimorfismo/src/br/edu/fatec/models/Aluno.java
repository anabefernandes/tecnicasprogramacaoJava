package br.edu.fatec.models;

public class Aluno {
	private String nome;
	private String doc;


	public Aluno(String nome, String doc) {
	this.nome = nome;
	this.doc = doc;

	}

	public String getNome() {
	return nome;
	}

	public void setNome(String nome) {
	this.nome = nome;
	}

	public String getDoc() {
	return doc;
	}

	public void setDoc(String doc) {
	this.doc = doc;
	}



	@Override
	public String toString() {
	return "Aluno [nome=" + nome + ", doc=" + doc + "]";
		}
	}
