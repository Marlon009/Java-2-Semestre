import br.edu.fatecpg.consumocep.model.Endereco;
import br.edu.fatecpg.consumocep.service.ConsumoApi;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
      ConsumoApi api = new ConsumoApi();
        Scanner sc = new Scanner(System.in);
         boolean sair = false;
        while (!sair) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Consultar CEP");
            System.out.println("2. Listar CEPs consultados");
            System.out.println("3. Sair");
            System.out.print("Digite a opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:

                System.out.println("Digite o cep que deseja buscar: ");
                String i = sc.nextLine();


                try {
                    //String resposta = api.buscarCep(i);
                    Endereco endereco = api.buscarCep(i);
                    //System.out.println("A resposta da API: " + resposta);
                    System.out.println("\nEndereço encontrado:?\n " + endereco);
                    System.out.println("Endereço salvo no log.txt");

                    if (endereco != null && endereco.getCep() != null) {
                        try {
                            FileWriter fw = new FileWriter("log.txt", true);
                            fw.write(endereco.toString());
                            fw.close();


                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else {
                        System.out.println("Endereço não encontrado.");
                    }

                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                break;

                case 2:
                    listarLogs();
                    break;

                case 3:
                    System.out.println("Adeus...");
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        }

         sc.close();
    }

    public static void listarLogs() {
        try(BufferedReader br = new BufferedReader(new FileReader("log.txt"))){
            String linha;
            while((linha = br.readLine()) != null)
            {
                System.out.println(linha);
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

}