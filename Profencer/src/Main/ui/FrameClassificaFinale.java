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

public class FrameClassificaFinale {

	 JFrame frame;
	 public Boolean errore=false;
	 
	//bisognerà passare la lista di atleti
	public FrameClassificaFinale(ProFencer profencer) {
		initialize(profencer);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ProFencer profencer) {
		try {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel label = new JLabel("Classifica finale");
	    frame.add(label,BorderLayout.NORTH);

	    profencer.CreaClassificaFinale();
	    List<Atleta> classificaF = profencer.VisualizzaClassificaFinale();
	    
	        // Creazione della tabella
	        String[] columnNames = {"posizione","codFIS","nome", "cognome","CF", "ranking"};
	        Object[][] data = new Object[classificaF.size()][6];
	        for (int i = 0; i < classificaF.size(); i++) {
	            Atleta atleta = classificaF.get(i);
	            data[i][0]= i+1;
	            data[i][1] = atleta.getCodFIS();
	        	data[i][2] = atleta.getNome();
	            data[i][3] = atleta.getCognome();
	            data[i][4]=atleta.getCF();
	            data[i][5] = atleta.getRanking();
	            
	        }
	        
	        JTable table = new JTable(data, columnNames);
	        JScrollPane scrollPane = new JScrollPane(table);
	        frame.add(scrollPane, BorderLayout.CENTER);

	     
	        
	       frame.pack();
	      
	    }catch(Exception e) {
			errore=true;
        	JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
	    }
		
	}	
		
}

