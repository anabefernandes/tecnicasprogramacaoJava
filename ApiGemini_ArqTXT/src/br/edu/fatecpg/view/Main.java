package br.edu.fatecpg.view;

import br.edu.fatecpg.service.ConsomeApi;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> perguntas = new ArrayList<>();

        System.out.println("Quantas multiplas perguntas deseja fazer? Min 3 perguntas.");
        int qntPerguntas = scanner.nextInt();
        scanner.nextLine();
        int i = 1;
        if (qntPerguntas >=3){
            while (i<=qntPerguntas) {
                System.out.println("Digite a pergunta: ");
                String pergunta = scanner.nextLine();
                perguntas.add(pergunta);
                i++;
            }
            String resumo = ConsomeApi.fazerPergunta(String.valueOf("Faça um resumo" + perguntas));
            String perguntasFormatadas = String.join(System.lineSeparator(), perguntas);
            criarArquivo(perguntasFormatadas, resumo);
        } else {
            System.out.println("Quantidade de perguntas inválidas, insira um número maior que 3 perguntas!");
        }

    }

    public static void criarArquivo(String perg, String resp){
        try {
            FileWriter escrita = new FileWriter("arquivos.txt", true);
            escrita.write("Perguntas: " + perg + System.lineSeparator());
            escrita.write("Respostas: " + resp);
            escrita.write(System.lineSeparator());
            escrita.close();
            System.out.println("Resposta salva com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar a resposta.");
            e.printStackTrace();
        }
    }
}

