package com.ge.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectedBooks extends HttpServlet{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		try
		{
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
			
			//reading form data
			String cat=req.getParameter("category");
			String checkAction=req.getParameter("source");
			
			DBConnector dbc=new DBConnector();
			ArrayList<BookBean> al=dbc.search(cat);
			
			//sending data to jsp
			req.setAttribute("list", al);
			req.setAttribute("category",cat);
			
			String target=null;
			if(checkAction.equalsIgnoreCase("html"))
			{
				target="HtmlPrint.jsp";
			}
			else if(checkAction.equalsIgnoreCase("excel"))
			{
				target="ExcelScreen.jsp";
			}
			
			RequestDispatcher rd=req.getRequestDispatcher(target);
			rd.forward(req, res);
			
			pw.close();
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		}
	
	

}
