package Main.ui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Font;
import Main.domain.*;

public class FrameCreazioneCompetizione extends JFrame {

	JFrame frame;
	private JTextField textNomeCodice;
	private JPanel contentPane;
	private JTextField textArma;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public FrameCreazioneCompetizione (ProFencer profencer,int codiceCompetizione) {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 732, 503);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCodiceNome = new JLabel("Inserire nome");
		lblCodiceNome.setBounds(55, 60, 111, 25);
		frame.getContentPane().add(lblCodiceNome);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setBounds(55, 251, 111, 25);
		frame.getContentPane().add(lblDescrizione);
		
		textNomeCodice = new JTextField();
		textNomeCodice.setBounds(215, 63, 96, 19);
		frame.getContentPane().add(textNomeCodice);
		textNomeCodice.setColumns(10);
		textNomeCodice.getText();
		
		JComboBox boxCategoria = new JComboBox();
		boxCategoria.setModel(new DefaultComboBoxModel(new String[] {"", "under 14", "under 18", "under 21"}));
		boxCategoria.setToolTipText("");
		boxCategoria.setBounds(215, 187, 96, 21);
		frame.getContentPane().add(boxCategoria);
		
		JDateChooser selezionaData = new JDateChooser();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		selezionaData.setDateFormatString(sdf.toPattern());
		selezionaData.setBounds(215, 95, 117, 19);
		frame.getContentPane().add(selezionaData);
		
		JLabel lblErrorCodice = new JLabel("");
		lblErrorCodice.setBounds(393, 63, 280, 19);
		frame.getContentPane().add(lblErrorCodice);
		
		JLabel lblErrorCategoria = new JLabel("");
		lblErrorCategoria.setBounds(393, 189, 280, 19);
		frame.getContentPane().add(lblErrorCategoria);
		
		JLabel lblErrorDescrizione = new JLabel("");
		lblErrorDescrizione.setBounds(421, 257, 252, 19);
		frame.getContentPane().add(lblErrorDescrizione);
			
		JTextArea textAreaDescrizione = new JTextArea();
		textAreaDescrizione.setLineWrap(true);
		textAreaDescrizione.setBounds(169, 232, 190, 76);
		frame.getContentPane().add(textAreaDescrizione);

		JTextArea lblErrorDate = new JTextArea();
		lblErrorDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblErrorDate.setCaretColor(new Color(0, 0, 0));
		lblErrorDate.setLineWrap(true);
		lblErrorDate.setBackground(new Color(240, 240, 240));
		lblErrorDate.setBounds(376, 91, 236, 53);
		frame.getContentPane().add(lblErrorDate);
		
		JTextArea textDescrizione = new JTextArea();
		textDescrizione.setRows(1);
		textDescrizione.setBounds(163, 232, 196, 85);
		frame.getContentPane().add(textDescrizione);
		
		textArma = new JTextField();
		textArma.setColumns(10);
		textArma.setBounds(215, 158, 96, 19);
		frame.getContentPane().add(textArma);
		
		JLabel lblErrorArma = new JLabel("");
		lblErrorArma.setBounds(393, 159, 280, 19);
		frame.getContentPane().add(lblErrorArma);
		
				
		JButton btnConferma = new JButton("Conferma");
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date currentDate = new Date();
				lblErrorCodice.setText("");
				lblErrorDescrizione.setText("");
				lblErrorDate.setText("");
				lblErrorCategoria.setText("");
				
				
				if(textNomeCodice.getText().equals("")||textAreaDescrizione.getText().equals("")||boxCategoria.getSelectedItem().equals("")|| selezionaData.getDate()==null||selezionaData.getDate().before(currentDate)||textArma.getText().equals("")) {
					if (textNomeCodice.getText().equals(""))
						lblErrorCodice.setText("ERRORE; devi compilare il campo");
					if (selezionaData.getDate()==null || selezionaData.getDate().before(currentDate))
						lblErrorDate.setText("ERRORE; devi selezionare una data futura per la gara");
					if (textAreaDescrizione.getText().equals(""))
						lblErrorDescrizione.setText("ERRORE; devi inserire una descrizione");
					if(boxCategoria.getSelectedItem().equals("")) 
						lblErrorCategoria.setText("DEVI SELEZIONARE UNA CATEGORIA");
					if(textArma.getText().equals(""))
						lblErrorArma.setText("Errore, inserire un arma");
					//si dovrebbe controllare se Codice/nome è già presnte nel file(?) o database dove abbiamo conservati le competizioni già create.
					//si aggiorna sto file o database solo a fine caso d'uso in modo tale che se le specifiche non sono state inserite corretaemtne la prima volta l'utente possa riprovare a metterle.
				}else {
		            try {
				profencer.InserimentoDatiCompetizione(textNomeCodice.getText(), textAreaDescrizione.getText(), currentDate,boxCategoria.getSelectedItem().toString(), textArma.getText());
				
				//da controllare il metodo sopra, ha ancora float quota e non presenta indirizzo invece ha arma
				
				//controllo se i valori sono già stati inseriti bisogna non creare l'oggetto, cioè se ha sbagliato le specifiche 
				//e rimette gli stessi dati per la competizione non dobbiamo creare run nuovo oggettto ma solo passare all'aggiunta specifiche.
				
				//quindi qui va messo un if in cui si controllano tutti i campi per vedere se esite già in memoria l'oggetto con quei campi, se esite si passa alle specifiche, se non esiste si crea 
				// chiamare la create di competizione passando codice,descrizione , data , categoria 
				// bisogna mostrare una schermata per specificare la formula di gara.
				
				
				int NstoccateG=Integer.parseInt((JOptionPane.showInputDialog(contentPane,"Inserisci numero di stoccate per i gironi :\n","specifiche",JOptionPane.PLAIN_MESSAGE)));
				int eliminati=Integer.parseInt((JOptionPane.showInputDialog(contentPane,"Inserisci percentuale di elimnati in formato intero:\n","specifiche",JOptionPane.PLAIN_MESSAGE)));
				int NstoccateE=Integer.parseInt((JOptionPane.showInputDialog(contentPane,"Inserisci numero di stoccate per la fase ad eliminazione:\n","specifiche",JOptionPane.PLAIN_MESSAGE)));
				int MacAtleti=Integer.parseInt((JOptionPane.showInputDialog(contentPane,"Inserisci il numero massimo di atleti:\n","specifiche",JOptionPane.PLAIN_MESSAGE)));
				//se clicco sulla X da un eccezzione, provare a risolvere ? inoltre da eccezzioni pure se si inseriscono caratteri, bisogna gestirlo?
					if(NstoccateG>=0 && eliminati>=0&&NstoccateE>=0 && MacAtleti>=0) {
						//si settano le specifiche a competizione e si chiude la finestra
						//si salva la competizione creata in qualche posto
						profencer.ScegliFormulaGara(MacAtleti, eliminati, NstoccateE, NstoccateG);
						profencer.ConfermaInserimento();
						frame.dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Errore: Non è possibile inserire 0 in nessuno dei campi. Riprova ", "Errore", JOptionPane.ERROR_MESSAGE);
					}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
				}				
				}
			}
		});
		btnConferma.setBounds(87, 351, 159, 46);
		frame.getContentPane().add(btnConferma);
		
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(65, 95, 111, 19);
		frame.getContentPane().add(lblData);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(60, 188, 106, 19);
		frame.getContentPane().add(lblCategoria);
		
		JLabel lblIndirizzo = new JLabel("Arma:");
		lblIndirizzo.setBounds(62, 165, 45, 13);
		frame.getContentPane().add(lblIndirizzo);
		
		
		
		
	}

}
