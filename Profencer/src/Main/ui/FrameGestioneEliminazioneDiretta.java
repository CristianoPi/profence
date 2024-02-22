package Main.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Main.domain.EliminazioneDiretta;
import Main.domain.ProFencer;

public class FrameGestioneEliminazioneDiretta {

	 JFrame frame;
	 public boolean errore=false;
	/**
	 * Create the application.
	 */
	public FrameGestioneEliminazioneDiretta(ProFencer profencer) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	   //bisogna prendere da profencere la lista degli atleti iscritti alla competizoone corrente.
	    //si riportano i daati a schermo con un foreach di atleata su atleti, al memomento penso ai soli codicei fiscali
	   // List<Integer> ED= new ArrayList<Integer>();
	    //la lista di ED è una lista di interi ad esmpio --> 7,6,5,4,3,2,1,0  
	    //in base alla dimensione della lista capisco quante righe stampare, un pulsante per ogni riga
	    // il numero di assalti per quella riga sarà uguale a 2^numero della lista e lo gestiro come ho gestito assalti girone;
	   try {
		    List<EliminazioneDiretta> lista = profencer.getCompetizioneCorrente().getEliminazioniDirette();
		   
		    
		    //quindi lista sarò una lista di eliminazione diretta  cove ogni elemento contiene uno stato, una lista di assalti e gli eliminati
		  
		        for( EliminazioneDiretta ed: lista) {
		        	JLabel textField = new JLabel();
		        	textField.setPreferredSize(new Dimension(130,40));
		            if(ed.getStato()!=1) {
		            	 textField.setText("Tabellone dei "+String.valueOf((int)Math.pow(2, ed.getStato())));
		            }
		            else {
		            	 textField.setText("FINALE");
		            }
		            JButton button = new JButton("Seleziona fase"); 
		            										 
		            button.addActionListener(new ActionListener() {
		            	 
		            	public void actionPerformed(ActionEvent arg0) {
		    				
		    				FrameGestisciAssaltiG fgaf = new FrameGestisciAssaltiG(ed.getStato(),profencer); //andra passat o direttametne la lista 
		    																		//degli assalti o qualcosa per arrivarci
		    																		//metto i nel cotruttore succede qualcosa ?
		            		fgaf.frame.setVisible(true);
		    				frame.dispose();
		    			}
		    		});
		            
		            JPanel linePanel = new JPanel(new BorderLayout());
		            
		            linePanel.setMaximumSize(new Dimension(400, 30)); 
		            
		            linePanel.add(textField, BorderLayout.CENTER);
		            linePanel.add(button, BorderLayout.EAST);
		            panel.add(linePanel);
		        }
		  //  } catch (FileNotFoundException e) {
		   //     e.printStackTrace();
		   // }
		    JScrollPane scrollPane = new JScrollPane(panel);
		    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		    frame.setMinimumSize(new Dimension(600,400));
		    frame.setMaximumSize(new Dimension(800, 500)); // Imposta 
		    frame.setVisible(true);
		    
		}catch(Exception e) {
			errore=true;
		   JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
	   }
	}

}