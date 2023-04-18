package com.cruds.swingproj;

public class BookIssue 
{
	private int issueid;
	private String USN;
	private int issued_date;
	private int return_date;
	private int ISBN;
	
	
	public String getUSN() {
		return USN;
	}
	public void setUSN(String uSN) {
		USN = uSN;
	}
	public int getIssued_date() {
		return issued_date;
	}
	public void setIssued_date(int issued_date) {
		this.issued_date = issued_date;
	}
	public int getReturn_date() {
		return return_date;
	}
	public void setReturn_date(int return_date) {
		this.return_date = return_date;
	}
	
	public int getIssueid() {
		return issueid;
	}
	public void setIssueid(int issueid) {
		this.issueid = issueid;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
}
