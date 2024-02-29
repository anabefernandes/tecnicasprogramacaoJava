import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int operacao;
        double num1, num2, resultado=0;
        Scanner scanner = new Scanner(System.in);   

        while (true) {
            System.out.println("Digite a operação desejada: \n 1- Soma \n 2- Divisão \n 3- Multiplicação \n 4- Subtração \n 5- Sair" );
            operacao = scanner.nextInt();
            if (operacao==5) {
                break;
            }

            System.out.println("Digite o primeiro valor: ");
            num1 = scanner.nextInt();

            System.out.println("Digite o segundo valor: ");
            num2 = scanner.nextInt();            
            Calculadora calc = new Calculadora();
            switch(operacao){
                case 1:
                    resultado = calc.soma(num1, num2);                            
                break;
                case 2:
                    resultado = calc.divisao(num1, num2);                            
                break;
                case 3:
                    resultado = calc.multiplicacao(num1, num2);                            
                break;            
                case 4:
                    resultado = calc.subtracao(num1, num2);                            
                break;
            }
            System.out.println(resultado);
        }       

    }
}

