package entities;

import entities.enums.TipoProblema;

public class Problema {
    private String relato;
    protected TipoProblema tipoProblema;

    public Problema(String relato) {
        this.relato = relato;
        setTipoProblema();
    }

    public String getRelato() {
        return relato;
    }

    public void setRelato(String relato) {
        this.relato = relato;
    }

    protected void setTipoProblema (){
        tipoProblema = TipoProblema.GERAL;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipoProblema.toString() + "\n" +
                "Descrição: " + relato;
    }
}
