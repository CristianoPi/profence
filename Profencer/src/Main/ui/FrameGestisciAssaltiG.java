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
public class FrameGestisciAssaltiG {

    JFrame frame;
    public boolean errore=false;
    List<JTextField> punteggio1Fields = new ArrayList<>();
    List<JTextField> punteggio2Fields = new ArrayList<>();
    List<JTextField> tempoFields = new ArrayList<>();
    Dimension textSize = new Dimension(80, 30);
  
    public FrameGestisciAssaltiG(int numero,ProFencer profencer) {
    	if(numero<0)
    	{
    		System.out.print("siamo un giorne");
    		int codGirone = -numero;
    		List<Assalto> assalti=profencer.getCompetizioneCorrente().getGironi().get(codGirone-1).getAssalti();
    		initialize(codGirone,assalti,profencer);
    	}	
    	else {
    		System.out.println("siamo l'eliminazione diretta"+String.valueOf(numero));  
    		//se siamo in questo caso 2^numero 
    		//da il numero di assalti che si devono stampare 
    		try {
    		profencer.SelezionaED(numero);
    		EliminazioneDiretta ed = profencer.getCompetizioneCorrente().getDirettaCorrente();
    			initialize(ed.getAssaltiED(),profencer);
    		}catch(Exception e) {
    			errore=true;
    			JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
    		}
    	}
    }

    private void initialize(int codice, List<Assalto> assalti,ProFencer profencer) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
       
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        for (Assalto assalto : assalti) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
            JLabel label1 = new JLabel(String.valueOf(assalto.getAtleta1()));
            JLabel label2 = new JLabel(String.valueOf(assalto.getAtleta2()));
        
            Dimension labelSize = new Dimension(100, 20); // Puoi cambiare le dimensioni come preferisci
            label1.setPreferredSize(labelSize);
            label2.setPreferredSize(labelSize);
            
	        label1.setBorder(new EmptyBorder(0, 10, 0, 20));
	        label2.setBorder(new EmptyBorder(0, 0, 0, 20)); 
	        panel.add(label1);
	        panel.add(label2);
	        
	        JTextField punteggio1Field = new JTextField(String.valueOf(assalto.getPunteggio1()));
	        JTextField punteggio2Field = new JTextField(String.valueOf(assalto.getPunteggio2()));
	        JTextField tempoField = new JTextField(String.valueOf(assalto.getTempo()));
	        punteggio1Fields.add(punteggio1Field);
	        punteggio2Fields.add(punteggio2Field);
	        tempoFields.add(tempoField);
	        panel.add(punteggio1Field);
	        panel.add(punteggio2Field);
	        panel.add(tempoField);
	 
	        mainPanel.add(panel);
	        // frame.add(panel);
        }
        JScrollPane ScrollPane= new JScrollPane(mainPanel);
        frame.add(ScrollPane);
        JButton confermaButton = new JButton("Conferma");
        confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            //per vedere se funziona.
            	for(int i=0; i<assalti.size();i++) {
            	//List <Assalto> assaltiRisultati= new ArrayList<Assalto>();
            	assalti.get(i).setPunteggio1(Integer.parseInt(punteggio1Fields.get(i).getText()));
            	assalti.get(i).setPunteggio2(Integer.parseInt(punteggio2Fields.get(i).getText()));
            	assalti.get(i).setTempo(Integer.parseInt(tempoFields.get(i).getText()));

            	}
            	for(Assalto a : assalti)
            		System.out.println(" vediamo:  "+a.toString());
            	try {
            	profencer.InserimentoRisultati(codice, assalti);
            	JOptionPane.showMessageDialog(null, "risultati inseriti correttamente ", "Info", JOptionPane.INFORMATION_MESSAGE);
            	frame.dispose();
            	}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);

            	}
            	for (int i = 0; i < assalti.size(); i++) {
            		System.out.println(tempoFields.get(i).getText());
            		System.out.println(punteggio1Fields.get(i).getText());
            		System.out.println(punteggio2Fields.get(i).getText());
            	}
            }
        });
        frame.add(confermaButton, BorderLayout.SOUTH);
        frame.setMinimumSize(new Dimension(500,400));
       // frame.setMaximumSize(new Dimension(500,450));
       frame.pack();
    }
    
    private void initialize(List<Assalto> assalti,ProFencer profencer) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
       
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        for (Assalto assalto : assalti) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
            JLabel label1 = new JLabel(String.valueOf(assalto.getAtleta1()));
            JLabel label2 = new JLabel();
            if(assalto.getAtleta2()!=-1) {
              	 label2.setText(String.valueOf(assalto.getAtleta2()));
           
               Dimension labelSize = new Dimension(110, 20); // Puoi cambiare le dimensioni come preferisci
               label1.setPreferredSize(labelSize);
               label2.setPreferredSize(labelSize);
	               
	   	        label1.setBorder(new EmptyBorder(0, 10, 0, 20));
	   	        label2.setBorder(new EmptyBorder(0, 0, 0, 20)); 
	   	        panel.add(label1);
	   	        panel.add(label2);
	   	        
	   	        JTextField punteggio1Field = new JTextField(String.valueOf(assalto.getPunteggio1()));
	   	        JTextField punteggio2Field = new JTextField(String.valueOf(assalto.getPunteggio2()));
	   	        JTextField tempoField = new JTextField(String.valueOf(assalto.getTempo()));
	   	        
	   	        punteggio1Field.setPreferredSize(textSize);
    	        punteggio2Field.setPreferredSize(textSize);
    	        tempoField.setPreferredSize(textSize);
	   	        
	   	        punteggio1Fields.add(punteggio1Field);
	   	        punteggio2Fields.add(punteggio2Field);
	   	        tempoFields.add(tempoField);
	   	        panel.add(punteggio1Field);
	   	        panel.add(punteggio2Field);
	   	        panel.add(tempoField);
	   	 
	   	        mainPanel.add(panel);
               }else {
               	label2.setText("fase successiva");
               	Dimension labelSize = new Dimension(110, 20); // Puoi cambiare le dimensioni come preferisci
                   label1.setPreferredSize(labelSize);
                   label2.setPreferredSize(labelSize);
                   
       	        label1.setBorder(new EmptyBorder(0, 10, 0, 20));
       	        label2.setBorder(new EmptyBorder(0, 0, 0, 20)); 
       	        panel.add(label1);
       	        panel.add(label2);
       	        
       	        JTextField punteggio1Field = new JTextField(String.valueOf(assalto.getPunteggio1()));
       	        punteggio1Field.setEditable(false);
       	        
       	        JTextField punteggio2Field = new JTextField(String.valueOf(assalto.getPunteggio2()));
       	        punteggio2Field.setEditable(false);
       	       
       	        JTextField tempoField = new JTextField(String.valueOf(assalto.getTempo()));
       	        tempoField.setEditable(false);
       	        
       	        
       	        punteggio1Field.setPreferredSize(textSize);
       	        punteggio2Field.setPreferredSize(textSize);
       	        tempoField.setPreferredSize(textSize);
       	        
       	        punteggio1Fields.add(punteggio1Field);
       	        punteggio2Fields.add(punteggio2Field);
       	        tempoFields.add(tempoField);
       	        panel.add(punteggio1Field);
       	        panel.add(punteggio2Field);
       	        panel.add(tempoField);
       	        
               	mainPanel.add(panel);
               }
        }
        JScrollPane ScrollPane= new JScrollPane(mainPanel);
        frame.add(ScrollPane);
        JButton confermaButton = new JButton("Conferma");
        confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            //per vedere se funziona.
            	for(int i=0; i<assalti.size();i++) {
            	//List <Assalto> assaltiRisultati= new ArrayList<Assalto>();
            	assalti.get(i).setPunteggio1(Integer.parseInt(punteggio1Fields.get(i).getText()));
            	assalti.get(i).setPunteggio2(Integer.parseInt(punteggio2Fields.get(i).getText()));
            	assalti.get(i).setTempo(Integer.parseInt(tempoFields.get(i).getText()));

            	}
            	for(Assalto a : assalti)
            		System.out.println(" vediamo:  "+a.toString());
            	try {
            	profencer.InserisciRisultatiED(assalti);
            	JOptionPane.showMessageDialog(null, "risultati inseriti correttamente ", "Info", JOptionPane.INFORMATION_MESSAGE);
            	frame.dispose();
            	}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);

            	}
            	for (int i = 0; i < assalti.size(); i++) {
            		System.out.println(tempoFields.get(i).getText());
            		System.out.println(punteggio1Fields.get(i).getText());
            		System.out.println(punteggio2Fields.get(i).getText());
            	}
            }
        });
        frame.add(confermaButton, BorderLayout.SOUTH);
        frame.setMinimumSize(new Dimension(500,400));
       // frame.setMaximumSize(new Dimension(500,450));
       frame.pack();
    }
    
}
