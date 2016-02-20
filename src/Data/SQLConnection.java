package Data;

import java.sql.*;
import javax.swing.*;

public class SQLConnection {
	 Connection on = null;
	public static Connection databaseConnect(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(
					"jdbc:sqlite:C:\\Users\\Tom\\workspace\\Card Reader\\Resources\\Books.sqlite");
			return con;	
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
}