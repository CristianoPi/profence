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
import Main.domain.Atleta_Girone;
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
	
	try {	
		profencer.CreazioneGironi();
		//    initialize(elenco, elencoAssalti);
		List<Girone>elenco= profencer.VisualizzaGironi();
		//List<Girone>elenco= profencer.getCompetizioneCorrente().getGironi();
		System.out.println("ciao");
		for(Girone g : elenco)
			System.out.println(g.toString());
		System.out.println("elenco gironi finito");
		for(Girone g: elenco) {
			for(Assalto a : g.getAssalti())
				System.out.println(a.toString());
		}
		System.out.println("Assalti finiti");
		for(Girone g: elenco) {
			for(Atleta_Girone a : g.getAtletiGiorne())
				System.out.println(a.toString());
		}
		System.out.println("Atleti girone finiti");
		initialize(elenco,profencer);
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
	}
	}
	
	public void initialize(List<Girone> elenco, ProFencer profencer) {	
		frame = new JFrame();
	    JPanel panel = new JPanel();
	   // panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

	    	for(Girone g : elenco) {
	    	JPanel rowPanel = new JPanel();
	        rowPanel.setLayout(new BoxLayout(rowPanel, BoxLayout.Y_AXIS));

	        JPanel labelButtonPanel = new JPanel();
	        labelButtonPanel.setLayout(new BoxLayout(labelButtonPanel, BoxLayout.X_AXIS));


	        JLabel label = new JLabel("girone: "+String.valueOf(g.getCodGirone()));
	        JButton button = new JButton("inserisci dati");
	        button.addActionListener(new ActionListener() {
           
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
	        	
	        	textArea.append("Codice Atleta1:"+as.getAtleta1()+"  Codice Atleta2:"+as.getAtleta2() + "\n");
	       
	       
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        textArea.setColumns(30);
	        
	       
	        
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

