package br.edu.fatec.main;
import java.util.Scanner;
import br.edu.fatec.models.Aluno;
import br.edu.fatec.models.Compra;
import br.edu.fatec.models.Cupom;
import br.edu.fatec.models.Disciplina;

public class Principal {

	public static void main(String[] args) {
		
		var scan = new Scanner(System.in);
		System.out.print("Digite o nome do aluno: "); String nome = scan.nextLine();
		System.out.print("Digite o documento do aluno: "); String doc =
		scan.nextLine(); System.out.print("Digite o nome da disciplina: "); String
		nome_disciplina = scan.nextLine();
		System.out.print("Digite o codigo da disciplina : "); int cod_disciplina =
		scan.nextInt(); scan.nextLine(); scan.close(); var aluno = new Aluno(nome,
		doc); var disciplina = new Disciplina(nome_disciplina, cod_disciplina);
		disciplina.setAluno(aluno); System.out.println(disciplina);
		var cupom = new Cupom(4.0, 5);
		var compra = new Compra("Iphone", 1400.00, 1);
		compra.finalizar(cupom);
		
		}
	}

