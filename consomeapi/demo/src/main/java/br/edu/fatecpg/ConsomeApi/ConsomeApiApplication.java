package br.edu.fatecpg.ConsomeApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

import static br.edu.fatecpg.ConsomeApi.service.ConsomeGemini.fazerPergunta;

@SpringBootApplication
public class ConsomeApiApplication {

    public ConsomeApiApplication() throws IOException, InterruptedException {
    }

    public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(ConsomeApiApplication.class, args);


		String resposta = fazerPergunta("Como programar em java?");
		System.out.println(resposta);
	}
}

