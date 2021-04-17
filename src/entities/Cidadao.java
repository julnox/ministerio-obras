package entities;

public class Cidadao {
    private int id;
    private String nome;
    private Endereco endereco;

    public Cidadao() {
    }

    public Cidadao(int id, String nome) {
        this.nome = nome;
        this.id = id;
    }

    public Cidadao(String nome, Endereco endereco) {
        this.nome = nome;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nNome: " + nome +
                "\nENDEREÇO= " + endereco;
    }
}
