package fatec.fatec.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ConsomeApi {
    public List<Comments> obterComentarios() throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/comments";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new Gson();
        Type commentListType = new TypeToken<List<Comments>>() {}.getType();
        return gson.fromJson(json, commentListType);
    }
}
