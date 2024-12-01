import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ator extends Pessoa {
    private int registro;
    Scanner scanner = new Scanner(System.in);

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public Ator() {
        super();
        this.registro = 0;
    }

    public Ator(int registro, String nome, String cpf, String email) {
        super(nome, cpf, email);
        this.registro = registro;
    }

    public Boolean cadastrar(Ator ator) {
        try {
            FileWriter fw = new FileWriter("Atores.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            System.out.println("Digite um numero de registro para este ator: ");
            // this.registro = scanner.nextInt();
            ator.registro = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o nome deste ator: ");
            String nome = scanner.nextLine();
            // this.setNome(nome);
            ator.setNome(nome);

            System.out.println("Digite o cpf deste ator: ");
            String cpf = scanner.nextLine();
            // this.setCpf(cpf);
            ator.setCpf(cpf);

            System.out.println("Digite o email deste ator: ");
            String email = scanner.nextLine();
            // this.setEmail(email);
            ator.setEmail(email);

            writer.write(registro + ";" + nome + ";" + cpf + ";" + email);
            writer.newLine();

            writer.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }
    }

    public ArrayList<Ator> listar(Ator ator) {

        ArrayList<Ator> array = new ArrayList<>();

        try {
            FileReader fr = new FileReader("Atores.txt");
            BufferedReader reader = new BufferedReader(fr);
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int registro = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String cpf = dados[2];
                String email = dados[3];

                ator = new Ator(registro, nome, cpf, email);

                array.add(ator);

            }
            reader.close();
            return array;

        } catch (IOException e) {
            e.printStackTrace();
            return array;

        }
    }

    public Ator consultar(Ator ator) {
        System.out.println("Digite numero do registro do ator que voce deseja consultar ou associar: ");
        int registroBuscado = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Ator> array = this.listar(ator);
        
        try {
            for (Ator atores : array) {
                if (atores.getRegistro() == registroBuscado) {
                    ator = atores;

                    System.out.println("Ator encontrado com sucesso!\n");

                    System.out.println("Registro: " + ator.getRegistro() + "\nNome: "
                            + ator.getNome() + "\nCPF: " + ator.getCpf() + "\nEmail: "
                            + ator.getEmail() + "\n");

                }
            }
            return ator;

        } catch (NullPointerException n) {
            n.printStackTrace();
            scanner.close();
            return ator;
        }
    }

    public void exibir() {
        System.out.println("Registro: " + this.getRegistro() + "\nNome: "
                            + this.getNome() + "\nCPF: " + this.getCpf() + "\nEmail: "
                            + this.getEmail() + "\n");
    }
}
