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

            scanner.close();
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

    public Genero consultar(int id) {
        ArrayList<Genero> array = this.listar();
        Genero g = null;
        try {
            for (Genero genero : array) {
                if (genero.id == id) {
                    g = genero;
                    // System.out.println("Genero encontrado com sucesso.");
                    // System.out.println("Id: " + g.id + " Desc: " + g.desc + " Status: " +
                    // g.status);
                }
            }
            return g;
        } catch (NullPointerException n) {
            n.printStackTrace();
            return g;
        }

    }

    // public void consultarInfo(Genero g) {

    // System.out.println("Id: " + g.id + " Desc: " + g.desc + " Status: " +
    // g.status);

    // }
}
