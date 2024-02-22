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

import Main.domain.Assalto;
import Main.domain.Girone;
import Main.domain.ProFencer;

public class FrameVisualizzaGironi {

	 JFrame frame;
	 public boolean errore=false;
	public FrameVisualizzaGironi(ProFencer profencer) {
		try {
		List<Girone> elenco=profencer.VisualizzaGironi();
		    initialize(elenco, profencer);
		}catch(Exception e) {
			errore=true;
			JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void initialize(List<Girone> elenco, ProFencer profencer) {
		frame = new JFrame();
	    JPanel panel = new JPanel();
	   

	   // for (int i = 0; i < elenco.size(); i++) {
	    	for(Girone g : elenco) {
	    		
	        JPanel rowPanel = new JPanel();
	        rowPanel.setLayout(new BoxLayout(rowPanel, BoxLayout.Y_AXIS));

	        JPanel labelButtonPanel = new JPanel();
	        labelButtonPanel.setLayout(new BoxLayout(labelButtonPanel, BoxLayout.X_AXIS));

	        JLabel label = new JLabel("girone: "+String.valueOf(g.getCodGirone()));
	        JButton button = new JButton("Seleziona girone");
	        button.addActionListener(new ActionListener() {
        	// boolean isDone = false;
        	public void actionPerformed(ActionEvent arg0) {
				
        		FrameGestisciAssaltiG Fga= new FrameGestisciAssaltiG(-g.getCodGirone(),profencer);  //numero negativo perchè si tratta di assalti gironi
        		if(!Fga.errore)
        			Fga.frame.setVisible(true);
				
			}
		});

	        labelButtonPanel.add(label);
	        labelButtonPanel.add(Box.createHorizontalGlue());  // Aggiungi dello spazio tra la label e il bottone
	        labelButtonPanel.add(button);
	        JTextArea textArea = new JTextArea();
	        for(Assalto as : g.getAssalti())
	        	
	        	textArea.append("Codice Atleta1:"+as.getAtleta1()+" - Codice Atleta2:"+as.getAtleta2() + "\n");
	       
	       
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        textArea.setColumns(30);
	        
	    
	        
	        JScrollPane scrollPane = new JScrollPane(textArea);
	        scrollPane.setPreferredSize(new Dimension(textArea.getPreferredSize().width, 100)); // Limita l'altezza a 50 pixel
	        
	        JPanel labelPanel = new JPanel();
	        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.X_AXIS));

	        // Crea le due JLabel e aggiungile al JPanel
	        JLabel pedanaLabel = new JLabel("Pedana: " + String.valueOf(g.getPedana()));
	        JLabel dataLabel = new JLabel("Data: " + String.valueOf(g.getDataOra()));
	        labelPanel.add(pedanaLabel);
	        labelPanel.add(Box.createHorizontalGlue());  // Aggiungi dello spazio tra le due JLabel
	        labelPanel.add(dataLabel);
	        
	        
	        rowPanel.add(labelButtonPanel);
	        rowPanel.add(scrollPane);
	        rowPanel.add(labelPanel);
	        
	        panel.add(rowPanel);
	    }

	    frame.add(panel);
	    frame.setMinimumSize(new Dimension(800, 500));
	    frame.setVisible(true);
	}
}