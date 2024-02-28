import java.util.Scanner;

public class Soma {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int Matriz1[][] = new int [3][3];
        int Matriz2[][] = new int [3][3];
        int ResultadoM[][] = new int [3][3];

        System.out.println("Digite os valores da primeira matriz:");

        for(int x=0; x<3; x++){
            for(int y=0; y<3; y++){
                Matriz1[x][y] = scanner.nextInt();
            }
        }

        System.out.println("Digite os valores da segunda matriz: ");

        for(int x=0; x<3; x++){
            for(int y=0; y<3; y++){
                Matriz2[x][y] = scanner.nextInt();
            }
        }

        for(int x=0; x<3; x++){
            for(int y=0; y<3; y++){
                ResultadoM[x][y] = Matriz1[x][y] + Matriz2[x][y];
                System.out.println(Matriz1[x][y]+ " + " + Matriz2[x][y] +" = "+ ResultadoM[x][y]);
            }
        }
        scanner.close();  

    }
}
