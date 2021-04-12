package entities;

import entities.enums.LocalizacaoBuraco;
import entities.enums.TipoProblema;

public final class Buraco extends Problema{
    private Integer tamanho;
    private LocalizacaoBuraco localizacao;

    public Buraco(String relato, Integer tamanho, int localizacao) {
        super(relato);
        this.tamanho = tamanho;
        this.localizacao = LocalizacaoBuraco.values()[localizacao-1];
    }

    @Override
    protected void setTipoProblema() {
        tipoProblema = TipoProblema.BURACO;
    }

    public LocalizacaoBuraco getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(LocalizacaoBuraco localizacao) {
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
        return super.toString() + "\n" +
                "Tamanho: " + tamanho +
                ", Localização: " + localizacao.toString();
    }
}
