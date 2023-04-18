package com.cruds.swingproj;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class HomePanel extends JPanel{
	
	JButton btncreateBook;
	JButton btnlistallBook;
	JButton btnsearchBook;
	JButton btncreateStudent;
	JButton btnstudentDetails;
	JButton btnbookissue;
	
	public HomePanel()
	{
		btncreateBook = new JButton("Create Book");
		btncreateBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) getParent().getLayout();
				card.show(getParent(),"CREATEPANEL");
				
			}
		});
		
		btnlistallBook = new JButton("List all the Books");
		btnlistallBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) getParent().getLayout();
				card.show(getParent(),"DISPLAYPANEL");
				
			}
		});
		
		
		btnsearchBook = new JButton("Search Book based on ");
		btnsearchBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) getParent().getLayout();
				card.show(getParent(),"SEARCHPANEL");
			
			}
		});
		
		
		btncreateStudent = new JButton("Create Student");
		btncreateStudent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout card = (CardLayout) getParent().getLayout();
				card.show(getParent(), "STUDENTPANEL");
				
			}
		});
		
		btnstudentDetails = new JButton("Display Students");
		btnstudentDetails.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout card = (CardLayout) getParent().getLayout();
				card.show(getParent(), "STUDENTDISPLAY");
				
			}
		});
		
		btnbookissue = new JButton("Book Issue");
		btnbookissue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) getParent().getLayout();
				card.show(getParent(), "BOOKISSUE");
				
			}
		});
		
		add(btncreateBook);
		add(btnlistallBook);
		add(btnsearchBook);
		add(btncreateStudent);
		add(btnstudentDetails);
		add(btnbookissue);
	}
}
