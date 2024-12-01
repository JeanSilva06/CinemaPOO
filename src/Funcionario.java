import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario extends Pessoa {
    private int matricula;
    private String horarioTrabalho;
    Scanner scanner = new Scanner(System.in);

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getHorarioTrabalho() {
        return horarioTrabalho;
    }

    public void setHorarioTrabalho(String horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }

    public Funcionario() {
        super();
        this.matricula = 0;
        this.horarioTrabalho = "HoraInicial:MinutoInicial - HoraFinal:MinutoFinal";
    }

    public Funcionario(int matricula, String horarioTrabalho, String nome, String cpf, String email) {
        super(nome, cpf, email);
        this.matricula = matricula;
        this.horarioTrabalho = horarioTrabalho;
    }

    public Boolean cadastrar(Funcionario funcionario) {
        try {
            FileWriter fw = new FileWriter("funcionarios.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            System.out.println("Digite a matricula para este funcionario: ");
            funcionario.matricula = scanner.nextInt();
            scanner.nextLine();

            System.out.println(
                    "Digite o horario de entrada e saida desse funcionario seguindo o exemplo HoraInicial:MinutoInicial - HoraFinal:MinutoFinal: ");
            funcionario.horarioTrabalho = scanner.nextLine();
            funcionario.setNome(horarioTrabalho);

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
                String horarioTrabalho = dados[1]; // perguntar sobre String --> date
                String nome = dados[2];
                String cpf = dados[3];
                String email = dados[4];

                Funcionario func = new Funcionario(matricula, horarioTrabalho, nome, cpf, email);

                array.add(func);

            }
            reader.close();
            return array;

        } catch (IOException e) {
            e.printStackTrace();
            return array;

        }
    }

    public Funcionario consultar(Funcionario funcionario) {
        System.out.println("Digite a matricula do funcionario que voce deseja consultar: ");
        int matriculaBuscada = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Funcionario> array = this.listar(funcionario);
        Funcionario funcionarioEncontrado = null;
        try {
            for (Funcionario funcionarios : array) {
                if (funcionarios.getMatricula() == matriculaBuscada) {
                    funcionarioEncontrado = funcionarios;

                    System.out.println("Matricula: " + funcionarioEncontrado.getMatricula() + " Horario de trabalho: "
                            + funcionarioEncontrado.getHorarioTrabalho() + " Nome: "
                            + funcionarioEncontrado.getNome() + " CPF: " + funcionarioEncontrado.getCpf() + " Email: "
                            + funcionarioEncontrado.getEmail());

                }
            }
            return funcionarioEncontrado;

        } catch (NullPointerException n) {
            n.printStackTrace();
            scanner.close();
            return funcionarioEncontrado;
        }
    }
}
