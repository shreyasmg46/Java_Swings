package com.cruds.swingproj;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Navigation extends JFrame 

{
	private JPanel mainpanel;
	
	public Navigation()
	{
		setTitle("Book Management System");
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		mainpanel = new JPanel();
		mainpanel.setLayout(new CardLayout());
		
		mainpanel.add(new HomePanel(), "HOMEPANEL");
		mainpanel.add(new CreateBookPanel(), "CREATEPANEL");
		mainpanel.add(new DisplayBookPanel(), "DISPLAYPANEL");
		mainpanel.add(new SearchPanel(), "SEARCHPANEL");
		mainpanel.add(new CreateStudentPanel(), "STUDENTPANEL");
		mainpanel.add(new StudentDisplayPanel(), "STUDENTDISPLAY");
		mainpanel.add(new Book_IssuePanel(), "BOOKISSUE");
		add(mainpanel);
		setVisible(true);
	}

	public static void main(String[] args) {
		
		new Navigation();
	}

}
