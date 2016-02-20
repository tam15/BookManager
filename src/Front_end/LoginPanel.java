package Front_end;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Dimension;
import javax.swing.JTextField;

import Data.User;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author Tom
 */
public class LoginPanel extends JPanel {
    private Dimension bounds;
    private JTextField email;
    private JPasswordField password;
    private boolean loggedIn;
    private Login login;
    private JButton btnNewButton;
    private CreateUser create = new CreateUser();
    
    
    public LoginPanel(Login l){
        login = l;
        init();
        loggedIn=false;   
    }
    
    public void setLoggedIn(boolean b){
    	loggedIn = b;
    }
    
    public boolean isLoggedIn(){
    	if(loggedIn==true){
    		return true;
    	}else{
    		return false;
    	}
    		
    }
    
    public String getEmail(){
    	return email.getText();
    }
    
    public String getPassword(){
    	return password.getText();
    }
    
    private void init(){
        
        // Set size
        bounds = new Dimension(100,80);
        this.setSize(new Dimension(252, 138));
        setLayout(null);
        
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		login.logIn();
        		System.out.println(login.getLoggedIn());
        	}
        });

   
        loginButton.setBounds(77, 76, 102, 23);
        add(loginButton);
        
        email = new JTextField();
        email.setToolTipText("Enter Email");
        email.setBounds(56, 21, 150, 20);
        add(email);
        email.setColumns(10);
        
        password = new JPasswordField();
        password.setToolTipText("password");
        password.setEchoChar('*');
        password.setBounds(56, 52, 150, 20);
        add(password);
        
        btnNewButton = new JButton("Create User");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		create.setVisible(true);
        	}
        });
        btnNewButton.setBounds(77, 104, 102, 23);
        add(btnNewButton);
    }
}
