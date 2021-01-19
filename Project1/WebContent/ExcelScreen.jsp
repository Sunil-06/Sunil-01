<%@page import="java.util.ArrayList,com.ge.www.BookBean" %>

<%
	response.setContentType("application/vnd.ms-excel");
	response.setHeader("content-Disposition", "attachment; filename=sample.xls");
	
	ArrayList<BookBean> al=(ArrayList)request.getAttribute("list");
	String cat=(String)request.getAttribute("category");
%>
<form name="myform">
	<center><h2><u>
		Books Belongs To  <%= cat.toUpperCase() %>
	</u></h2></center>
	<br>
	<br>
	<table border="1" width="100%">
	<tr>
		<th>SNO</th>
		<th>BOOKID</th>
		<th>BOOKNAME</th>
		<th>AUTHORNAME</th>
		<th>STATUS</th>
	</tr>
	
	<%
		for(int i=0;i<al.size();i++)
		{
			BookBean bb=(BookBean)al.get(i);
		
	%>
		<tr>
			<td> <%= (i+1) %></td>
			<td> <%= bb.getBookid() %></td>
			<td> <%= bb.getBookname() %></td>
			<td> <%= bb.getAuthorname() %></td>
			<td> <%= bb.getStatus() %></td>
		</tr>
		<%
		}
		%>
	</table>
	<br><br>
	<center>
		<input type="button" value="PRINT" onClick="window.print()"/>
	</center>
</form>
