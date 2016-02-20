package Front_end;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import Data.Book;
import Data.BookData;
import Data.User;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class MainFrame extends JFrame {

	private MainPanel mainPanel;
	private Dimension size = new Dimension(800,600);
	private Dimension menuSize = new Dimension(440,120);
	private ControlPanel controlPanel;
	private User user;


	public MainFrame(User u){
		user = u;
		init();		
	}
	
	public void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(size);
		setBounds(100, 100, 472, 341);
		controlPanel = new ControlPanel(user);
		controlPanel.setBounds(5, 177, 441, 120);
		controlPanel.setPreferredSize(menuSize);
		getContentPane().add(controlPanel,BorderLayout.SOUTH);	
		
		mainPanel=new MainPanel(user,controlPanel);
		getContentPane().add(mainPanel, BorderLayout.NORTH);
		mainPanel.setVisible(true);
		
	}

}
