package com.cruds.swingproj;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Book_IssuePanel extends JPanel
{
	JTable tableUSN;
	JTable tableISBN;
	JTextField txtUSN;
	JLabel lblUSN;
	JTextField txtISBN;
	JLabel lblISBN;
	JButton btnsearchUSN;
	JButton btnsearchISBN;
	JScrollPane spaneUSN;
	JScrollPane spaneISBN;
	JButton btnissue;
	JButton btnhome;

	Vector<String> ColUSN;
	Vector<String> ColISBN;
	BookDAO dao = new BookDAO();
	IssuebookDAO dao1 = new IssuebookDAO();

	public Book_IssuePanel()
	{
		ColUSN = new Vector<>();
		lblUSN = new JLabel("Student USN");
		txtUSN = new JTextField(7);
		ColUSN.add("USN");
		ColUSN.add("Name");

		ColISBN = new Vector<>();
		lblISBN = new JLabel("Book ISBN");
		txtISBN = new JTextField(7);
		ColISBN.add("ISBN");
		ColISBN.add("Title");
		ColISBN.add("Category");
		ColISBN.add("No of Books");
		ColISBN.add("Author Name");
		ColISBN.add("Email ID");
		tableUSN = new JTable(null, ColUSN);
		spaneUSN = new JScrollPane(tableUSN);

		btnsearchUSN = new JButton("Search");
		btnsearchUSN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String strUsn = txtUSN.getText();
				tableUSN.setModel(new DefaultTableModel(dao1.getStudentUSN(strUsn), ColUSN));

			}
		}); 

		tableISBN = new JTable(null, ColISBN);
		spaneISBN = new JScrollPane(tableISBN);
		btnsearchISBN = new JButton("Search");
		btnsearchISBN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String strIsbn = txtISBN.getText();
				tableISBN.setModel(new DefaultTableModel(dao1.getBookISBN(Integer.parseInt(strIsbn)), ColISBN));				
			}

		});
		
		btnissue = new JButton("Issue");
		btnissue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int rowidx = tableUSN.getSelectedRow();
				String strUsn =  (String) tableUSN.getModel().getValueAt(rowidx, 0);
				String strISBN =  (String) tableISBN.getModel().getValueAt(rowidx, 0);

				if(dao1.book_issue(new Student(strUsn),DateUtil.getCurrDateAsSQLDate(),Integer.parseInt(strISBN)))
				{
					JOptionPane.showMessageDialog(parent(), "Book Issued", "Success",JOptionPane.INFORMATION_MESSAGE);

					layout.show(parent(), "LIST STUDENT BOOKS");
				}	
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
		add(lblUSN);
		add(txtUSN);
		add(btnsearchUSN);
		add(lblISBN);
		add(txtISBN);
		add(btnsearchISBN);
		add(spaneISBN);
		add(spaneUSN);
		add(btnissue);
		add(btnhome);
	}
}
