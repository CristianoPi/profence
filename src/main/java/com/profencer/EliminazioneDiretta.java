package com.profencer;
import java.util.List;

public class EliminazioneDiretta {
    private int stato;
    private List<Assalto> assaltiED;
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

    
}
