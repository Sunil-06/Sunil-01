<html>
	<head>
		<script language="javascript">
			function isHtml()
			{
				f.source.value="Html";
				validate();
			}
			function isExcel()
			{
				f.source.value="Excel";
				validate();
			}
			
			function validate()
			{
				if(f.category.selectedIndex=='0')
				{
					alert("You should selecte category");
					f.category.focus();
					return false;
				}
				else
				{
					f.submit();
					return false;
				}
			}
			function addBook(){
				window.location="books.jsp";
				//validate();
			}
		</script>
	</head>
	<body>
		<form name="f" action="test" method="POST">
		<center>
			<font color="red" size="10">
				Search For Books
			</font>
			<hr color="orange" width="50%"/>
		</center>
		
		<table border="1" 
		        cellpadding="4" 
		         cellspacing="14" 
		           align="center" 
		             bgcolor="lavender">
		<tr>
			<th>Select Category:</th>
			<th>
				<select name="category">
					<option selected value=''>select a value</option>
					<option value="java">JAVA</option>
					<option value="python">PYTHON</option>
					<option value="dotnet">.Net</option>
				</select>
			</th>
		</tr>
		<tr>
			<th>
	<input type="button" value="HTML Output"  onClick="isHtml()"/>
			</th>
			<th>
	<input type="button" value="Excel screen"  onClick="isExcel()"/>
			</th>
		</tr>
		
			
		</table>
		<br><br>
		<center><input type="button" value="AddBooks" onclick="addBook();"/></center>
		
	<input type="text" name="source" readonly style="visibility:hidden"/>

		
		</form>
			

	</body>
</html>
