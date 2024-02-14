package prova;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class FrameCreazioneCompetizione {

	JFrame frame;
	private JTextField textNomeCodice;
	private JTextField textDescrizione;
	private JTextField textData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCreazioneCompetizione window = new FrameCreazioneCompetizione();
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
	public FrameCreazioneCompetizione() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 732, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCodiceNome = new JLabel("Inserire nome/codice");
		lblCodiceNome.setBounds(55, 60, 128, 25);
		frame.getContentPane().add(lblCodiceNome);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setBounds(55, 114, 128, 25);
		frame.getContentPane().add(lblDescrizione);
		
		textNomeCodice = new JTextField();
		textNomeCodice.setBounds(205, 63, 96, 19);
		frame.getContentPane().add(textNomeCodice);
		textNomeCodice.setColumns(10);
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.setBounds(276, 344, 159, 46);
		frame.getContentPane().add(btnConferma);
		
		textDescrizione = new JTextField();
		textDescrizione.setBounds(184, 117, 96, 19);
		frame.getContentPane().add(textDescrizione);
		textDescrizione.setColumns(10);
		
		textData = new JTextField();
		textData.setColumns(10);
		textData.setBounds(184, 178, 96, 19);
		frame.getContentPane().add(textData);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(55, 178, 111, 19);
		frame.getContentPane().add(lblData);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(56, 207, 106, 19);
		frame.getContentPane().add(lblCategoria);
		
		JComboBox boxCategoria = new JComboBox();
		boxCategoria.setBounds(184, 207, 96, 21);
		frame.getContentPane().add(boxCategoria);
	}
}
