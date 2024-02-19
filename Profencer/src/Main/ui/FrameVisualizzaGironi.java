package Main.ui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FrameVisualizzaGironi {

	 JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameVisualizzaGironi window = new FrameVisualizzaGironi();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameVisualizzaGironi() {
		 List<String> elenco = new ArrayList<String>();
		    elenco.add("girone 1");
		    elenco.add("girone 2");
		    elenco.add("girone 3");
		    elenco.add("girone n");

		    List<List<String>> elencoAssalti = new ArrayList<>();
		    elencoAssalti.add(Arrays.asList("assalto 1 del primo", "assalto 2 del primo", "assalto n del primo"));
		    elencoAssalti.add(Arrays.asList("assalto 1 del sec", "assalto 2 del sec", "assalto n del sec"));
		    elencoAssalti.add(Arrays.asList("assalto 1 del ter", "assalto 2 del ter", "assalto n del ter"));
		    elencoAssalti.add(Arrays.asList("assalto 1 del quart", "assalto 2 del quart", "assalto n del quart"));

		    initialize(elenco, elencoAssalti);
	}

	private void initialize(List<String> elenco, List<List<String>> elencoAssalti) {
		frame = new JFrame();
	    JPanel panel = new JPanel();
	   

	    for (int i = 0; i < elenco.size(); i++) {
	        JPanel rowPanel = new JPanel();
	        rowPanel.setLayout(new BoxLayout(rowPanel, BoxLayout.Y_AXIS));

	        JPanel labelButtonPanel = new JPanel();
	        labelButtonPanel.setLayout(new BoxLayout(labelButtonPanel, BoxLayout.X_AXIS));

	        JLabel label = new JLabel(elenco.get(i));
	        JButton button = new JButton("Seleziona girone");
	        button.addActionListener(new ActionListener() {
        	 boolean isDone = false;
        	public void actionPerformed(ActionEvent arg0) {
				//bisogna aprire o una nuova frame con solo l'elenco degli assalti di tale girone oppure qua stesso chiedere  per ogni assalto, 
        		//punteggio 1 punteggio 2 e tempo, salvarli nella lista degli assalti compilati
        		
        		//proviamo la prima opzione, si rende visibile una nuova frame passandogli il girone selezionato. questa frame 
        		//dal girone si ricaverana la lista degli assalti di quel girone e la tradurra in un formato accettabile
        		FrameGestisciAssaltiG Fga= new FrameGestisciAssaltiG();
        		Fga.frame.setVisible(true);
				
			}
		});

	        labelButtonPanel.add(label);
	        labelButtonPanel.add(Box.createHorizontalGlue());  // Aggiungi dello spazio tra la label e il bottone
	        labelButtonPanel.add(button);

	        JTextArea textArea = new JTextArea(String.join("\n", elencoAssalti.get(i)));   //ci saranno per forza cambiamenti qui
	        //dovro ciclare assalto su assalti e fare in modo che ogni riga sia composta da assalto.giocatore 1 vs assalto.giocatore g
	        //altra alternativa sarebbe quella di convertire il formato ed adattatlo, nel senso ricevo lista assalti , prendo  per ogni assalto giocatore 1 e giocatore 2 e creo un lista formatttata nel seguente modo
	        //"giocatore 1 vs giocatore 2"; ecc ecc
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