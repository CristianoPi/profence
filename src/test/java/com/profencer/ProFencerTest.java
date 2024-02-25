package com.profencer;
import static org.junit.Assert.fail;
import org.junit.Test;

public class ProFencerTest {
    ProFencer proFencer=new ProFencer();
   
    @Test
    public void UC1(){
        proFencer.caricaDati();
        try {
            proFencer.InserimentoCodiceCompetizione(10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }
        try {
            proFencer.InserimentoDatiCompetizione("gara1", "descrizione1", null, "U14", "Spada", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }
        try {
            proFencer.ScegliFormulaGara(0, 15, 5, 7);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }

        try {
            proFencer.ConfermaInserimento();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
            // TODO: handle exception
        }
        //System.out.println(proFencer.getCompetizioneCorrente().toString());
        System.out.println(proFencer.getCompetizioni());
    }
    //Il test funziona correttamente. Viene sollevata un'eccezione se si prova ad inserire una competizione 
    //con codice già presente nel sistema e se si inseriscono dati della formula di gara non possibili

    @Test
    public void UC2(){
        proFencer.caricaDati();
        try {
            proFencer.CreaTesseramento(1,"mario", "rossi", null, "aaaaaaa", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }
        try {
            proFencer.ConfermaTesseramento();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }
        System.out.println(proFencer.getAtletaCorrente().toString());
        System.out.println(proFencer.getTesserati());
    }
    //Il test funziona correttamente. Viene sollevata un'eccezione se si prova a tesserare un atleta già tesserato

    @Test
    public void testIscrizione() {
        proFencer.caricaDati();
        try {
            //dobbiamo tesserare un atleta e creare una competizone
            proFencer.CreaTesseramento(1,"mario", "rossi", null, "aaaaaaa", true);
            proFencer.ConfermaTesseramento();
            proFencer.Iscrizione(1, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }
    }
    //Il test funziona correttamente. Viene sollevata un'eccezione se si prova a iscrivere un atleta non tesserato
    // se si iscrive un atleta già iscritto o se si prova a iscrivere a un c non esistente

    @Test
    public void UC4(){
        proFencer.caricaDati();
        try {
            proFencer.SelezionaCompetizione(1);
            System.out.println(proFencer.VisualizzaFormulaGara());
            proFencer.ModificaFormulaGara(0, 9, 111, 5);
            System.out.println(proFencer.VisualizzaFormulaGara());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }
    }
    //Il test funziona correttamente. Viene sollevata un'eccezione se si inseriscono dati della formula di gara non possibili

    @Test
    public void UC5(){
        proFencer.caricaDati();
        try {
            proFencer.CreaTesseramento(1,"mario", "rossi", null, "aaaaaaa", true);
            proFencer.ConfermaTesseramento();
            proFencer.Iscrizione(1, 1);
            proFencer.SelezionaCompetizione(1);
            System.out.println( proFencer.VisualizzaAtleti());
            proFencer.AccettazioneAtleta(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }
    }
    //Il test funziona correttamente. Viene sollevata un'eccezione se si prova ad accettare un atleta già accettato o un alteta non iscritto

    //_________________UC6________________
    @Test
    public void testCreazioneGironi() {
        proFencer.caricaDati();
        try {
            proFencer.SelezionaCompetizione(1);
            proFencer.CreazioneGironi();
            System.out.println(proFencer.VisualizzaGironi());
    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
    }
    //Il test funziona correttamente. Viene sollevata un'eccezione se ci sono meno di due atleti accettati
    

    @Test
    public void testInserimentoSpecifiche() {
        proFencer.caricaDati();
        try {
            proFencer.CreazioneGironi();
            proFencer.InserimentoSpecifiche(1, 10, 10);
            System.out.println(proFencer.VisualizzaGironi());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //Il test funziona correttamente. Viene sollevata un'eccezione se il girone non esiste
    //__________________________________________________________________________________

    //____________________UC7____________________________________
    @Test
    public void testInserimentoRisultati() {
        proFencer.caricaDati();
        try {
            proFencer.SelezionaCompetizione(1);
            proFencer.CreazioneGironi();
            proFencer.InserimentoRisultati(1, proFencer.CaricaListaAssalti());
            System.out.println(proFencer.VisualizzaGironi());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //Il test funzione correttamente. Viene sollevata un'eccezione se si cercano di inserire risultati non coerenti rispettto la FDG
    //_________________________________________________________________________________
    //____________________UC7_1________________________________________________________
    @Test
    public void CreaClassifica(){
        proFencer.caricaDati();
        try {
            proFencer.SelezionaCompetizione(1);
            proFencer.CreazioneGironi();
            proFencer.InserimentoRisultati(1, proFencer.CaricaListaAssalti());
            proFencer.CreaClassifica();
            System.out.println(proFencer.VisualizzaClassifica());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //Il test funzione correttamente. Viene sollevata un'eccezione se ancora non esistono gironi
    //_________________________________________________________________________________
    //____________________UC8________________________________________________________
    @Test
    public void testCreazioneED() {
        proFencer.caricaDati();
        try {
            proFencer.SelezionaCompetizione(1);
            proFencer.CreazioneGironi();
            proFencer.InserimentoRisultati(1, proFencer.CaricaListaAssalti());
            proFencer.CreaClassifica();
            System.out.println(proFencer.CreazioneED());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     //Il test funzione correttamente. Viene sollevata un'eccezione se ancora non è stata creata la classifica dopo i gironi
  
    @Test
    public void testConfermaED() {
        proFencer.caricaDati();
        try {
            proFencer.SelezionaCompetizione(1);
            proFencer.CreazioneGironi();
            proFencer.InserimentoRisultati(1, proFencer.CaricaListaAssalti());
            proFencer.CreaClassifica();
            proFencer.CreazioneED();
            System.out.println(proFencer.getCompetizioneCorrente().getDirettaCorrente());
            proFencer.ConfermaED();
            System.out.println(proFencer.getCompetizioneCorrente().getEliminazioniDirette());
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
    }
    //Il test funzione correttamente. Viene sollevata un'eccezione se non esiste una diretta corrente
    //_________________________________________________________________________________
    //____________________UC9________________________________________________________
    @Test
    public void testSelezionaED(){
        proFencer.caricaDati();
        try {
            proFencer.SelezionaCompetizione(1);
            proFencer.CreazioneGironi();
            proFencer.InserimentoRisultati(1, proFencer.CaricaListaAssalti());
            proFencer.CreaClassifica();
            proFencer.CreazioneED();
            proFencer.getCompetizioneCorrente();
            proFencer.ConfermaED();
            proFencer.SelezionaED(3);
            System.out.println(proFencer.getCompetizioneCorrente().getDirettaCorrente());
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
    }
    //Il test funzione correttamente. Viene sollevata un'eccezione se si seleziona un'ED non esistente

    @Test
    public void testInserisciRisultatiED() {
        proFencer.caricaDati();
        try {
            proFencer.SelezionaCompetizione(1);
            proFencer.CreazioneGironi();
            proFencer.InserimentoRisultati(1, proFencer.CaricaListaAssalti());
            proFencer.CreaClassifica();
            proFencer.CreazioneED();
            proFencer.getCompetizioneCorrente();
            proFencer.ConfermaED();
            proFencer.SelezionaED(3);
            proFencer.InserisciRisultatiED(proFencer.CaricaListaAssaltiED());
            System.out.println(proFencer.VisualizzaED());
            System.out.println(proFencer.getCompetizioneCorrente().getEliminazioniDirette());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //Il test funzione correttamente. Viene sollevata un'eccezione se si inseriscono punteggio non coerenti con la FDG

    //_________________________________________________________________________________
    //____________________UC10________________________________________________________
    @Test
    public void testCreaClassificaFinale() {
        proFencer.caricaDati();
        try {
            proFencer.SelezionaCompetizione(1);
            proFencer.CreazioneGironi();
            proFencer.InserimentoRisultati(1, proFencer.CaricaListaAssalti());
            proFencer.CreaClassifica();
            //System.out.println(proFencer.getCompetizioneCorrente().getClassificaG());
            proFencer.CreazioneED();
            proFencer.getCompetizioneCorrente();
            proFencer.ConfermaED();
            proFencer.SelezionaED(3);
            proFencer.InserisciRisultatiED(proFencer.CaricaListaAssaltiED());
            proFencer.SelezionaED(2);
            proFencer.InserisciRisultatiED(proFencer.CaricaListaAssaltiED3());
            proFencer.SelezionaED(1);
            proFencer.InserisciRisultatiED(proFencer.CaricaListaAssaltiED4());
            //System.out.println(proFencer.getCompetizioneCorrente());
            proFencer.CreaClassificaFinale();
            System.out.println(proFencer.getCompetizioneCorrente().getClassificaFinale());
            System.out.println((proFencer.getCompetizioneCorrente().getClassificaFinale().size()));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //Il test funzione correttamente. Viene sollevata un'eccezione se la gara non è stata completata
    //_________________________________________________________________________________
    //____________________UC11________________________________________________________
    @Test
    public void testCreaRanking() {
        proFencer.caricaDati();
        try {
            proFencer.SelezionaCompetizione(10);
            proFencer.CreazioneGironi();
            proFencer.InserimentoRisultati(1, proFencer.CaricaListaAssalti());
            proFencer.CreaClassifica();
            //System.out.println(proFencer.getCompetizioneCorrente().getClassificaG());
            proFencer.CreazioneED();
            proFencer.getCompetizioneCorrente();
            proFencer.ConfermaED();
            proFencer.SelezionaED(3);
            proFencer.InserisciRisultatiED(proFencer.CaricaListaAssaltiED());
            proFencer.SelezionaED(2);
            proFencer.InserisciRisultatiED(proFencer.CaricaListaAssaltiED3());
            proFencer.SelezionaED(1);
            proFencer.InserisciRisultatiED(proFencer.CaricaListaAssaltiED4());
            //System.out.println(proFencer.getCompetizioneCorrente());
           proFencer.CreaRanking();
           System.out.println(proFencer.getTesserati());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //Il test funzione correttamente. Viene sollevata un'eccezione se la gara non è stata completata

}
