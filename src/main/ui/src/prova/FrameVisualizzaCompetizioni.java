package prova;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class FrameVisualizzaCompetizioni {

	 JFrame frame;
	 private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameVisualizzaCompetizioni window = new FrameVisualizzaCompetizioni();
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
	public FrameVisualizzaCompetizioni() {
		initialize();
		JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    try (Scanner scanner = new Scanner(new File("C:\\Users\\giuse\\OneDrive\\Documenti\\GitHub\\profence\\src\\main\\ui\\src\\prova\\file.txt"))) {
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            JTextField textField = new JTextField(line);
	            JButton button = new JButton("Iscriviti alla gara"); //ogni bottone dovrebbe poter aprire la frame relativa 
	            										  //all'iscrizione dell'atleta in quella competizione.
	            button.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent arg0) {
	    				//si dovrebbe verificare che l'atletta risulti tesserato
	    				// e che la categoria della competizione sia adatta alla propria.
	    				//bisogna chiedere il codice fiscale per poter verificare se è prima tesserato, 
	    				//poi che la competizione sia aperta a lui in base alla sua categoria
	    				
	    				//se tutto va bene si aggiungere atleta alla lista di atleti iscritti a quwella competizione.
	    			String cf=JOptionPane.showInputDialog(contentPane,"Inserisci il codice fiscale dell'atleta :\n","iscrizione",JOptionPane.PLAIN_MESSAGE);
	    				// dal codice fiscale si fanno le verifiche.
	    			JOptionPane.showMessageDialog(null, cf, "il cf: ", JOptionPane.INFORMATION_MESSAGE);
	    		 //if cf è presente in tesserati e if  la categoria va ben per la categoria della competizione --> si iscrive l'atleta e si chiude il frame
	    			//else  si notifica l'errore
	    				if(cf.equals("")) {
	    					JOptionPane.showMessageDialog(null, "errore: o non sei tesserati o non è aperta a te la gara ", "ERRORE ", JOptionPane.ERROR_MESSAGE);
	    				}
	    				else {
	    					//caso postivo 
	    					frame.dispose();
	    				}
	    			}
	    		});
	            
	            JPanel linePanel = new JPanel(new BorderLayout());
	            
	            linePanel.setMaximumSize(new Dimension(400, 30)); 
	            
	            linePanel.add(textField, BorderLayout.CENTER);
	            linePanel.add(button, BorderLayout.EAST);
	            panel.add(linePanel);
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
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
	    frame.setBounds(100, 100, 649, 474);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.getContentPane().setLayout(new BorderLayout());
	

	}
}
