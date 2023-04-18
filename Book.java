package com.cruds.swingproj;

import com.cruds.exception.SMSException;

public class Book 
{
	private int ISBN;
	private String title;
	private String category;
	private int no_of_books;

	private Author author;
	private BookIssue bookissue;

	public Book(int ISBN, String title, String category, int no_of_books, Author author, Student student, BookIssue bookissue)
	{
		super();
		this.ISBN = ISBN;
		this.title = title;
		this.category = category;
		this.no_of_books = no_of_books;
	}

	public Book (int ISBN, String title, String category, int no_of_books) 
	{
		if(title.trim().equals(""))
		{
		throw new SMSException("Please Enter the Proper Title");
		}
		if(category.trim().equals(""))
		{
			throw new SMSException("Please Enter the Category of the Book");
		}
		if(ISBN <=0)
		{
			throw new SMSException("Invalid ISBN Number");
		}
		if(no_of_books <=0)
		{
			throw new SMSException("No of Books cannot be Zero or Negative");
		}
		this.ISBN= ISBN;
		this.title = title;
		this.category = category;
		this.no_of_books = no_of_books;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getNo_of_books() {
		return no_of_books;
	}

	public void setNo_of_books(int no_of_books) {
		this.no_of_books = no_of_books;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public BookIssue getBookissue() {
		return bookissue;
	}

	public void setBookissue(BookIssue bookissue) {
		this.bookissue = bookissue;
	}

	public Book(int iSBN, String title, String category, int no_of_books, Author author) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.category = category;
		this.no_of_books = no_of_books;
		this.author = author;
	}

	
	
}
