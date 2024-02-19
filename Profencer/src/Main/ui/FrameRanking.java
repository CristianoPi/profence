package Main.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameRanking {

	 JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameRanking window = new FrameRanking();
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
	//bisognera aggiungere cosa verra passato o competizione o lista atleti della competizione
	public FrameRanking() {
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
	        String[] columnNames = {"codFIS","nome", "cognome","CF", "genere", "ranking"};
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
	        Object[][] data = new Object[60][6];
	        for(int i=0; i<60;i++) {
	        	 data[i][0] ="CodeFis";
	        	 data[i][1] = "nome";
	             data[i][2] = "cognome";
	             data[i][3]="CF";
	    	     data[i][4] = "genere";
	    	     data[i][5] = "ranking";
	    	     
	        }
	        
	        JTable table = new JTable(data, columnNames);
	        JScrollPane scrollPane = new JScrollPane(table);
	        frame.add(scrollPane, BorderLayout.CENTER);

	     
	        
	       frame.pack();
	      
	    }

}
