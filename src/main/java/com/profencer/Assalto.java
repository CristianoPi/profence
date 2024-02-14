package com.profencer;

public class Assalto {
    private int codAssalto;

	private int atleta1;

	private int atleta2;

	private int punteggio1;

	private int punteggio2;

	private int tempo;

    public int getCodAssalto() {
        return codAssalto;
    }

    public void setCodAssalto(int codAssalto) {
        this.codAssalto = codAssalto;
    }

    public int getAtleta1() {
        return atleta1;
    }

    public void setAtleta1(int atleta1) {
        this.atleta1 = atleta1;
    }

    public int getAtleta2() {
        return atleta2;
    }

    public void setAtleta2(int atleta2) {
        this.atleta2 = atleta2;
    }

    public int getPunteggio1() {
        return punteggio1;
    }

    public void setPunteggio1(int punteggio1) {
        this.punteggio1 = punteggio1;
    }

    public int getPunteggio2() {
        return punteggio2;
    }

    public void setPunteggio2(int punteggio2) {
        this.punteggio2 = punteggio2;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    public Assalto(int codAssalto, int atleta1, int atleta2, int punteggio1, int punteggio2, int tempo) {
        this.codAssalto = codAssalto;
        this.atleta1 = atleta1;
        this.atleta2 = atleta2;
        this.punteggio1 = punteggio1;
        this.punteggio2 = punteggio2;
        this.tempo = tempo;
    }

    public Assalto(int codAssalto) {
        this.codAssalto = codAssalto;
    }

    
}
