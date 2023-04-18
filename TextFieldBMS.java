package com.cruds.swingproj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cruds.exception.SMSException;

public class TextFieldBMS extends JFrame
{
	JTextField txtISBN;
	JLabel lblISBN;
	JTextField txttitle;
	JLabel lbltitle;
	JTextField txtcategory;
	JLabel lblcategory;
	JTextField txtno_of_books;
	JLabel lblno_of_books;
	JTextField txtname;
	JLabel lblname;
	JTextField txtemail;
	JLabel lblemail;
	JButton btnclick;

	JPanel panel;

	public TextFieldBMS()
	{
		setTitle("Text Field BMS Project");
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panel = new JPanel();
		lblISBN = new JLabel("Book ISBN");
		txtISBN = new JTextField(5);
		lbltitle = new JLabel("Book Title");
		txttitle = new JTextField(15);
		lblcategory = new JLabel("Book Category");
		txtcategory = new JTextField(7);
		lblno_of_books = new JLabel("No of Books");
		txtno_of_books = new JTextField(5);
		lblname = new JLabel("Author Name");
		txtname = new JTextField(7);
		lblemail = new JLabel("Author Email Id");
		txtemail = new JTextField(15);
		btnclick = new JButton("Submit");

		btnclick.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String strISBN = txtISBN.getText();
				String strtitle = txttitle.getText();
				String strcategory = txtcategory.getText();
				String strno_of_books = txtno_of_books.getText();
				String strname = txtname.getText();
				String stremail = txtemail.getText();

				try
				{
					Author a = new Author(strname, stremail);
					Book b = new Book(Integer.parseInt(strISBN), strtitle, strcategory, Integer.parseInt(strno_of_books), a);
					BookDAO dao = new BookDAO();

					if(dao.create(b))
					{
						txtISBN.setText("");
						txttitle.setText("");
						txtcategory.setText("");
						txtno_of_books.setText("");
						txtname.setText("");
						txtemail.setText("");
						JOptionPane.showMessageDialog(panel, "Book Created Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
						}
				}
				catch (NumberFormatException nfe)
				{
					getToolkit().beep();
					JOptionPane.showMessageDialog(panel, "Invalid Book ISBN","Error", JOptionPane.ERROR_MESSAGE);
				}
				catch(SMSException smse)
				{
					getToolkit().beep();
					JOptionPane.showMessageDialog(panel, smse.getInfo(),"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		panel.add(lblISBN);
		panel.add(txtISBN);
		panel.add(lbltitle);
		panel.add(txttitle);
		panel.add(lblcategory);
		panel.add(txtcategory);
		panel.add(lblno_of_books);
		panel.add(txtno_of_books);
		panel.add(lblname);
		panel.add(txtname);
		panel.add(lblemail);
		panel.add(txtemail);
		panel.add(btnclick);
		add(panel);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		new TextFieldBMS();
	}

}
