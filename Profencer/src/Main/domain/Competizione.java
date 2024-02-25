package Main.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Competizione {
	private int codCompetizione;
	private String nome;
	private String descrizione;
	private Date data;
	private String categoria;
	private String arma;
	private float quotaParticipazione;
	private FormulaDiGara formulaDiGara;
	private Boolean Genere;
	private List<Girone> gironi;
    private List<Atleta> iscritti;
    private List<Atleta> accettazioni;
    Map<Integer, Atleta> mappaAtleti = new HashMap<>(); //mi è utile per non scorre ogni volta atleti
    private List<Atleta_Girone> classificaG;
    private EliminazioneDiretta direttaCorrente;
    private List<EliminazioneDiretta> eliminazioniDirette;
    private List<Atleta> classificaFinale;
    private boolean rankingCreato;
    private List<Tabella_ranking> tr;//Gestito con un oggetto tabella, non rappresentato in uml, nel progetto definitivo si gestira con DB

    //getters and setters
    public int getCodCompetizione() {
        return codCompetizione;
    }
    public boolean isGenere() {
        return Genere;
    }

    public void setGenere(boolean Genere) {
        this.Genere = Genere;
    }

    public void setClassificaG(List<Atleta_Girone> classificaG) {
        this.classificaG = classificaG;
    }

    public EliminazioneDiretta getDirettaCorrente()throws Exception {
    	System.out.println(direttaCorrente);
        if (direttaCorrente==null) {
            throw new Exception("non c'è una diretta corrente");
        }
        return direttaCorrente;
    }
    public void setDirettaCorrente(EliminazioneDiretta direttaCorrente) {
        this.direttaCorrente = direttaCorrente;
    }

    public List<EliminazioneDiretta> getEliminazioniDirette() throws Exception{
    	if(this.eliminazioniDirette.size()==0)
            throw new Exception("non c'è una diretta corrente");
    	
        return eliminazioniDirette;
    }

    public void setEliminazioniDirette(List<EliminazioneDiretta> eliminazioniDirette) {
        this.eliminazioniDirette = eliminazioniDirette;
    }

    public List<Atleta> getIscritti() {
        return iscritti;
    }

    public void setIscritti(List<Atleta> iscritti) {
        this.iscritti = iscritti;
    }

    public List<Atleta> getAccettazioni() {
        return accettazioni;
    }

    public void setAccettazioni(List<Atleta> accettazioni) {
        this.accettazioni = accettazioni;
    }

    public void setCodCompetizione(int codCompetizione) {
        this.codCompetizione = codCompetizione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public float getQuotaParticipazione() {
        return quotaParticipazione;
    }

    public void setQuotaParticipazione(float quotaParticipazione) {
        this.quotaParticipazione = quotaParticipazione;
    }

    public FormulaDiGara getFormulaDiGara() {
        return formulaDiGara;
    }

    public void setFormulaDiGara(FormulaDiGara formulaDiGara) {
        this.formulaDiGara = formulaDiGara;
    }

    public List<Girone> getGironi() {
        return gironi;
    }

    public void setGironi(List<Girone> gironi) {
        this.gironi = gironi;
    }

    public List<Atleta_Girone> getClassificaG() {
        return classificaG;
    }

    public void setClassifica(List<Atleta_Girone> classificaG) {
        this.classificaG = classificaG;
    }
   
    public List<Atleta> getClassificaFinale() {
        return classificaFinale;
    }

    public void setClassificaFinale(List<Atleta> classificaFinale) {
        this.classificaFinale = classificaFinale;
    }

    //costruttori
    public Competizione(int codCompetizione) {
        this.codCompetizione = codCompetizione;

        this.gironi = new ArrayList<Girone>();
        this.iscritti = new ArrayList<Atleta>();
        this.accettazioni = new ArrayList<Atleta>();
        this.classificaG = new ArrayList<Atleta_Girone>();;
        this.eliminazioniDirette = new ArrayList<EliminazioneDiretta>();;
        this.classificaFinale = new ArrayList<Atleta>();
        rankingCreato=false;
    }
    
    
    public Competizione() {
    	this.codCompetizione = 0;

        this.gironi = new ArrayList<Girone>();
        this.iscritti = new ArrayList<Atleta>();
        this.accettazioni = new ArrayList<Atleta>();
        this.classificaG = new ArrayList<Atleta_Girone>();;
        this.eliminazioniDirette = new ArrayList<EliminazioneDiretta>();;
        this.classificaFinale = new ArrayList<Atleta>();
        rankingCreato=false;
    }

    public Competizione(int codCompetizione, String nome, String descrizione, Date data, String categoria, String arma,
            FormulaDiGara formulaDiGara, boolean genere) {
        this.codCompetizione = codCompetizione;
        this.nome = nome;
        this.descrizione = descrizione;
        this.data = data;
        this.categoria = categoria;
        this.arma = arma;
        this.formulaDiGara = formulaDiGara;
        this.Genere = genere;

        this.gironi = new ArrayList<Girone>();
        this.iscritti = new ArrayList<Atleta>();
        this.accettazioni = new ArrayList<Atleta>();
        this.classificaG = new ArrayList<Atleta_Girone>();;
        this.eliminazioniDirette = new ArrayList<EliminazioneDiretta>();;
        this.classificaFinale = new ArrayList<Atleta>();
    }


	//@Override
   // public String toString() {
    //    return "Competizione: " + codCompetizione ;
    //}
    
  //_____________fine costruttori_________________


  //operazioni
      //operazioni di amministratore
      public void Iscrizione(Atleta atleta) throws Exception{
          try {
              iscritti.add(atleta);
          } catch (Exception e) {
              throw new Exception("Funzione Add fallita");
              // TODO: handle exception
          }
      }
      //fine operazioni amministratore

      //operazioni dell'Ufficiale di gara
      public void AccettazioneAtleta(int codFIS) throws Exception {
          for (Atleta atletaA : accettazioni) {
              if (atletaA.getCodFIS()==codFIS)
              throw new Exception("Atleta già accettato");
          }
          for (Atleta atleta : iscritti) {
              if (atleta.getCodFIS()==codFIS) {
                  accettazioni.add(atleta);
                  return;
              }
          }
          throw new Exception("nessun atleta iscritto con quel codice");
      }

      private static int gironi(int a, int d) {//funzione privata per calcolare il numero di gironi in base alla FDG e il n Atleti
          if (a % d == 0)
              return a / d;
          else {
              return (a / d) + 1;
          }
      }

      public void OrdinaAlteti(){//ordina in base al ranking decrescente l'atleta col ranking più alto è il primo
         Collections.sort(this.accettazioni, new Comparator<Atleta>() {
              @Override
              public int compare(Atleta a1, Atleta a2) {
                  return Float.compare(a2.getRanking(), a1.getRanking());
              }
          });

          for (Atleta atleta : accettazioni) {
              mappaAtleti.put(atleta.getCodFIS(), atleta);
          }
      }

      public void CreazioneGironi() throws Exception{
          this.gironi.clear();
          //oridno gli atleti e prendo i valori che mi servono dalla formula di gara
          OrdinaAlteti();
          if(this.accettazioni.size()<=1)
        	  throw new Exception("impossibile creare i gironi perchè non sono presenti almeno due atletit accettati");
          int numAtleti=this.accettazioni.size();
          int maxDimGironi=this.formulaDiGara.getMaxDimGirone();


          //creo i gironi con solamente il loro codice
          int numGironi=gironi(numAtleti, maxDimGironi);
          for(int i=1; i<=numGironi; i++){
              Girone g=new Girone(i);
              this.gironi.add(g);//si aggiunge alla fine della lista, quindi la lista sarà oridnata in modo crescente g1, g2, ..., gn
          }


          //riempio la lista Atleti_girone per ogni singolo giorne, seguendo le regole
          int x=0;
          int posNelGiorne=1;
          while(x<numAtleti){
              for (Girone girone : gironi) {
                  Atleta a = null;
                  try {
                      if(accettazioni.size()>x){
                          a = accettazioni.get(x);
                          Atleta_Girone a_g=new Atleta_Girone(a.getCodFIS());
                          a_g.setPosizione(posNelGiorne);
                          girone.getAtletiGiorne().add(a_g);
                      }
                      else{
                          //non deve fare niente, hai assegnato tutti gli atleti ai gironi
                      }
                      x++;
                  } catch (IndexOutOfBoundsException e) {
                      //è normale essere qui in giorni non perfettamente divisibili
                  }  
              }
              posNelGiorne++;
          }


          //PER ORA NON ORIDNE CORRETTO
          //riempio la lista degli assalti, in cui non saranno presenti ancora i risultati
          //per fare ciò si segue l'algoritmo di Berger
          for (Girone girone : gironi) {
              int numAtletiGirone=girone.getAtletiGiorne().size();
              int c=0;
              List<Assalto> assalti=new ArrayList<Assalto>();
              for(int z=0; z<numAtletiGirone; z++){
                  for(int i=z; i<numAtletiGirone; i++){
                      if(z!=i){
                          Assalto ass=new Assalto(c,girone.getAtletiGiorne().get(z).getCodFIS(),girone.getAtletiGiorne().get(i).getCodFIS());
                          // ass.setAtleta1(girone.getAtletiGiorne().get(z).getCodFIS());
                          // ass.setAtleta2(girone.getAtletiGiorne().get(i).getCodFIS());
                          assalti.add(ass);
                          c++;
                      }
                  }
                  
              }
              try {
                  girone.setAssalti(assalti);
              } catch (Exception e) {
                  throw new Exception("errore add");
                  // TODO: handle exception
              }
          }

             
      }

      public void InserimentoSpecifiche(int codGirone, int dataOra, int pedana) throws Exception{
          boolean b=false;
          for (Girone girone : gironi) {
              if(girone.getCodGirone()==codGirone){
                  girone.setDataOra(dataOra);
                  girone.setPedana(pedana);
                  b=true;
              }
          }
          if (!b) {
              //IL GIRONE NON ESISTE
              throw new Exception("Il girone non esiste");
          }   
      }

      public void InserimentoRisultati(int codGirone, List<Assalto> listaAssalti) throws Exception{
          Girone girone=null;
          //trovo il girone di cui voglio insserire gli assalti
          for (Girone g : gironi) {
              if(g.getCodGirone()==codGirone){
                  girone=g;
              }
          }
          if (girone==null) {
              throw new Exception("Il girone non esiste");
          }

          int nStoccateGirone=this.getFormulaDiGara().getNumeroStoccateGironi();

          //vedo se i risultati sono validi
          for (Assalto assalto : listaAssalti) {
              if(assalto.getPunteggio1()!=-2||assalto.getPunteggio2()!=-2)//ricordiamo -2 valore che ci dice che l'assalto non è disputato
                  if(0>assalto.getPunteggio1()||assalto.getPunteggio1()>nStoccateGirone||0>assalto.getPunteggio2()||assalto.getPunteggio2()>nStoccateGirone)
                      throw new Exception("punteggio non valido");
          }

          //se sono qui il girone esiste e i risultati sono validi
          girone.setAssalti(listaAssalti);//PER ORA NON STIAMO CONSIDERANDO LA POSSIBILITà CH ENON SI INSERISCANO TUTTI GLI ASSALTI DI UN GIRONE
          
          
          //bisogna settare gli atributi di atleta_girone dopo che si inseriscono i risultati
          for(Atleta_Girone a : girone.getAtletiGiorne()){
              a.setPunteggio(0);
              a.setSconfitte(0);
              a.setVittorie(0);
          }

          for (Assalto assalto : listaAssalti) {
              for(Atleta_Girone a : girone.getAtletiGiorne()){
                  if(assalto.getAtleta1()==a.getCodFIS()){
                      a.setStoccateDate(assalto.getPunteggio1()+a.getStoccateDate());
                      a.setStoccateRicevute(assalto.getPunteggio2()+a.getStoccateRicevute());
                      if(assalto.getPunteggio1()>assalto.getPunteggio2()){
                          a.setVittorie(a.getVittorie()+1);
                      }
                      else{
                          a.setSconfitte(a.getSconfitte()+1);
                      }
                  }
                  if (assalto.getAtleta2()==a.getCodFIS()) {
                      a.setStoccateDate(assalto.getPunteggio2()+a.getStoccateDate());
                      a.setStoccateRicevute(assalto.getPunteggio1()+a.getStoccateRicevute());
                      if(assalto.getPunteggio2()>assalto.getPunteggio1()){
                          a.setVittorie(a.getVittorie()+1);
                      }
                      else{
                          a.setSconfitte(a.getSconfitte()+1);
                      }
                  }
              }
          }

          //ora bisogna calcolare i punteggi degli atleti
          for(Atleta_Girone a : girone.getAtletiGiorne()){
              if(a.getVittorie()+a.getSconfitte() != 0){
                  a.setPunteggio((float)a.getVittorie()/(a.getVittorie()+a.getSconfitte()));
              }
              else{
                  a.setPunteggio(-1); // o qualsiasi altro valore di default
              }
          }
      } 

      private void ordinaGironi(List<Atleta_Girone> classificaG){
          Collections.sort(classificaG, new Comparator<Atleta_Girone>() {
              @Override
              public int compare(Atleta_Girone a1, Atleta_Girone a2) {
                  if(a1.getPunteggio() != a2.getPunteggio()) {
                      return Float.compare(a2.getPunteggio(), a1.getPunteggio()); // Ordina prima per punteggio, dal più alto al più basso
                  } else {
                      if(a1.getVittorie() != a2.getVittorie()) {
                          return Integer.compare(a2.getVittorie(), a1.getVittorie()); // Se il punteggio è lo stesso, ordina per vittorie, dal più alto al più basso
                      }
                      else{
                          if(a1.getStoccateDate()-a1.getStoccateRicevute() != a2.getStoccateDate()-a2.getStoccateRicevute()) {// Se le vittorie sono le stesse, ordina per differenza fra d e r, dalla più alta alla più bassa
                              return Integer.compare(a2.getStoccateDate()-a2.getStoccateRicevute(), a1.getStoccateDate()-a1.getStoccateRicevute());
                          }
                          else
                              return Integer.compare(a2.getStoccateDate(), a1.getStoccateDate());
                      }
                  }
              }
          });
      }

      public void CreaClassifica() throws Exception{
          classificaG.clear();
          boolean r=false;
          for (Girone g : gironi) {
              List<Atleta_Girone> Atletig = g.getAtletiGiorne();
              for (Atleta_Girone atleta_Girone : Atletig) {
                  r=true;
                  classificaG.add(atleta_Girone);
              }
          }
          if(!r){
              throw new Exception("Completare tutti i passsi precedenti");
          }
          //ordina classifica gironi
          ordinaGironi(classificaG);
      }
       
      public EliminazioneDiretta CreazioneED() throws Exception{
          eliminazioniDirette.clear();
          if(classificaG.size()==0){
              throw new Exception("Creare la classifica dopo i gironi");
          }

          int stato=0;  
          int pe=formulaDiGara.getPercEliminati();

          int num_pass=classificaG.size()-(classificaG.size()*pe/100);
          stato=(int)Math.ceil(Math.log(num_pass) / Math.log(2));//In questo modo, stato sarà il logaritmo in base 2 di num_pass arrotondato per eccesso.

      
          EliminazioneDiretta direttaCorrente= new EliminazioneDiretta(stato);
          List<Assalto> assalti= new ArrayList<Assalto>();
          int codice=0;
          int atleta1=0;
          int atleta2=0;
          int valore=0;
          
          for(int i=1; i<=(int)Math.pow(2, stato-1); i++){
              codice=i;
              atleta1=classificaG.get(i-1).getCodFIS();
              valore=(int)Math.pow(2, stato)-i;

              if((valore>=num_pass)){
                  atleta2=-1;//info che mi dice che l'atleta 1 ha automaticamente vinto
              }
              else{
                  atleta2=classificaG.get((int)Math.pow(2, stato)-i).getCodFIS();
              }
              assalti.add(new Assalto(codice, atleta1, atleta2));
          }
          direttaCorrente.setAssaltiED(assalti);
          return direttaCorrente;
      }


      public void ConfermaED()throws Exception{
          if (direttaCorrente==null) {
  			throw new Exception("Nessuna diretta corrente ");
  		}
          eliminazioniDirette.add(direttaCorrente);
      }

      public void SelezionaED(int stato)throws Exception{
          if (eliminazioniDirette.size()==0) {
              throw new Exception("Dirette non create");
          }
          for (EliminazioneDiretta eliminazioneDiretta : eliminazioniDirette) {
              if(eliminazioneDiretta.getStato()==stato){
                  direttaCorrente=eliminazioneDiretta;
                  return;
              }
          }
          throw new Exception("Dirette non esistente"); 
      }

      public void InserisciRisultatiED(List<Assalto> listaAssalti) throws Exception{
          boolean fine=true;
          direttaCorrente.setAssaltiED(listaAssalti);
          int nStoccateED=this.getFormulaDiGara().getNumeroStoccateDirette();
          if(direttaCorrente.getStato()==1)
              fine=false;

          // se gli assalti sono completi si deve settare la nuova diretta corrente
          
          // if(assalto.getPunteggio1()!=-2||assalto.getPunteggio2()!=-2)//ricordiamo -2 valore che ci dice che l'assalto non è disputato
          //         if(0>assalto.getPunteggio1()||assalto.getPunteggio1()>nStoccateGirone||0>assalto.getPunteggio2()||assalto.getPunteggio2()>nStoccateGirone)
          //             throw new Exception("punteggio non valido");
          
          for(Assalto assalto : listaAssalti){
              if(assalto.getPunteggio1()==-2||assalto.getPunteggio2()==-2){
                  //Qui i punteggi non sono stati modificati
                  if(assalto.getAtleta2()!=-1){
                      fine=false;
                  }
              }
              else{
                  if(0>assalto.getPunteggio1()||assalto.getPunteggio1()>nStoccateED||0>assalto.getPunteggio2()||assalto.getPunteggio2()>nStoccateED)
                      throw new Exception("punteggio non valido");
              }

          }

          if(fine){//se finiamo tutti gli assalti di una fase es.64 quella corrente diventa in automatico quella dei 32

              List<Atleta> eliminati = new ArrayList<Atleta>();
              List<Assalto> assalti  = new ArrayList<Assalto>();
              int vincitore1=0;
              int vincitore2=0;
              
              for(int i = 0; i < listaAssalti.size(); i += 2){
                  if(listaAssalti.get(i).getPunteggio1()>listaAssalti.get(i).getPunteggio2()||listaAssalti.get(i).getAtleta2()==-1){//atleta uguale a -1 vuol dire che in realtà era un assalto fittizio vinto automaticamente da a1
                      vincitore1=listaAssalti.get(i).getAtleta1();
                      if (listaAssalti.get(i).getAtleta2()!=-1) {
                          eliminati.add(mappaAtleti.get(listaAssalti.get(i).getAtleta2()));
                          //new_ED.getEliminati().add(mappaAtleti.get(listaAssalti.get(i).getAtleta2()));
                      }
                  }
                  else{
                      vincitore1=listaAssalti.get(i).getAtleta2();
                      eliminati.add(mappaAtleti.get(listaAssalti.get(i).getAtleta1()));
                      //new_ED.getEliminati().add(mappaAtleti.get(listaAssalti.get(i).getAtleta1()));
                  }

                  if(listaAssalti.get(i+1).getPunteggio1()>listaAssalti.get(i+1).getPunteggio2()||listaAssalti.get(i+1).getAtleta2()==-1){
                      vincitore2=listaAssalti.get(i+1).getAtleta1();
                      if (listaAssalti.get(i).getAtleta2()!=-1) {
                          eliminati.add(mappaAtleti.get(listaAssalti.get(i+1).getAtleta2()));
                          //new_ED.getEliminati().add(mappaAtleti.get(listaAssalti.get(i+1).getAtleta2()));
                      }
                  }
                  else{
                      vincitore2=listaAssalti.get(i+1).getAtleta2();
                      eliminati.add(mappaAtleti.get(listaAssalti.get(i+1).getAtleta1()));
                      //new_ED.getEliminati().add(mappaAtleti.get(listaAssalti.get(i+1).getAtleta1()));
                  }
                  assalti.add(new Assalto(i/2, vincitore1, vincitore2));
                  //new_ED.getAssaltiED().add(a); 
              }

              EliminazioneDiretta new_ED=new EliminazioneDiretta(direttaCorrente.getStato()-1, assalti, eliminati);
              direttaCorrente=new_ED;
              eliminazioniDirette.add(new_ED);
          }

          //Per ora non verificato cosa succede se si arriva in finale
      }

      public void CreaClassificaFinale()throws Exception{
          classificaFinale.clear();
          boolean fine=false;
          Atleta atleta=null;

          // aggiungiamo vincitore della gara in cima
          // la gara deve essere finita, da verificare(PER ORA forse aggiungere atrributo fine_gara)
          for (EliminazioneDiretta ed : eliminazioniDirette){
              if(ed.getStato()==1){
                  if(ed.getAssaltiED().get(0).getPunteggio1()!=-2&&ed.getAssaltiED().get(0).getPunteggio2()!=-2){
                      if(ed.getAssaltiED().get(0).getPunteggio1()>ed.getAssaltiED().get(0).getPunteggio2()){
                          atleta=mappaAtleti.get(ed.getAssaltiED().get(0).getAtleta1());
                          classificaFinale.add(atleta);
                          atleta=mappaAtleti.get(ed.getAssaltiED().get(0).getAtleta2());
                          classificaFinale.add(atleta);
                      }
                      else{
                          atleta=mappaAtleti.get(ed.getAssaltiED().get(0).getAtleta2());
                          classificaFinale.add(atleta);
                          atleta=mappaAtleti.get(ed.getAssaltiED().get(0).getAtleta1());
                          classificaFinale.add(atleta);
                      }
                      fine=true;
                  }
              }
          }
          if(!fine){
              throw new Exception("La competzione non è ancora finita"); 
          }
          
          //_____
          
          int stato=0;  

          int pe=formulaDiGara.getPercEliminati();
          int num_pass=classificaG.size()-(classificaG.size()*pe/100);
          int num_elimi=classificaG.size()*formulaDiGara.getPercEliminati()/100;
          //int num_pass=classificaG.size()-num_elimi;

          stato=(int)Math.ceil(Math.log(num_pass) / Math.log(2));//In questo modo, stato sarà il logaritmo in base 2 di num_pass arrotondato per eccesso.

          for (int i = eliminazioniDirette.size() - 1; i >= 0; i--) {
              EliminazioneDiretta ed = eliminazioniDirette.get(i);
              if(ed.getStato() != stato) {
                  classificaFinale.addAll(ed.getEliminati());
              }
          }
          
          for(int i=num_pass; i<num_elimi+num_pass; i++){
              atleta = mappaAtleti.get(classificaG.get(i).getCodFIS());
              if(atleta != null){
                  classificaFinale.add(atleta);
              }
          }
      }

      public List<Atleta> CreaRanking() throws Exception{
          if(rankingCreato){
              throw new Exception("Ranking gia' creato");
          }
          try {
              CreaClassificaFinale();
          } catch (Exception e) {
              throw new Exception("Errore in crea classifica"); 
              // TODO: handle exception
          }
          
          Tabella_ranking tr=new Tabella_ranking();
          tr.CaricaTabellaRanking();
          float punteggio=0;
          Atleta a;
          for(int i=0; i<classificaFinale.size(); i++){
              punteggio=tr.OttieniPunteggio(i);
              a=classificaFinale.get(i);
              a.setRanking(a.getRanking()+punteggio);// considerando che è un riferimento all'oggetto lo sto modificando ovunque anche su tesserati
          }
          rankingCreato=true;
          return classificaFinale;
      }

      @Override
      public String toString() {
          return "Competizione [codCompetizione=" + codCompetizione + ", nome=" + nome + ", descrizione=" + descrizione
                  + ", data=" + data + ", categoria=" + categoria + ", arma=" + arma + ", formulaDiGara=" + formulaDiGara
                  + ", gironi=" + gironi + ", iscritti=" + iscritti + ", accettazioni=" + accettazioni + ", tr=" + tr
                  + "]";
      }


  }