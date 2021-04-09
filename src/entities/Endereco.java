package entities;

public class Endereco {
    private Integer rua;
    private Integer numero;
    private String bairro;
    private String cep;

    public Endereco(Integer rua, Integer numero, String bairro, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
    }

    public Endereco(Integer rua, Integer numero, String bairro) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
    }

    public Integer getRua() {
        return rua;
    }

    public void setRua(Integer rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Endereco{" + "rua=" + rua +
                ", numero=" + numero +
                ", bairro='" + bairro + '\'' +
                ", cep=" + cep +
                '}';
    }
}
