package Front_end;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.User;

public class CreateBookFrame extends JFrame {

   CreateBookPanel cBPanel;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public CreateBookFrame(User u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 399);
	
		
		cBPanel = new CreateBookPanel(u);
		cBPanel.setBounds(10, 11, 313, 338);
		this.getContentPane().add(cBPanel);
	}
}
