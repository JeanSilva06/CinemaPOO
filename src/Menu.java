import java.util.Scanner;

public class Menu {
    private Genero genero = new Genero();
    private Ator ator = new Ator();
    private Filme filme = new Filme();
    private Funcionario funcionario = new Funcionario();
    private Sala sala = new Sala();
    private TipoAssento tipoAssento = new TipoAssento();
    Scanner scanner = new Scanner(System.in);

    public void realizarOperacao() {
        Boolean operacaoEncerrada = false;

        while (operacaoEncerrada == false) {

            System.out
                    .println("Acessando sistema de cinema...\n" + "\nDigite os seguintes numeros para efetuar acoes:\n"
                            + "\n1: consultar generos de filmes");
            int operacao = scanner.nextInt();
            scanner.nextLine();

            if (operacao == 1) {
                System.out.println("Acessando generos...\n" + "\nDigite os seguintes numeros para efetuar acoes:\n"
                        + "\n1: Cadastrar novo genero");
                int operacaoClasse = scanner.nextInt();
                scanner.nextLine();

                if (operacaoClasse == 1) {
                    if (genero.inserir() == true) {
                        System.out.println("Genero cadastrado com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                                + "1 para sim\n2 para nao");
                        int novaOperacao = scanner.nextInt();
                        scanner.nextLine();

                        if (novaOperacao == 1) {
                            operacao = 0;
                        } else {
                            System.out.println("Ok, obrigado por utilizar o SISTcinema\nFechando sistema...");
                            operacaoEncerrada = true;
                        }
                    }
                }
            }
        }
    }
}
