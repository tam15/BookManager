package Data;

import java.util.ArrayList;

public class User {
	
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private ArrayList<Book> allBooks = new ArrayList<Book>();
	
	public User(){
		
	}
	
	public User(int i,String e, String fN, String lN
			   ,String pw) {
		id = i;
		email = e;
		firstName = fN;
		lastName = lN;
		password = pw;
	}
	
	public void setCards(ArrayList<Book>c){
		allBooks = c;
	}
	
	public ArrayList<Book> getCardList(){
		return allBooks;
	}
	
	public String toString(){
		return ("email= " + email + " name =  " + firstName);
	}
	
	public void setId(int i){
		id = i;
	}
	
	public int getID(){
		return id;
	}
	
	public void setEmail(String e){
		email = e;
	}
	
	public void setFirstName(String f){
		firstName = f;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setLastName(String l){
		lastName = l;
	}
	
	public void setPassword(String p){
		password = p;
	}

}
