package Main.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class EliminazioneDiretta {
    private int stato;
    private List<Assalto> assaltiED;
    private List<Atleta> eliminati;

    public int getStato() {
        return stato;
    }
    public void setStato(int stato) {
        this.stato = stato;
    }
    public List<Assalto> getAssaltiED() {
        return assaltiED;
    }
    public void setAssaltiED(List<Assalto> assaltiED) {
        this.assaltiED = assaltiED;
    }
    public EliminazioneDiretta(int stato, List<Assalto> assaltiED) {
        this.stato = stato;
        this.assaltiED = assaltiED;
    }

    public EliminazioneDiretta(int stato) {
        this.stato = stato;
        this.assaltiED =new ArrayList<>();
    }
    public List<Atleta> getEliminati() {
        return eliminati;
    }
    public void setEliminati(List<Atleta> eliminati) {
        this.eliminati = eliminati;
    }

    
}
