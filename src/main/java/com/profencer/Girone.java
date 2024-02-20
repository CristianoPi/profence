package com.profencer;

import java.util.ArrayList;
import java.util.List;

public class Girone {
    private int codGirone;
	private int dataOra;//non funziona date
	private int pedana;
	private List<Assalto> assalti;
	private List<Atleta_Girone> atletiGiorne=new ArrayList<Atleta_Girone>();

    public int getCodGirone() {
        return codGirone;
    }

    public void setCodGirone(int codGirone) {
        this.codGirone = codGirone;
    }

    public int getDataOra() {
        return dataOra;
    }

    public void setDataOra(int dataOra) {
        this.dataOra = dataOra;
    }

    public int getPedana() {
        return pedana;
    }

    public void setPedana(int pedana) {
        this.pedana = pedana;
    }


    public List<Assalto> getAssalti() {
        return assalti;
    }

    public void setAssalti(List<Assalto> assalti) {
        this.assalti = assalti;
    }

    public List<Atleta_Girone> getAtletiGiorne() {
        return atletiGiorne;
    }

    public void setAtletiGiorne(List<Atleta_Girone> atletiGiorne) {
        this.atletiGiorne = atletiGiorne;
    }

    public Girone(int codGirone, int dataOra, int pedana, List<Assalto> assalti,
            List<Atleta_Girone> atletiGiorne) {
        this.codGirone = codGirone;
        this.dataOra = dataOra;
        this.pedana = pedana;
        this.assalti = assalti;
        this.atletiGiorne = atletiGiorne;
    }

    public Girone(int codGirone) {
        this.codGirone = codGirone;
    }

    @Override
    public String toString() {
        return "Girone [codGirone=" + codGirone + ", dataOra=" + dataOra + ", pedana=" + pedana + ", assalti=" + assalti
                + ", atletiGiorne=" + atletiGiorne + "]";
    }

}
