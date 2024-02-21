package Main.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Main.domain.Atleta;
import Main.domain.ProFencer;

public class FrameRanking {

	 JFrame frame;

	
	//bisognera aggiungere cosa verra passato o competizione o lista atleti della competizione
	public FrameRanking( ProFencer profencer) {
		initialize(profencer);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ProFencer profencer) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 JLabel label = new JLabel("Classifica finale");
	        frame.add(label,BorderLayout.NORTH);
	        
	        try {
	        profencer.CreaRanking();
	        List<Atleta> ranking = profencer.VisualizzaRanking();
	        // Creazione della tabella
	        String[] columnNames = {"codFIS","nome", "cognome","CF", "genere", "ranking"};
	        Object[][] data = new Object[ranking.size()][6];
	        for (int i = 0; i < ranking.size(); i++) {
	            Atleta atleta = ranking.get(i);
	            data[i][0] = atleta.getCF();
	        	  data[i][1] = atleta.getNome();
	        	  data[i][2] = atleta.getCognome();
	        	  if(atleta.isGenere())
	        		  data[i][3] = "male";
	        	  else
	        		  data[i][3] = "female";
	        	  data[i][4] = atleta.getRanking();
	            
	        }
	        
	        JTable table = new JTable(data, columnNames);
	        JScrollPane scrollPane = new JScrollPane(table);
	        frame.add(scrollPane, BorderLayout.CENTER);

	     
	        
	       frame.pack();
	        }catch(Exception e) {
	        	JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
	        }
	      
	    }

}
