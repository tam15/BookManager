package Data;

public class Book {
	
	private int bookID;
	private int ownerID;
	private String title;
	private String author;
	private String edition;
	private boolean read;
	private String ibsn;
	
	
	public Book(int bID, int oID,String t, String a, String e, boolean r
			    ,String i){
		bookID = bID;
		ownerID = oID;
		title = t;
		author = a;
		edition = e;
		read = r;
		ibsn = i;	
	}
	
	//second constructor for when inserting into database (do not know book ID yet, until JPA implementation)
	public Book(int id,String t, String a, String e, boolean r, String i) {
		bookID = id;
		title = t;
		author = a;
		edition = e;
		read = r;
		ibsn = i;	
	}

	public int getBookID(){
		return bookID;
	}
	
	public int getOwnerID(){
		return ownerID;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public String getEdition(){
		return edition;
	}
	
	public boolean getRead(){
		return read;
	}
	
	public String getIBSN(){
		return ibsn;
	}
	
	public String toString(){
		return "ID = " + bookID + " UserID = " + ownerID + " Title = " + title;
	}

}
