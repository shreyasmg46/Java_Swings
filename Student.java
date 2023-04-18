package com.cruds.swingproj;

public class Student 
{
	private String USN;
	private String name;
	
	public Student(String USN)
	{
		super();
		this.setUSN(USN);
		this.setName(name);
	}
	
	public Student(String uSN, String name) {
		super();
		USN = uSN;
		this.name = name;
	}

	public String getUSN() {
		return USN;
	}
	public void setUSN(String uSN) {
		USN = uSN;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
