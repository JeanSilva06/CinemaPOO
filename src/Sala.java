import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sala {
    private int idSala;
    private int capacidadeSala;
    private String descricao;
    private String status;
    Scanner scanner = new Scanner(System.in);

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getCapacidadeSala() {
        return capacidadeSala;
    }

    public void setCapacidadeSala(int capacidadeSala) {
        this.capacidadeSala = capacidadeSala;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Sala() {
        this.idSala = 0;
        this.capacidadeSala = 0;
        this.descricao = "";
        this.status = "";
    }

    public Sala(int idSala, int capacidadeSala, String descricao, String status) {
        this.idSala = idSala;
        this.capacidadeSala = capacidadeSala;
        this.descricao = descricao;
        this.status = status;
    }

    public Boolean cadastrar(Sala sala) {
        try {
            FileWriter fw = new FileWriter("salas.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            System.out.println("Digite um id para esta sala: ");
            sala.idSala = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite uma capacidade para esta sala: ");
            sala.capacidadeSala = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite uma descricao para esta sala: ");
            sala.descricao = scanner.nextLine();

            System.out.println("Digite um status para esta sala, sendo A para ativa-la e I para inativa-la: ");
            sala.status = scanner.nextLine();

            writer.write(sala.idSala + ";" + sala.capacidadeSala + ";" + sala.descricao + ";" + sala.status);
            writer.newLine();

            scanner.close();
            writer.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }
    }

    public ArrayList<Sala> listar(Sala sala) {

        ArrayList<Sala> array = new ArrayList<>();

        try {
            FileReader fr = new FileReader("salas.txt");
            BufferedReader reader = new BufferedReader(fr);
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int idSala = Integer.parseInt(dados[0]);
                int capacidadeSala = Integer.parseInt(dados[1]);
                String descricao = dados[2];
                String status = dados[3];

                Sala sa = new Sala(idSala, capacidadeSala, descricao, status);

                array.add(sa);

            }
            reader.close();
            return array;

        } catch (IOException e) {
            e.printStackTrace();
            return array;

        }
    }

    public Sala consultar(Sala sala) {
        System.out.println("Digite o id da sala que voce deseja consultar: ");
        int idBuscado = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Sala> array = this.listar(sala);
        Sala salaEncontrada = null;
        try {
            for (Sala salas : array) {
                if (salas.getIdSala() == idBuscado) {
                    salaEncontrada = salas;

                    System.out.println("Id da sala: "
                            + salaEncontrada.getIdSala() + " Capacidade da sala: " +salaEncontrada.capacidadeSala + " Descricao: "
                            + salaEncontrada.getDescricao() + " Status: " + salaEncontrada.getStatus());

                }
            }
            scanner.close();
            return salaEncontrada;

        } catch (NullPointerException n) {
            n.printStackTrace();
            scanner.close();
            return salaEncontrada;
        }
    }
}
