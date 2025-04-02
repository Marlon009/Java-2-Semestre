package br.com.fatec.pg.processamento;

import br.com.fatec.pg.processamento.model.Processar;
import br.com.fatec.pg.processamento.service.ConsumoApi;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;

@SpringBootApplication
public class ProcessamentoDadosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProcessamentoDadosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
           Gson gson = new Gson();

		   String processar = ConsumoApi.obterDados("https://jsonplaceholder.typicode.com/posts");
		   System.out.println(processar);
		   Processar enderecoJson = gson.fromJson(processar, Processar.class);
		   System.out.println(enderecoJson);
	}

	List<Processar> processar = new ArrayList<>();


	List<Processar> ordenar = new processar.stream().filter(p -> getTitle().equals("title")).toList();
	title.forEach(System.out::println);
}
