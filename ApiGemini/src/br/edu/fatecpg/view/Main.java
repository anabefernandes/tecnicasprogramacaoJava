package br.edu.fatecpg.view;

import br.edu.fatecpg.service.ConsomeApi;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Faça uma pergunta ou digite sair:");
            String pergunta = scanner.nextLine();
            if (pergunta.equalsIgnoreCase("sair")) {
                System.out.println("Saindo...");
                break;
            } else {
                String resposta = ConsomeApi.fazerPergunta(pergunta);
                System.out.println(resposta);
            }

        }
    }
}
