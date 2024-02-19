package Main.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrameEliminazioneDiretta {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameEliminazioneDiretta window = new FrameEliminazioneDiretta();
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
	public FrameEliminazioneDiretta() {
		List<String> assalti= new ArrayList<String>();
    	assalti.add("assalto 1");
	    assalti.add("assalto 2");
	    assalti.add("assalto 3");
	    assalti.add("assalto 1");
	    assalti.add("assalto 2");
	    assalti.add("assalto 3");
	    assalti.add("assalto 1");
	    assalti.add("assalto 2");
	    assalti.add("assalto 3");
	    assalti.add("assalto 1");
	    assalti.add("assalto 2");
	    assalti.add("assalto 3");
	    assalti.add("assalto 1");
	    assalti.add("assalto 2");
	    assalti.add("assalto 3");
	    assalti.add("assalto 1");
	    assalti.add("assalto 2");
	    assalti.add("assalto 3");
	    assalti.add("assalto 1");
	    assalti.add("assalto 2");
	    assalti.add("assalto 3");
	    assalti.add("assalto 1");
	    assalti.add("assalto 2");
	    assalti.add("assalto 3");
	    assalti.add("assalto 3");
	    assalti.add("assalto 1");
	    assalti.add("assalto 2");
	    assalti.add("assalto 3");
	    assalti.add("assalto 1");
	    assalti.add("assalto 2");
	    assalti.add("assalto 3");
	    assalti.add("assalto 3");
		initialize(assalti);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(List<String>assalti) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		//frame.setMaximumSize(new Dimension(600,400));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel label = new JLabel("Tabellone eliminazione diretta");
        frame.add(label,BorderLayout.NORTH);
        
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
       // frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        for (String assalto : assalti) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
            panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50)); // Imposta la dimensione massima del pannello

            JLabel label1 = new JLabel(assalto);
            JLabel label2 = new JLabel("giocatore 2");
            label1.setBorder(new EmptyBorder(0, 0, 0, 20));
            label2.setBorder(new EmptyBorder(0, 0, 0, 20)); 
            panel.add(label1);
            panel.add(label2);
            
            JTextField punteggio1Field = new JTextField(String.valueOf("0"));
            punteggio1Field.setEditable(false); // Rende il campo di testo non modificabile
            JTextField punteggio2Field = new JTextField(String.valueOf("0"));
            punteggio2Field.setEditable(false); // Rende il campo di testo non modificabile
            JTextField tempoField = new JTextField("oggi");
            tempoField.setEditable(false); // Rende il campo di testo non modificabil

            panel.add(punteggio1Field);
            panel.add(punteggio2Field);
            panel.add(tempoField);

            mainPanel.add(panel);
        }
        JScrollPane ScrollPane= new JScrollPane(mainPanel);
        frame.add(ScrollPane);
        JButton confermaButton = new JButton("Conferma");
        confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.add(confermaButton, BorderLayout.SOUTH);
        frame.setMinimumSize(new Dimension(500,400));
       
      
	}

}
