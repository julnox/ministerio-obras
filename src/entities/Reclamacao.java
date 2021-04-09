package entities;

import entities.enums.Situacao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Reclamacao {
    private int id;
    private Date data;
    private Cidadao cidadao;
    private ArrayList<Problema> problemas;
    private Situacao situacao;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");

    public Reclamacao(Date data, Cidadao cidadao, Situacao situacao) {
        this.data = data;
        this.cidadao = cidadao;
        this.situacao = situacao;
        problemas = new ArrayList<>();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cidadao getCidadao() {
        return cidadao;
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
}
