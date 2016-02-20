package Front_end;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.SQLConnection;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateUser extends JFrame {

	private JPanel contentPane;
	private JTextField fName;
	private JTextField lName;
	private JTextField email;
	private JPasswordField password1;
	private JPasswordField password2;
	private SQLConnection conManage;
	private Connection conn;
	
	
	private static final String CREATE = "INSERT INTO Users"
			+ "(FirstName, LastName, Email, Password) VALUES"
			+ "(?,?,?,?)";
	

	public CreateUser() {
		init();
	}
	
	public void createUser(){
		conn = conManage.databaseConnect();
		try {
			PreparedStatement pst = conn.prepareStatement(CREATE);
			pst.setString(1, fName.getText());
			pst.setString(2, lName.getText());
			pst.setString(3, email.getText());
			pst.setString(4, password1.getText());
			pst.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void init(){
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 264, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fName = new JTextField();
		fName.setBounds(115, 61, 120, 20);
		contentPane.add(fName);
		fName.setColumns(10);
		
		lName = new JTextField();
		lName.setBounds(115, 92, 120, 20);
		contentPane.add(lName);
		lName.setColumns(10);
		
		email = new JTextField();
		email.setBounds(115, 123, 120, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		password1 = new JPasswordField();
		password1.setBounds(115, 159, 120, 20);
		contentPane.add(password1);
		
		password2 = new JPasswordField();
		password2.setBounds(115, 192, 120, 20);
		contentPane.add(password2);
		
		JLabel lblNewLabel = new JLabel("Create User");
		lblNewLabel.setBounds(100, 28, 63, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(28, 64, 70, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(28, 95, 55, 14);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(28, 126, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(28, 162, 61, 14);
		contentPane.add(lblPassword);
		
		JLabel lblReenter = new JLabel("Re-Enter:");
		lblReenter.setBounds(28, 195, 55, 14);
		contentPane.add(lblReenter);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createUser();
				setVisible(false);
			}
		});
		btnCreate.setBounds(89, 237, 89, 23);
		contentPane.add(btnCreate);
	}
	
}

