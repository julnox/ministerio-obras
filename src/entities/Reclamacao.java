package entities;

import entities.enums.Situacao;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Reclamacao {
    private int id;
    private Date data;
    private Cidadao cidadao;
    private Problema problema;
    private Situacao situacao;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");

    public Reclamacao(int id, Cidadao cidadao, Problema problema) {
        this.cidadao = cidadao;
        this.id = id;
        this.problema = problema;
        situacao = Situacao.REGISTRADO;
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

    public Problema getProblema() {
        return problema;
    }

    public void setProblema(Problema problema) {
        this.problema = problema;
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
                "\nPROBLEMA\n" + problema;
    }
}
