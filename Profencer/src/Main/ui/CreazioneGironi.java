package Main.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Main.domain.Assalto;
import Main.domain.Girone;
import Main.domain.ProFencer;

public class CreazioneGironi {

	 JFrame frame;
	 private JPanel contentPane;
	
	/**
	 * Create the application.
	 */
	public CreazioneGironi(ProFencer profencer) {
		//qui quindi mi serve passata la lista dei gironi, attraverso la quale per ogni girone prenderò la lista degli assalti,
		//nell'esmpio ho usato una lista di liste per simulare 
	//	 List<String> elenco = new ArrayList<String>();
	//	    elenco.add("girone 1");
	//	    elenco.add("girone 2");
	//	    elenco.add("girone 3");
	//	    elenco.add("girone n");

	//	    List<List<String>> elencoAssalti = new ArrayList<>();
	//	    elencoAssalti.add(Arrays.asList("assalto 1 del primo", "assalto 2 del primo", "assalto n del primo"));
	//	    elencoAssalti.add(Arrays.asList("assalto 1 del sec", "assalto 2 del sec", "assalto n del sec"));
	//	    elencoAssalti.add(Arrays.asList("assalto 1 del ter", "assalto 2 del ter", "assalto n del ter"));
	//	    elencoAssalti.add(Arrays.asList("assalto 1 del quart", "assalto 2 del quart", "assalto n del quart"));
		profencer.CreazioneGironi();
		//    initialize(elenco, elencoAssalti);
		
		List<Girone>elenco= profencer.getCompetizioneCorrente().getGironi();
		initialize(elenco,profencer);
	}
	
	public void initialize(List<Girone> elenco, ProFencer profencer) {	
		frame = new JFrame();
	    JPanel panel = new JPanel();
	   // panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

	    //for (int i = 0; i < elenco.size(); i++) {
	    	for(Girone g : elenco) {
	    	JPanel rowPanel = new JPanel();
	        rowPanel.setLayout(new BoxLayout(rowPanel, BoxLayout.Y_AXIS));

	        JPanel labelButtonPanel = new JPanel();
	        labelButtonPanel.setLayout(new BoxLayout(labelButtonPanel, BoxLayout.X_AXIS));

	        
	        //mi stampa sempre il codice 1 per il girone, capire perchè
	        JLabel label = new JLabel("girone: "+String.valueOf(g.getCodGirone()));
	        JButton button = new JButton("inserisci dati");
	        button.addActionListener(new ActionListener() {
           	//boolean isDone = false;
           	public void actionPerformed(ActionEvent arg0) {
   				
            //bisogna chiedere via messaggio data ora e depana
           	// successivamente si settano data ora pedana dellìistanza girone scelta
           		String data=JOptionPane.showInputDialog(contentPane,"Inserisci data ed ora :\n","specifiche",JOptionPane.PLAIN_MESSAGE);
				int pedana=Integer.parseInt((JOptionPane.showInputDialog(contentPane,"Inserisci numero della pedana:\n","specifiche",JOptionPane.PLAIN_MESSAGE)));
                profencer.InserimentoSpecifiche(g.getCodGirone(), Integer.parseInt(data), pedana);
				button.setText("Modifica Dati");
   			}
   		});

	        labelButtonPanel.add(label);
	        labelButtonPanel.add(Box.createHorizontalGlue());  // Aggiungi dello spazio tra la label e il bottone
	        labelButtonPanel.add(button);
	        JTextArea textArea = new JTextArea();
	        for(Assalto as : g.getAssalti())
	        	//problemi nella visualizzazione, sono dei codici devo ricare o nomi o qualco'altro
	        	textArea.append(as.getAtleta1()+" "+as.getAtleta2() + "\n");
	       
	        // JTextArea textArea = new JTextArea(String.join("\n", elenco.get(i).getAssalti().get(i)));   //ci saranno per forza cambiamenti qui
	        //dovro ciclare assalto su assalti e fare in modo che ogni riga sia composta da assalto.giocatore 1 vs assalto.giocatore g
	        //altra alternativa sarebbe quella di convertire il formato ed adattatlo, nel senso ricevo lista assalti , prendo  per ogni assalto giocatore 1 e giocatore 2 e creo un lista formatttata nel seguente modo
	        //"giocatore 1 vs giocatore 2"; ecc ecc
	       
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        textArea.setColumns(30);
	        
	       // textArea.setPreferredSize(new Dimension(textArea.getPreferredSize().width, 50)); // Limita l'altezza a 50 pixel
	        //textArea.setAlignmentX(Component.RIGHT_ALIGNMENT); // Ancora il JTextArea alla sinistra
	        // Crea un JScrollPane che avvolge il JTextArea
	       
	        
	        JScrollPane scrollPane = new JScrollPane(textArea);
	        scrollPane.setPreferredSize(new Dimension(textArea.getPreferredSize().width, 100)); // Limita l'altezza a 50 pixel
	        
	        rowPanel.add(labelButtonPanel);
	        rowPanel.add(scrollPane);

	        panel.add(rowPanel);
	    }

	    frame.add(panel);
	    frame.setMinimumSize(new Dimension(800, 500));
	    frame.setVisible(true);
	}
}

