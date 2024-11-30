import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Assento {
    private int idAssento;
    private TipoAssento tipoAssento;
    Scanner scanner = new Scanner(System.in);

    public Assento() {
        this.idAssento = 0;
        this.tipoAssento = new TipoAssento();

    }
    
    public Assento(int idAssento, TipoAssento tipoAssento) {
        this.idAssento = idAssento;
        this.tipoAssento = tipoAssento;

    }

    public int getIdAssento() {
        return idAssento;
    }

    public void setIdAssento(int idAssento) {
        this.idAssento = idAssento;
    }

    public Boolean cadastrar(Assento assento) {
        try {
            FileWriter fw = new FileWriter("Assentos.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            System.out.println("Digite um id para este assento");
            assento.idAssento = scanner.nextInt();
            scanner.nextLine();

            assento.tipoAssento = tipoAssento.consultar(tipoAssento);

            writer.write(assento.idAssento + ";" + assento.tipoAssento.getIdTipoAssento());
            writer.newLine();

            writer.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }
    }

    public ArrayList<Assento> listar(Assento assento) {

        ArrayList<Assento> array = new ArrayList<>();

        try {
            FileReader fr = new FileReader("Assentos.txt");
            BufferedReader reader = new BufferedReader(fr);
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int idAssento = Integer.parseInt(dados[0]);
                int idTipoAssento = Integer.parseInt(dados[1]);

                for (TipoAssento tipoAssentos : tipoAssento.listar(tipoAssento)) {
                    if (tipoAssentos.getIdTipoAssento() == idTipoAssento) {
                        tipoAssento = tipoAssentos;
                    }
                }

                assento = new Assento(idAssento ,tipoAssento);
                array.add(assento);

            }
            reader.close();
            return array;

        } catch (IOException e) {
            e.printStackTrace();
            return array;

        }
    }

    public Assento consultar(Assento assento) {
        System.out.println("Digite o id do assento que voce deseja consultar ou associar: ");
        int idBuscado = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Assento> array = assento.listar(assento);
        try {
            for (Assento assentos : array) {
                if (assentos.getIdAssento() == idBuscado) {
                    assento = assentos;

                    System.out.println("Assento encontrado com sucesso!\n");

                    System.out.println("ID do assento: " + assento.idAssento + "\n Receba o tipo do assento: " + assento.tipoAssento.getDescricao());

                }
            }
            return assento;

        } catch (NullPointerException n) {
            n.printStackTrace();
            scanner.close();
            return assento;
        }
    }
}