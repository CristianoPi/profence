package Main.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Main.domain.Assalto;
import Main.domain.EliminazioneDiretta;
import Main.domain.ProFencer;

public class FrameEliminazioneDiretta {

	JFrame frame;

	
	public FrameEliminazioneDiretta(ProFencer profencer) {
	
		
		
		//List<String> assalti= new ArrayList<String>();
   
		//	assalti.add("assalto 1");
	//    assalti.add("assalto 2");
	//    assalti.add("assalto 3");
	//    assalti.add("assalto 1");
	//    assalti.add("assalto 2");
		//	assalti.add("assalto 1");
		//    assalti.add("assalto 2");
		//    assalti.add("assalto 3");
		//    assalti.add("assalto 1");
		//    assalti.add("assalto 2");  
		//	assalti.add("assalto 1");
		//    assalti.add("assalto 2");
		//    assalti.add("assalto 3");
		//    assalti.add("assalto 1");
		//    assalti.add("assalto 2");
		  
		initialize(profencer);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ProFencer profencer) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		//frame.setMaximumSize(new Dimension(600,400));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel label = new JLabel("Tabellone eliminazione diretta");
        frame.add(label,BorderLayout.NORTH);
        try {
        EliminazioneDiretta ED=profencer.CreazioneED();
        List<Assalto> assalti=ED.getAssaltiED();
       // System.out.println("SONO IL TABELLONE");
       // System.out.println(ED);	
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
       // frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        for (Assalto assalto : assalti) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
            panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50)); // Imposta la dimensione massima del pannello

            //System.out.println(assalto);
            
            JLabel label1 = new JLabel(String.valueOf(assalto.getAtleta1()));
            JLabel label2 = new JLabel();
            
            if(assalto.getAtleta2()!=-1) 
            	 label2.setText(String.valueOf(assalto.getAtleta2()));
            
            Dimension labelSize = new Dimension(100, 20); // Puoi cambiare le dimensioni come preferisci
            label1.setPreferredSize(labelSize);
            label2.setPreferredSize(labelSize);
            label1.setBorder(new EmptyBorder(0, 0, 0, 20));
            label2.setBorder(new EmptyBorder(0, 0, 0, 20)); 
            panel.add(label1);
            panel.add(label2);
            
            JTextField punteggio1Field = new JTextField(String.valueOf(assalto.getPunteggio1()));
            punteggio1Field.setEditable(false); // Rende il campo di testo non modificabile
            JTextField punteggio2Field = new JTextField(String.valueOf(assalto.getPunteggio2()));
            punteggio2Field.setEditable(false); // Rende il campo di testo non modificabile
            JTextField tempoField = new JTextField(String.valueOf(assalto.getTempo()));
            tempoField.setEditable(false); // Rende il campo di testo non modificabil

            panel.add(punteggio1Field);
            panel.add(punteggio2Field);
            panel.add(tempoField);

            mainPanel.add(panel);
        }
        JScrollPane ScrollPane= new JScrollPane(mainPanel);
        frame.add(ScrollPane);
        JButton confermaButton = new JButton("Conferma");
        confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            	profencer.ConfermaED();
                frame.dispose();
            	}
            	catch(Exception ex) {
            		JOptionPane.showMessageDialog(null, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
            	}
            }
        });
        frame.add(confermaButton, BorderLayout.SOUTH);
        frame.setMinimumSize(new Dimension(500,400));
       
        }catch(Exception e) {
        	JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
	}

}
