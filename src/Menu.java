import java.util.Scanner;

public class Menu {
    //Classes utilizadas 11
    private Genero genero = new Genero();
    private Ator ator = new Ator();
    private Filme filme = new Filme();
    private Funcionario funcionario = new Funcionario();
    private Sala sala = new Sala();
    private TipoAssento tipoAssento = new TipoAssento();
    private FilmeAtor filmeAtor = new FilmeAtor();
    private Assento assento = new Assento();
    private SalaAssento salaAssento = new SalaAssento();
    private Sessao sessao = new Sessao();
    private Ingresso ingresso = new Ingresso();

    Scanner scanner = new Scanner(System.in);
    private int operacao = 0;

    //Metodo para operar o menu
    public void realizarOperacao() {
        Boolean operacaoEncerrada = false;

        while (operacaoEncerrada == false) {
            // comando básico
            if (operacao == 0) {
                System.out
                        .println("Acessando sistema de cinema...\n"
                                + "\nDigite os seguintes numeros realizar operacoes:\n"
                                + "\n1: Acessar pagina de Generos\n" + "2: Acessar pagina de Filmes\n"
                                + "3: Acessar pagina de Atores\n" + "4: Acessar pagina de Funcionarios\n"
                                + "5: Acessar pagina de Salas\n" + "6: Acessar pagina de TipoAssento\n"
                                + "7: Acessar pagina de FilmeAtor\n" + "8: Acessar pagina de Assentos\n"
                                + "9: Acessar pagina de SalaAssento\n" + "10: Acessar pagina de Sessao\n"
                                + "11: Acessar pagina de Ingressos\n" + "12: Encerrar sistema\n"
                                + "\nDigite aqui abaixo:");
                operacao = scanner.nextInt();
                scanner.nextLine();
            }

            // operação genero
            if (operacao == 1) {
                System.out.println("Acessando generos...\n" + "\nDigite os seguintes numeros para realizar operacoes:\n"
                        + "\n1: Cadastrar novo genero" + "\n2: Consultar generos" + "\n3: Listar generos" + "\n4: Voltar");
                int operacaoClasse = scanner.nextInt();
                scanner.nextLine();

                // genero cadastrar
                if (operacaoClasse == 1) {
                    if (genero.cadastrar(genero) == true) {
                        System.out.println("Genero cadastrado com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                                + "1 para sim\n2 para nao");
                        int novaOperacao = scanner.nextInt();
                        scanner.nextLine();

                        if (novaOperacao == 1) {
                            operacao = 0;
                        } else {
                            System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                            operacaoEncerrada = true;
                        }
                    }
                }

                // genero consultar
                if (operacaoClasse == 2) {
                    genero.consultar(genero);

                    System.out.println("Genero consultado com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                            + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                // genero listar
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
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                //opção voltar
                if (operacaoClasse == 4) {
                    operacao = 0;
                }
            }

            // operação Filme
            if (operacao == 2) {
                System.out.println("Acessando filmes...\n" + "\nDigite os seguintes numeros para realizar operacoes:\n"
                        + "\n1: Cadastrar novo filme" + "\n2: Consultar filme" + "\n3: Listar filmes" + "\n4: Voltar");
                int operacaoClasse = scanner.nextInt();
                scanner.nextLine();

                // filme cadastrar
                if (operacaoClasse == 1) {
                    if (filme.cadastrar(filme) == true) {
                        System.out.println("Filme cadastrado com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                                + "1 para sim\n2 para nao");
                        int novaOperacao = scanner.nextInt();
                        scanner.nextLine();

                        if (novaOperacao == 1) {
                            operacao = 0;
                        } else {
                            System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                            operacaoEncerrada = true;
                        }
                    }
                }

                // filme consultar
                if (operacaoClasse == 2) {
                    filme.consultar(filme);

                    System.out.println("Filme consultado com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                            + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                // Filme listar
                if (operacaoClasse == 3) {
                    for (Filme filmes : filme.listar(filme)) {
                        filmes.exibir();
                    }

                    System.out.println("Filmes listados com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                            + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                //opção voltar
                if (operacaoClasse == 4) {
                    operacao = 0;
                }
            }

            // operação ator
            if (operacao == 3) {
                System.out.println("Acessando atores...\n"
                        + "\nDigite os seguintes numeros para realizar operacoes\n" + "\n1: Cadastrar novo ator\n"
                        + "2: Consultar ator\n" + "3: Listar atores" + "\n4: Voltar");
                int operacaoClasse = scanner.nextInt();
                scanner.nextLine();

                // cadastrar ator
                if (operacaoClasse == 1) {
                    ator.cadastrar(ator);

                    System.out.println("Ator cadastrado com sucesso!\n\n" + "Deseja realizar uma nova acao?\n"
                            + "1 para sim\n" + "2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                // consultar ator
                if (operacaoClasse == 2) {
                    ator.consultar(ator);

                    System.out.println("Deseja realizar uma nova acao?\n" + "1 para sim\n" + "2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                // listar atores
                if (operacaoClasse == 3) {
                    for (Ator atores : ator.listar(ator)) {
                        atores.exibir();
                    }

                    System.out.println("Atores listados com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                            + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                //opção voltar
                if (operacaoClasse == 4) {
                    operacao = 0;
                }
            }

            // Operação funcionário
            if (operacao == 4) {
                System.out.println(
                        "Acessando funcionarios...\n" + "\nDigite os seguintes numeros para realizar operacoes:\n"
                                + "\n1: Cadastrar novo funcionario" + "\n2: Consultar funcionario"
                                + "\n3: Listar funcionarios" + "\n4: Voltar");
                int operacaoClasse = scanner.nextInt();
                scanner.nextLine();

                // funcionario cadastrar
                if (operacaoClasse == 1) {
                    if (funcionario.cadastrar(funcionario) == true) {
                        System.out.println(
                                "Funcionario cadastrado com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                                        + "1 para sim\n2 para nao");
                        int novaOperacao = scanner.nextInt();
                        scanner.nextLine();

                        if (novaOperacao == 1) {
                            operacao = 0;
                        } else {
                            System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                            operacaoEncerrada = true;
                        }
                    }
                }

                // funcionario consultar
                if (operacaoClasse == 2) {
                    funcionario.consultar(funcionario);

                    System.out.println("Funcionario consultado com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                            + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                // funcionario listar
                if (operacaoClasse == 3) {
                    for (Funcionario funcionarios : funcionario.listar(funcionario)) {
                        funcionarios.exibir();
                    }

                    System.out.println("Funcionarios listados com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                            + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                //opção voltar
                if (operacaoClasse == 4) {
                    operacao = 0;
                }
            }

            // operação sala
            if (operacao == 5) {
                System.out.println("Acessando salas...\n" + "\nDigite os seguintes numeros para realizar operacoes:\n"
                        + "\n1: Cadastrar nova sala" + "\n2: Consultar sala" + "\n3: Listar salas" + "\n4: Voltar");
                int operacaoClasse = scanner.nextInt();
                scanner.nextLine();

                // sala cadastrar
                if (operacaoClasse == 1) {
                    if (sala.cadastrar(sala) == true) {
                        System.out.println("Sala cadastrada com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                                + "1 para sim\n2 para nao");
                        int novaOperacao = scanner.nextInt();
                        scanner.nextLine();

                        if (novaOperacao == 1) {
                            operacao = 0;
                        } else {
                            System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                            operacaoEncerrada = true;
                        }
                    }
                }

                // sala consultar
                if (operacaoClasse == 2) {
                    sala.consultar(sala);

                    System.out.println("Sala consultada com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                            + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                // sala listar
                if (operacaoClasse == 3) {
                    for (Sala salas : sala.listar(sala)) {
                        salas.exibir();
                    }

                    System.out.println("Salas listadas com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                            + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                //opção voltar
                if (operacaoClasse == 4) {
                    operacao = 0;
                }
            }

            // operação tipoAssento
            if (operacao == 6) {
                System.out.println(
                        "Acessando TipoAssento...\n" + "\nDigite os seguintes numeros para realizar operacoes:\n"
                                + "\n1: Cadastrar novo TipoAssento" + "\n2: Consultar TipoAssento"
                                + "\n3: Listar Tipos de Assento" + "\n4: Voltar");
                int operacaoClasse = scanner.nextInt();
                scanner.nextLine();

                // TipoAssento cadastrar
                if (operacaoClasse == 1) {
                    if (tipoAssento.cadastrar(tipoAssento) == true) {
                        System.out.println(
                                "TipoAssento cadastrado com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                                        + "1 para sim\n2 para nao");
                        int novaOperacao = scanner.nextInt();
                        scanner.nextLine();

                        if (novaOperacao == 1) {
                            operacao = 0;
                        } else {
                            System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                            operacaoEncerrada = true;
                        }
                    }
                }

                // TipoAssento consultar
                if (operacaoClasse == 2) {
                    tipoAssento.consultar(tipoAssento);

                    System.out.println("TipoAssento consultado com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                            + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                // TipoAssento listar
                if (operacaoClasse == 3) {
                    for (TipoAssento tiposAssento : tipoAssento.listar(tipoAssento)) {
                        tiposAssento.exibir();
                    }

                    System.out.println(
                            "Tipos de Assento listados com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                                    + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                //opção voltar
                if (operacaoClasse == 4) {
                    operacao = 0;
                }
            }

            // operação FilmeAtor
            if (operacao == 7) {
                System.out.println("Acessando FilmeAtor...\n"
                        + "\nDigite os seguintes numeros para realizar operacoes:\n"
                        + "\n1: Cadastrar novo FilmeAtor" + "\n2: Consultar FilmeAtor" + "\n3: Listar FilmeAtor" + "\n4: Voltar");
                int operacaoClasse = scanner.nextInt();
                scanner.nextLine();

                // FilmeAtor cadastrar
                if (operacaoClasse == 1) {
                    if (filmeAtor.cadastrar(filmeAtor) == true) {
                        System.out
                                .println("FilmeAtor cadastrado com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                                        + "1 para sim\n2 para nao");
                        int novaOperacao = scanner.nextInt();
                        scanner.nextLine();

                        if (novaOperacao == 1) {
                            operacao = 0;
                        } else {
                            System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                            operacaoEncerrada = true;
                        }
                    }
                }

                // FilmeAtor consultar
                if (operacaoClasse == 2) {
                    filmeAtor.consultar(filmeAtor);

                    System.out.println("FilmeAtor consultado com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                            + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                // FilmeAtor listar
                if (operacaoClasse == 3) {
                    for (FilmeAtor filmesAtor : filmeAtor.listar(filmeAtor)) {
                        filmesAtor.exibir();
                    }

                    System.out.println("FilmesAtor listados com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                            + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                //opção voltar
                if (operacaoClasse == 4) {
                    operacao = 0;
                }
            }

            // operação Assento
            if (operacao == 8) {
                System.out
                        .println("Acessando Assentos...\n" + "\nDigite os seguintes numeros para realizar operacoes:\n"
                                + "\n1: Cadastrar novo Assento" + "\n2: Consultar Assento" + "\n3: Listar Assentos" + "\n4: Voltar");
                int operacaoClasse = scanner.nextInt();
                scanner.nextLine();

                // Assento cadastrar
                if (operacaoClasse == 1) {
                    if (assento.cadastrar(assento) == true) {
                        System.out.println("Assento cadastrado com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                                + "1 para sim\n2 para nao");
                        int novaOperacao = scanner.nextInt();
                        scanner.nextLine();

                        if (novaOperacao == 1) {
                            operacao = 0;
                        } else {
                            System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                            operacaoEncerrada = true;
                        }
                    }
                }

                // Assento consultar
                if (operacaoClasse == 2) {
                    assento.consultar(assento);

                    System.out.println("Assento consultado com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                            + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                // Assento listar
                if (operacaoClasse == 3) {
                    for (Assento assentos : assento.listar(assento)) {
                        assentos.exibir();
                    }

                    System.out.println("Assentos listados com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                            + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                //opção voltar
                if (operacaoClasse == 4) {
                    operacao = 0;
                }
            }

            // operação SalaAssento
            if (operacao == 9) {
                System.out.println(
                        "Acessando SalaAssento...\n" + "\nDigite os seguintes numeros para realizar operacoes:\n"
                                + "\n1: Cadastrar nova SalaAssento" + "\n2: Consultar SalaAssento"
                                + "\n3: Listar SalasAssento" + "\n4: Voltar");
                int operacaoClasse = scanner.nextInt();
                scanner.nextLine();

                // SalaAssento cadastrar
                if (operacaoClasse == 1) {
                    if (salaAssento.cadastrar(salaAssento) == true) {
                        System.out.println(
                                "SalaAssento cadastrada com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                                        + "1 para sim\n2 para nao");
                        int novaOperacao = scanner.nextInt();
                        scanner.nextLine();

                        if (novaOperacao == 1) {
                            operacao = 0;
                        } else {
                            System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                            operacaoEncerrada = true;
                        }
                    }
                }

                // SalaAssento consultar
                if (operacaoClasse == 2) {
                    salaAssento.consultar(salaAssento);

                    System.out.println("SalaAssento consultado com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                            + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                // SalaAssento listar
                if (operacaoClasse == 3) {
                    for (SalaAssento salasAssento : salaAssento.listar(salaAssento)) {
                        salasAssento.exibir();
                    }

                    System.out.println("SalasAssento listadas com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                            + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                //opção voltar
                if (operacaoClasse == 4) {
                    operacao = 0;
                }
            }

            // operação Sessao
            if (operacao == 10) {
                System.out.println("Acessando Sessoes...\n" + "\nDigite os seguintes numeros para realizar operacoes:\n"
                        + "\n1: Cadastrar nova Sessao" + "\n2: Consultar Sessao" + "\n3: Listar sessoes" + "\n4: Voltar");
                int operacaoClasse = scanner.nextInt();
                scanner.nextLine();

                // Sessao cadastrar
                if (operacaoClasse == 1) {
                    if (sessao.cadastrar(sessao) == true) {
                        System.out.println("Sessao cadastrada com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                                + "1 para sim\n2 para nao");
                        int novaOperacao = scanner.nextInt();
                        scanner.nextLine();

                        if (novaOperacao == 1) {
                            operacao = 0;
                        } else {
                            System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                            operacaoEncerrada = true;
                        }
                    }
                }

                // Sessao consultar
                if (operacaoClasse == 2) {
                    sessao.consultar(sessao);

                    System.out.println("Sessao consultada com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                            + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                // Sessao listar
                if (operacaoClasse == 3) {
                    for (Sessao sessoes : sessao.listar(sessao)) {
                        sessoes.exibir();
                    }

                    System.out.println("Sessoes listadas com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                            + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                //opção voltar
                if (operacaoClasse == 4) {
                    operacao = 0;
                }
            }

            // operação Ingresso
            if (operacao == 11) {
                System.out
                        .println("Acessando Ingressos...\n" + "\nDigite os seguintes numeros para realizar operacoes:\n"
                                + "\n1: Cadastrar novo Ingresso" + "\n2: Consultar Ingresso" + "\n3: Listar Ingressos" + "\n4: Voltar");
                int operacaoClasse = scanner.nextInt();
                scanner.nextLine();

                // genero cadastrar
                if (operacaoClasse == 1) {
                    if (ingresso.cadastrar(ingresso) == true) {
                        System.out
                                .println("Ingresso cadastrado com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                                        + "1 para sim\n2 para nao");
                        int novaOperacao = scanner.nextInt();
                        scanner.nextLine();

                        if (novaOperacao == 1) {
                            operacao = 0;
                        } else {
                            System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                            operacaoEncerrada = true;
                        }
                    }
                }

                // Ingresso consultar
                if (operacaoClasse == 2) {
                    ingresso.consultar(ingresso);

                    System.out.println("Ingresso consultado com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                            + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                // Ingresso listar
                if (operacaoClasse == 3) {
                    for (Ingresso ingressos : ingresso.listar(ingresso)) {
                        ingressos.exibir();
                    }

                    System.out.println("Ingressos listados com sucesso!\n\n" + "Deseja realizar mais alguma acao?\n"
                            + "1 para sim\n2 para nao");
                    int novaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (novaOperacao == 1) {
                        operacao = 0;
                    } else {
                        System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                        operacaoEncerrada = true;
                    }
                }

                //opção voltar
                if (operacaoClasse == 4) {
                    operacao = 0;
                }
            }

            if (operacao == 12) {
                System.out.println("Ok, obrigado por utilizar o SISTcinema\nEncerrando sistema...");
                operacaoEncerrada = true;
            }

            // Fim ... Obrigado por este semestre prof André, vou sentir saudade do senhor
            // chamando eu e meu irmão de tibia e peroni. Tamo Junto prof! Abraço!
        }
    }
}
