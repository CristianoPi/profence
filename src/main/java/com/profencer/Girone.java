package com.profencer;

import java.util.List;

public class Girone {
    private int codGirone;

	private int dataOra;

	private int pedana;

	private Competizione competizione;

	private List<Assalto> Assalti;

	private List<Atleta_Girone> AtletiGiorne;

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

    public Competizione getCompetizione() {
        return competizione;
    }

    public void setCompetizione(Competizione competizione) {
        this.competizione = competizione;
    }

    public List<Assalto> getAssalti() {
        return Assalti;
    }

    public void setAssalti(List<Assalto> assalti) {
        Assalti = assalti;
    }

    public List<Atleta_Girone> getAtletiGiorne() {
        return AtletiGiorne;
    }

    public void setAtletiGiorne(List<Atleta_Girone> atletiGiorne) {
        AtletiGiorne = atletiGiorne;
    }

    public Girone(int codGirone, int dataOra, int pedana, Competizione competizione, List<Assalto> assalti,
            List<Atleta_Girone> atletiGiorne) {
        this.codGirone = codGirone;
        this.dataOra = dataOra;
        this.pedana = pedana;
        this.competizione = competizione;
        Assalti = assalti;
        AtletiGiorne = atletiGiorne;
    }
    
}
