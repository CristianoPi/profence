package com.profencer;

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
	private FormulaDiGara formulaDiGara;
	private List<Girone> gironi;
    private List<Atleta> iscritti;
    private List<Atleta> accettazioni;
    Map<Integer, Atleta> mappaAtleti = new HashMap<>(); //mi è utile per non scorre ogni volta atleti
    private List<Atleta_Girone> classificaG;
    private EliminazioneDiretta direttaCorrente;
    private List<EliminazioneDiretta> eliminazioniDirette;
    private List<Atleta> classificaFinale; //PER ORA IMPLEMENTATA COME LISTA
    private List<Tabellla_ranking> tr;//PER ORA IMPLEMENTATA COME LISTA

    //getters and setters
    public int getCodCompetizione() {
        return codCompetizione;
    }

    public void setClassificaG(List<Atleta_Girone> classificaG) {
        this.classificaG = classificaG;
    }

    public EliminazioneDiretta getDirettaCorrente() {
        return direttaCorrente;
    }

    public void setDirettaCorrente(EliminazioneDiretta direttaCorrente) {
        this.direttaCorrente = direttaCorrente;
    }

    public List<EliminazioneDiretta> getEliminazioniDirette() {
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
    }
    
    public Competizione() {
        this.codCompetizione = 0;

        this.gironi = new ArrayList<Girone>();
        this.iscritti = new ArrayList<Atleta>();
        this.accettazioni = new ArrayList<Atleta>();
        this.classificaG = new ArrayList<Atleta_Girone>();;
        this.eliminazioniDirette = new ArrayList<EliminazioneDiretta>();;
        this.classificaFinale = new ArrayList<Atleta>();
    }


    public Competizione(int codCompetizione, String nome, String descrizione, Date data, String categoria, String arma,
            FormulaDiGara formulaDiGara) {
        this.codCompetizione = codCompetizione;
        this.nome = nome;
        this.descrizione = descrizione;
        this.data = data;
        this.categoria = categoria;
        this.arma = arma;
        this.formulaDiGara = formulaDiGara;

        this.gironi = new ArrayList<Girone>();
        this.iscritti = new ArrayList<Atleta>();
        this.accettazioni = new ArrayList<Atleta>();
        this.classificaG = new ArrayList<Atleta_Girone>();;
        this.eliminazioniDirette = new ArrayList<EliminazioneDiretta>();;
        this.classificaFinale = new ArrayList<Atleta>();
    }

   
    



    //operazioni
    public void Iscrizione(Atleta atleta) throws Exception{
        try {
            iscritti.add(atleta);
        } catch (Exception e) {
            throw new Exception("Funzione Add fallita");
            // TODO: handle exception
        }
    }

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
        throw new Exception("nessun atleta con quel codice");

        //gestire errori
    }

    private static int gironi(int a, int d) {
        if (a % d == 0)
            return a / d;
        else {
            return (a / d) + 1;
        }
    }

    public void OrdinaAlteti(){
       Collections.sort(this.accettazioni, new Comparator<Atleta>() {
            @Override
            public int compare(Atleta a1, Atleta a2) {
                return Float.compare(a1.getRanking(), a2.getRanking());
            }
        });

        for (Atleta atleta : accettazioni) {
            mappaAtleti.put(atleta.getCodFIS(), atleta);
        }
    }

    public void CreazioneGironi() throws Exception{
        this.gironi=new ArrayList<Girone>();
        //oridno gli atleti e prendo i valori che mi servono dalla formula di gara
        OrdinaAlteti();


        int numAtleti=this.accettazioni.size();
        int maxDimGironi=this.formulaDiGara.getMaxDimGirone();


        //creo i gironi con solamente il loro codice
        int numGironi=gironi(numAtleti, maxDimGironi);
        for(int i=1; i<=numGironi; i++){
            Girone g=new Girone(i);
            gironi.add(g);//si aggiunge alla fine della lista, quindi la lista sarà oridnata in modo crescente g1, g2, ..., gn
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
            // int numAtletiGirone=girone.getAtletiGiorne().size();
            // int turni=numAtletiGirone-1;
            // Assalto ass=new Assalto(0);
            // int j=0;
            // int c=1;
            // for(int i=1; i<turni; i++){
            //     j=i+1;
            //     while (j<=numAtletiGirone) {
            //         ass.setCodAssalto(c);
            //         ass.setAtleta1(girone.getAtletiGiorne().get(i).getCodFIS());
            //         ass.setAtleta2(girone.getAtletiGiorne().get(j).getCodFIS());
            //         girone.getAssalti().add(ass);
            //         c++;
            //         j++;
            //     }
            int numAtletiGirone=girone.getAtletiGiorne().size();
            int c=0;
            List<Assalto> assalti=new ArrayList<Assalto>();
            for(int z=0; z<numAtletiGirone; z++){
                for(int i=c; i<numAtletiGirone; i++){
                    if(z!=i){
                        System.out.println(z);
                        System.out.println(i);
                        System.out.println("________");
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

    public void InserimentoRisultati(int codGirone, List<Assalto> listaAssalti){
        Girone girone=null;
        //trovo il girone di cui voglio insserire gli assalti
        for (Girone g : gironi) {
            if(g.getCodGirone()==codGirone){
                girone=g;
                
            }
        }
        if (girone==null) {
            //IL GIRONE NON ESISTE, non devo fare nulla
			System.out.println("IL GIRONE NON ESISTE");
            return;
        }
        //se sono qui il girone esiste
        girone.setAssalti(listaAssalti);//PER ORA NON STIAMO CONSIDERANDO LA POSSIBILITà CH ENON SI INSERISCANO TUTTI GLI ASSALTI DI UN GIRONE

        //bisogna settare gli atributi di atleta_girone dopo che si inseriscono i risultati
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
                    break;
                }
            }
        }
        //ora bisogna calcolare i punteggi degli atleti
        for(Atleta_Girone a : girone.getAtletiGiorne()){
            if(a.getVittorie()+a.getSconfitte() != 0){
                a.setPunteggio(a.getVittorie()/(a.getVittorie()+a.getSconfitte()));
            }
            else{
                a.setPunteggio(0); // o qualsiasi altro valore di default
            }
        }
    } 

    private void ordinaGironi(List<Atleta_Girone> classificaG){
        Collections.sort(classificaG, new Comparator<Atleta_Girone>() {
            @Override
            public int compare(Atleta_Girone a1, Atleta_Girone a2) {
                if(a1.getPunteggio() != a2.getPunteggio()) {
                    return Integer.compare(a2.getPunteggio(), a1.getPunteggio()); // Ordina prima per punteggio, dal più alto al più basso
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

    public void CreaClassifica(){
        for (Girone g : gironi) {
            List<Atleta_Girone> Atletig = g.getAtletiGiorne();
            for (Atleta_Girone atleta_Girone : Atletig) {
                classificaG.add(atleta_Girone);
            }
        }
        //ordina gironi
        ordinaGironi(classificaG);
    }
     




    @Override
    public String toString() {
        return "Competizione [codCompetizione=" + codCompetizione + ", nome=" + nome + ", descrizione=" + descrizione
                + ", data=" + data + ", categoria=" + categoria + ", arma=" + arma + ", formulaDiGara=" + formulaDiGara
                + ", gironi=" + gironi + ", iscritti=" + iscritti + ", accettazioni=" + accettazioni + ", tr=" + tr
                + "]";
    }

    public EliminazioneDiretta CreazioneED(){
        int stato=0;
        
        int pe=formulaDiGara.getPercEliminati();
        int num_pass=classificaG.size()-(classificaG.size()*pe/100);
        stato=(int)Math.ceil(Math.log(num_pass) / Math.log(2));//In questo modo, stato sarà il logaritmo in base 2 di num_pass arrotondato per eccesso.
    
        EliminazioneDiretta direttaCorrente= new EliminazioneDiretta(stato, null);
        Assalto a=new Assalto(0);

        for(int i=1; i<=(int)Math.pow(2, stato-1); i++){
            a.setCodAssalto(i);
            a.setAtleta1(classificaG.get(i-1).getCodFIS());
            if(((int)Math.pow(2, stato)-i)>num_pass){
                a.setAtleta2(-1);//info che mi dice che l'atleta 1 ha automaticamente vinto
            }
            else{
                a.setAtleta2(classificaG.get((int)Math.pow(2, stato)-i).getCodFIS());
            }
            direttaCorrente.getAssaltiED().add(a);
        }

        return direttaCorrente;
    }

    public void ConfermaED(){
        eliminazioniDirette.add(direttaCorrente);
    }

    public void SelezionaED(int stato){
        direttaCorrente= eliminazioniDirette.get(stato);
    }

    public void InserisciRisultatiED(List<Assalto> listaAssalti){
        direttaCorrente.setAssaltiED(listaAssalti);
        // se gli assalti sono completi si deve settare la nuova diretta corrente
        boolean fine=true;
        for(Assalto a : listaAssalti){
           if(a.getPunteggio1()==-2||a.getPunteggio2()==-2){//ricordiamo che -2 èun valore deciso da noi per indicare assalto non ancora disputato 
            fine=false;    
           } 
        }
       
        if(fine){//se finiamo tutti gli assalti di una fase es.64 quella corrente diventa in automatico quella dei 32
            EliminazioneDiretta new_ED=new EliminazioneDiretta(direttaCorrente.getStato()-1);
            int vincitore1=0;
            int vincitore2=0;
            for(int i = 0; i < listaAssalti.size(); i += 2){
                if(listaAssalti.get(i).getPunteggio1()>listaAssalti.get(i).getPunteggio2()||listaAssalti.get(i).getAtleta2()==-1){//atleta uguale a -1 vuol dire che in realtà era un assalto fittizio vinto automaticamente da a1
                    vincitore1=listaAssalti.get(i).getAtleta1();
                    if (listaAssalti.get(i).getAtleta2()!=-1) {
                        new_ED.getEliminati().add(mappaAtleti.get(listaAssalti.get(i).getAtleta2()));
                    }
                }
                else{
                    vincitore1=listaAssalti.get(i).getAtleta2();
                    new_ED.getEliminati().add(mappaAtleti.get(listaAssalti.get(i).getAtleta1()));
                }

                if(listaAssalti.get(i+1).getPunteggio1()>listaAssalti.get(i+1).getPunteggio2()||listaAssalti.get(i+1).getAtleta2()==-1){
                    vincitore2=listaAssalti.get(i+1).getAtleta1();
                    if (listaAssalti.get(i).getAtleta2()!=-1) {
                        new_ED.getEliminati().add(mappaAtleti.get(listaAssalti.get(i+1).getAtleta2()));
                    }
                }
                else{
                    vincitore2=listaAssalti.get(i+1).getAtleta2();
                    new_ED.getEliminati().add(mappaAtleti.get(listaAssalti.get(i+1).getAtleta1()));
                }
                Assalto a=new Assalto(i/2, vincitore1, vincitore2);
                new_ED.getAssaltiED().add(a); 
            }
            direttaCorrente=new_ED;
        }
    }

    public void CreaClassificaFinale(){
        classificaFinale= new ArrayList<>();
        Atleta atleta;
        //aggiungiamo vincitore della gara in cima
        //la gara deve essere finita, da verificare(PER ORA forse aggiungere atrributo fine_gara)
        Assalto finale=eliminazioniDirette.get(eliminazioniDirette.size()-1).getAssaltiED().get(0);
        if(finale.getPunteggio1()>finale.getPunteggio2()){
            atleta = mappaAtleti.get(finale.getAtleta1());
        }
        else{
            atleta = mappaAtleti.get(finale.getAtleta2());
        }
        for (EliminazioneDiretta ed : eliminazioniDirette) {//PER ORA NON FATTO ma da verificare in che senso scorre
            classificaFinale.addAll(ed.getEliminati());
        }
        int num_elimi=classificaG.size()*formulaDiGara.getPercEliminati()/100;
        int num_pass=classificaG.size()-num_elimi;
        for(int i=num_pass; i<num_elimi+num_pass; i++){
            atleta = mappaAtleti.get(classificaG.get(i).getCodFIS());
            if(atleta != null){
                classificaFinale.add(atleta);
            }
        }
    }

    public void CreaRanking(){
        CreaClassificaFinale();
        Tabellla_ranking tr=new Tabellla_ranking();
        tr.CaricaTabellaRanking();
        float punteggio=0;
        Atleta a;
        for(int i=0; i<classificaFinale.size(); i++){
            punteggio=tr.OttieniPunteggio(i);
            a=classificaFinale.get(i);
            a.setRanking(a.getRanking()+punteggio);// considerando che è un riferimento all'oggetto lo sto modificando ovunque anche su tesserati
        }
    }

}

