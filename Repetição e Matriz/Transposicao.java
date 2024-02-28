import java.util.Scanner;

public class Transposicao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Digite o elemento da matriz na posição [" + i + "][" + j + "]:");
                matriz[i][j] = scanner.nextInt();
            }
        }

        int[][] matrizTransposta = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrizTransposta[j][i] = matriz[i][j];
            }
        }

        System.out.println("Matriz transposta:");
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrizTransposta[i][j] + "   ");
            }
            System.out.println();
        }
        scanner.close();
    }
}