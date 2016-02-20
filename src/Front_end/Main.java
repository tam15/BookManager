package Front_end;

import java.sql.Connection;

import Data.SQLConnection;

public class Main {
	
	private static Login login;
	private static MainFrame mainFrame;
	private static boolean loggedIn;
	private static CreateUser create;
	
	
	public Main(){
		loggedIn = false;
	}

	public static void main(String[] args) {
		login = new Login();
		while(!login.getLoggedIn()){
			create = new CreateUser();
		}
		login.setVisible(false);
		mainFrame=new MainFrame(login.getUser());
		mainFrame.setVisible(true);
		
	}

}
