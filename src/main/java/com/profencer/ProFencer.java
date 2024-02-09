package com.profencer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProFencer {
    private List<Atleta> tesserati;

    private Atleta atletaCorrente; //Serve sicuro?

	private List<Competizione> Competizioni;

	private Competizione competizioneCorrente;



	public List<Atleta> getTesserati() {
        return tesserati;
    }

    public void setTesserati(List<Atleta> tesserati) {
        this.tesserati = tesserati;
    }

    public Atleta getAtletaCorrente() {
        return atletaCorrente;
    }

    public void setAtletaCorrente(Atleta atletaCorrente) {
        atletaCorrente = atletaCorrente;
    }

    public List<Competizione> getCompetizioni() {
        return Competizioni;
    }

    public void setCompetizioni(List<Competizione> competizioni) {
        Competizioni = competizioni;
    }

    public Competizione getCompetizioneCorrente() {
        return competizioneCorrente;
    }

    public void setCompetizioneCorrente(Competizione CompetizioneCorrente) {
        competizioneCorrente = CompetizioneCorrente;
    }


    public ProFencer(List<Atleta> tesserati, Atleta atletaCorrente, List<Competizione> competizioni,
            Competizione CompetizioneCorrente) {
        this.tesserati = tesserati;
        this.atletaCorrente = atletaCorrente;
        Competizioni = competizioni;
        competizioneCorrente = CompetizioneCorrente;
    }

    //Operazioni
    public void InserimentoCodiceCompetizione(int codCompetizione) {
		competizioneCorrente = new Competizione(codCompetizione);
	}

	public void InserimentoDatiCompetizione(int codCompetizione, String nome, String descrizione, Date data, String categoria, String arma, float quotaPartecipazione) {
		competizioneCorrente.setNome(nome);
		competizioneCorrente.setDescrizione(descrizione);
		competizioneCorrente.setData(data);
		competizioneCorrente.setCategoria(categoria);
		competizioneCorrente.setArma(arma);
		competizioneCorrente.setQuotaParticipazione(quotaPartecipazione);
	}

	public void ScegliFormulaGara(int codFormula, int percEliminati, int numeroStoccateDirette, int numeroStoccateGironi, int maxDimGirone) {
		FormulaDiGara f=new FormulaDiGara(codFormula, numeroStoccateGironi, percEliminati, numeroStoccateDirette, maxDimGirone);
		competizioneCorrente.setFormulaDiGara(f);
	}

	public void ConfermaInserimento() {
		Competizioni.add(competizioneCorrente);
	}

	public void CreaTesseramento(int codFIS, String Nome, String Cognome, Date data_nascita, String CF, boolean genere) {
		Atleta a= new Atleta(codFIS, Nome, Cognome, CF, genere);
		atletaCorrente=a;
	}

	public void ConfermaTesseramento() {
		tesserati.add(atletaCorrente);
	}

	public List<Competizione> MostraCompetizioni() {
		return Competizioni;
	}

	public boolean Iscrizione(int codFIS, int codCompetizione) {
		boolean b=false;
		Competizione c=new Competizione(0);
		for (Competizione competizione : Competizioni) {
			if(competizione.getCodCompetizione()==codCompetizione)
				c=competizione;
		}
		b=c.IscrizioneAtleta(codFIS);

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
