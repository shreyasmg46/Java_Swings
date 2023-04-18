package com.cruds.swingproj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class IssuebookDAO
{

	public Vector<Vector<String>> getBookISBN(int ISBN)
	{
		String sql ="select b.ISBN, b.title, b.category, b.no_of_books, a.name, a.email from book b, author a where b.ISBN=a.ISBN and b.ISBN = ?"; 
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = null;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ISBN);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs !=null && rs.next())
			{
				row = new Vector<String>();
				row.add(String.valueOf(rs.getInt(1)));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(String.valueOf(rs.getInt(4)));
				row.add(rs.getString(5));
				row.add(rs.getString(6));
				data.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return data;
	}
	
	
	public Vector<Vector<String>> getStudentUSN(String USN)
	{
		String sql ="select USN, sname from student where USN = ?"; 
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = null;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, USN);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs !=null && rs.next())
			{
				row = new Vector<String>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				data.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return data;
	}
	
	public boolean book_issue(Student s, Date issued_date, int ISBN)
	{
		String sql = "select USN from Student where usn = ?";
		String sql2 = "insert into book_issue(USN,issued_date, return_date, ISBN) values(?,?,?,?)";
		String sql3 = "update book set no_of_books = no_of_books-? where ISBN = ?";
		
		int row2=0, row3=0;
		int Book = 1;
		String USN = null;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(issued_date);
		cal.add(Calendar.DATE, 7);
		Date return_date = cal.getTime();
		
		java.sql.Date idate = new java.sql.Date(issued_date.getTime());
		java.sql.Date rdate = new java.sql.Date(return_date.getTime());
		
		try(Connection conn = com.cruds.swingproj.DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getUSN());
			ResultSet rs = ps.executeQuery(); 
			if(rs!=null && rs.next())
			{
				USN = rs.getString(1);
			}
			
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setString(1, s.getUSN());
			ps2.setDate(2, idate);
			ps2.setDate(3, rdate);
			ps2.setInt(4, ISBN);
			row2 = ps2.executeUpdate();
			
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.setInt(1, Book);
			ps3.setInt(2, ISBN);
			row3 = ps3.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return (row2 > 0 && row3 > 0);
	}
	
}

