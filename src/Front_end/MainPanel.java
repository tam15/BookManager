package Front_end;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;

import Data.Book;
import Data.BookData;
import Data.User;

import java.awt.Dimension;
import java.util.ArrayList;


public class MainPanel extends JPanel {
	private JTable table;
	private User user;
	private ControlPanel cPanel;
	private BookTable bTable;
	private JScrollPane scroll;
	/**
	 * Create the panel.
	 */
	public MainPanel(User u, ControlPanel c) {
		user = u;
		cPanel = c;
		init();
	}
	
	public void init(){
		setBounds(5,5,441,172);	
		bTable = new BookTable(user);
		table = new JTable(bTable);
	    JScrollPane scrollPane = new JScrollPane(table);
	    add(scrollPane);
	    scrollPane.setVisible(true);
		
	}
}


class BookTable extends AbstractTableModel{
	
	private BookData db;
	private ArrayList<Book> books;

	
	public BookTable(User u){
		db = new BookData(u);
		books = db.loadAllBooks(); 
	}
    
    private String[] columnNames = {
        "Book ID",
        "User ID",
        "Title",
        "Author",
        "Edition",
        "Read",
        "IBSN",
    };

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

	@Override
	public Object getValueAt(int r, int c) {
		Book b = books.get(r);
		switch(c){
		case 0:
			return b.getBookID();
		case 1:
			return b.getOwnerID();
		case 2:
			return b.getTitle();
		case 3:
			return b.getAuthor();
		case 4: 
			return b.getEdition();
		case 5:
			return b.getRead();
		case 6:
			return b.getIBSN();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int c){
		return columnNames[c];
	}
}
  
    

