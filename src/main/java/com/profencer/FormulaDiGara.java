package com.profencer;

public class FormulaDiGara {
	private int NumeroStoccateGironi;
	private int PercEliminati;
	private int NumeroStoccateDirette;
	private int Codice;
    public int getNumeroStoccateGironi() {
        return NumeroStoccateGironi;
    }
    public int getPercEliminati() {
        return PercEliminati;
    }
    public int getNumeroStoccateDirette() {
        return NumeroStoccateDirette;
    }
    public int getCodice() {
        return Codice;
    }
    public void setNumeroStoccateGironi(int numeroStoccateGironi) {
        NumeroStoccateGironi = numeroStoccateGironi;
    }
    public void setPercEliminati(int percEliminati) {
        PercEliminati = percEliminati;
    }
    public void setNumeroStoccateDirette(int numeroStoccateDirette) {
        NumeroStoccateDirette = numeroStoccateDirette;
    }
    public void setCodice(int codice) {
        Codice = codice;
    }
    public FormulaDiGara(int numeroTurniDiGironi, int numeroStoccateGironi, int percEliminati,
            int numeroStoccateDirette, int codice) {
        NumeroStoccateGironi = numeroStoccateGironi;
        PercEliminati = percEliminati;
        NumeroStoccateDirette = numeroStoccateDirette;
        Codice = codice;
    }
    
}
