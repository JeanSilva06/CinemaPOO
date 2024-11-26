import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Funcionario extends Pessoa {
    private int matricula;
    private Date horarioTrabalho;
    Scanner scanner = new Scanner(System.in);

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Date getHorarioTrabalho() {
        return horarioTrabalho;
    }

    public void setHorarioTrabalho(Date horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }

    public Funcionario() {
        super();
        this.matricula = 0;
        this.horarioTrabalho = new Date();
    }

    public Funcionario(int matricula, String nome, String cpf, String email) {
        super(nome, cpf, email);
        this.matricula = matricula;
        this.horarioTrabalho = new Date();
    }

    public Boolean cadastrar(Funcionario funcionario) {
        try {
            FileWriter fw = new FileWriter("funcionarios.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            System.out.println("Digite a matricula para este funcionario: ");
            funcionario.matricula = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o nome deste funcionario: ");
            String nome = scanner.nextLine();
            funcionario.setNome(nome);

            System.out.println("Digite o cpf deste funcionario: ");
            String cpf = scanner.nextLine();
            funcionario.setCpf(cpf);

            System.out.println("Digite o email deste funcionario: ");
            String email = scanner.nextLine();
            funcionario.setEmail(email);

            writer.write(funcionario.matricula + ";" + funcionario.horarioTrabalho + ";" + funcionario.getNome() + ";"
                    + funcionario.getCpf() + ";" + funcionario.getEmail());
            writer.newLine();

            scanner.close();
            writer.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }
    }

    public ArrayList<Funcionario> listar(Funcionario funcionario) {

        ArrayList<Funcionario> array = new ArrayList<>();

        try {
            FileReader fr = new FileReader("funcionarios.txt");
            BufferedReader reader = new BufferedReader(fr);
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int matricula = Integer.parseInt(dados[0]);
                String date = dados[1]; 
                String nome = dados[2];
                String cpf = dados[3];
                String email = dados[4];

                Funcionario func = new Funcionario(matricula, nome, cpf, email);

                array.add(func);

            }
            reader.close();
            return array;

        } catch (IOException e) {
            e.printStackTrace();
            return array;

        }
    }
}
