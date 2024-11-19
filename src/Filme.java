import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Filme {
    private int id;
    private String titulo;
    private String sinopse;
    private Genero genero = new Genero();
    private int classificacao;
    private String status;
    Scanner scanner = new Scanner(System.in);

    public Filme() {
        this.id = 0;
        this.titulo = "";
        this.sinopse = "";
        this.genero = new Genero();
        this.classificacao = 0;
        this.status = "A";
    }

    public Filme(int id, String titulo, String sinopse, int idGenero, int classificacao, String status) {
        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.genero = genero.consultar(idGenero);
        this.classificacao = classificacao;
        this.status = status;
    }

    public Boolean inserir() {
        try {
            FileWriter fw = new FileWriter("filmes.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            System.out.println("Digite um id para este filme: ");
            id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite um titulo para este filme: ");
            titulo = scanner.nextLine();

            System.out.println("Digite uma sinopse para este filme: ");
            sinopse = scanner.nextLine();

            System.out.println("Digite um id de genero para este filme: ");
            int idGenero = scanner.nextInt();
            genero.consultar(idGenero);
            scanner.nextLine();

            System.out.println("Digite uma classificacao para este filme: ");
            classificacao = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o status A para ativar o filme e I para inativar: ");
            status = scanner.nextLine();

            writer.write(id + ";" + titulo + ";" + sinopse + ";" + idGenero + ";" + classificacao + ";" + status);
            writer.newLine();

            scanner.close();
            writer.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }
    }

    public ArrayList<Filme> listar() {

        ArrayList<Filme> array = new ArrayList<>();

        try {
            FileReader fr = new FileReader("filmes.txt");
            BufferedReader reader = new BufferedReader(fr);
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int id = Integer.parseInt(dados[0]);
                String titulo = dados[1];
                String sinopse = dados[2];
                int idGenero = Integer.parseInt(dados[3]);
                int classificacao = Integer.parseInt(dados[4]);
                String status = dados[5];

                Filme filme = new Filme(id, titulo, sinopse, idGenero, classificacao, status);
                // System.out.println(id + ";" + titulo + ";" + sinopse + ";" + idGenero + ";" + classificacao + ";" + status);
                array.add(filme);

            }
            reader.close();
            return array;

        } catch (IOException e) {
            e.printStackTrace();
            return array;

        }
    }
}
