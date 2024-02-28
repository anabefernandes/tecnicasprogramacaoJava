import java.util.Scanner;

public class Multiplicacao {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String login, senha;
        int i;
        String matriz[][] = new String [][]{
        {"ana@fatec", "123456"},
        {"manu@fatec", "123456"},
        {"bia@fatec", "123456"},
        {"nome@fatec", "123456"},
        {"name@fatec", "123456"},
        {"yourname@fatec", "123456"},
        };

        System.out.println("Login: ");
        login = scanner.nextLine();
        System.out.println("Senha: ");
        senha = scanner.nextLine();

        for(i=0; i<6; i++){
            if (matriz[i][0].equals(login) && matriz[i][1].equals(senha)) {
            System.out.println("Login e senha corretos!");  
            break;        
            }
        }
        if(i == 6){
            System.out.println("Login ou senha incorretos! Tente novamente.");
        }
        scanner.close();     
    }
}
