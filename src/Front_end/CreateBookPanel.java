package Front_end;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Data.Book;
import Data.BookData;
import Data.User;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateBookPanel extends JPanel {
	private BookData db;
	private JTextField titleTxt;
	private JTextField authorTxt;
	private JTextField editionTxt;
	private JTextField ibsnTxt;
	private User user;

	/**
	 * Create the panel.
	 */
	public CreateBookPanel(User u) {
		user = u;
		db = new BookData(user);
		init();
	}
	
	public void init(){
		Dimension size = new Dimension(313, 338);
		this.setPreferredSize(new Dimension(313, 287));
		setLayout(null);
		
		JLabel lblCreateBook = new JLabel("Create Book");
		lblCreateBook.setBounds(122, 22, 59, 14);
		add(lblCreateBook);
		
		JLabel titleLbl = new JLabel("Title:");
		titleLbl.setBounds(36, 67, 46, 14);
		add(titleLbl);
		
		JLabel authorLbl = new JLabel("Author:");
		authorLbl.setBounds(36, 102, 46, 14);
		add(authorLbl);
		
		JLabel editionLbl = new JLabel("Edition:");
		editionLbl.setBounds(36, 139, 46, 14);
		add(editionLbl);
		
		JLabel readLbl = new JLabel("Read:");
		readLbl.setBounds(36, 173, 46, 14);
		add(readLbl);
		
		JLabel ibsnLbl = new JLabel("IBSN:");
		ibsnLbl.setBounds(36, 204, 46, 14);
		add(ibsnLbl);
		
		titleTxt = new JTextField();
		titleTxt.setBounds(92, 64, 175, 20);
		add(titleTxt);
		titleTxt.setColumns(10);
		
		authorTxt = new JTextField();
		authorTxt.setBounds(92, 99, 175, 20);
		add(authorTxt);
		authorTxt.setColumns(10);
		
		editionTxt = new JTextField();
		editionTxt.setBounds(92, 136, 86, 20);
		add(editionTxt);
		editionTxt.setColumns(10);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setBounds(88, 169, 51, 23);
		add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(141, 169, 46, 23);
		add(rdbtnNo);
		
		ibsnTxt = new JTextField();
		ibsnTxt.setBounds(92, 201, 175, 20);
		add(ibsnTxt);
		ibsnTxt.setColumns(10);
		
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(user.getID());
				int id = user.getID();
				System.out.println(id);
				String t = titleTxt.getText();
				String a = authorTxt.getText();
				String e = editionTxt.getText();
				boolean r;
				if(rdbtnYes.isSelected())
					r = true;
				else
					r = false;
				String i = ibsnTxt.getText();
				Book b = new Book(id,t,a,e,r,i);
				db.insertIntoBooks(b);
				
			}
		});
		addBtn.setBounds(102, 232, 89, 23);
		add(addBtn);
	}
}
