package entities;

import entities.enums.TipoProblema;

public class Problema {
    private String relato;
    private TipoProblema tipoProblema = TipoProblema.GERAL;

    public Problema(String relato) {
        this.relato = relato;
    }

    public String getRelato() {
        return relato;
    }

    public void setRelato(String relato) {
        this.relato = relato;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipoProblema.toString() + "\n" +
                "Descrição: " + relato;
    }
}
