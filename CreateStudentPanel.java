package com.cruds.swingproj;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cruds.exception.SMSException;

public class CreateStudentPanel extends JPanel
{
	JTextField txtUSN;
	JLabel lblUSN;
	JTextField txtsname;
	JLabel lblsname;
	JButton btncreate;
	JButton btnhome;

	public CreateStudentPanel() 
	{

		lblUSN = new JLabel("Student USN");
		txtUSN = new JTextField(10);
		lblsname = new JLabel("Student Name");
		txtsname = new JTextField(10);
		btncreate = new JButton("Create");
		btncreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String strUSN = txtUSN.getText();
				String strname = txtsname.getText();
				
				try
				{
					Student s = new Student(strUSN, strname);
					BookDAO dao = new BookDAO();
					
					if(dao.create(s))
					{
						txtUSN.setText("");
						txtsname.setText("");
						JOptionPane.showMessageDialog(getParent(), "Student Created Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch(SMSException smse)
				{
					getToolkit().beep();
					JOptionPane.showMessageDialog(getParent(), smse.getInfo(), "Error", JOptionPane.ERROR_MESSAGE);
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
		add(lblsname);
		add(txtsname);
		add(btncreate);
		add(btnhome);
	}
	
}

