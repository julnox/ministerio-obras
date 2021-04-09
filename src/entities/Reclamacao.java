package entities;

import entities.enums.Situacao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public final class Reclamacao {
    private int id;
    private Date data;
    private Cidadao cidadao;
    private ArrayList<Problema> problemas;
    private Situacao situacao;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");

    public Reclamacao(int id, Cidadao cidadao) {
        this.cidadao = cidadao;
        situacao = Situacao.REGISTRADO;
        this.id = id;
        problemas = new ArrayList<>();
        data = new Date();
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public Cidadao getCidadao() {
        return cidadao;
    }

    public void addProblema(Problema problema){
        problemas.add(problema);
    }

    public void removeProblema(Problema problema){
        problemas.remove(problema);
    }

    public String getProblemas(){
        StringBuilder sb = new StringBuilder();

        for (Problema p : problemas){
            sb.append(p.toString());
        }
        return sb.toString();
    }

    public void setCidadao(Cidadao cidadao) {
        this.cidadao = cidadao;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return  "ID: " + id +
                "\nData: " + sdf.format(data) +
                "\nCidadão= ID: " + cidadao.getId() + ", Nome: " + cidadao.getNome() +
                "\nSituação: " + situacao +
                "\nPROBLEMAS\n" + getProblemas();
    }
}
