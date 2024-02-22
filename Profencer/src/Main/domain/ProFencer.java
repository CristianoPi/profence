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
		//super();
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
	                boolean genere = Boolean.parseBoolean(parts[6]);
	                int numeroStoccateGironi = Integer.parseInt(parts[7]);
	                int percEliminati = Integer.parseInt(parts[8]);
	                int numeroStoccateDirette = Integer.parseInt(parts[9]);
	                int maxDimGirone = Integer.parseInt(parts[10]);
	                FormulaDiGara formulaDiGara = new FormulaDiGara(numeroStoccateGironi, percEliminati, numeroStoccateDirette, maxDimGirone);
	                Competizioni.add(new Competizione(codCompetizione, nome, descrizione, data, categoria, arma, formulaDiGara, genere));	            	}
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

   	//OPERAZIONI DELL'AMMINISTRATORE
   	//________UC1________
   	//1.1
       public void InserimentoCodiceCompetizione(int codCompetizione) throws Exception{
   		for (Competizione competizione : Competizioni) {
   			if(competizione.getCodCompetizione()==codCompetizione){
   				throw new Exception("CodCompetizone già presente nel sistema");
   			}
   		}
   		competizioneCorrente = new Competizione(codCompetizione);	
   	}

   	//1.2
   	public void InserimentoDatiCompetizione(String nome, String descrizione, Date data, String categoria, String arma, boolean genere) throws Exception {
   		if(competizioneCorrente==null){
   			throw new Exception("Competizone non selezionata");
   		}
   		competizioneCorrente.setNome(nome);
   		competizioneCorrente.setDescrizione(descrizione);
   		competizioneCorrente.setData(data);
   		competizioneCorrente.setCategoria(categoria);
   		competizioneCorrente.setArma(arma);
   		competizioneCorrente.setGenere(genere);
   	}

   	//1.3
   	public void ScegliFormulaGara(int percEliminati, int numeroStoccateDirette, int numeroStoccateGironi, int maxDimGirone) throws Exception{
   		if(competizioneCorrente==null){
   			throw new Exception("Competizone non selezionata");
   		}
   		if(percEliminati<0 || numeroStoccateDirette<=0 || numeroStoccateGironi<=0||maxDimGirone<=0)
   			throw new Exception("Errore hai inserito dei dati non permessi");
   		if(percEliminati>100)
   			throw new Exception("Errore non si può inserire una percentuale del genere");
   		FormulaDiGara f=new FormulaDiGara(numeroStoccateGironi, percEliminati, numeroStoccateDirette, maxDimGirone);
   		competizioneCorrente.setFormulaDiGara(f);
   	}

   	//1.4
   	public void ConfermaInserimento()throws Exception {
   		if(competizioneCorrente==null){
   			throw new Exception("Competizone non selezionata");
   		}
   		Competizioni.add(competizioneCorrente);
   	}
   	//___________________

   	//________UC2________
   	//2.1
   	public void CreaTesseramento(int codFIS, String Nome, String Cognome, Date data_nascita, String CF, boolean genere) throws Exception {
   		for (Atleta atleta : tesserati) {
   			if(atleta.getCodFIS()==codFIS){
   				throw new Exception("Atleta già tessereato");
   			}
   		}
   		Atleta a= new Atleta(codFIS, Nome, Cognome, CF, genere);
   		atletaCorrente=a;
   	}

   	//2.2
   	public void ConfermaTesseramento() throws Exception{
   		if(atletaCorrente==null){
   			throw new Exception("Atleta non selezionato");
   		}
   		tesserati.add(atletaCorrente);
   	}
   	//___________________

   	//________UC3________
   	//3.1
   	public List<Competizione> MostraCompetizioni() {
   		return Competizioni;
   	}

   	//3.2
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

   		//vedo se è già iscritto
   		for (Atleta iscritto : c.getIscritti()) {
   			if(iscritto.getCodFIS()==a.getCodFIS())
   				throw new Exception("Atleta già iscritto");
   		}
   		if(c.isGenere()!=a.isGenere())
   			throw new Exception("L'atleta non puo' iscirversi ad un'altra competizione");
   	
   		try {
   			c.Iscrizione(a);
   		} catch (Exception e) {
   			throw new Exception("Funzione in competizione non va");
   			// TODO: handle exception
   		}
   	}
   	//__________________
   	//FINE OPERAZIONI DELL'AMMINISTRATORE

   	//OPERAZIONI DELL'UFFICIALE DI GARA
   	//________UC4________
   	//4.1(anche 5.1)
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

   	//4.2
   	public FormulaDiGara VisualizzaFormulaGara( ) throws Exception {
   		if(competizioneCorrente==null){
   			throw new Exception("Competizone non selezionata");
   		}
   		return competizioneCorrente.getFormulaDiGara();
   	}

   	//4.3
   	public void ModificaFormulaGara(int percEliminati, int numeroStoccateDirette, int numeroStoccateGironi, int maxDimGironi)throws Exception {
   		if(competizioneCorrente==null){
   			throw new Exception("Competizone non selezionata");
   		}
   		if(percEliminati<0 || numeroStoccateDirette<=0 || numeroStoccateGironi<=0||maxDimGironi<=0)
   			throw new Exception("Errore hai inserito dei dati non permessi");
   		if(percEliminati>100)
   			throw new Exception("Errore non si può inserire una percentuale del genere");
   		
   		competizioneCorrente.getFormulaDiGara().setPercEliminati(percEliminati);
   		competizioneCorrente.getFormulaDiGara().setNumeroStoccateDirette(numeroStoccateDirette);
   		competizioneCorrente.getFormulaDiGara().setNumeroStoccateGironi(numeroStoccateGironi);
   		competizioneCorrente.getFormulaDiGara().setMaxDimGirone(maxDimGironi);
   	}
   	//___________________

   	//________UC5________
   	//5.2
   	public List<Atleta> VisualizzaAtleti() throws Exception{
   		if(competizioneCorrente==null){
   			throw new Exception("Competizone non selezionata");
   		}
   		return competizioneCorrente.getIscritti();
   	}

   	//5.3
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
   	//__________________

   	//________UC6________
   	//6.1
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

   	//6.2
   	public List<Girone> VisualizzaGironi() throws Exception{
   		if (competizioneCorrente==null) {
   			throw new Exception("Nessuna competizione corrente");
   		}
   		if(competizioneCorrente.getGironi().size()==0){
   			throw new Exception("Gironi non creati");
   		}
   		return competizioneCorrente.getGironi();
   	}

   	//6.3
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
   	//__________________

   	//________UC7________
   	//7.2
   	public void InserimentoRisultati(int codGirone, List<Assalto> listaAssalti) throws Exception{
   		if (competizioneCorrente==null) {
   			throw new Exception("Competizione non selezionata");
   		}
   		competizioneCorrente.InserimentoRisultati(codGirone, listaAssalti);
   	}
   	
   	//___________________

   	//________UC7.1________
   	//7.1
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

   	//7.2
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
   	//______________________

   	//________UC8________
   	//8.1
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

   	//8.2
   	public void ConfermaED()throws Exception{
   		if (competizioneCorrente==null) {
   			throw new Exception("Competizione non selezionata");
   		}
   		competizioneCorrente.ConfermaED();
   	}
   	//___________________

   	//________UC9________
   	//9.1
   	public void SelezionaED(int stato)throws Exception{
   		if (competizioneCorrente==null) {
   			throw new Exception("Competizione non selezionata");
   		}
   		competizioneCorrente.SelezionaED(stato); 
   	}

   	//9.2
   	public EliminazioneDiretta VisualizzaED()throws Exception{
   		if (competizioneCorrente==null) {
   			throw new Exception("Competizione non selezionata");
   		}
   		if (competizioneCorrente.getDirettaCorrente()==null) {
   			throw new Exception("diretta non selezionata");
   		}
   		return competizioneCorrente.getDirettaCorrente();
   	}

   	//9.3
   	public void InserisciRisultatiED(List<Assalto> listaAssalti)throws Exception{
   		if (competizioneCorrente==null) {
   			throw new Exception("Competizione non selezionata");
   		}
   		try {
   			competizioneCorrente.InserisciRisultatiED(listaAssalti);
   		} catch (Exception e) {
   			throw new Exception(e.getMessage()); 
   		}
   		
   	}
   	//___________________

   	//________UC11________
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

   	public List<Atleta> VisualizzaClassificaFinale(){
   		return competizioneCorrente.getClassificaFinale();
   	}
   	//____________________

   	//________UC10________
   	public void CreaRanking()throws Exception{
   		if (competizioneCorrente==null) {
   			throw new Exception("Competizione non selezionata");
   		}
   		try {

   			List<Atleta> la=competizioneCorrente.CreaRanking();
   			for (Atleta a : la) {
   				for (Atleta atleta : tesserati) {
   					if(a.getCodFIS()==atleta.getCodFIS()){
   						atleta.setRanking(a.getRanking());
   					}
   				}
   			}
   		} catch (Exception e) {
   			throw new Exception(e.getMessage());
   			// TODO: handle exception
   		}
   	}
   	public List<Atleta> VisualizzaRanking(){//voglio che si stampi il ranking di tutti i tesserati
   		return tesserati;
   	}
   	//____________________
}