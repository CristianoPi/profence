package com.profencer;

public class Atleta_Girone {
    private int codFIS;

	private int stoccateDate;

	private int stoccateRicevute;

	private int punteggio;

	private int vittorie;

	private int posizione;

    public int getCodFIS() {
        return codFIS;
    }

    public void setCodFIS(int codFIS) {
        this.codFIS = codFIS;
    }

    public int getStoccateDate() {
        return stoccateDate;
    }

    public void setStoccateDate(int stoccateDate) {
        this.stoccateDate = stoccateDate;
    }

    public int getStoccateRicevute() {
        return stoccateRicevute;
    }

    public void setStoccateRicevute(int stoccateRicevute) {
        this.stoccateRicevute = stoccateRicevute;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public int getVittorie() {
        return vittorie;
    }

    public void setVittorie(int vittorie) {
        this.vittorie = vittorie;
    }

    public int getPosizione() {
        return posizione;
    }

    public void setPosizione(int posizione) {
        this.posizione = posizione;
    }

    public Atleta_Girone(int codFIS, int stoccateDate, int stoccateRicevute, int punteggio, int vittorie,
            int posizione) {
        this.codFIS = codFIS;
        this.stoccateDate = stoccateDate;
        this.stoccateRicevute = stoccateRicevute;
        this.punteggio = punteggio;
        this.vittorie = vittorie;
        this.posizione = posizione;
    }
    
}
