package Main.ui;


import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import Main.domain.ProFencer;  // cosi la classe ProFencer

public class MainFrameUDG {

	private JFrame frame;
	private JPanel contentPane;
	private static ProFencer profencer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameUDG window = new MainFrameUDG();
					window.frame.setVisible(true);
					profencer=ProFencer.getInstance();
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
				
				try {
				int s=Integer.parseInt(JOptionPane.showInputDialog(contentPane,"Inserisci codice/ nome della competizione:\n","inserimento competizione",JOptionPane.PLAIN_MESSAGE));
				
					try {
					profencer.SelezionaCompetizione(s);
					//System.out.println("bravo codice buono");
					//la funziona SelezionaCompetizione mi dovrebbe far capire se è stata selezionata o meno 
					//System.out.println("allora la competizione corrente adesso :" +profencer.getCompetizioneCorrente());
					//System.out.println("allora la competizione corrente adesso :" +profencer.getCompetizioneCorrente().getCodCompetizione());
					//System.out.println("allora la competizione corrente adesso :" +profencer.getCompetizioneCorrente().getArma());
					if(profencer.getCompetizioneCorrente()==null) {
						JOptionPane.showMessageDialog(null, "Errore: Non è presente una competizione con questo codice ", "Errore", JOptionPane.ERROR_MESSAGE);
						lblCompetizione.setText("nessuna competizione scelta ");
					}else
					lblCompetizione.setText("Competizione attuale: "+String.valueOf(profencer.getCompetizioneCorrente().getCodCompetizione()));
					
					}catch(Exception e) {
						
						JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
						lblCompetizione.setText("nessuna competizione scelta ");
					}
				}catch(Exception e ){
					System.out.println("Eccezzione devi inserire un numero che identifica la competizione");
					lblCompetizione.setText("nessuna competizione scelta ");
				}
				
			}
		});
		btnSelezionaCompetizione.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSelezionaCompetizione.setBounds(35, 101, 363, 65);
		frame.getContentPane().add(btnSelezionaCompetizione);
		
		JButton btnGestioneformula = new JButton("Gestione Formula di gara");
		btnGestioneformula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(profencer.getCompetizioneCorrente()==null) {
					JOptionPane.showMessageDialog(null, "Errore: per modificare una formuladi gara devi selezionare una competizione ", "Errore", JOptionPane.ERROR_MESSAGE);
				}else {
				FrameGestioneFormulaDiGara fgfdg= new FrameGestioneFormulaDiGara(profencer);
				fgfdg.frame.setVisible(true);
				}
			}
		});
		btnGestioneformula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGestioneformula.setBounds(35, 197, 363, 65);
		frame.getContentPane().add(btnGestioneformula);
		
		JButton btnAccettazioneatleti = new JButton("AccettazioneAtleti");
		btnAccettazioneatleti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(profencer.getCompetizioneCorrente()==null) {
					JOptionPane.showMessageDialog(null, "Errore: per accettare degli atleti bisogna selezionare una competizione ", "Errore", JOptionPane.ERROR_MESSAGE);
				}else {
					
					FrameAccettaAtleta faa= new FrameAccettaAtleta(profencer);
					faa.frame.setVisible(true);
				}
				
			}
		});
		btnAccettazioneatleti.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAccettazioneatleti.setBounds(449, 101, 288, 65);
		frame.getContentPane().add(btnAccettazioneatleti);
		
		JButton btnCreazioneGironi = new JButton("Creazione Gironi");
		btnCreazioneGironi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(profencer.getCompetizioneCorrente()==null) {
					JOptionPane.showMessageDialog(null, "Errore: creare i gironi deve essere selezionata una competizione ", "Errore", JOptionPane.ERROR_MESSAGE);
				}else {
				 //si verrifica se nella competizone corrente è presente una lista di atleti accettati , se è minore di 3 si notifica l'errore 
					//se è presente ed è maggiore uguale a 3, cioè caso  positivvo si apre la Frame relatica alla creazione dei gironi della competizione corrente. 
					
					CreazioneGironi fcg= new CreazioneGironi(profencer);
					fcg.frame.setVisible(true);
					//nel frame che apro ci devono esser visualizzati i gironi e per ogni girone gli assalti ordinati che lo compongono
					//come prima cosa si chiama CreazioneGirone() da essa ho bisogno che mi venga restituita la lista dei gironi, in modo tale 
					//che facendo count() ? oppure un foreach di girone su gironi
					//posso diveder la frame nei gironi ed allo stesso tempo ho visogno della lista degli assalti per girone per fare in modo di popolare,
				}
				
			}
		});
		btnCreazioneGironi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCreazioneGironi.setBounds(448, 197, 295, 65);
		frame.getContentPane().add(btnCreazioneGironi);
		
		JButton btnGestioneAssaltiGironi = new JButton("Gestione Assalti Gironi");
		btnGestioneAssaltiGironi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(profencer.getCompetizioneCorrente()==null) {
					JOptionPane.showMessageDialog(null, "Errore: deve essere selezionata una competizione ", "Errore", JOptionPane.ERROR_MESSAGE);
				}else {
					// come verificare se i gironi sono stati creati?
					FrameVisualizzaGironi fvg= new FrameVisualizzaGironi(profencer);
					fvg.frame.setVisible(true);

				}
				
			}
		});
		try {	
		btnGestioneAssaltiGironi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGestioneAssaltiGironi.setBounds(30, 290, 368, 65);
		frame.getContentPane().add(btnGestioneAssaltiGironi);
		
		JButton btnCreazioneEliminazioniDirette = new JButton("Creazione Eliminazioni Dirette");
		btnCreazioneEliminazioniDirette.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//i gironi devono essere finiti e ci deve essere una competizione corrente
				if(profencer.getCompetizioneCorrente()==null) {
					JOptionPane.showMessageDialog(null, "Errore: deve essere selezionata una competizione ", "Errore", JOptionPane.ERROR_MESSAGE);
				}else {
					// come verificare se i gironi sono stati finiti?
					// fa partire il metodo da profencer che crea il tabellone, un attrivuot del tabellone sarà la lista degli assalti ad eleiminazione diretta.
					//io creo la mia frame di visualizzazione de ltabellone passando  eliminazionediretta.listaAssalti, che è una lista assalti
					FrameEliminazioneDiretta fed = new FrameEliminazioneDiretta(profencer);
					fed.frame.setVisible(true);

				}
				
			}
		});
		btnCreazioneEliminazioniDirette.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCreazioneEliminazioniDirette.setBounds(30, 388, 368, 65);
		frame.getContentPane().add(btnCreazioneEliminazioniDirette);
		
		JButton btnGestioneAssaltiEliminazioni = new JButton("Gestione Assalti Eliminazioni");
		btnGestioneAssaltiEliminazioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(profencer.getCompetizioneCorrente()==null) {
					JOptionPane.showMessageDialog(null, "Errore: deve essere selezionata una competizione ", "Errore", JOptionPane.ERROR_MESSAGE);
				}else {
					
					FrameGestioneEliminazioneDiretta fged = new FrameGestioneEliminazioneDiretta(profencer);
					fged.frame.setVisible(true);

				}
				
			}
		});
		
		btnGestioneAssaltiEliminazioni.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGestioneAssaltiEliminazioni.setBounds(448, 388, 295, 65);
		frame.getContentPane().add(btnGestioneAssaltiEliminazioni);
		
		JButton btnClassificaGironi = new JButton("Classifica Gironi");
		btnClassificaGironi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//controllo se effettivaemnte i gironi sono file e se la competizione corrente è stata selezionata
				if(profencer.getCompetizioneCorrente()==null) {
					JOptionPane.showMessageDialog(null, "Errore: deve essere selezionata una competizione ", "Errore", JOptionPane.ERROR_MESSAGE);
				}else {
					// come verificare se i gironi sono stati finiti?
					FrameClassificaGironi fcf= new FrameClassificaGironi(profencer);
					fcf.frame.setVisible(true);

				}
			}
		});
		btnClassificaGironi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClassificaGironi.setBounds(445, 290, 295, 65);
		frame.getContentPane().add(btnClassificaGironi);
		
		JButton btnGesnerazioneRanking = new JButton("Ranking");
		btnGesnerazioneRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(profencer.getCompetizioneCorrente()==null) {
					JOptionPane.showMessageDialog(null, "Errore: per generare un ranking devi aver selezionato una competizione ", "Errore", JOptionPane.ERROR_MESSAGE);
				}else {
					// come verificare se  le eliminazioni sono finete?
					//il raking dovrebbe essere stampare la lista degli atleti della competizione con i valori aggiornati di ranking
					//dalla competizione corrente prendo la lista degli atleti e la stampo
					//prima si dovrebbe chimare la funziona che crea il ranking.
					//poi si passsa alla frame la competiizone corrente o la lista atleti della competizione corrente
					FrameMenuRanking fmr = new FrameMenuRanking(profencer);
					fmr.frame.setVisible(true);
				}
				
			}
		});
		btnGesnerazioneRanking.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGesnerazioneRanking.setBounds(30, 463, 368, 65);
		frame.getContentPane().add(btnGesnerazioneRanking);
		
		JButton btnClassificaFinale = new JButton("Classifica Finale");
		btnClassificaFinale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//non solo la competizioen deve essere selezionata ma deve essere anche finita
				//coem per classifica giorni si passa una lista di atleti quindi credo possa andare bene la stessa frame variando solo la lista in ingressso
				//no cambia il fatto che si tratterà di una lista di atleti e non di atleti girone quindi non si può usare la stessa frame 
				if(profencer.getCompetizioneCorrente()==null) {
					JOptionPane.showMessageDialog(null, "Errore: deve essere selezionata una competizione ", "Errore", JOptionPane.ERROR_MESSAGE);
				}else {
					// come verificare se i gironi sono stati finiti?
					FrameClassificaFinale fcf= new FrameClassificaFinale(profencer);
					fcf.frame.setVisible(true);

				}
				
			}
		});
		btnClassificaFinale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClassificaFinale.setBounds(445, 463, 298, 65);
		frame.getContentPane().add(btnClassificaFinale);
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
	}
		JButton btnAmministratore = new JButton("amministratore");
		btnAmministratore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String s =JOptionPane.showInputDialog(null, "inserisci il codice dell'amministratore ", "Amministratore", JOptionPane.PLAIN_MESSAGE);
				if(s.equals("000")) {
					ProfencerMainAmm pma= new ProfencerMainAmm(profencer);
					pma.frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Errore: codice amministatore sbagliato ", "Errore", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAmministratore.setBounds(364, 10, 147, 21);
		frame.getContentPane().add(btnAmministratore);
		
	
		
	}
}

