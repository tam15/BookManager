package Front_end;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Data.User;

import javax.swing.JLabel;

public class ControlPanel extends JPanel {
	private JTextField txtSearchABook;
	private User user;
	private MainPanel mainPanel;
	private CreateBookFrame createBook;

	/**
	 * Create the panel.
	 */
	public ControlPanel(User u) {
        user = u;
		init();
		setLayout(null);
		
	}
	
	public void init(){
		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logoutButton.setBounds(35, 31, 89, 23);
		add(logoutButton);
		
		JButton addBookButton = new JButton("Add Book");
		addBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createBook = new CreateBookFrame(user);
				createBook.setVisible(true);
			}
		});
		addBookButton.setBounds(182, 12, 147, 23);
		add(addBookButton);
		
		JButton btnViewAllBooks = new JButton("View All Books");
		btnViewAllBooks.setBounds(182, 46, 147, 23);
		add(btnViewAllBooks);
		
		
		txtSearchABook = new JTextField();
		txtSearchABook.setText("search a book!...");
		txtSearchABook.setBounds(109, 80, 147, 23);
		add(txtSearchABook);
		txtSearchABook.setColumns(10);
		
		JButton searchButton = new JButton("Go!");

		searchButton.setBounds(266, 80, 147, 23);
		add(searchButton);
		
		JLabel userName = new JLabel();
		try{
		String name = user.getFirstName();
		userName.setText(name);
		userName.setBounds(35, 16, 89, 14);
		add(userName);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
