package prova;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class FrameCreazioneCompetizione extends JFrame {

	JFrame frame;
	private JTextField textNomeCodice;

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
	public FrameCreazioneCompetizione () {
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
		boxCategoria.setModel(new DefaultComboBoxModel(new String[] {"", "under 14", "under 18", "ciao"}));
		boxCategoria.setToolTipText("");
		boxCategoria.setBounds(215, 153, 96, 21);
		frame.getContentPane().add(boxCategoria);
		
		JDateChooser selezionaData = new JDateChooser();
		selezionaData.setBounds(215, 95, 117, 19);
		frame.getContentPane().add(selezionaData);
		
		JLabel lblErrorCodice = new JLabel("");
		lblErrorCodice.setBounds(393, 63, 280, 19);
		frame.getContentPane().add(lblErrorCodice);
		
		JLabel lblErrorCategoria = new JLabel("");
		lblErrorCategoria.setBounds(393, 154, 280, 19);
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
				
		JButton btnConferma = new JButton("Conferma");
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date currentDate = new Date();
				lblErrorCodice.setText("");
				lblErrorDescrizione.setText("");
				lblErrorDate.setText("");
				lblErrorCategoria.setText("");
				
				JTextArea textDescrizione = new JTextArea();
				textDescrizione.setRows(1);
				textDescrizione.setBounds(163, 232, 196, 85);
				frame.getContentPane().add(textDescrizione);
				
				
				
				if(textNomeCodice.getText().equals("")||textAreaDescrizione.getText().equals("")||boxCategoria.getSelectedItem().equals("")|| selezionaData.getDate()==null) {
					if (textNomeCodice.getText().equals(""))
						lblErrorCodice.setText("ERRORE; devi compilare il campo");
					if (selezionaData.getDate()==null || selezionaData.getDate().before(currentDate))
						lblErrorDate.setText("ERRORE; devi selezionare una data futura per la gara");
					if (textAreaDescrizione.getText().equals(""))
						lblErrorDescrizione.setText("ERRORE; devi inserire una descrizione");
					if(boxCategoria.getSelectedItem().equals("")) 
						lblErrorCategoria.setText("DEVI SELEZIONARE UNA CATEGORIA");
				}else {
				textDescrizione.setText("BRAVO");
				// chiamare la create di competizione passando codice,descrizione , data , categoria .
				frame.dispose();
				}
			}
		});
		btnConferma.setBounds(87, 351, 159, 46);
		frame.getContentPane().add(btnConferma);
		
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(55, 95, 111, 19);
		frame.getContentPane().add(lblData);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(55, 154, 106, 19);
		frame.getContentPane().add(lblCategoria);
		
		
		
		
		
		
		
		
		
		
		
	}
}
