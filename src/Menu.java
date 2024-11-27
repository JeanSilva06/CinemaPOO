import java.util.Scanner;

public class Menu {
    private Genero genero = new Genero();
    private Ator ator = new Ator();
    private Filme filme = new Filme();
    private Funcionario funcionario = new Funcionario();
    private Sala sala = new Sala();
    private TipoAssento tipoAssento = new TipoAssento();
    Scanner scanner = new Scanner(System.in);
    private int operacao = 0;

    public void realizarOperacao() {
        Boolean operacaoEncerrada = false;

        while (operacaoEncerrada == false) {
            if (operacao == 0) {
                System.out
                        .println("Acessando sistema de cinema...\n"
                                + "\nDigite os seguintes numeros para efetuar acoes:\n"
                                + "\n1: consultar generos de filmes");
                operacao = scanner.nextInt();
                scanner.nextLine();
            }

            if (operacao == 1) {
                System.out.println("Acessando generos...\n" + "\nDigite os seguintes numeros para efetuar acoes:\n"
                        + "\n1: Cadastrar novo genero" + "\n2: consultar ");
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

                if (operacaoClasse == 2) {
                    genero.consultar(genero);

                    System.out.println("Genero consultado com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
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
