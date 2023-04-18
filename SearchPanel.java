package com.cruds.swingproj;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SearchPanel extends JPanel 
{
	JTable table;
	JTextField txttitle;
	JLabel lbltitle;
	JTextField txtcategory;
	JLabel lblcategory;
	JTextField txtname;
	JLabel lblname;
	JScrollPane scrollpane;
	JButton btnsearch;
	JButton btnsearch1;
	JButton btnsearch2;
	JButton btnhome;
	Vector<Vector<String>> data;
	Vector<String> colNames;
	BookDAO dao = new BookDAO();

	public SearchPanel()
	{
		colNames = new Vector<>();
		lblcategory = new JLabel("Search Category");
		txtcategory = new JTextField(7);
		lbltitle = new JLabel("Search Title");
		txttitle = new JTextField(7);
		lblname = new JLabel("Search Author Name");
		txtname = new JTextField(7);

		colNames.add("ISBN");
		colNames.add("Title");
		colNames.add("Category");
		colNames.add("No of Books");
		table = new JTable(data,colNames);
		scrollpane = new JScrollPane(table);
		
		btnsearch = new JButton("Search");
		btnsearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dao.getBookByAuthor(txtname.getText());
				table.setModel(new DefaultTableModel(dao.getBookByAuthor(txtname.getText()),colNames));
				
			}
		}); 
		
		btnsearch1 = new JButton("Search");
		btnsearch1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dao.getBookByAuthor(txttitle.getText());
				table.setModel(new DefaultTableModel(dao.getBookByTitle(txttitle.getText()),colNames));
				
			}
		}); 
		
		btnsearch2 = new JButton("Search");
		btnsearch2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dao.getBookByAuthor(txtcategory.getText());
				table.setModel(new DefaultTableModel(dao.getBookByCategory(txtcategory.getText()),colNames));
				
			}
		}); 
		
		btnhome = new JButton("Home");
		btnhome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) getParent().getLayout();
				card.show(getParent(),"HOMEPANEL");
				
			}
		});
		


		add(lblcategory);
		add(txtcategory);
		add(btnsearch2);
		add(lbltitle);
		add(txttitle);
		add(btnsearch1);
		add(lblname);
		add(txtname);
		add(btnsearch);
		add(scrollpane);
		add(btnhome);

	}
}
