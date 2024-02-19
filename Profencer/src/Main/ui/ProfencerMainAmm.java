package Main.ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;


import Main.domain.Competizione;

import Main.domain.*;
public class ProfencerMainAmm {

	JFrame frame;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ProfencerMainAmm(ProFencer profencer) {
		//initialize();
		frame = new JFrame();
		frame.setBounds(100, 100, 815, 489);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitolo = new JLabel("Profencer\r\n");
		lblTitolo.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblTitolo.setBounds(30, 26, 234, 55);
		frame.getContentPane().add(lblTitolo);
		
		JButton btnNewCompetizione = new JButton("Crea una nuova competizione");
		btnNewCompetizione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					int s=Integer.parseInt(JOptionPane.showInputDialog(contentPane,"Inserisci codice/ nome della competizione:\n","inserimento competizione",JOptionPane.PLAIN_MESSAGE));
				
						try {
							
						profencer.InserimentoCodiceCompetizione(s);
						System.out.println("bravo codice buono");
						
						}catch(Exception e) {
							System.out.println("Eccezzione è gia presente ");
							//se mi da l'eccezione relativa al fatto che già c'è 
						}
				}catch(Exception e ){
						System.out.println("Eccezzione devi inserire un numero che identifica la competizione");
						
					}
				
				FrameCreazioneCompetizione fcc= new FrameCreazioneCompetizione(profencer);
				fcc.frame.setVisible(true);
			}
		});
		btnNewCompetizione.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewCompetizione.setBounds(388, 60, 319, 86);
		frame.getContentPane().add(btnNewCompetizione);
		
		JButton btnTesseramento = new JButton("Tesseramento");
		btnTesseramento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameTesseramento ft= new FrameTesseramento();
				ft.frame.setVisible(true);
			}
		});
		btnTesseramento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTesseramento.setBounds(388, 180, 319, 99);
		frame.getContentPane().add(btnTesseramento);
		
		JButton btnIscrizione = new JButton("Iscrizione");
		btnIscrizione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//FrameTesseramento ft= new FrameTesseramento();
				//ft.frame.setVisible(true);
				//devo aprire il frame di sicrizone per l'atleta.
				FrameVisualizzaCompetizioni fvc = new FrameVisualizzaCompetizioni();
				fvc.frame.setVisible(true);
			}
		});
		btnIscrizione.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIscrizione.setBounds(388, 290, 319, 99);
		frame.getContentPane().add(btnIscrizione);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
}