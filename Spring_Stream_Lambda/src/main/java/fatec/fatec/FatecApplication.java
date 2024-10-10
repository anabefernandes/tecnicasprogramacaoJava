package fatec.fatec;

import fatec.fatec.service.Comments;
import fatec.fatec.service.ConsomeApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class FatecApplication {

	public static void main(String[] args) {
		SpringApplication.run(FatecApplication.class, args);
		ConsomeApi consomeApi = new ConsomeApi();
		try{
			List<Comments> comment = consomeApi.obterComentarios();

			List<String> emails = comment.stream()
					.map(Comments::getEmail)
					.toList();
			emails.forEach(System.out::println);

		} catch (IOException | InterruptedException e){
			System.out.println("Erro na api: " + e.getMessage());
		}
	}

}
