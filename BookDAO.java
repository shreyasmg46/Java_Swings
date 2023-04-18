package com.cruds.swingproj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.cruds.exception.SMSException;


public class BookDAO 
{

	public Vector<Vector<String>> getStudentDetails()
	{
		String sql = "Select USN, sname from student";
		Vector<Vector<String>> data = new Vector<>();
		Vector<String> row = null;

		try(Connection conn = com.cruds.swingproj.DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while(rs != null && rs.next())
			{
				row = new Vector<>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				data.add(row);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return data;
	}


	public boolean create(Student s)
	{
		String sql = "insert into student(USN, sname) values(?,?)";
		int rows = 0;

		try(Connection conn = com.cruds.swingproj.DBConnectionManager.getConnection())
		{
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getUSN());
			ps.setString(2, s.getName());
			rows = ps.executeUpdate();
			conn.commit();
		}

		catch (SQLException e) 
		{
			e.printStackTrace();
			if(e.getMessage().contains("Duplicate"))
			{
				throw new SMSException("USN Already Exsists" + s.getUSN());
			}
			else
			{
				throw new SMSException("Database error during insert " + e.getMessage());
			}
		}
		return rows > 0;

	}


	public Vector<Vector<String>> getTableData()  //[Case 5]
	{
		String sql = "select b.ISBN,b.title,b.category, b.no_of_books, a.name, a.email from book b, author a where b.ISBN=a.ISBN";
		Vector<Vector<String>> data = new Vector<>();
		Vector<String> row = null;

		try(Connection conn = com.cruds.swingproj.DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while(rs != null && rs.next())
			{
				row = new Vector<>();
				row.add(String.valueOf(rs.getInt(1)));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(String.valueOf(rs.getInt(4)));
				row.add(rs.getString(5));
				row.add(rs.getString(6));
				data.add(row);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return data;
	}

	public Vector<Vector<String>> getBookByAuthor(String name) //[Case 4]
	{
		String sql = "Select b.ISBN,b.title,b.category,b.no_of_books,a.name from book b, author a where b.ISBN=a.ISBN and a.name = ?";
		Vector<Vector<String>> data = new Vector<>();
		Vector<String> row = null;

		try(Connection conn = com.cruds.swingproj.DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs != null && rs.next())
			{
				row = new Vector<>();
				row.add(String.valueOf(rs.getInt(1)));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(String.valueOf(rs.getInt(4)));
				data.add(row);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return data;
	}

	public Vector<Vector<String>> getBookByCategory(String category) //[Case 3]
	{
		String sql = "Select ISBN, title, category, no_of_books from book where category = ?";
		Vector<Vector<String>> data = new Vector<>();
		Vector<String> row = null;

		try(Connection conn = com.cruds.swingproj.DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category);

			ResultSet rs = ps.executeQuery();
			while(rs!= null && rs.next())
			{
				row = new Vector<>();
				row.add(String.valueOf(rs.getInt(1)));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(String.valueOf(rs.getInt(4)));
				data.add(row);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return data;
	}

	public Vector<Vector<String>> getBookByTitle(String title) //[Case 2]
	{
		String sql = "Select ISBN, title, category, no_of_books from book where title = ?";
		Vector<Vector<String>> data = new Vector<>();
		Vector<String> row = null;

		try(Connection conn = com.cruds.swingproj.DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, title);

			ResultSet rs = ps.executeQuery();
			while(rs!= null && rs.next())
			{
				row = new Vector<>();
				row.add(String.valueOf(rs.getInt(1)));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(String.valueOf(rs.getInt(4)));
				data.add(row);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return data;
	}

	public boolean create (Book b) //[Case 1]
	{
		String sql = "insert into book(ISBN, title, category, no_of_books) values(?,?,?,?)";
		String sql2 = "insert into author(name, email, ISBN) values(?,?,?)";
		int rows = 0;

		try(Connection conn = com.cruds.swingproj.DBConnectionManager.getConnection())
		{
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, b.getISBN());
			ps.setString(2, b.getTitle());
			ps.setString(3, b.getCategory());
			ps.setInt(4, b.getNo_of_books());
			rows = ps.executeUpdate();

			if(b.getAuthor()!=null)
			{
				PreparedStatement ps2 = conn.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
				ps2.setString(1, b.getAuthor().getName());
				ps2.setString(2, b.getAuthor().getEmail());
				ps2.setInt(3, b.getISBN());

				rows = ps2.executeUpdate();

				ResultSet rs = ps2.getGeneratedKeys();
				if(rs!= null && rs.next())
				{
					System.out.println("Author Name" + rs.getString(1));
				}
			}
			conn.commit();	
		} 

		catch (SQLException e) 
		{
			e.printStackTrace();
			if(e.getMessage().contains("Duplicate"))
			{
				throw new SMSException("ISBN Already Exists" + b.getISBN());
			}
			else
			{
				throw new SMSException("Database error during insert " + e.getMessage());
			}
		}
		return rows > 0;

	}

}
