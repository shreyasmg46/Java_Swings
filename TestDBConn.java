package com.cruds.swingproj;

import java.sql.Connection;

import com.cruds.proj.DBConnectionManager;

public class TestDBConn {

	public static void main(String[] args) 
	{
		Connection con = DBConnectionManager.getConnection();

		if(con != null)
		{
			System.out.println("Connection Successful");
		}

	}


}

