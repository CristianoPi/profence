package Main.domain;

import java.util.List;

public class Girone {
    private int codGirone;
	private int dataOra;//non funziona date
	private int pedana;
	private Competizione competizione;
	private List<Assalto> assalti;
	private List<Atleta_Girone> atletiGiorne;

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

    public Girone(int codGirone, int dataOra, int pedana, Competizione competizione, List<Assalto> assalti,
            List<Atleta_Girone> atletiGiorne) {
        this.codGirone = codGirone;
        this.dataOra = dataOra;
        this.pedana = pedana;
        this.competizione = competizione;
        this.assalti = assalti;
        this.atletiGiorne = atletiGiorne;
    }

    public Girone(int codGirone) {
        this.codGirone = codGirone;
    }


    
}
