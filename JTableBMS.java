package com.cruds.swingproj;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class JTableBMS extends JFrame
{
	JTable table;
	JScrollPane scrollpane;
	
	Vector<String> colNames;
	Vector<Vector<String>> data;
	BookDAO dao = new BookDAO();
	
	public JTableBMS() {
		setTitle("JTable BMS Proj");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		colNames = new Vector<>();
		colNames.add("ISBN");
		colNames.add("Title");
		colNames.add("Category");
		colNames.add("No of Books");
		data = dao.getTableData();
		
		table = new JTable(data,colNames);
		scrollpane = new JScrollPane(table);
		add(scrollpane);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		new JTableBMS();
	}

}
