import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;

        Connection connection = null;
        try {
            connection = ConexaoBanco.connect();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
            return;
        }

        while (true) {
            System.out.println("Menu:");
            System.out.println("1 - Consultar CEP");
            System.out.println("2 - Listar CEPs consultados");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            num = scanner.nextInt();
            scanner.nextLine();

            switch (num) {
                case 1:
                    consultarCep(scanner, connection);
                    break;
                case 2:
                    listarCepsConsultados(connection);
                    break;
                case 3:
                    registrarSaida();
                    System.out.println("Saindo");
                    try {
                        if (connection != null && !connection.isClosed()) {
                            connection.close();
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro ao fechar a conexão.");
                        e.printStackTrace();
                    }
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void consultarCep(Scanner scanner, Connection connection) {
        System.out.print("Digite o CEP para consultar: ");
        String cep = scanner.nextLine();

        Endereco endereco = new Endereco();
        endereco.setCep(cep);
        endereco.toString();

        try {
            endereco.addBancoDados();
            System.out.println("Consulta do CEP realizada e registrada.");
        } catch (SQLException | IOException | InterruptedException e) {
            System.out.println("Erro ao consultar o CEP.");
            e.printStackTrace();
        }
    }

    private static void listarCepsConsultados(Connection connection) {
        Endereco.consultaBanco(connection);
    }

    private static void registrarSaida() {
        try (FileWriter logFile = new FileWriter("log.txt", true)) {
            logFile.write("Saída do programa - " + java.time.LocalDateTime.now() + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao registrar saída no log.");
            e.printStackTrace();
        }
    }
}