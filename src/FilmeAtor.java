import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FilmeAtor {
    private int idFilmeAtor;
    private Ator ator = new Ator();
    private Filme filme = new Filme();
    private String personagem;
    private Boolean principal;
    Scanner scanner = new Scanner(System.in);

    // construtores

    public FilmeAtor(int idFilmeAtor, Ator ator, Filme filme, String personagem, Boolean principal) {
        this.idFilmeAtor = idFilmeAtor;
        this.ator = ator;
        this.filme = filme;
        this.personagem = personagem;
        this.principal = principal;

    }

    public FilmeAtor() {
        this.idFilmeAtor = 0;
        this.ator = new Ator();
        this.filme = new Filme();
        this.personagem = "";
        this.principal = false;

    }

    public int getIdFilmeAtor() {
        return idFilmeAtor;
    }

    public void setIdFilmeAtor(int idFilmeAtor) {
        this.idFilmeAtor = idFilmeAtor;
    }

    public String getPersonagem() {
        return personagem;
    }

    public void setPersonagem(String personagem) {
        this.personagem = personagem;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    public Boolean cadastrar(FilmeAtor filmeAtor) {
        try {
            FileWriter fw = new FileWriter("FilmeAtor.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            System.out.println("Digite um id para este FilmeAtor");
            filmeAtor.idFilmeAtor = scanner.nextInt();
            scanner.nextLine();

            filmeAtor.ator = ator.consultar(ator);

            filmeAtor.filme = filme.consultar(filme);

            System.out.println("Digite o nome do personagem interpretado pelo ator");
            filmeAtor.personagem = scanner.nextLine();

            System.out.println("Este personagem e o principal do filme?\n1 para sim \n2 para nao");
            int isPrincipal = scanner.nextInt();

            if (isPrincipal == 1) {
                filmeAtor.principal = true;
            } else {
                filmeAtor.principal = false;
            }

            writer.write(filmeAtor.idFilmeAtor + ";" + ator.getRegistro() + ";" + filme.getId() + ";"
                    + filmeAtor.personagem + ";" + isPrincipal);
            writer.newLine();

            writer.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }
    }

    public ArrayList<FilmeAtor> listar(FilmeAtor filmeAtor) {

        ArrayList<FilmeAtor> array = new ArrayList<>();

        try {
            FileReader fr = new FileReader("FilmeAtor.txt");
            BufferedReader reader = new BufferedReader(fr);
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int idFilmeAtor = Integer.parseInt(dados[0]);
                int idAtor = Integer.parseInt(dados[1]);
                int idFilme = Integer.parseInt(dados[2]);
                String personagem = dados[3];
                int principal = Integer.parseInt(dados[4]);

                for (Filme filmes : filme.listar(filme)) {
                    if (filmes.getId() == idFilme) {
                        filme = filmes;
                    }
                }

                for (Ator atores : ator.listar(ator)) {
                    if (atores.getRegistro() == idAtor) {
                        ator = atores;
                    }
                }

                Boolean isPrincipal = null;
                if (principal == 1) {
                    isPrincipal = true;
                } else if (principal == 2) {
                    isPrincipal = false;
                } else {
                    System.out.println("Nao foi possivel identificar");
                }
                
                filmeAtor = new FilmeAtor(idFilmeAtor, ator, filme, personagem, isPrincipal);

                array.add(filmeAtor);

            }
            reader.close();
            return array;

        } catch (IOException e) {
            e.printStackTrace();
            return array;

        }
    }

    public FilmeAtor consultar(FilmeAtor filmeAtor) {
        System.out.println("Informe o id do FilmeAtor que voce deseja consultar ou associar: ");
        int idBuscado = scanner.nextInt();
        scanner.nextLine();

        ArrayList<FilmeAtor> array = filmeAtor.listar(filmeAtor);
        try {
            for (FilmeAtor filmeAtores : array) {
                if (filmeAtores.getIdFilmeAtor() == idBuscado) {
                    filmeAtor = filmeAtores;

                    System.out.println("O FilmeAtor foi encontrado com sucesso!\n");

                    System.out.println("Id do FilmeAtor: " + filmeAtor.idFilmeAtor + "\nNome do ator: "
                            + filmeAtor.ator.getNome() + "\nParticipou do filme: " + filmeAtor.filme.getTitulo()
                            + "\nPersonagem interpretada pelo ator: " + filmeAtor.personagem
                            + "\nO ator e uma personagem principal do filme: " + filmeAtor.principal);

                }
            }
            return filmeAtor;

        } catch (NullPointerException n) {
            n.printStackTrace();
            scanner.close();
            return filmeAtor;
        }
    }

    public void exibir() {
        System.out.println("Id do FilmeAtor: " + this.idFilmeAtor + "\nNome do ator: "
                            + this.ator.getNome() + "\nParticipou do filme: " + this.filme.getTitulo()
                            + "\nPersonagem interpretada pelo ator: " + this.personagem
                            + "\nO ator e uma personagem principal do filme: " + this.principal);
    }
}