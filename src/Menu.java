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
                                + "\n1: consultar generos de filmes\n" + "2: consultar atores\n");
                operacao = scanner.nextInt();
                scanner.nextLine();
            }

            if (operacao == 1) {
                System.out.println("Acessando generos...\n" + "\nDigite os seguintes numeros para efetuar acoes:\n"
                        + "\n1: Cadastrar novo genero" + "\n2: consultar " + "\n3: listar generos");
                int operacaoClasse = scanner.nextInt();
                scanner.nextLine();

                if (operacaoClasse == 1) {
                    if (genero.cadastrar(genero) == true) {
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

                if (operacaoClasse == 3) {
                    for (Genero generos : genero.listar(genero)) {
                        generos.exibir();
                    }

                    System.out.println("Generos listados com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
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

            // operação ator
            if (operacao == 2) {
                System.out.println("Acessando pagina de atores...\n"
                        + "\nDigite os seguintes numeros para efetuar acoes\n" + "\n1: Cadastrar novo ator\n" + "2: Consultar ator\n");
                int operacaoClasse = scanner.nextInt();
                scanner.nextLine();

                // tipos de operação ator
                if (operacaoClasse == 1) {
                    ator.cadastrar(ator);

                    System.out.println("Ator cadastrado com sucesso!\n\n" + "Deseja realizar uma nova acao?\n"
                            + "1 para sim\n" + "2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nFechando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                if (operacaoClasse == 2) {
                    ator.consultar(ator);

                    System.out.println("Deseja realizar uma nova acao?\n" + "1 para sim\n" + "2 para nao");
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
