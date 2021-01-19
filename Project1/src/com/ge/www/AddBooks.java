package com.ge.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddBooks extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String bid=req.getParameter("Bookid");
		String bname=req.getParameter("Bookname");
		String athr=req.getParameter("Authorname");
		String sts=req.getParameter("Status");
		String cat=req.getParameter("category");
		
		int id=Integer.parseInt(bid);
		
		Connection con=null;
		PreparedStatement ps=null;
		String qry=null;
		int result=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
			qry="insert into select_books values(?,?,?,?,?)";
			ps=con.prepareStatement(qry);
			//set the values
			ps.setInt(1, id);
			ps.setString(2,bname);
			ps.setString(3,athr);
			ps.setString(4,sts);
			ps.setString(5,cat);
			
			//execute
			result=ps.executeUpdate();
			if(result==0)
				pw.println("No Record inserted");
			else
				pw.println("Record inserted");
			
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			pw.println(e);
		}
	
		pw.close();
	
		
		
	
}
	
}
	
	
