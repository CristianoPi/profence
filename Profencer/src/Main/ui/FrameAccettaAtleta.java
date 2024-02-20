package Main.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Main.domain.Atleta;
import Main.domain.ProFencer;

public class FrameAccettaAtleta {

	 JFrame frame;
	private JPanel contentPane;
	
	/**
	 * Create the application.
	 */
	public FrameAccettaAtleta(ProFencer profencer) {
		initialize();
		List<Atleta> iscritti = profencer.getCompetizioneCorrente().getIscritti();
		JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	   //bisogna prendere da profencere la lista degli atleti iscritti alla competizoone corrente.
	    //si riportano i dati a schermo con un foreach di atleata su atleti, al memomento penso ai soli codicei fiscali
	   
	   // try (Scanner scanner = new Scanner(new File("C:\\Users\\giuse\\OneDrive\\Documenti\\GitHub\\profence\\src\\main\\ui\\src\\prova\\file.txt"))) {
	    //    while (scanner.hasNextLine()) {
	    		for(Atleta a : iscritti) {
	           // String line = scanner.nextLine();
	            JLabel textField = new JLabel(a.getNome()+" "+a.getCognome());
	            JButton button = new JButton("Accetta atleta"); 
	            										 
	            button.addActionListener(new ActionListener() {
	            	// boolean isAccepted = false;
	            	public void actionPerformed(ActionEvent arg0) {
	    				try {
	            		profencer.AccettazioneAtleta(a.getCodFIS());
	            			JOptionPane.showMessageDialog(null, "atleta accettato correttaemtne ", "info", JOptionPane.INFORMATION_MESSAGE);
	    				}catch(Exception e) {
	            			JOptionPane.showMessageDialog(null, e.getMessage() , "errore", JOptionPane.ERROR_MESSAGE);
	    				}
	            	
	            		//valutare se implementare la rimozione di un'atleta dalla lista degli accettati, 
	            		//in questo modo si dovrebbe fare switch di bottone dopo che viene accettato
	            		
	            		//	if (!isAccepted) {
	                        //bisogna agiungere l'atleta alla lista di atleti accettati
	                  //      isAccepted = true;
	                      //  button.setText("Rimuovi atleta");
	                 //   } else {
	                        //biaogna rimuovere l'atleta  dalal lista di atleti accettati
	                 //       isAccepted = false;
	                 //       button.setText("Accetta atleta");
	                 //   }
	    				
	    			}
	    		});
	            
	            JPanel linePanel = new JPanel(new BorderLayout());
	            
	            linePanel.setMaximumSize(new Dimension(400, 30)); 
	            
	            linePanel.add(textField, BorderLayout.CENTER);
	            linePanel.add(button, BorderLayout.EAST);
	            panel.add(linePanel);
	        }
	    
	    JScrollPane scrollPane = new JScrollPane(panel);
	    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	    frame.setMinimumSize(new Dimension(600,400));
	    frame.setMaximumSize(new Dimension(800, 500)); // Imposta 
	    frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 754, 519);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
