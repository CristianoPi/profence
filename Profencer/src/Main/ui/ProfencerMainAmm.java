package Main.ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import Main.domain.Competizione;

public class ProfencerMainAmm {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfencerMainAmm window = new ProfencerMainAmm();
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
	public ProfencerMainAmm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
				FrameCreazioneCompetizione fcc= new FrameCreazioneCompetizione();
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
}
