import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sessao {
    private int idSessao;
    private String dataHoraSessao;
    private Filme filme;
    private Sala sala;
    private Funcionario funcionario;
    private String status;
    Scanner scanner = new Scanner(System.in);

    public int getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    public String getDataHoraSessao() {
        return dataHoraSessao;
    }

    public void setDataHoraSessao(String dataHoraSessao) {
        this.dataHoraSessao = dataHoraSessao;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Sessao() {
        this.idSessao = 0;
        this.dataHoraSessao = "DD/MM/AA HH:MM";
        this.filme = new Filme();
        this.sala = new Sala();
        this.funcionario = new Funcionario();
        this.status = "A";
    }

    public Sessao(int idSessao, String dataHoraSessao, Filme filme, Sala sala, Funcionario funcionario, String status) {
        this.idSessao = idSessao;
        this.dataHoraSessao = dataHoraSessao;
        this.filme = filme;
        this.sala = sala;
        this.funcionario = funcionario;
        this.status = status;
    }

    public Boolean cadastrar(Sessao sessao) {
        try {
            FileWriter fw = new FileWriter("Sessoes.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            System.out.println("Digite um id para esta sessao");
            sessao.idSessao = scanner.nextInt();
            scanner.nextLine();

            System.out
                    .println("Digite uma data e um horario para esta sessao, seguindo a formatacao --> DD/MM/AA HH:MM");
            sessao.dataHoraSessao = scanner.nextLine();

            sessao.filme = filme.consultar(filme);

            sessao.sala = sala.consultar(sala);

            sessao.funcionario = funcionario.consultar(funcionario);

            System.out.println("Digite um status para esta sessao, sendo A para ativa-la e I para inativa-la");
            sessao.status = scanner.nextLine();

            writer.write(sessao.idSessao + ";" + sessao.dataHoraSessao + ";" + sessao.filme.getId() + ";"
                    + sessao.sala.getIdSala() + ";" + sessao.funcionario.getMatricula() + ";" + sessao.status);
            writer.newLine();

            writer.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Sessao> listar(Sessao sessao) {

        ArrayList<Sessao> array = new ArrayList<>();

        try {
            FileReader fr = new FileReader("Sessoes.txt");
            BufferedReader reader = new BufferedReader(fr);
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int idSessao = Integer.parseInt(dados[0]);
                String dataHoraSessao = dados[1];
                int idFilme = Integer.parseInt(dados[2]);
                int idSala = Integer.parseInt(dados[3]);
                int matriculaFuncionario = Integer.parseInt(dados[4]);
                String status = dados[5];

                for (Filme filmes : filme.listar(filme)) {
                    if (filmes.getId() == idFilme) {
                        filme = filmes;
                    }
                }

                for (Sala salas : sala.listar(sala)) {
                    if (salas.getIdSala() == idSala) {
                        sala = salas;
                    }
                }

                for (Funcionario funcionarios : funcionario.listar(funcionario)) {
                    if (funcionarios.getMatricula() == matriculaFuncionario) {
                        funcionario = funcionarios;
                    }
                }

                sessao = new Sessao(idSessao, dataHoraSessao, filme, sala, funcionario, status);
                array.add(sessao);

            }
            reader.close();
            return array;

        } catch (IOException e) {
            e.printStackTrace();
            return array;

        }
    }

    public Sessao consultar(Sessao sessao) {
        System.out.println("Digite o id da sessao que voce deseja consultar ou associar: ");
        int idBuscado = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Sessao> array = sessao.listar(sessao);
        try {
            for (Sessao sessoes : array) {
                if (sessoes.getIdSessao() == idBuscado) {
                    sessao = sessoes;

                    System.out.println("A sessao encontrada com sucesso!\n");

                    System.out.println("Id sessao: " + sessao.idSessao + "\nData e hora da sessao: "
                            + sessao.dataHoraSessao + "\nFilme em exibicao: " + sessao.filme.getTitulo() + "\nSala: "
                            + sessao.sala.getIdSala() + "\nFuncionario responsavel: " + sessao.funcionario.getNome()
                            + "\nStatus: " + sessao.status);

                }
            }
            return sessao;

        } catch (NullPointerException n) {
            n.printStackTrace();
            scanner.close();
            return sessao;
        }
    }

    public void exibir() {
        System.out.println("Id sessao: " + this.idSessao + "\nData e hora da sessao: "
                            + this.dataHoraSessao + "\nFilme em exibicao: " + this.filme.getTitulo() + "\nSala: "
                            + this.sala.getIdSala() + "\nFuncionario responsavel: " + this.funcionario.getNome()
                            + "\nStatus: " + this.status);
    }
}
