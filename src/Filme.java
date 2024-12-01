import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Filme {
    // Atributos
    private int id;
    private String titulo;
    private String sinopse;
    private Genero genero = new Genero();
    private int classificacao;
    private String status;
    Scanner scanner = new Scanner(System.in);

    // Gets e Sets
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Filme() {
        this.id = 0;
        this.titulo = "";
        this.sinopse = "";
        this.genero = new Genero();
        this.classificacao = 0;
        this.status = "A";
    }

    public Filme(int id, String titulo, String sinopse, Genero genero, int classificacao, String status) {
        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.genero = genero;
        this.classificacao = classificacao;
        this.status = status;
    }

    public Boolean cadastrar(Filme filme) {
        try {
            FileWriter fw = new FileWriter("filmes.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            System.out.println("Digite um id para este filme: ");
            filme.id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite um titulo para este filme: ");
            filme.titulo = scanner.nextLine();

            System.out.println("Digite uma sinopse para este filme: ");
            filme.sinopse = scanner.nextLine();

            filme.genero = genero.consultar(genero);

            System.out.println("Digite uma classificacao para este filme: ");
            filme.classificacao = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o status A para ativar o filme e I para inativar: ");
            filme.status = scanner.nextLine();

            writer.write(filme.id + ";" + filme.titulo + ";" + filme.sinopse + ";" + filme.genero.getId() + ";"
                    + filme.classificacao + ";" + filme.status);
            writer.newLine();

            writer.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }
    }

    public ArrayList<Filme> listar(Filme filme) {

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

                for (Genero generos : genero.listar(genero)) {
                    if (generos.getId() == idGenero) {
                        genero = generos;
                    }
                }

                filme = new Filme(id, titulo, sinopse, genero, classificacao, status);
                array.add(filme);

            }
            reader.close();
            return array;

        } catch (IOException e) {
            e.printStackTrace();
            return array;

        }
    }

    public Filme consultar(Filme filme) {
        System.out.println("Digite o id do filme que voce deseja consultar ou associar: ");
        int idBuscado = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Filme> array = filme.listar(filme);
        try {
            for (Filme filmes : array) {
                if (filmes.getId() == idBuscado) {
                    filme = filmes;

                    System.out.println("Filme encontrado com sucesso!\n");

                    System.out.println(
                            "Id do filme: " + filme.id + "\nTitulo: " + filme.titulo + "\nSinopse: "
                                    + filme.sinopse + "\nGenero: " + filme.genero.getDesc() + "\nClassificacao: "
                                    + filme.classificacao + "\nStatus: " + filme.status);

                }
            }
            return filme;

        } catch (NullPointerException n) {
            n.printStackTrace();
            scanner.close();
            return filme;
        }
    }

    public void exibir() {
        System.out.println(
                            "Id do filme: " + this.id + "\nTitulo: " + this.titulo + "\nSinopse: "
                                    + this.sinopse + "\nGenero: " + this.genero.getDesc() + "\nClassificacao: "
                                    + this.classificacao + "\nStatus: " + this.status);
    }
}
