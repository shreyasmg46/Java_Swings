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

public class StudentDisplayPanel extends JPanel
{
	JTable stable;
	JScrollPane scrollpane;
	JButton btnhome;
	Vector<String> colNames;
	Vector<Vector<String>> data;
	BookDAO dao = new BookDAO();

	public StudentDisplayPanel()
	{
		colNames = new Vector<>();
		colNames.add("Student USN");
		colNames.add("Student Name");
		data = dao.getStudentDetails();

		stable = new JTable(data,colNames);
		scrollpane = new JScrollPane(stable);
		add(scrollpane);

		addComponentListener(new ComponentAdapter() {

			@Override
			public void componentShown(ComponentEvent e) 
			{
				stable.setModel(new DefaultTableModel(dao.getStudentDetails(),colNames));
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
