package com.profencer;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Comparator;

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
        //_____________________________DA COMPLETARE_______________________________
        //riempio la lista degli assalti, in cui non saranno presenti ancora i risultati
        //per fare ciò si segue l'algoritmo di Berger

        //https://lavorielavoretti.blogspot.com/2012/06/calcolo-delle-competizioni-senza_11.html

        /*
         * import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> partite = calcoloPartite(4);
        for (List<Integer> partita : partite) {
            System.out.println(partita.get(0) + " - " + partita.get(1));
        }
    }

    public static List<List<Integer>> calcoloPartite(int n) {
        Map<String, Boolean> partite = new HashMap<>();
        List<Integer> sequenza = new ArrayList<>();
        List<Boolean> utile = new ArrayList<>();
        List<List<Integer>> giocate = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            sequenza.add(i);
            utile.add(true);
            for (int j = i + 1; j <= n; j++)
                partite.put(i + "-" + j, true);
        }

        if (n % 2 != 0) {
            sequenza.add(1);
            utile.add(true);
            utile.set(0, false);
            n++;
        }

        for (int i = 0; i < n; i++) {
            int s1 = sequenza.get(i);
            int s2 = sequenza.get(++i);
            if (s1 > s2) {
                int temp = s1;
                s1 = s2;
                s2 = temp;
            }
            partite.remove(s1 + "-" + s2);
            giocate.add(Arrays.asList(s1, s2));
        }

        boolean unaCancellata = true;
        boolean scambiati = false;
        int j = 0;
        int i = 0;
        while (!partite.isEmpty()) {
            if (unaCancellata)
                unaCancellata = false;
            else
                i++;

            n = sequenza.size();
            while (i < n && !utile.get(i))
                i++;
            int s1 = sequenza.get(i);
            j = i + 1;
            while (j < n && !unaCancellata) {
                int s2 = sequenza.get(j);
                if (s1 > s2) {
                    int temp = s1;
                    s1 = s2;
                    s2 = temp;
                    scambiati = true;
                }
                if (utile.get(j) && partite.containsKey(s1 + "-" + s2)) {
                    partite.remove(s1 + "-" + s2);
                    giocate.add(Arrays.asList(s1, s2));
                    sequenza.add(sequenza.get(i));
                    sequenza.add(sequenza.get(j));
                    utile.add(true);
                    utile.add(true);
                    utile.set(i, false);
                    utile.set(j, false);
                    unaCancellata = true;
                }
                if (scambiati) {
                    s1 = s2;
                    scambiati = false;
                }
                j++;
            }
        }

        // patch(giocate); // Patch al risultato

        return giocate;
    }
}

         */

        for (Girone girone : gironi) {
            int numAtletiGirone=girone.getAtletiGiorne().size();
            Atleta_Girone atletaFinto=new Atleta_Girone(0)
            if(numAtletiGirone%2!=0){
                girone.getAtletiGiorne().add(atletaFinto);
                numAtletiGirone++;
            }

            int turni=numAtletiGirone-1;

            for(int i=0; i<turni; i++){
                for(int j=0; j<numAtletiGirone/2; j++){
                    //il primo incontro è 
                    girone.getAtletiGiorne().get(j);
                    //vs
                    girone.getAtletiGiorne().get(turni-j);
                }
            }
        }


    }
}
