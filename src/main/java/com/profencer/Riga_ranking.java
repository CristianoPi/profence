package com.profencer;

public class Riga_ranking {
    int posizioneMax;
    int posizioneMin;
    float punteggio;
    
    public int getPosizioneMax() {
        return posizioneMax;
    }

    public void setPosizioneMax(int posizioneMax) {
        this.posizioneMax = posizioneMax;
    }

    public int getPosizioneMin() {
        return posizioneMin;
    }

    public void setPosizioneMin(int posizioneMin) {
        this.posizioneMin = posizioneMin;
    }

    public float getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(float punteggio) {
        this.punteggio = punteggio;
    }

    public Riga_ranking(int posizioneMax, int posizioneMin, float punteggio) {
        this.posizioneMax = posizioneMax;
        this.posizioneMin = posizioneMin;
        this.punteggio = punteggio;
    }
}
