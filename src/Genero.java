import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Genero {
    private int id;
    private String desc;
    private String status;
    Scanner scanner = new Scanner(System.in);

    public Genero() {
        this.id = 0;
        this.desc = "";
        this.status = "";
    }

    public Genero(int id, String desc, String status) {
        this.id = id;
        this.desc = desc;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Boolean inserir() {
        try {
            FileWriter fw = new FileWriter("generos.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            System.out.println("Digite um id para este genero: ");
            this.id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite uma descricao para este genero: ");
            this.desc = scanner.nextLine();

            System.out.println("Digite o status A para ativar o genero e I para inativar: ");
            this.status = scanner.nextLine();

            writer.write(id + ";" + desc + ";" + status);
            writer.newLine();

            writer.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }
    }

    public ArrayList<Genero> listar() {

        ArrayList<Genero> array = new ArrayList<>();

        try {
            FileReader fr = new FileReader("generos.txt");
            BufferedReader reader = new BufferedReader(fr);
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int id = Integer.parseInt(dados[0]);
                String desc = dados[1];
                String status = dados[2];

                // System.out.println("Id: " + id + " Desc: " + desc + " Status: " + status);
                Genero genero = new Genero(id, desc, status);
                array.add(genero);

            }
            reader.close();
            return array;

        } catch (IOException e) {
            e.printStackTrace();
            return array;

        }
    }

    public Genero consultar(Genero genero) {

        System.out.println("Digite o id do genero que voce deseja consultar: ");
        int idBuscado = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Genero> array = this.listar();
        Genero generoEncontrado = null;

        try {
            for (Genero generos : array) {
                if (generos.getId() == idBuscado) {
                    generoEncontrado = generos;

                    System.out.println("Id do genero: "
                            + generoEncontrado.getId() + " Descricao: "
                            + generoEncontrado.getDesc() + " Status: " + generoEncontrado.getStatus());

                }
            }
            return generoEncontrado;

        } catch (NullPointerException n) {
            n.printStackTrace();
            return generoEncontrado;
        }
    }

    // public void consultarInfo(Genero g) {

    // System.out.println("Id: " + g.id + " Desc: " + g.desc + " Status: " +
    // g.status);

    // }
}
