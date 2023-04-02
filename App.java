import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexao HTTP e buscar os top 250 filmes
        String url = ("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json");
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        // extrair so os dados que interessam (titulo, poster, classificacao)
        var parse = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parse.parse(body) ;
        System.out.println(listaDeFilmes.size());
        // exibir e manipular os dados
    }
}
