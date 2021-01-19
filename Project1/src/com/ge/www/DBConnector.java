package com.ge.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DBConnector {
	
	public Connection getConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	public ArrayList<BookBean> search(String category)
	{
		Connection con=getConnection();
		Statement st=null;
		ResultSet rs=null;
		ArrayList<BookBean> al=new ArrayList<BookBean>();
		String searchQuery=null;
		try
		{
			category="'"+category+"'";
			searchQuery="select bookid,bookname,authorname,status from select_books where category="+category;
			st=con.createStatement();
			rs=st.executeQuery(searchQuery);
			while(rs.next())
			{
				BookBean b=new BookBean();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthorname(rs.getString(3));
				b.setStatus(rs.getString(4));
				al.add(b);
				
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}


}
