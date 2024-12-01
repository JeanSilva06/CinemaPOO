import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ingresso {
    private int idIngresso;
    private Double valorPago;
    private SalaAssento salaAssento;
    private Sessao sessao;
    Scanner scanner = new Scanner(System.in);

    public int getIdIngresso() {
        return idIngresso;
    }

    public void setIdIngresso(int idIngresso) {
        this.idIngresso = idIngresso;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public SalaAssento getSalaAssento() {
        return salaAssento;
    }

    public void setSalaAssento(SalaAssento salaAssento) {
        this.salaAssento = salaAssento;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Ingresso() {
        this.idIngresso = 0;
        this.valorPago = 0.0;
        this.salaAssento = new SalaAssento();
        this.sessao = new Sessao();
    }

    public Ingresso(int idIngresso, Double valorPago, SalaAssento salaAssento, Sessao sessao) {
        this.idIngresso = idIngresso;
        this.valorPago = valorPago;
        this.salaAssento = salaAssento;
        this.sessao = sessao;
    }

    public Boolean cadastrar(Ingresso ingresso) {
        try {
            FileWriter fw = new FileWriter("Ingressos.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            System.out.println("Digite um id para este ingresso");
            ingresso.idIngresso = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite um valor a ser pago por este ingresso utilizando (,) para casas decimais");
            ingresso.valorPago = scanner.nextDouble();
            scanner.nextLine();

            ingresso.salaAssento = salaAssento.consultar(salaAssento);

            ingresso.sessao = sessao.consultar(sessao);

            writer.write(ingresso.idIngresso + ";" + ingresso.valorPago + ";" + ingresso.salaAssento.getIdSalaAssento()
                    + ";" + ingresso.sessao.getIdSessao());
            writer.newLine();

            writer.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Ingresso> listar(Ingresso ingresso) {

        ArrayList<Ingresso> array = new ArrayList<>();

        try {
            FileReader fr = new FileReader("Ingressos.txt");
            BufferedReader reader = new BufferedReader(fr);
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int idIngresso = Integer.parseInt(dados[0]);
                Double valorPago = Double.valueOf(dados[1]);
                int idSalaAssento = Integer.parseInt(dados[2]);
                int idSessao = Integer.parseInt(dados[3]);

                for (SalaAssento salaAssentos : salaAssento.listar(salaAssento)) {
                    if (salaAssentos.getIdSalaAssento() == idSalaAssento) {
                        salaAssento = salaAssentos;
                    }
                }

                for (Sessao sessoes : sessao.listar(sessao)) {
                    if (sessoes.getIdSessao() == idSessao) {
                        sessao = sessoes;
                    }
                }

                ingresso = new Ingresso(idIngresso, valorPago, salaAssento, sessao);
                array.add(ingresso);

            }
            reader.close();
            return array;

        } catch (IOException e) {
            e.printStackTrace();
            return array;

        }
    }

    public Ingresso consultar(Ingresso ingresso) {
        System.out.println("Informe o id do ingresso que voce deseja consultar ou associar: ");
        int idBuscado = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Ingresso> array = ingresso.listar(ingresso);
        try {
            for (Ingresso ingressos : array) {
                if (ingressos.getIdIngresso() == idBuscado) {
                    ingresso = ingressos;

                    System.out.println("O ingresso foi encontrado com sucesso!\n");

                    System.out.println("Id do ingresso: " + ingresso.idIngresso + "\nValor Pago: " + ingresso.valorPago
                            + "\nSala: " + ingresso.salaAssento.getSala().getIdSala() + "\nAssento: "
                            + ingresso.salaAssento.getAssento().getIdAssento() + "\nFilme em exibicao: "
                            + ingresso.sessao.getFilme().getTitulo() + "\nClassificacao do Filme: "
                            + ingresso.sessao.getFilme().getClassificacao() + "\nData e hora da sessao: "
                            + ingresso.sessao.getDataHoraSessao());

                }
            }
            return ingresso;

        } catch (NullPointerException n) {
            n.printStackTrace();
            scanner.close();
            return ingresso;
        }
    }

    public void exibir() {
        System.out.println("Id do ingresso: " + this.idIngresso + "\nValor Pago: " + this.valorPago
                            + "\nSala: " + this.salaAssento.getSala().getIdSala() + "\nAssento: "
                            + this.salaAssento.getAssento().getIdAssento() + "\nFilme em exibicao: "
                            + this.sessao.getFilme().getTitulo() + "\nClassificacao do Filme: "
                            + this.sessao.getFilme().getClassificacao() + "\nData e hora da sessao: "
                            + this.sessao.getDataHoraSessao());
    }
}