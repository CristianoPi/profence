package Main.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Main.domain.ProFencer;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameGestioneFormulaDiGara {

	JFrame frame;
	private JTextField textNstoccateG;
	private JTextField textMaxAtleti;
	private JTextField textPercentualeEliminati;
	private JTextField textNstoccateEliminazione;
	private int NomeCompetizione;


	/**
	 * Create the application.
	 */
	public FrameGestioneFormulaDiGara(ProFencer profencer) {
		 NomeCompetizione=profencer.getCompetizioneCorrente().getCodCompetizione();
	
		frame = new JFrame();
		frame.setBounds(100, 100, 777, 535);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGestioneF = new JLabel("gestione della formula  di gara della competizione :");
		lblGestioneF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGestioneF.setBounds(37, 29, 367, 43);
		frame.getContentPane().add(lblGestioneF);
		
		JLabel lblCompetizione = new JLabel(String.valueOf(NomeCompetizione));
		lblCompetizione.setBounds(414, 40, 127, 24);
		frame.getContentPane().add(lblCompetizione);
		//qui attraverso il codice della competizione bisogna risalire  ai campi della formula di gara di quella competizione 
		//ed assegnarli ai rispettivi text box. in modo tale che la schermata faccia sia da visualizzazione dell'attuale formula di gare 
		//si essendo i campi editabili possa comportare ad una modifica con il click su conferma.
		//quindi dal codice della competizione si recupera  l'oggetto formula di gara e poi si caricano i suoi attributi nelle varie textbox
		
		JLabel lblNstoccateG = new JLabel("Numero Stoccate gironi:");
		lblNstoccateG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNstoccateG.setBounds(69, 107, 177, 24);
		frame.getContentPane().add(lblNstoccateG);
		
		JLabel lblNumeroStoccateEliminazioni = new JLabel("Numero Stoccate eliminazioni diretta");
		lblNumeroStoccateEliminazioni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumeroStoccateEliminazioni.setBounds(73, 232, 232, 24);
		frame.getContentPane().add(lblNumeroStoccateEliminazioni);
		
		JLabel lblNumeroMassimoAtleti = new JLabel("Numero massimo atleti in un giorne :");
		lblNumeroMassimoAtleti.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumeroMassimoAtleti.setBounds(69, 155, 213, 24);
		frame.getContentPane().add(lblNumeroMassimoAtleti);
		
		JLabel lblPercentualeEliminati = new JLabel("Percentuale eliminati:");
		lblPercentualeEliminati.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPercentualeEliminati.setBounds(73, 189, 177, 24);
		frame.getContentPane().add(lblPercentualeEliminati);
		
		textNstoccateG = new JTextField(String.valueOf(profencer.getCompetizioneCorrente().getFormulaDiGara().getNumeroStoccateGironi()));
		textNstoccateG.setBounds(326, 107, 146, 23);
		frame.getContentPane().add(textNstoccateG);
		textNstoccateG.setColumns(10);
		//textNstoccateG.setText(""); // bisogna settarlo al valore attuale di numero di stoccate girone 
		
		textMaxAtleti = new JTextField(String.valueOf(profencer.getCompetizioneCorrente().getFormulaDiGara().getMaxDimGirone()));
		textMaxAtleti.setColumns(10);
		textMaxAtleti.setBounds(326, 159, 146, 23);
		frame.getContentPane().add(textMaxAtleti);
		//textMaxAtleti.setText(""); // bisogna settarlo al valore attuale	
		
		textPercentualeEliminati = new JTextField(String.valueOf(profencer.getCompetizioneCorrente().getFormulaDiGara().getPercEliminati()));
		textPercentualeEliminati.setColumns(10);
		textPercentualeEliminati.setBounds(326, 193, 146, 23);
		frame.getContentPane().add(textPercentualeEliminati);
		//textPercentualeEliminati.setText(""); // bisogna settarlo al valore attuale
		
		textNstoccateEliminazione = new JTextField(String.valueOf(profencer.getCompetizioneCorrente().getFormulaDiGara().getNumeroStoccateDirette()));
		textNstoccateEliminazione.setColumns(10);
		textNstoccateEliminazione.setBounds(326, 236, 146, 23);
		frame.getContentPane().add(textNstoccateEliminazione);
		//textNstocateEliminazione.setText(""); // bisogna settarlo al valore attuale
		
		JButton btnConferma = new JButton("Conferma Modifiche");
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//se i campi non sono vuoti si chiama la set campi su formula di gara  e poi si salva
				if(textNstoccateG.getText().equals("")||textMaxAtleti.getText().equals("")||textPercentualeEliminati.getText().equals("")||textNstoccateEliminazione.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Errore: non lasciare campi vuoti ", "Errore", JOptionPane.ERROR_MESSAGE);
				}
				else {
					//si fa la set degli attributi 
					try {
					profencer.ModificaFormulaGara(Integer.parseInt(textPercentualeEliminati.getText()),Integer.parseInt(textNstoccateEliminazione.getText()),Integer.parseInt(textNstoccateG.getText()), Integer.parseInt(textMaxAtleti.getText()));
					//JOptionPane.showMessageDialog(null, "Bravo ", "XD", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btnConferma.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConferma.setBounds(502, 361, 195, 59);
		frame.getContentPane().add(btnConferma);
	}
}
