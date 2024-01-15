package com.profencer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProFencer {
    private List<Atleta> tesserati;
    private List<Competizione> competizioni;
    private Atleta AtletaCorrente;
    private Competizione CompetizioneCorrente;

    public void InserimentoCodiceCompetizione(int Codice) {
        // Implementazione del metodo
    }

    public void InserimentoDatiCompetizione(int Codice, String Nome, String Descrizione, Date Data, boolean Individuale, String Categoria, String Arma, float QuotaPartecipazione) {
        // Implementazione del metodo
    }

    public void ScegliFormulaGara(int Codice, int NumeroTurnoDiGironi, int PercEliminati, int NumeroStoccateDirette, int NumeroStoccateGironi) {
        // Implementazione del metodo
    }

    public void ConfermaInserimento() {
        // Implementazione del metodo
    }

    public void CreaTesseramento(String Nome, String Cognome, Date data_nascita, String CF) {
        // Implementazione del metodo
    }

    public void ConfermaTesseramento() {
        // Implementazione del metodo
    }

    public void MostraCompetizioni() {
        // Implementazione del metodo
    }

    public ProFencer(Atleta atletaCorrente, Competizione competizioneCorrente) {
        tesserati = new ArrayList<>();
        competizioni = new ArrayList<>();
        AtletaCorrente = atletaCorrente;
        CompetizioneCorrente = competizioneCorrente;
    }
}
