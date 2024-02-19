package com.profencer;

import static org.junit.Assert.fail;

import org.junit.Test;

public class ProFencerTest {
    ProFencer proFencer=new ProFencer();

    @Test
    public void testInserimentoCodiceCompetizione() {
        try {
            proFencer.InserimentoCodiceCompetizione(10);
        } catch (Exception e) {
            fail();
            // TODO: handle exception
        }
    }
    
    @Test
    public void testInserimentoDatiCompetizione() {
        try {
            proFencer.InserimentoDatiCompetizione("gara1", "descrizione1", null, "U14", "Spada");
        } catch (Exception e) {
            fail();
            // TODO: handle exception
        }
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
