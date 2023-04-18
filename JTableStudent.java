package com.cruds.swingproj;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableStudent extends JFrame {

	JTable stable;
	JScrollPane scrollpane;

	Vector<String> colNames;
	Vector<Vector<String>> data;
	BookDAO dao = new BookDAO();
	
	public JTableStudent() {
		setTitle("Student Table");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		colNames = new Vector<>();
		colNames.add("Student USN");
		colNames.add("Student Name");

		data = dao.getStudentDetails();
		
		stable = new JTable(data,colNames);
		scrollpane = new JScrollPane(stable);
		add(scrollpane);
		setVisible(true);
	}


	public static void main(String[] args) 
	{
		new JTableStudent();
	}

}
