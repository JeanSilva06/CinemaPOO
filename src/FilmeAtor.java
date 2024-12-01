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

    //construtores

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


    //GETS
    public int getIdFilmeAtor() {
        return idFilmeAtor;
    }

    public String getPersonagem() {
        return personagem;
    }

    public Boolean getPrincipal() {
        return principal;
    }


    //SETS
    public void setIdFilmeAtor(int idFilmeAtor) {
        this.idFilmeAtor = idFilmeAtor;
    }

    public void setPersonagem(String personagem) {
        this.personagem = personagem;
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

            System.out.println("Este personagem e o principal do filme? \n\ndigite: \n\n1 - sim \n\n2 - nao");
            int isPrincipal = scanner.nextInt();

            if (isPrincipal == 1) {
                filmeAtor.principal = true;
            } else {
                filmeAtor.principal = false;
            }

            writer.write(filmeAtor.idFilmeAtor + ";" +ator.getRegistro() + ";" + filme.getId() + ";" + filmeAtor.personagem + ";" + isPrincipal);
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
                // Boolean isPrincipal = (principal == 1);

                //idFilme ator, Ator, Filme, personagem e Principal.
                FilmeAtor fa = new FilmeAtor(idFilmeAtor, ator, filme, personagem, isPrincipal);

                array.add(fa);

            }
            reader.close();
            return array;

        } catch (IOException e) {
            e.printStackTrace();
            return array;

        }
    }

    public FilmeAtor consultar(FilmeAtor filmeAtor) {
        System.out.println("Informe o id do filmeAtor que voce deseja consultar ou associar: ");
        int idBuscado = scanner.nextInt();
        scanner.nextLine();

        ArrayList<FilmeAtor> array = filmeAtor.listar(filmeAtor);
        try {
            for (FilmeAtor filmeAtores : array) {
                if (filmeAtores.getIdFilmeAtor() == idBuscado) {
                    filmeAtor = filmeAtores;

                    System.out.println("O filmeAtor foi encontrado com sucesso!\n");

                    System.out.println("ID do FilmeAtor: " + filmeAtor.idFilmeAtor + "\n Receba o Ator: " + filmeAtor.ator.getNome()+ "\n  Receba o filme: " + filmeAtor.filme.getTitulo() + "\n Receba a personagem: " + filmeAtor.personagem + "\n O ator e a personagem principal do filme: " + filmeAtor.principal);

                }
            }
            return filmeAtor;

        } catch (NullPointerException n) {
            n.printStackTrace();
            scanner.close();
            return filmeAtor;
        }
    }
}