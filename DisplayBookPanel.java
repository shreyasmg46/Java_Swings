package com.cruds.swingproj;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class DisplayBookPanel extends JPanel
{
	JTable table;
	JScrollPane scrollpane;
	JButton btnhome;
	Vector<String> colNames;
	Vector<Vector<String>> data;
	BookDAO dao = new BookDAO();

	public DisplayBookPanel()
	{
		colNames = new Vector<>();
		colNames.add("ISBN");
		colNames.add("Title");
		colNames.add("Category");
		colNames.add("No of Books");
		colNames.add("Author Name");
		colNames.add("Email ID");
		data = dao.getTableData();

		table = new JTable(data,colNames);
		scrollpane = new JScrollPane(table);
		add(scrollpane);

		addComponentListener(new ComponentAdapter() {

			@Override
			public void componentShown(ComponentEvent e) 
			{
				table.setModel(new DefaultTableModel(dao.getTableData(),colNames));

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
		add(btnhome);
	}
}
