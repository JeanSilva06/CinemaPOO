import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TipoAssento {
    private int idTipoAssento;
    private String descricao;
    private String status;
    Scanner scanner = new Scanner(System.in);

    public int getIdTipoAssento() {
        return this.idTipoAssento;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getStatus() {
        return this.status;
    }

    public void setIdTipoAssento(int idTipoAssento) {
        this.idTipoAssento = idTipoAssento;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TipoAssento() {
        this.idTipoAssento = 0;
        this.descricao = "";
        this.status = "";
    }

    public TipoAssento(int idTipoAssento, String descricao, String status) {
        this.idTipoAssento = idTipoAssento;
        this.descricao = descricao;
        this.status = status;
    }

    public Boolean cadastrar(TipoAssento tipoAssento) {
        try {
            FileWriter fw = new FileWriter("TiposDeAssentos.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            System.out.println("Digite o id para este tipo de assento: ");
            tipoAssento.idTipoAssento = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite uma descricao para esse tipo de assento: ");
            tipoAssento.descricao = scanner.nextLine();

            System.out
                    .println("Digite um status para este tipo de assento sendo A para ativa-lo e I para inativa-lo: ");
            tipoAssento.status = scanner.nextLine();

            writer.write(tipoAssento.idTipoAssento + ";" + tipoAssento.descricao + ";" + tipoAssento.status);
            writer.newLine();

            writer.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }
    }

    public ArrayList<TipoAssento> listar(TipoAssento tipoAssento) {

        ArrayList<TipoAssento> array = new ArrayList<>();

        try {
            FileReader fr = new FileReader("TiposDeAssentos.txt");
            BufferedReader reader = new BufferedReader(fr);
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int idTipoAssento = Integer.parseInt(dados[0]);
                String descricao = dados[1];
                String status = dados[2];

                tipoAssento = new TipoAssento(idTipoAssento, descricao, status);

                array.add(tipoAssento);

            }
            reader.close();
            return array;

        } catch (IOException e) {
            e.printStackTrace();
            return array;

        }
    }

    public TipoAssento consultar(TipoAssento tipoAssento) {
        System.out.println("Digite o id do tipo de assento que voce deseja consultar ou associar: ");
        int idBuscado = scanner.nextInt();
        scanner.nextLine();

        ArrayList<TipoAssento> array = this.listar(tipoAssento);
        
        try {
            for (TipoAssento assentos : array) {
                if (assentos.getIdTipoAssento() == idBuscado) {
                    tipoAssento = assentos;

                    System.out.println("Id do assento: "
                            + tipoAssento.idTipoAssento + " Descricao: "
                            + tipoAssento.descricao + " Status: " + tipoAssento.status);

                }
            }
            return tipoAssento;

        } catch (NullPointerException n) {
            n.printStackTrace();
            scanner.close();
            return tipoAssento;
        }
    }

    public void exibir() {
        System.out.println("Id do assento: "
        + this.idTipoAssento + " Descricao: "
        + this.descricao + " Status: " + this.status);
    }
}
