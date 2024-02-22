package Main.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Main.domain.ProFencer;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameMenuRanking {

	JFrame frame;

	
	public FrameMenuRanking(ProFencer profencer) {
		initialize(profencer);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ProFencer profencer) {
		frame = new JFrame();
		frame.setBounds(100, 100, 620, 460);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Crea Ranking");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrameRanking fr= new FrameRanking(profencer,true);
				if(!fr.errore)
					fr.frame.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(179, 83, 224, 59);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Visualizza Ranking");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameRanking fr= new FrameRanking(profencer,false);
				fr.frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(184, 224, 224, 59);
		frame.getContentPane().add(btnNewButton_1);
	}
}
