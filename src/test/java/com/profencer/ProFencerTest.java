package com.profencer;

import static org.junit.Assert.fail;

import org.junit.Test;

public class ProFencerTest {
    ProFencer proFencer=new ProFencer();

   
    @Test
    public void UC1(){
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
    public void testAccettazioneAtleta() {
        
    }

    @Test
    public void testConfermaED() {
        
    }

    @Test
    public void testConfermaInserimento() {
        
    }

    @Test
    public void testConfermaTesseramento() {
        
    }

    @Test
    public void testCreaClassificaFinale() {
        
    }

    @Test
    public void testCreaRanking() {
        
    }

    @Test
    public void testCreaTesseramento() {
        
    }

    @Test
    public void testCreazioneED() {
        
    }

    @Test
    public void testCreazioneGironi() {
        
    }

    @Test
    public void testGetIstanceProFencer() {
        
    }



    @Test
    public void testInserimentoRisultati() {
        
    }

    @Test
    public void testInserimentoSpecifiche() {
        
    }

    @Test
    public void testInserisciRisultatiED() {
        
    }

    @Test
    public void testIscrizione() {
        try {
            //dobbiamo tesserare un atleta e creare una competizone
            proFencer.setCompetizioni(null);
        } catch (Exception e) {
            // TODO: handle exception
        }
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

    @Test
    public void testVisualizzazioneFormulaGara() {
        
    }

    @Test
    public void testGetAtletaCorrente() {
        
    }

    @Test
    public void testGetCompetizioneCorrente() {
        
    }

    @Test
    public void testGetCompetizioni() {
        
    }

    @Test
    public void testGetTesserati() {
        
    }

    @Test
    public void testSetAtletaCorrente() {
        
    }

    @Test
    public void testSetCompetizioneCorrente() {
        
    }

    @Test
    public void testSetCompetizioni() {
        
    }

    @Test
    public void testSetTesserati() {
        
    }

}
