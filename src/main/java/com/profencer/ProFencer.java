package com.profencer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProFencer {
	//Singleton
	private static ProFencer sistema;

    private List<Atleta> tesserati;
    private Atleta atletaCorrente; //Serve sicuro?
	private List<Competizione> Competizioni;
	private Competizione competizioneCorrente;

	//gettter and setter
	public List<Atleta> getTesserati() {
        return tesserati;
    }

    public void setTesserati(List<Atleta> tesserati) {
        this.tesserati = tesserati;
    }

    public Atleta getAtletaCorrente() {
        return atletaCorrente;
    }

    public void setAtletaCorrente(Atleta AtletaCorrente) {
        atletaCorrente = AtletaCorrente;
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

	//costruttori



	//_____________________Singleton______________________
    public ProFencer() {
        this.tesserati = new ArrayList<Atleta>();
        this.atletaCorrente = null;
        Competizioni = new ArrayList<Competizione>();
        competizioneCorrente = null;
    }
	public static ProFencer GetIstanceProFencer(){
		if (sistema==null){
			sistema=new ProFencer();
		}
		return sistema;
	}
	//______________________________________________________



    //operazioni
    public void InserimentoCodiceCompetizione(int codCompetizione) throws Exception{
		for (Competizione competizione : Competizioni) {
			if(competizione.getCodCompetizione()==codCompetizione){
				throw new Exception("CodCompetizone già presente nel sistema");
			}
		}
		competizioneCorrente = new Competizione(codCompetizione);
		
	}
	public void InserimentoDatiCompetizione(String nome, String descrizione, Date data, String categoria, String arma) throws Exception {
		if(competizioneCorrente==null){
			throw new Exception("Competizone non selezionata");
		}
		competizioneCorrente.setNome(nome);
		competizioneCorrente.setDescrizione(descrizione);
		competizioneCorrente.setData(data);
		competizioneCorrente.setCategoria(categoria);
		competizioneCorrente.setArma(arma);
	}


	public void ScegliFormulaGara(int codFormula, int percEliminati, int numeroStoccateDirette, int numeroStoccateGironi, int maxDimGirone) throws Exception{
		if(competizioneCorrente==null){
			throw new Exception("Competizone non selezionata");
		}
		FormulaDiGara f=new FormulaDiGara(codFormula, numeroStoccateGironi, percEliminati, numeroStoccateDirette, maxDimGirone);
		competizioneCorrente.setFormulaDiGara(f);
	}

	public void ConfermaInserimento()throws Exception {
		if(competizioneCorrente==null){
			throw new Exception("Competizone non selezionata");
		}
		Competizioni.add(competizioneCorrente);
	}

	public void CreaTesseramento(int codFIS, String Nome, String Cognome, Date data_nascita, String CF, boolean genere) throws Exception {
		for (Atleta atleta : tesserati) {
			if(atleta.getCodFIS()==codFIS){
				throw new Exception("Atleta già tessereato");
			}
		}
		Atleta a= new Atleta(codFIS, Nome, Cognome, CF, genere);
		atletaCorrente=a;
	}

	public void ConfermaTesseramento() throws Exception{
		if(atletaCorrente==null){
			throw new Exception("Atleta non selezionato");
		}
		tesserati.add(atletaCorrente);
	}

	public List<Competizione> MostraCompetizioni() {
		return Competizioni;
	}

	public boolean Iscrizione(int codFIS, int codCompetizione) throws Exception{
		boolean r=false;
		//trovo la competizione
		Competizione c=new Competizione();
		for (Competizione competizione : Competizioni) {
			if (competizione.getCodCompetizione()==codCompetizione) {
				c=competizione;
				r=true;
			}
		}
		if (c.getCodCompetizione()==0) {
			throw new Exception("Competizione non esistente");
		}

		//trovo l'atleta
		Atleta a=new Atleta();

		for (Atleta atleta : tesserati) {
			if (atleta.getCodFIS()==codFIS) {
				a=atleta;
				r=true;
			}
		}
		if (a.getCodFIS()==0) {
			throw new Exception("Atleta non esistente");
		}
		
		c.Iscrizione(a);
		return r;
		//erorre gestito con variabile booleana, se non esiste la competizione o l'atleta non è tesserato errore.
	}

	public void SelezionaCompetizione(int codCompetizione) {
		for (Competizione competizione : Competizioni) {
			if (competizione.getCodCompetizione()==codCompetizione) {
				competizioneCorrente=competizione;
			}
		}	
	}

	public FormulaDiGara VisualizzazioneFormulaGara(Competizione c) {
		return c.getFormulaDiGara();
	}

	public void ModificaFormulaGara(int codFormula, int percEliminati, int numeroStoccateDirette, int numeroStoccateGironi, int maxDimGironi) {
		competizioneCorrente.getFormulaDiGara().setPercEliminati(percEliminati);
		competizioneCorrente.getFormulaDiGara().setNumeroStoccateDirette(numeroStoccateDirette);
		competizioneCorrente.getFormulaDiGara().setNumeroStoccateGironi(numeroStoccateGironi);
		competizioneCorrente.getFormulaDiGara().setMaxDimGirone(maxDimGironi);
	}

	public List<Atleta> VisualizzazioneAtleti(Competizione c) {
		return null;
	}

	public void AccettazioneAtleta(int codFIS) {
		competizioneCorrente.AccettazioneAtleta(codFIS);
	}

	public void CreazioneGironi() throws Exception {

		if (competizioneCorrente==null) {
			//BISOGNA SELEZIONARE UNA COMPETIZIONE!!
			System.out.println("ERRORE");
			throw new Exception("Nessuna competizione corrente");
		}
	
		competizioneCorrente.CreazioneGironi();
	
	}

	public List<Girone> VisualizzaGironi() {
		if (competizioneCorrente==null) {
			//BISOGNA SELEZIONARE UNA COMPETIZIONE!!
			System.out.println("ERRORE");
			return null;
		}
		return competizioneCorrente.getGironi();
	}

	public void InserimentoSpecifiche(int codGirone, int dataOra, int pedana) {
		if (competizioneCorrente==null) {
			//BISOGNA SELEZIONARE UNA COMPETIZIONE!!
			System.out.println("ERRORE");
		}
		competizioneCorrente.InserimentoSpecifiche(codGirone, dataOra, pedana);
	}

	public void InserimentoRisultati(int codGirone, List<Assalto> listaAssalti) {
		if (competizioneCorrente==null) {
			//BISOGNA SELEZIONARE UNA COMPETIZIONE!!
			System.out.println("ERRORE");
		}
	
		competizioneCorrente.InserimentoRisultati(codGirone, listaAssalti);
	}

	public EliminazioneDiretta CreazioneED(){
		if (competizioneCorrente==null) {
			//BISOGNA SELEZIONARE UNA COMPETIZIONE!!
			System.out.println("ERRORE");
		}
		return competizioneCorrente.CreazioneED();
	}

	public void ConfermaED(){
		competizioneCorrente.ConfermaED();
	}

	public void SelezionaED(int stato){
		competizioneCorrente.SelezionaED(stato); 
	}

	public EliminazioneDiretta VisualizzaED(){
		return competizioneCorrente.getDirettaCorrente();
	}

	public void InserisciRisultatiED(List<Assalto> listaAssalti){
		competizioneCorrente.InserisciRisultatiED(listaAssalti);
	}

	public void CreaClassificaFinale(){
		competizioneCorrente.CreaClassificaFinale();
	}

	public void CreaRanking(){
		competizioneCorrente.CreaRanking();
	}

	public List<Atleta> VisualizzaClassificaFinale(){
		return competizioneCorrente.getClassificaFinale();
	}

	public List<Atleta> VisualizzaRanking(){//voglio che si stampi il ranking di tutti i tesserati
		return tesserati;
	}
}
