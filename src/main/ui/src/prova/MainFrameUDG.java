package prova;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrameUDG {

	private JFrame frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameUDG window = new MainFrameUDG();
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
	public MainFrameUDG() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 856, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblTitolo = new JLabel("Profencer\r\n");
		lblTitolo.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblTitolo.setBounds(30, 26, 234, 55);
		frame.getContentPane().add(lblTitolo);
		
		JLabel lblCompetizione = new JLabel("nessuna competizione scelta ");
		lblCompetizione.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCompetizione.setBounds(601, 47, 204, 19);
		frame.getContentPane().add(lblCompetizione);
		
		JButton btnSelezionaCompetizione = new JButton("Seleziona Competizione");
		btnSelezionaCompetizione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String s=(String) JOptionPane.showInputDialog(contentPane,"Inserisci codice/ nome della competizione:\n","inserimento competizione",JOptionPane.PLAIN_MESSAGE);
				//ora si controlla se esiste una cometizione con questo nome/codie se si si imposta questa competizione nella label
				//in teoria bisognerebbe ciclare alla ricerca di tale competizione e se trovata si rende corrente ?
				if(s.equals("")) {
					JOptionPane.showMessageDialog(null, "Errore: Non è presente una competizione con questo nome/codice ", "Errore", JOptionPane.ERROR_MESSAGE);
					lblCompetizione.setText("nessuna competizione scelta ");
				}else {
					lblCompetizione.setText(s);
				}
			}
		});
		btnSelezionaCompetizione.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSelezionaCompetizione.setBounds(35, 101, 363, 65);
		frame.getContentPane().add(btnSelezionaCompetizione);
		
		JButton btnGestioneformula = new JButton("Gestione Formula di gara");
		btnGestioneformula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(lblCompetizione.getText().equals("nessuna competizione scelta ")) {
					JOptionPane.showMessageDialog(null, "Errore: per modificare una formuladi gara devi selezionare una competizione ", "Errore", JOptionPane.ERROR_MESSAGE);
				}else {
				FrameGestioneFormulaDiGara fgfdg= new FrameGestioneFormulaDiGara(lblCompetizione.getText());
				fgfdg.frame.setVisible(true);
				}
			}
		});
		btnGestioneformula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGestioneformula.setBounds(35, 197, 363, 65);
		frame.getContentPane().add(btnGestioneformula);
		
		JButton btnAccettazioneatleti = new JButton("AccettazioneAtleti");
		btnAccettazioneatleti.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAccettazioneatleti.setBounds(449, 101, 288, 65);
		frame.getContentPane().add(btnAccettazioneatleti);
		
		JButton btnCreazioneGironi = new JButton("Creazione Gironi");
		btnCreazioneGironi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCreazioneGironi.setBounds(448, 197, 295, 65);
		frame.getContentPane().add(btnCreazioneGironi);
		
		JButton btnGestioneAssaltiGironi = new JButton("Gestione Assalti Gironi");
		btnGestioneAssaltiGironi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGestioneAssaltiGironi.setBounds(30, 290, 368, 65);
		frame.getContentPane().add(btnGestioneAssaltiGironi);
		
		JButton btnCreazioneEliminazioniDirette = new JButton("Creazione Eliminazioni Dirette");
		btnCreazioneEliminazioniDirette.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCreazioneEliminazioniDirette.setBounds(30, 388, 368, 65);
		frame.getContentPane().add(btnCreazioneEliminazioniDirette);
		
		JButton btnGestioneAssaltiEliminazioni = new JButton("Gestione Assalti Eliminazioni");
		btnGestioneAssaltiEliminazioni.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGestioneAssaltiEliminazioni.setBounds(448, 388, 295, 65);
		frame.getContentPane().add(btnGestioneAssaltiEliminazioni);
		
		JButton btnClassificaGirone = new JButton("Classifica Girone");
		btnClassificaGirone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnClassificaGirone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClassificaGirone.setBounds(445, 290, 295, 65);
		frame.getContentPane().add(btnClassificaGirone);
		
		JButton btnGesnerazioneRanking = new JButton("Gesnerazione Ranking");
		btnGesnerazioneRanking.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGesnerazioneRanking.setBounds(30, 463, 368, 65);
		frame.getContentPane().add(btnGesnerazioneRanking);
		
		JButton btnClassificaFinale = new JButton("Classifica Finale");
		btnClassificaFinale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClassificaFinale.setBounds(445, 463, 298, 65);
		frame.getContentPane().add(btnClassificaFinale);
		
	
		
	}

}
