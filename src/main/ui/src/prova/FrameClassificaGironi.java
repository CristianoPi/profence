package prova;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameClassificaGironi {

	 JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameClassificaGironi window = new FrameClassificaGironi();
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
	//dovrei aver passata la classifica dei gironi che è una lista di atleta girone i cmpi di atleta girone sono : 
	//stoccate date int, staccate ricevute int, punteggio, vittorie e posizione.
	public FrameClassificaGironi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  JLabel label = new JLabel("Classifica Gironi");
	        frame.add(label,BorderLayout.NORTH);

	        // Creazione della tabella
	        String[] columnNames = {"atleta","Stoccate Date", "Staccate Ricevute", "Punteggio", "Vittorie", "Posizione"};
	     //   Object[][] data = new Object[atletiGirone.size()][5];
	     //   for (int i = 0; i < atletiGirone.size(); i++) {
	     //       AtletaGirone atleta = atletiGirone.get(i);
	     //       data[i][0] = atleta.getCF();
	        //	  data[i][1] = atleta.getStoccateDate();
	     //       data[i][2] = atleta.getStaccateRicevute();
	     //       data[i][3] = atleta.getPunteggio();
	     //       data[i][4] = atleta.getVittorie();
	     //       data[i][5] = atleta.getPosizione();
	     //   }
	        Object[][] data = new Object[3][6];
	        for(int i=0; i<3;i++) {
	        	 data[i][0] ="sono io";
	        	 data[i][1] = "numero stoccate aaaa";
	             data[i][2] = "ne ho ricevute aaa";
	    	     data[i][3] = "i miei punti";
	    	     data[i][4] = "le mie vittorie";
	    	     data[i][5] = "la mia posizione ";
	        }
	        
	        JTable table = new JTable(data, columnNames);
	        JScrollPane scrollPane = new JScrollPane(table);
	        frame.add(scrollPane, BorderLayout.CENTER);

	        // Impostazioni del frame
	        
	       frame.pack();
	        //setVisible(true);
	    }
		

}
