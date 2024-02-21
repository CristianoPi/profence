package com.profencer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	public void Iscrizione(int codFIS, int codCompetizione) throws Exception{

		//trovo la competizione
		Competizione c=new Competizione();
		for (Competizione competizione : Competizioni) {
			if (competizione.getCodCompetizione()==codCompetizione) {
				c=competizione;
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
			}
		}
		if (a.getCodFIS()==0) {
			throw new Exception("Atleta non esistente");
		}

		for (Atleta iscritto : c.getIscritti()) {
			if(iscritto.getCodFIS()==a.getCodFIS())
				throw new Exception("Atleta già iscritto");
		}
		try {
			c.Iscrizione(a);
		} catch (Exception e) {
			throw new Exception("Funzione in competizione non va");
			// TODO: handle exception
		}

		System.out.println(c);
		System.out.println(a);
		System.out.println(c.getIscritti());
		// //erorre gestito con variabile booleana, se non esiste la competizione o l'atleta non è tesserato errore.

	}

	public void SelezionaCompetizione(int codCompetizione) throws Exception {
		boolean r=false;
		for (Competizione competizione : Competizioni) {
			if (competizione.getCodCompetizione()==codCompetizione) {
				r=true;
				competizioneCorrente=competizione;
			}
		}	
		if (!r) {
			throw new Exception("Competizone non esistente");
		}
	}

	public FormulaDiGara VisualizzazioneFormulaGara( ) throws Exception {
		if(competizioneCorrente==null){
			throw new Exception("Competizone non selezionata");
		}
		return competizioneCorrente.getFormulaDiGara();
	}

	public void ModificaFormulaGara(int codFormula, int percEliminati, int numeroStoccateDirette, int numeroStoccateGironi, int maxDimGironi)throws Exception {
		if(competizioneCorrente==null){
			throw new Exception("Competizone non selezionata");
		}
		competizioneCorrente.getFormulaDiGara().setPercEliminati(percEliminati);
		competizioneCorrente.getFormulaDiGara().setNumeroStoccateDirette(numeroStoccateDirette);
		competizioneCorrente.getFormulaDiGara().setNumeroStoccateGironi(numeroStoccateGironi);
		competizioneCorrente.getFormulaDiGara().setMaxDimGirone(maxDimGironi);
	}

	public List<Atleta> VisualizzazioneAtleti() throws Exception{
		if(competizioneCorrente==null){
			throw new Exception("Competizone non selezionata");
		}
		return competizioneCorrente.getIscritti();
	}

	public void AccettazioneAtleta(int codFIS) throws Exception{
		if(competizioneCorrente==null){
			throw new Exception("Competizone non selezionata");
		}
		try {
			competizioneCorrente.AccettazioneAtleta(codFIS);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	public void CreazioneGironi() throws Exception {

		if (competizioneCorrente==null) {
			//BISOGNA SELEZIONARE UNA COMPETIZIONE!!
			System.out.println("ERRORE");
			throw new Exception("Nessuna competizione corrente");
		}
		try {
			competizioneCorrente.CreazioneGironi();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
			// TODO: handle exceptions
		}
		
	
	}

	public List<Girone> VisualizzaGironi() {
		if (competizioneCorrente==null) {
			//BISOGNA SELEZIONARE UNA COMPETIZIONE!!
			System.out.println("ERRORE");
			return null;
		}
		return competizioneCorrente.getGironi();
	}

	public void InserimentoSpecifiche(int codGirone, int dataOra, int pedana) throws Exception{
		if (competizioneCorrente==null) {
			throw new Exception("Competizione non selezionata");
		}
		try {
			competizioneCorrente.InserimentoSpecifiche(codGirone, dataOra, pedana);
		} catch (Exception e) {
			throw new Exception("Il girone non esiste");
			// TODO: handle exception
		}
		
	}

	public void InserimentoRisultati(int codGirone, List<Assalto> listaAssalti) throws Exception{
		if (competizioneCorrente==null) {
			throw new Exception("Competizione non selezionata");
		}
		competizioneCorrente.InserimentoRisultati(codGirone, listaAssalti);
	}

	public void CreaClassifica() throws Exception{
		if (competizioneCorrente==null) {
			throw new Exception("Competizione non selezionata");
		}
		try {
			competizioneCorrente.CreaClassifica();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Atleta_Girone> VisualizzaClassifica()throws Exception{
		if (competizioneCorrente==null) {
			throw new Exception("Competizione non selezionata");
		}
		if(competizioneCorrente.getClassificaG().size()>0) {
			return competizioneCorrente.getClassificaG();
		}
		else
			throw new Exception("Creare prima la classifica");
	}

	public EliminazioneDiretta CreazioneED()throws Exception{
		if (competizioneCorrente==null) {
			throw new Exception("Competizione non selezionata");
		}
		try {
			competizioneCorrente.setDirettaCorrente(competizioneCorrente.CreazioneED());
			return competizioneCorrente.CreazioneED();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
			// TODO: handle exception
		}
	}

	public void ConfermaED()throws Exception{
		if (competizioneCorrente==null) {
			throw new Exception("Competizione non selezionata");
		}
		competizioneCorrente.ConfermaED();
	}

	public void SelezionaED(int stato)throws Exception{
		if (competizioneCorrente==null) {
			throw new Exception("Competizione non selezionata");
		}
		competizioneCorrente.SelezionaED(stato); 
	}

	public EliminazioneDiretta VisualizzaED(){
		return competizioneCorrente.getDirettaCorrente();
	}

	public void InserisciRisultatiED(List<Assalto> listaAssalti)throws Exception{
		if (competizioneCorrente==null) {
			throw new Exception("Competizione non selezionata");
		}
		competizioneCorrente.InserisciRisultatiED(listaAssalti);
	}

	public void CreaClassificaFinale()throws Exception{
		if (competizioneCorrente==null) {
			throw new Exception("Competizione non selezionata");
		}
		try {
			competizioneCorrente.CreaClassificaFinale();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
			// TODO: handle exception
		}
	}

	public void CreaRanking()throws Exception{
		if (competizioneCorrente==null) {
			throw new Exception("Competizione non selezionata");
		}
		try {
			competizioneCorrente.CreaRanking();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
			// TODO: handle exception
		}
		
	}

	public List<Atleta> VisualizzaClassificaFinale(){
		return competizioneCorrente.getClassificaFinale();
	}

	public List<Atleta> VisualizzaRanking(){//voglio che si stampi il ranking di tutti i tesserati
		return tesserati;
	}

	//__popolo per prove
	public void caricaDati() {
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
			
			//Aggiungiamo iscritti per la competizione 1
			competizioneCorrente=Competizioni.get(0);

			//iscriviamo tutti gli atleti alla competizione 1
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
					   competizioneCorrente.getIscritti().add(new Atleta(codFIS, nome, cognome, CF, genere, posRanking));
			
				   }
			   } catch (IOException e) {
				   e.printStackTrace();
			   }

			   //accetto gli atleti alla competizione 1
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
					competizioneCorrente.getAccettazioni().add(new Atleta(codFIS, nome, cognome, CF, genere, posRanking));
		 
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	
	public List<Assalto> CaricaListaAssalti(){
		String filename="assalti.txt";
		 try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
	            String line;
				List<Assalto> listaAss= new ArrayList<Assalto>();
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                int codAssalto = Integer.parseInt(parts[0]);
	                int atleta1 = Integer.parseInt(parts[1]);
	                int atleta2 = Integer.parseInt(parts[2]);
	                int punteggio1 = Integer.parseInt(parts[3]);
	                int punteggio2 = Integer.parseInt(parts[4]);
	                int tempo = Integer.parseInt(parts[5]);
					listaAss.add(new Assalto(codAssalto, atleta1, atleta2, punteggio1, punteggio2, tempo));
					
	            }
				return listaAss;
				//competizioneCorrente.getGironi().get(0).setAssalti(listaAss);
	        } catch (IOException e) {
	            e.printStackTrace();
				return null;
	        }
	}

	public List<Assalto> CaricaListaAssaltiED(){
		String filename="assalti2.txt";
		 try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
	            String line;
				List<Assalto> listaAss= new ArrayList<Assalto>();
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                int codAssalto = Integer.parseInt(parts[0]);
	                int atleta1 = Integer.parseInt(parts[1]);
	                int atleta2 = Integer.parseInt(parts[2]);
	                int punteggio1 = Integer.parseInt(parts[3]);
	                int punteggio2 = Integer.parseInt(parts[4]);
	                int tempo = Integer.parseInt(parts[5]);
					listaAss.add(new Assalto(codAssalto, atleta1, atleta2, punteggio1, punteggio2, tempo));
					
	            }
				return listaAss;
				//competizioneCorrente.getGironi().get(0).setAssalti(listaAss);
	        } catch (IOException e) {
	            e.printStackTrace();
				return null;
	        }
	}

	public List<Assalto> CaricaListaAssaltiED3(){
		String filename="assalti3.txt";
		 try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
	            String line;
				List<Assalto> listaAss= new ArrayList<Assalto>();
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                int codAssalto = Integer.parseInt(parts[0]);
	                int atleta1 = Integer.parseInt(parts[1]);
	                int atleta2 = Integer.parseInt(parts[2]);
	                int punteggio1 = Integer.parseInt(parts[3]);
	                int punteggio2 = Integer.parseInt(parts[4]);
	                int tempo = Integer.parseInt(parts[5]);
					listaAss.add(new Assalto(codAssalto, atleta1, atleta2, punteggio1, punteggio2, tempo));
					
	            }
				return listaAss;
				//competizioneCorrente.getGironi().get(0).setAssalti(listaAss);
	        } catch (IOException e) {
	            e.printStackTrace();
				return null;
	        }
	}

	public List<Assalto> CaricaListaAssaltiED4(){
		String filename="assalti4.txt";
		 try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
	            String line;
				List<Assalto> listaAss= new ArrayList<Assalto>();
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                int codAssalto = Integer.parseInt(parts[0]);
	                int atleta1 = Integer.parseInt(parts[1]);
	                int atleta2 = Integer.parseInt(parts[2]);
	                int punteggio1 = Integer.parseInt(parts[3]);
	                int punteggio2 = Integer.parseInt(parts[4]);
	                int tempo = Integer.parseInt(parts[5]);
					listaAss.add(new Assalto(codAssalto, atleta1, atleta2, punteggio1, punteggio2, tempo));
					
	            }
				return listaAss;
				//competizioneCorrente.getGironi().get(0).setAssalti(listaAss);
	        } catch (IOException e) {
	            e.printStackTrace();
				return null;
	        }
	}
	
}
