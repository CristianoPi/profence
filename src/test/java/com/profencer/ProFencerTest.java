package com.profencer;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

public class ProFencerTest {
    ProFencer proFencer=new ProFencer();

   
   
    @Test
    public void UC1(){
        proFencer.caricaDati();
        try {
            proFencer.InserimentoCodiceCompetizione(10);
        } catch (Exception e) {
            fail();
            // TODO: handle exception
        }
        try {
            proFencer.InserimentoDatiCompetizione("gara1", "descrizione1", null, "U14", "Spada");
        } catch (Exception e) {
            fail();
            // TODO: handle exception
        }
        try {
            proFencer.ScegliFormulaGara(1, 20, 15, 5, 7);
        } catch (Exception e) {
            fail();
            // TODO: handle exception
        }

        try {
            proFencer.ConfermaInserimento();
        } catch (Exception e) {
            fail();
            // TODO: handle exception
        }
        System.out.println(proFencer.getCompetizioneCorrente().toString());
        System.out.println(proFencer.getCompetizioni());
    }

    @Test
    public void UC2(){
        proFencer.caricaDati();
        try {
            proFencer.CreaTesseramento(1,"mario", "rossi", null, "aaaaaaa", true);
        } catch (Exception e) {
            fail();
            // TODO: handle exception
        }
        try {
            proFencer.ConfermaTesseramento();
        } catch (Exception e) {
            fail();
            // TODO: handle exception
        }
        System.out.println(proFencer.getAtletaCorrente().toString());
        System.out.println(proFencer.getTesserati());
    }

    @Test
    public void testIscrizione() {
        proFencer.caricaDati();
        try {
            //dobbiamo tesserare un atleta e creare una competizone
            proFencer.Iscrizione(12345, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
            // TODO: handle exception
        }
    }

    @Test
    public void UC4(){
        proFencer.caricaDati();
        try {
            proFencer.SelezionaCompetizione(1);
            System.out.println(proFencer.VisualizzazioneFormulaGara());
            proFencer.ModificaFormulaGara(0, 70, 111, 111, 5);
            System.out.println(proFencer.VisualizzazioneFormulaGara());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
    }

    @Test
    public void UC5(){
        proFencer.caricaDati();
        try {
            proFencer.SelezionaCompetizione(1);
            System.out.println( proFencer.VisualizzazioneAtleti());
            proFencer.AccettazioneAtleta(12345);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
            // TODO: handle exception
        }
    }

    @Test
    public void testCreazioneGironi() {
        proFencer.caricaDati();
        try {
            proFencer.SelezionaCompetizione(1);
            proFencer.CreazioneGironi();
            System.out.println(proFencer.VisualizzaGironi());
    
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
            // TODO: handle exception
        }
       
    }

    @Test
    public void testInserimentoSpecifiche() {
        proFencer.caricaDati();
        try {
            proFencer.CreazioneGironi();
            proFencer.InserimentoSpecifiche(1, 0, 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
            // TODO: handle exception
        }
    }


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
            fail();
            // TODO: handle exception
        }
    }

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
            fail();
            // TODO: handle exception
        }
    }

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
            fail();
            // TODO: handle exception
        }
    }


    @Test
    public void testConfermaED() {
        proFencer.caricaDati();
        try {
            proFencer.SelezionaCompetizione(1);
            proFencer.CreazioneGironi();
            proFencer.InserimentoRisultati(1, proFencer.CaricaListaAssalti());
            proFencer.CreaClassifica();
            proFencer.CreazioneED();
            proFencer.getCompetizioneCorrente();
            proFencer.ConfermaED();
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
            // TODO: handle exception
        }
       
    }


    @Test
    public void testCreaClassificaFinale() {
        
    }

    @Test
    public void testCreaRanking() {
        
    }





    @Test
    public void testInserisciRisultatiED() {
        
    }

    @Test
    public void testModificaFormulaGara() {
        
    }

    @Test
    public void testMostraCompetizioni() {
        
    }

    @Test
    public void testScegliFormulaGara() {
        
    }

    @Test
    public void testSelezionaCompetizione() {
        
    }

    @Test
    public void testSelezionaED() {
        
    }

    @Test
    public void testVisualizzaClassificaFinale() {
        
    }

    @Test
    public void testVisualizzaED() {
        
    }

    @Test
    public void testVisualizzaGironi() {
        
    }

    @Test
    public void testVisualizzaRanking() {
        
    }

    @Test
    public void testVisualizzazioneAtleti() {
        
    }


  

}
