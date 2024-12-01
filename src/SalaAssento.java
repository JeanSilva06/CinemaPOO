import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class SalaAssento {
    private int idSalaAssento;
    private Assento assento = new Assento();
    private Sala sala = new Sala();
    Scanner scanner = new Scanner(System.in);

    public SalaAssento(int idSalaAssento, Assento assento, Sala sala) {
        this.idSalaAssento = idSalaAssento;
        this.assento = assento;
        this.sala = sala;

    }

    public SalaAssento() {
        this.idSalaAssento = 0;
        this.assento = new Assento();
        this.sala = new Sala();

    }

    public int getIdSalaAssento() {
        return idSalaAssento;
    }

    public void setIdSalaAssento(int idSalaAssento) {
        this.idSalaAssento = idSalaAssento;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public Boolean cadastrar(SalaAssento salaAssento) {
        try {
            FileWriter fw = new FileWriter("SalaAssentos.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            System.out.println("Digite um id para esta sala assento");
            salaAssento.idSalaAssento = scanner.nextInt();
            scanner.nextLine();

            salaAssento.assento = assento.consultar(assento);
            
            salaAssento.sala = sala.consultar(sala);

            writer.write(salaAssento.idSalaAssento + ";" +assento.getIdAssento() + ";" + sala.getIdSala());
            writer.newLine();

            writer.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }
    }

    public ArrayList<SalaAssento> listar(SalaAssento salaAssento) {

        ArrayList<SalaAssento> array = new ArrayList<>();

        try {
            FileReader fr = new FileReader("SalaAssentos.txt");
            BufferedReader reader = new BufferedReader(fr);
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int idSalaAssento = Integer.parseInt(dados[0]);
                int idAssento = Integer.parseInt(dados[1]);
                int idSala = Integer.parseInt(dados[2]);

                for (Assento assentos : assento.listar(assento)) {
                    if (assentos.getIdAssento() == idAssento) {
                        assento = assentos;
                    }
                }

                for (Sala salas : sala.listar(sala)) {
                    if (salas.getIdSala() == idSala) {
                        sala = salas;
                    }
                }

                salaAssento = new SalaAssento(idSalaAssento, assento ,sala);
                array.add(salaAssento);

            }
            reader.close();
            return array;

        } catch (IOException e) {
            e.printStackTrace();
            return array;

        }
    }

    public SalaAssento consultar(SalaAssento salaAssento) {
        System.out.println("Informe o id da sala assento que voce deseja consultar ou associar: ");
        int idBuscado = scanner.nextInt();
        scanner.nextLine();

        ArrayList<SalaAssento> array = salaAssento.listar(salaAssento);
        try {
            for (SalaAssento salaAssentos : array) {
                if (salaAssentos.getIdSalaAssento() == idBuscado) {
                    salaAssento = salaAssentos;

                    System.out.println("A Sala assento foi encontrada com sucesso!\n");

                    System.out.println("ID da Sala assento: " + salaAssento.idSalaAssento + "\n Receba o assento: " + salaAssento.assento.getIdAssento()+ "\n Receba a Sala: " + salaAssento.sala.getIdSala());

                }
            }
            return salaAssento;

        } catch (NullPointerException n) {
            n.printStackTrace();
            scanner.close();
            return salaAssento;
        }
    }
}