package br.edu.fatecpg.tp.main;
import java.util.Scanner;

import br.edu.fatecpg.tp.abstracao.Carro;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		Carro meuCarro = new Carro();
		Carro carroNovo = new Carro();
		System.out.println("Digite a marca do seu carro: ");
		String marca = scan.nextLine();
		//meuCarro.marca = marca;
		meuCarro.setMarca(marca);
		System.out.println("Digite o modelo do seu carro: ");
		String modelox = scan.nextLine();
		//meuCarro.modelo = modelo;
		meuCarro.setModelo(modelox);
		System.out.println("Digite a aceleração: ");
		double acle = scan.nextDouble();
		meuCarro.acelerar(acle);
		System.out.println("Digite a aceleração: ");
		acle = scan.nextDouble();
		meuCarro.acelerar(acle);
		System.out.println("Digite a aceleração: ");
		acle = scan.nextDouble();
		meuCarro.acelerar(acle);
		System.out.println(meuCarro.getMarca());
		//System.out.println(meuCarro.marca);
		meuCarro.girarChave();
		
	}

}
