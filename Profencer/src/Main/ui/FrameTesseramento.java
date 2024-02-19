package Main.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FrameTesseramento {

	JFrame frame;
	private JTextField textNome;
	private JTextField textCognome;
	private JTextField textCF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameTesseramento window = new FrameTesseramento();
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
	public FrameTesseramento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 696, 482);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome dell'atleta: ");
		lblNome.setBounds(85, 104, 127, 27);
		frame.getContentPane().add(lblNome);
		
		JLabel lblCognomeDellatleta = new JLabel("Cognome dell'atleta: ");
		lblCognomeDellatleta.setBounds(85, 141, 154, 27);
		frame.getContentPane().add(lblCognomeDellatleta);
		
		JLabel lblCf = new JLabel("CF");
		lblCf.setBounds(85, 178, 127, 27);
		frame.getContentPane().add(lblCf);
		
		JLabel lblDataDiNascita = new JLabel("Data di nascita: : ");
		lblDataDiNascita.setBounds(85, 236, 127, 19);
		frame.getContentPane().add(lblDataDiNascita);
		
		textNome = new JTextField();
		textNome.setBounds(255, 108, 132, 19);
		frame.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		textCognome = new JTextField();
		textCognome.setColumns(10);
		textCognome.setBounds(255, 145, 132, 19);
		frame.getContentPane().add(textCognome);
		
		textCF = new JTextField();
		textCF.setColumns(10);
		textCF.setBounds(255, 182, 132, 19);
		frame.getContentPane().add(textCF);
		
		JDateChooser selezionaDateN = new JDateChooser();
		selezionaDateN.setBounds(255, 236, 132, 19);
		frame.getContentPane().add(selezionaDateN);
		
		JLabel lblErrorCF = new JLabel("");
		lblErrorCF.setBounds(434, 185, 195, 19);
		frame.getContentPane().add(lblErrorCF);
		
		JLabel lblErrorCognome = new JLabel("");
		lblErrorCognome.setBounds(397, 148, 244, 19);
		frame.getContentPane().add(lblErrorCognome);
		
		JLabel lblErrorNome = new JLabel("");
		lblErrorNome.setBounds(403, 111, 238, 19);
		frame.getContentPane().add(lblErrorNome);
		
		JTextArea lblErrorDateN = new JTextArea();
		lblErrorDateN.setLineWrap(true);
		lblErrorDateN.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblErrorDateN.setCaretColor(Color.BLACK);
		lblErrorDateN.setBackground(UIManager.getColor("Button.background"));
		lblErrorDateN.setBounds(424, 234, 229, 53);
		frame.getContentPane().add(lblErrorDateN);
		
		JButton btnConfermatesserametno = new JButton("Conferma");
		btnConfermatesserametno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Date currentDate = new Date();
				Calendar calendar = Calendar.getInstance();
		        calendar.setTime(currentDate);
		        calendar.add(Calendar.YEAR, -10); // sottrai 10 anni
		        Date tenYearsAgo = calendar.getTime(); // crea un nuovo oggetto Date
				
				lblErrorNome.setText("");
				lblErrorCognome.setText("");
				lblErrorDateN.setText("");
				lblErrorCF.setText("");
				
				
				
				if(textNome.getText().equals("")||textCognome.getText().equals("")||textCF.getText().equals("")|| selezionaDateN.getDate()==null||selezionaDateN.getDate().after(tenYearsAgo)) {
					if (textNome.getText().equals(""))
						lblErrorNome.setText("ERRORE; devi compilare il campo");
					if (selezionaDateN.getDate()==null || selezionaDateN.getDate().after(tenYearsAgo))
						lblErrorDateN.setText("ERRORE; devi selezionare una data valida");
					if (textCognome.getText().equals(""))
						lblErrorCognome.setText("ERRORE; devi inserire un cognome");
					if(textCF.getText().equals("")) 
						lblErrorCF.setText("Devi inserire un CF");
					
					// ultimo controllo verificare dove abbiamo salvati i tesserati se risultaa tesserata un persona con tale codice fiscale se si notificare l'errore.
				}else {
					//creare tesseraro con i dati inseriti e conservarlo dove teniamo a dati dei tesserati
					frame.dispose();
				}
								
				
			}
		});
		btnConfermatesserametno.setBounds(203, 327, 114, 27);
		frame.getContentPane().add(btnConfermatesserametno);
		
		JLabel lblTesseramento = new JLabel("Tesseramento");
		lblTesseramento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTesseramento.setBounds(209, 28, 142, 27);
		frame.getContentPane().add(lblTesseramento);
	}
}
