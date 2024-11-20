import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ator extends Pessoa{
    private int registro;
    Scanner scanner = new Scanner(System.in);

    public Boolean inserir() {
        try {
            FileWriter fw = new FileWriter("generos.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            System.out.println("Digite um numero de registro para este ator: ");
            this.registro = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o nome deste ator: ");
            nome = scanner.nextLine();
            this.setNome(nome);

            System.out.println("Digite o cpf deste ator: ");
            cpf = scanner.nextLine();
            this.setCpf(cpf);

            System.out.println("Digite o email deste ator: ");
            email = scanner.nextLine();
            this.setEmail(email);

            writer.write(nome + ";" + registro + ";" + cpf + ";" + email);
            writer.newLine();

            scanner.close();
            writer.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }
    }
}
