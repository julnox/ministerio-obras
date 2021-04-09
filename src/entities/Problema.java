package entities;

public class Problema {
    private String relato;

    public String getRelato() {
        return relato;
    }

    public void setRelato(String relato) {
        this.relato = relato;
    }

    @Override
    public String toString() {
        return "Problema{" +
                "relato='" + relato + '\'' +
                '}';
    }
}
