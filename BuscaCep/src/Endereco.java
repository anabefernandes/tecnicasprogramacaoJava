import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Endereco {
    public String cep;
    @SerializedName("logradouro")
    public String rua;
    public String bairro;
    @SerializedName("localidade")
    public String cidade;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }

    void addBancoDados() throws SQLException, IOException, InterruptedException {
        String insertQuery = "INSERT INTO busca_cep (cep, rua, bairro, cidade) VALUES (?, ?, ?, ?)";
        String selectQuery = "SELECT id FROM busca_cep WHERE cep = ?";

        if (cep == null || cep.isEmpty()) {
            System.out.println("Erro: O campo CEP deve ser preenchido.");
            return;
        }

        ConsomeApi api = new ConsomeApi();
        String responseJson = api.consomeApiCep(this.cep);

        Gson gson = new Gson();
        Endereco enderecoData = gson.fromJson(responseJson, Endereco.class);

        if (enderecoData.rua == null || enderecoData.bairro == null || enderecoData.cidade == null) {
            System.out.println("Erro: Dados incompletos retornados pela API.");
            return;
        }

        this.rua = enderecoData.rua;
        this.bairro = enderecoData.bairro;
        this.cidade = enderecoData.cidade;

        try (Connection connection = ConexaoBanco.connect();
             PreparedStatement stmtInsert = connection.prepareStatement(insertQuery);
             PreparedStatement stmtSelect = connection.prepareStatement(selectQuery);
             FileWriter gravar = new FileWriter(new File("log.txt"), true)) {

            stmtInsert.setString(1, this.cep);
            stmtInsert.setString(2, this.rua);
            stmtInsert.setString(3, this.bairro);
            stmtInsert.setString(4, this.cidade);

            int linhas = stmtInsert.executeUpdate();
            if (linhas > 0) {
                System.out.println("CEP adicionado com sucesso.");
            } else {
                System.out.println("Falha ao adicionar o CEP.");
            }

            stmtSelect.setString(1, this.cep);

            String jsonTime = ConsomeApi.consomeApiData();
            Data data = gson.fromJson(jsonTime, Data.class);

            try (ResultSet rs = stmtSelect.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String mensagemLog = String.format("Id: %d. CEP: %s. Data e hora: %s%n",
                            id, this.cep, data.getHora());
                    gravar.write(mensagemLog);
                }
            } catch (SQLException e) {
                System.out.println("Erro ao consultar o banco de dados.");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            System.out.println("Erro ao acessar o banco de dados.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Erro ao salvar informações no arquivo.");
            e.printStackTrace();
        }
    }

    public static void consultaBanco(Connection connection) {
        String query = "SELECT * FROM busca_cep ORDER BY id ASC";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id2 = rs.getInt("id");
                String cep = rs.getString("cep");
                String rua = rs.getString("rua");
                String cidade = rs.getString("cidade");

                System.out.println("ID: " + id2 + "\n" +
                        "CEP: " + cep + "\n" +
                        "Rua: " + rua + "\n" +
                        "Cidade: " + cidade + "\n" +
                        "--------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar o banco de dados.");
            e.printStackTrace();
        }
    }

    static Connection connection;

    static {
        try {
            connection = ConexaoBanco.connect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
