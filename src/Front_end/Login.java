package Front_end;
import javax.swing.JFrame;

import Data.SQLConnection;
import Data.User;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Thomas Mills
 */

public class Login extends JFrame {
    
    private Dimension size;
    private LoginPanel panel;
    private Connection conn;
    private User loggedUser;
    private boolean loggedIn;
    
    private static final String LOGIN
    = "SELECT * FROM Users WHERE Email=? and Password=?";
    
    public  Login(){
        init();
    }
    
    public void setLoggedIn(boolean b){
    	loggedIn=b;
    }
    
    public boolean getLoggedIn(){
    	return loggedIn;
    }
    
    public void logIn(){
    	
        conn = SQLConnection.databaseConnect();
       
        try {
			PreparedStatement pst = conn.prepareStatement(LOGIN);
			pst.setString(1, getPanel().getEmail());		
			pst.setString(2, getPanel().getPassword());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){		
				User currentUser = new User();
				currentUser.setId(rs.getInt("UID"));
				currentUser.setEmail(rs.getString("Email"));
				currentUser.setFirstName(rs.getString("FirstName"));
				currentUser.setLastName(rs.getString("LastName"));
				currentUser.setPassword(rs.getString("Password"));
				loggedUser=currentUser;
				setLoggedIn(true);
			}
			rs.close();
			conn.close();
			}catch(Exception e){
				System.err.println(e);
				
			}
    }
    
    public String getUserName(){
    	return "Welcome " + loggedUser.getFirstName();
    }
    
    
    public LoginPanel getPanel(){
    	return panel;
    }
    
    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Set size
        size = new Dimension(252, 138);
        this.getContentPane().setPreferredSize(size);
        
        this.setBounds(600,250,266,143);
      
        panel = new LoginPanel(this);
        getContentPane().add(panel);
        panel.setVisible(true);
        this.setVisible(true);
        pack();
    }

	public User getUser() {
		return loggedUser;
	}


}