package com.profencer;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


public class Competizione {
	private int codCompetizione;
	private String nome;
	private String descrizione;
	private Date data;
	private String categoria;
	private String arma;
	private float quotaParticipazione;
	private FormulaDiGara formulaDiGara;
	private List<Girone> gironi;
    //private Map<Integer, Set<Integer>> iscritti = new HashMap<>();
    private List<Atleta> iscritti;
    //private Map<Integer, Set<Integer>> accettazioni = new HashMap<>();
    private List<Atleta> accettazioni;
  
    //gettere and setter

    public int getCodCompetizione() {
        return codCompetizione;
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

    //costruttori
    public Competizione(int codCompetizione) {
        this.codCompetizione = codCompetizione;
    }

    public Competizione(int codCompetizione, String nome, String descrizione, Date data, String categoria, String arma,
            float quotaParticipazione, com.profencer.FormulaDiGara formulaDiGara, List<Girone> gironi,
            List<Atleta> iscritti, List<Atleta> accettazioni) {
        this.codCompetizione = codCompetizione;
        this.nome = nome;
        this.descrizione = descrizione;
        this.data = data;
        this.categoria = categoria;
        this.arma = arma;
        this.quotaParticipazione = quotaParticipazione;
        this.formulaDiGara = formulaDiGara;
        this.gironi = gironi;
        this.iscritti = iscritti;
        this.accettazioni = accettazioni;
    }
    
    public Competizione() {
        
    }

    //operazioni
    public void Iscrizione(Atleta atleta){
        iscritti.add(atleta);
    }

    public void AccettazioneAtleta(int codFIS)
    {
        for (Atleta atleta : iscritti) {
            if (atleta.getCodFIS()==codFIS) {
                accettazioni.add(atleta);
            }
        }
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
       Collections.sort(accettazioni, new Comparator<Atleta>() {
            @Override
            public int compare(Atleta a1, Atleta a2) {
                return Integer.compare(a1.getPosRanking(), a2.getPosRanking());
            }
        });
    }

    public void CreazioneGironi(){
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
        while(x<numAtleti){
            int posNelGiorne=1;
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
            int turni=numAtletiGirone-1;
            Assalto ass=new Assalto(0);
            int j=0;
            int c=1;
            for(int i=1; i<turni; i++){
            j=i+1;
                while (j<=numAtletiGirone) {
                    ass.setCodAssalto(c);
                    ass.setAtleta1(girone.getAtletiGiorne().get(i).getCodFIS());
                    ass.setAtleta1(girone.getAtletiGiorne().get(j).getCodFIS());
                    girone.getAssalti().add(ass);
                    c++;
                    j++;
                }
            }
        }
    }

    public void InserimentoSpecifiche(int codGirone, int dataOra, int pedana){
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
			System.out.println("IL GIRONE NON ESISTE");
        }   
    }

    public void InserimentoRisultati(int codGirone, List<Assalto> listaAssalti){
        boolean b=false;
        for (Girone girone : gironi) {
            if(girone.getCodGirone()==codGirone){
                girone.setAssalti(listaAssalti);
                b=true;
            }
        }
        if (!b) {
            //IL GIRONE NON ESISTE
			System.out.println("IL GIRONE NON ESISTE");
        }
    } 
}

