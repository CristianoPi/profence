package prova;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameClassificaFinale {

	 JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameClassificaFinale window = new FrameClassificaFinale();
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
	//bisognerà passare la lista di atleti
	public FrameClassificaFinale() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  JLabel label = new JLabel("Classifica finale");
	        frame.add(label,BorderLayout.NORTH);

	        // Creazione della tabella
	        String[] columnNames = {"CF","nome", "cognome", "genere", "ranking"};
	     //   Object[][] data = new Object[atletiGirone.size()][4];
	     //   for (int i = 0; i < atleti.size(); i++) {
	     //       AtletaGirone atleta = atleti.get(i);
	     //       data[i][0] = atleta.getCF();
	        //	  data[i][1] = atleta.getNome();
	     //       data[i][2] = atleta.getCognome();
	     //       data[i][3] = atleta.getGenere();
	     //       data[i][4] = atleta.getRanking();
	     //       
	     //   }
	        Object[][] data = new Object[60][5];
	        for(int i=0; i<60;i++) {
	        	 data[i][0] ="CF";
	        	 data[i][1] = "nome";
	             data[i][2] = "cognome";
	    	     data[i][3] = "genere";
	    	     data[i][4] = "ranking";
	    	     
	        }
	        
	        JTable table = new JTable(data, columnNames);
	        JScrollPane scrollPane = new JScrollPane(table);
	        frame.add(scrollPane, BorderLayout.CENTER);

	     
	        
	       frame.pack();
	      
	    }
		
	}

