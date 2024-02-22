package Main.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Main.domain.Competizione;
import Main.domain.ProFencer;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class FrameVisualizzaCompetizioni {

	 JFrame frame;
	 private JPanel contentPane;

	/**
	 * Create the application.
	 */
	public FrameVisualizzaCompetizioni(ProFencer profencer) {
		initialize();
		JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    
	    //List<Competizione>lista =new ArrayList<Competizione>();
	    
	    //qui invece di utilizzare un file devo prendere da profencer la lista delle competizioni e fare un foreach di competizione su competizioni
	  
	  //  try (Scanner scanner = new Scanner(new File("C:\\Users\\giuse\\OneDrive\\Documenti\\GitHub\\profence\\src\\main\\ui\\src\\prova\\file.txt"))) {
	  //      while (scanner.hasNextLine()) {
	    
	    List<Competizione>lista = profencer.MostraCompetizioni();
	    	for (Competizione c : lista) {
	            System.out.print(c.getCodCompetizione());
	            JLabel textField = new JLabel("Competizione: "+c.getCodCompetizione());
	            JButton button = new JButton("Iscriviti alla gara"); 
	            										  
	            button.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent arg0) {
	    				//si dovrebbe verificare che l'atletta risulti tesserato
	    				// e che la categoria della competizione sia adatta alla propria.
	    				//bisogna chiedere il codice fiscale per poter verificare se è prima tesserato, 
	    				//poi che la competizione sia aperta a lui in base alla sua categoria
	    				
	    				//se tutto va bene si aggiungere atleta alla lista di atleti iscritti a quwella competizione.
	    			String fis=JOptionPane.showInputDialog(contentPane,"Inserisci il codice fis dell'atleta :\n","iscrizione",JOptionPane.PLAIN_MESSAGE);
	    				// dal codice fiscale si fanno le verifiche.
	    			//JOptionPane.showMessageDialog(null, fis, "il CodFis: ", JOptionPane.INFORMATION_MESSAGE);
	    		
	    			//if cf è presente in tesserati e if  la categoria va ben per la categoria della competizione --> si iscrive l'atleta e si chiude il frame
	    			//else  si notifica l'errore
	    				if(fis.equals("")) {
	    					JOptionPane.showMessageDialog(null, "errore: compila il campo ", "ERRORE ", JOptionPane.ERROR_MESSAGE);
	    				}
	    				else {
	    					//caso postivo 
	    					//bisogna aggiungere alla lista di iscritti della competizione 
	    					//"line" l'atleta con il codice fiscale inserito nel box a tendina
	    					try {
		    					profencer.Iscrizione(Integer.parseInt(fis), c.getCodCompetizione());
	    						JOptionPane.showMessageDialog(null, "iscrizione avvenura corretamente ", "Risultato: ", JOptionPane.INFORMATION_MESSAGE);
	    						//frame.dispose();
	    					}
	    					catch(Exception e) {
	    						JOptionPane.showMessageDialog(null, e.getMessage(), "errore ", JOptionPane.ERROR_MESSAGE);
	    					}
	    				}
	    			}
	    		});
	            
	            JPanel linePanel = new JPanel(new BorderLayout());
	            
	            linePanel.setMaximumSize(new Dimension(400, 30)); 
	            
	            linePanel.add(textField, BorderLayout.CENTER);
	            linePanel.add(button, BorderLayout.EAST);
	            panel.add(linePanel);
	        }
	   
	    JScrollPane scrollPane = new JScrollPane(panel);
	    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	    frame.setMinimumSize(new Dimension(600,400));
	    frame.setMaximumSize(new Dimension(800, 500)); // Imposta 
	    frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	    frame = new JFrame();
	    frame.setBounds(100, 100, 649, 474);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.getContentPane().setLayout(new BorderLayout());
	

	}
}
