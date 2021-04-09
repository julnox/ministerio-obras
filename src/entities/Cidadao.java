package entities;

public class Cidadao {
    private int id;
    private String nome;
    private String cpf;
    private Endereco endereco;

    public Cidadao(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cidadao(String nome, String cpf, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cidadao{" + "nome='" + nome + '\'' +
                ", id=" + id +
                ", cpf='" + cpf + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
