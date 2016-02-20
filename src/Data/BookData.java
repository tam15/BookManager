package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookData {
	
    //instance variables
	private User user;
	
	//Queries
	private static final String LOAD = "SELECT * FROM Books WHERE OwnerID = ?";
	private static final String INSERT =  "INSERT INTO Books"
			+ "(OwnerID, Title, Author, Edition ,Read ,IBSN) VALUES"
			+ "(?,?,?,?,?,?)";
	private static final String DELETE = "DELETE From Books WHERE Title = ?";
	
	public BookData(User u){
		user = u;
	}
	
	
	//Loads all Books
	
	public ArrayList<Book> loadAllBooks(){
		Connection conn = SQLConnection.databaseConnect();
		ArrayList<Book> tempCards = new ArrayList<Book>();
		try {
			PreparedStatement pst = conn.prepareStatement(LOAD);
			pst.setInt(1, user.getID());
			ResultSet rs = pst.executeQuery();
			tempCards = processResults(rs);
			conn.close();
		} catch (SQLException e) {			
			System.err.println(e);
		}
		return tempCards;		
	}
	
	//TODO
	public void insertIntoBooks(Book b){
		Connection conn = SQLConnection.databaseConnect();
		try{
			PreparedStatement pst = conn.prepareStatement(INSERT);
			pst.setInt(1, user.getID());
			pst.setString(2, b.getTitle());
			pst.setString(3, b.getAuthor());
			pst.setString(4, b.getEdition());
			pst.setBoolean(5, b.getRead());
			pst.setString(6, b.getIBSN());
			pst.executeUpdate();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//TODO
	public void deleteBookByName(String name){
		Connection conn = SQLConnection.databaseConnect();
		try{
			PreparedStatement pst = conn.prepareStatement(DELETE);
			pst.setString(1, name);
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//TODO 
	public void filterBooksByName(String Name){
		user.getCardList();
	}


   public ArrayList<Book> processResults(ResultSet rs){
	   ArrayList<Book> tempCards = new ArrayList<Book>();
	   try {
		while(rs.next()){
				int id = rs.getInt("BookID");
				int oID = rs.getInt("OwnerID");
				String title = rs.getString("Title");
				String author = rs.getString("Author");
				String edition = rs.getString("Edition");
				boolean read = rs.getBoolean("Read");
				String ibsn = rs.getString("IBSN");								
				Book book = new Book(id, oID,title, author, edition, read
						,ibsn);
				tempCards.add(book);
		   }
	} catch (SQLException e) {
		e.printStackTrace();
	}
	   return tempCards;
	   
	}
   }
