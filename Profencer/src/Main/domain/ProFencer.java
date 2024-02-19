package Main.domain;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class ProFencer {
	private static ProFencer instance;
    private List<Atleta> tesserati;
    private Atleta atletaCorrente; //Serve sicuro?
	private List<Competizione> Competizioni;
	private Competizione competizioneCorrente;
	
	public ProFencer() {
		super();
		this.tesserati = new ArrayList<Atleta>();
		this.atletaCorrente=null;
		this.Competizioni=new ArrayList<Competizione>();
		this.competizioneCorrente=null;
		this.caricaDati(); // per caricare da file quello gia salvato	
	}
	private void caricaDati() {
		//Inserimento dati per una prova iniziale
		//carico la lista delle competizioni, la lista degli atleti
		
		//carico le competizioni
		String filename="competizioni.txt";
		
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
	            try { 
	            	String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                int codCompetizione = Integer.parseInt(parts[0]);
	                String nome = parts[1];
	                String descrizione = parts[2]; 
	                Date data = sdf.parse(parts[3]);
	                String categoria = parts[4];
	                String arma = parts[5];
	                int codFormula = Integer.parseInt(parts[6]);
	                int numeroStoccateGironi = Integer.parseInt(parts[7]);
	                int percEliminati = Integer.parseInt(parts[8]);
	                int numeroStoccateDirette = Integer.parseInt(parts[9]);
	                int maxDimGirone = Integer.parseInt(parts[10]);
	                FormulaDiGara formulaDiGara = new FormulaDiGara(codFormula, numeroStoccateGironi, percEliminati, numeroStoccateDirette, maxDimGirone);
	                Competizioni.add(new Competizione(codCompetizione, nome, descrizione, data, categoria, arma, formulaDiGara));
	            	}
	            }
	            catch(ParseException e) {
	                	e.printStackTrace();
	                	return;
	                }
	        } catch (IOException  e) {
	            e.printStackTrace();
	        }
		 
		 //da modificicare
		 filename="tesserati.txt";
		 try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                int codFIS = Integer.parseInt(parts[0]);
	                String nome = parts[1];
	                String cognome = parts[2];
	                String CF = parts[3];
	                boolean genere = Boolean.parseBoolean(parts[4]);
	                float posRanking = Float.parseFloat(parts[5]);
	                tesserati.add(new Atleta(codFIS, nome, cognome, CF, genere, posRanking));
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		 
		}

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

    public static ProFencer getInstance() {
		//gestione singleton
		if (instance == null)
			instance = new ProFencer();
		else
			System.out.println("Istanza già creata");

		return instance;
	}
    
	//costruttori
    public ProFencer(List<Atleta> tesserati, Atleta atletaCorrente, List<Competizione> competizioni,
            Competizione CompetizioneCorrente) {
        this.tesserati = tesserati;
        this.atletaCorrente = atletaCorrente;
        Competizioni = competizioni;
        competizioneCorrente = CompetizioneCorrente;
    }

    //operazioni
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
		boolean r=false;
		//trovo la competizione
		Competizione c=new Competizione();
		for (Competizione competizione : Competizioni) {
			if (competizione.getCodCompetizione()==codCompetizione) {
				c=competizione;
				r=true;
			}
		}
		//trovo l'atleta
		if(r){
			for (Atleta atleta : tesserati) {
				if (atleta.getCodFIS()==codFIS) {
					c.Iscrizione(atleta);
					r=true;
				}
				else
					return false;
			}
		}
		else
			return false;
		
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

	public void CreazioneGironi() {
		if (competizioneCorrente==null) {
			//BISOGNA SELEZIONARE UNA COMPETIZIONE!!
			System.out.println("ERRORE");
			return;
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
