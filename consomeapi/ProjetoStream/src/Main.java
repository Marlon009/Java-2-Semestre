import br.edu.fatecpg.model.Pessoa;
import br.edu.fatecpg.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Crie uma classe produto(nome,categoria e preco)
        //Crie 5 objetos
        //filtre os produtos da categoria "Eletronic"
        //Aplique 10% de desconto em produtos de preco maior que 100
        //Apresentar a soma do preco de todos os produtos

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Notebook","Eletronic", 9999.99));
        produtos.add(new Produto("Celular","Eletronic", 7777.77));
        produtos.add(new Produto("Garrafa","Alimenticio", 50.99));
        produtos.add(new Produto("Mouse RGB","Eletronic", 99.90));
        produtos.add(new Produto("Aspirador de pó","Eletrodoméstico", 2089.60));

        List<Produto> eletronicos = produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletronic"))
                .toList();
        eletronicos.forEach(System.out::println);

        produtos.stream()
                .filter(p -> p.getPreco() > 100.00)
                .forEach(p -> p.setPreco(p.getPreco() * 0.9));
        produtos.forEach(System.out::println);

        double somaPreco = produtos.stream()
                .map(p -> p.getPreco())
                .reduce(0.0,Double::sum);
        System.out.println("total: " + somaPreco);


        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Ale", 31));
        pessoas.add(new Pessoa("Aline", 28));
        pessoas.add(new Pessoa("Ana", 15));
        pessoas.add(new Pessoa("Daniel", 16));
        pessoas.add(new Pessoa("Pedro", 62));

        //Listar maiores de idade
        List<Pessoa> maiorIdade = pessoas.stream()
                .filter(p -> p.getIdade() > 17)
                .toList();
        maiorIdade.forEach(System.out::println);

        List<Pessoa> comA = pessoas.stream()
                .filter(p -> p.getNome().startsWith("A"))
                .toList();
        comA.forEach(System.out::println);
    }
}

//List<Integer> numeros = Arrays.asList(1,2,3,4,5);
//        numeros.stream()
//                .map(n -> n*2)
//                .forEach(System.out::println);
//
//        //os numeros se mantem iguais
//        numeros.forEach(System.out::println);
//
//        int somaDobroPares = numeros.stream()
//                .filter(n -> n%2 == 0)
//                .map(n -> n*2)
//                .reduce(0, Integer::sum);
//        System.out.println("\n"+somaDobroPares);
//
//        List<String> frutas = Arrays.asList("banana","maça","abacaxi","laranja","uva");
//
//        List<String> palavrasFiltradas = frutas.stream()
//                .filter(f -> f.length() > 5)
//                .toList();
//        palavrasFiltradas.forEach(System.out::println);