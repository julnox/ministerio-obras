package entities;

import entities.enums.LocalizacaoDesnivel;
import entities.enums.TipoProblema;

public final class Desnivelamento extends Problema{
    private Integer tamanho;
    private LocalizacaoDesnivel localizacao;
    private TipoProblema tipoProblema = TipoProblema.DESNIVELAMENTO;

    public Desnivelamento(String relato, Integer tamanho, int localizacao) {
        super(relato);
        this.tamanho = tamanho;
        this.localizacao = LocalizacaoDesnivel.values()[localizacao-1];
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
        return super.toString() + "\n" +
                "Tamanho: " + tamanho +
                ", Localização: " + localizacao.toString();
    }
}
