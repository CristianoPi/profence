package Main.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Main.domain.ProFencer;
import Main.domain.Atleta_Girone;

public class FrameClassificaGironi {

	 JFrame frame;

	
	/**
	 * Create the application.
	 */
	//dovrei aver passata la classifica dei gironi che è una lista di atleta girone i cmpi di atleta girone sono : 
	//stoccate date int, staccate ricevute int, punteggio, vittorie e posizione.
	public FrameClassificaGironi(ProFencer profencer) {
		initialize(profencer);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ProFencer profencer) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  JLabel label = new JLabel("Classifica Gironi");
	        frame.add(label,BorderLayout.NORTH);
	        
	        try {
	        	profencer.CreaClassifica();
	        	List<Atleta_Girone> classifica= profencer.VisualizzaClassifica();
	        
	        
	        
	        // Creazione della tabella
	        String[] columnNames = {"atleta","Stoccate Date", "Staccate Ricevute", "Punteggio", "Vittorie"};
	        Object[][] data = new Object[classifica.size()][5];
	        for (int i = 0; i < classifica.size(); i++) {
	            Atleta_Girone atleta = classifica.get(i);
	            data[i][0] = atleta.getCodFIS();
	        	data[i][1] = atleta.getStoccateDate();
	           data[i][2] = atleta.getStoccateRicevute();
	            data[i][3] = atleta.getPunteggio();
	            data[i][4] = atleta.getVittorie();
	            
	        }
	    
	        
	        JTable table = new JTable(data, columnNames);
	        JScrollPane scrollPane = new JScrollPane(table);
	        frame.add(scrollPane, BorderLayout.CENTER);

	        // Impostazioni del frame
	        
	       frame.pack();
	        //setVisible(true);
	       }catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
	        }
	    }
		

}
