public abstract class Pessoa {
    private String cpf;
    private String nome;
    private String email;

    public void falarNome(){
        System.out.println("Meu nome e: " + this.nome);
    }

    public Pessoa() {
        this.cpf = "";
        this.nome = "";
        this.email = "";
    }

    public Pessoa(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
