package br.edu.fatecpg.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsomeApi {
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=AIzaSyCCD9ZO4-M_OxD5Zdaj8KnXUEpLAcZhDu0";
    private static final Pattern RESP_PATTERN = Pattern.compile("\"text\"\\s*:\\s*\"([^\"]+)\"");

    //fazerPergunta()
    public static String fazerPergunta(String pergunta) throws IOException, InterruptedException {
        String jsonRequest = gerarJsonRequest(pergunta);
        String respostaJson = enviarRequisicao(jsonRequest);
        return extrairResposta(respostaJson);
    }


    //gerarJsonRequest()
    private static String gerarJsonRequest(String pergunta) {
        String promptFormatado = "O resultado gerado não deve possuir formatação ou caracteres especiais. Pergunta: " + pergunta;
        return "{\"contents\":[{\"parts\":[{\"text\":\"" + promptFormatado + "\"}]}]}";
    }

    //enviarRequisicao()
    private static String enviarRequisicao(String jsonRequest) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .header("Content-Type", "application/json")
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            }else {
                return "Código erro: " + response.statusCode();
            }
        }catch (IOException | InterruptedException e ) {
            return "Erro ao conectar: " + e.getMessage();
        }
    }
    //extrairResposta()
    private static String extrairResposta(String respostaJson) {
        StringBuilder resposta = new StringBuilder();
        for (String linha : respostaJson.lines().toList()){
            Matcher matcher = RESP_PATTERN.matcher(linha);
            if (matcher.find()){
                resposta.append(matcher.group(1)).append(" ");

            }
        }
        return resposta.toString().trim();
    }


}
