package entities;

import entities.enums.LocalizacaoDesnivel;

public class Desnivelamento extends Problema{
    private Integer tamanho;
    private LocalizacaoDesnivel localizacao;

    public Desnivelamento(Integer tamanho, LocalizacaoDesnivel localizacao) {
        this.tamanho = tamanho;
        this.localizacao = localizacao;
    }

    public LocalizacaoDesnivel getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(LocalizacaoDesnivel localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Desnivelamento{" +
                "tamanho=" + tamanho +
                '}';
    }
}
