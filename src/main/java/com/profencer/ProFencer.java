package com.profencer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProFencer {
    private List<Atleta> tesserati;

    private Atleta AtletaCorrente; //Serve sicuro?

	private List<Competizione> Competizioni;

	private Competizione CompetizioneCorrente;



	public List<Atleta> getTesserati() {
        return tesserati;
    }

    public void setTesserati(List<Atleta> tesserati) {
        this.tesserati = tesserati;
    }

    public Atleta getAtletaCorrente() {
        return AtletaCorrente;
    }

    public void setAtletaCorrente(Atleta atletaCorrente) {
        AtletaCorrente = atletaCorrente;
    }

    public List<Competizione> getCompetizioni() {
        return Competizioni;
    }

    public void setCompetizioni(List<Competizione> competizioni) {
        Competizioni = competizioni;
    }

    public Competizione getCompetizioneCorrente() {
        return CompetizioneCorrente;
    }

    public void setCompetizioneCorrente(Competizione competizioneCorrente) {
        CompetizioneCorrente = competizioneCorrente;
    }


    public ProFencer(List<Atleta> tesserati, Atleta atletaCorrente, List<Competizione> competizioni,
            Competizione competizioneCorrente) {
        this.tesserati = tesserati;
        AtletaCorrente = atletaCorrente;
        Competizioni = competizioni;
        CompetizioneCorrente = competizioneCorrente;
    }

    //Operazioni
    public void InserimentoCodiceCompetizione(int codCompetizione) {

	}

	public void InserimentoDatiCompetizione(int codCompetizione, String nome, String descrizione, Date data, String categoria, String arma, float quotaPartecipazione) {

	}

	public void ScegliFormulaGara(int codFormula, int percEliminati, int numeroStoccateDirette, int numeroStoccateGironi) {

	}

	/**
	 *  
	 */
	public void CreaFormulaGara(int codFormula, int percEliminati, int numeroStoccateDirette, int numeroStoccateGironi) {

	}

	public void ConfermaInserimento() {

	}

	public void CreaTesseramento(String Nome, String Cognome, Date data_nascita, String CF) {

	}

	public void ConfermaTesseramento() {

	}

	public List<Competizione> MostraCompetizioni() {
		return null;
	}

	public void Iscrizione(int codFIS, int codCompetizione, float quota) {

	}

	public void SelezionaCompetizione(int codCompetizione) {

	}

	public FormulaDiGara VisualizzazioneFormulaGara(Competizione c) {
		return null;
	}

	public void ModificaFormulaGara(int codFormula, int percEliminati, int numeroStoccateDirette, int numeroStoccateGironi, int maxDimGironi) {

	}

	public List<Atleta> VisualizzazioneAtleti(Competizione c) {
		return null;
	}

	public void AccettazioneAtleta(int codFIS) {

	}

	public void CreazioneGironi() {

	}

	public void VisualizzaGironi() {

	}

	public void InserimentoSpecifiche(int codGirone, Date dataOra, int pedana) {

	}

	public void InserimentoRisultati(int codGirone, List<Assalto> listaAssalti) {

	}

}
