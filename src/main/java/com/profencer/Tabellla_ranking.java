package com.profencer;
import java.util.List;


public class Tabellla_ranking {
    private List<Riga_ranking> righe;
    
    public void CaricaTabellaRanking(){

		righe.add(new Riga_ranking(0, 0, 100));//0 atleta arrrivato primo
        righe.add(new Riga_ranking(1, 1, 80));
        righe.add(new Riga_ranking(2, 2, 65));
        righe.add(new Riga_ranking(4, 7, 50));
        righe.add(new Riga_ranking(8, 15, 32));
        righe.add(new Riga_ranking(16, 31, 16));
        righe.add(new Riga_ranking(32, 63, 8));
        righe.add(new Riga_ranking(64, 127, 4));
        righe.add(new Riga_ranking(128, 255, 2));
        righe.add(new Riga_ranking(256, 512, 1));
        
	}
    public float OttieniPunteggio(int posizione){
        for (Riga_ranking riga_ranking : righe) {
            if(riga_ranking.getPosizioneMin()<posizione && posizione<riga_ranking.getPosizioneMax()){
                return riga_ranking.getPunteggio();
            }
        }
        return 0;
    }
}

