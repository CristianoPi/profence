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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Main.domain.Assalto;
import Main.domain.ProFencer;
public class FrameGestisciAssaltiG {

    JFrame frame;
    List<JTextField> punteggio1Fields = new ArrayList<>();
    List<JTextField> punteggio2Fields = new ArrayList<>();
    List<JTextField> tempoFields = new ArrayList<>();
  
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
    	}
    	
    	//List<String> assalti= new ArrayList<String>();
    	//assalti.add("assalto 1");
	    //assalti.add("assalto 2");
	    //assalti.add("assalto 3");
	    //assalti.add("assalto n");
       // initialize(assalti);
    }

    private void initialize(int codice, List<Assalto> assalti,ProFencer profencer) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        for (Assalto assalto : assalti) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
            JLabel label1 = new JLabel(String.valueOf(assalto.getAtleta1()));
            JLabel label2 = new JLabel(String.valueOf(assalto.getAtleta2()));
        label1.setBorder(new EmptyBorder(0, 0, 0, 20));
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
          //  panel.add(new JLabel(assalto.getGiocatore1()));
          //  panel.add(new JLabel(assalto.getGiocatore2()));
          //  panel.add(new JTextField(String.valueOf(assalto.getPunteggio1())));
          //  panel.add(new JTextField(String.valueOf(assalto.getPunteggio2())));
          //  panel.add(new JTextField(assalto.getTempo().toString()));
            frame.add(panel);
        }
        JButton confermaButton = new JButton("Conferma");
        confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aggiorna la lista di assalti qui
            	/*
            	  for (int i = 0; i < assalti.size(); i++) {
                    Assalto assalto = assalti.get(i);
                    assalto.setPunteggio1(Integer.parseInt(punteggio1Fields.get(i).getText()));
                    assalto.setPunteggio2(Integer.parseInt(punteggio2Fields.get(i).getText()));
                    assalto.setTempo(Time.valueOf(tempoFields.get(i).getText()));
                } 
            	 */
            	//per vedere se funziona.
            	for(int i=0; i<assalti.size();i++) {
            	//List <Assalto> assaltiRisultati= new ArrayList<Assalto>();
            	assalti.get(i).setPunteggio1(Integer.parseInt(punteggio1Fields.get(i).getText()));
            	assalti.get(i).setPunteggio2(Integer.parseInt(punteggio2Fields.get(i).getText()));
            	assalti.get(i).setTempo(Integer.parseInt(tempoFields.get(i).getText()));

            	}
            	for(Assalto a : assalti)
            		System.out.println(" vediamo:  "+a.toString());
            	profencer.InserimentoRisultati(codice, assalti);
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
