<html>
<head>
	<script language="javascript">
	function addbooks(){
		f.source.value="addBook";
		validate();
		
		}
	function validate()
	{
		
		if(f.category.selectedIndex=='0')
		{
			alert("You should selecte fields");
			f.category.focus();
			return false;
		}
		else
		{
			f.submit();
			return false;
		}
	}
	</script>
</head>
<body>
 	<form action="test1" method="post" name="f">
	BOOKID:<input type="text" name="Bookid"/><br>
	BOOKNAME:<input type="text" name="Bookname"/><br>
	AUTHORNAME:<input type="text" name="Authorname"/><br>
	STATUS:<input type="text" name="Status"/><br>
	CATEGORY:<select  name="category" >
		<option value="select" >Select a category</option>
		<option value="java" >JAVA</option>
		<option value="python" >PYTHON</option>
	</select>
	<br>

	<input type="button" value="AddBooks" onclick="addbooks()"/>
	
	<input type="text" name="source" readonly style="visibility:hidden"/>

	</form>
</body>
</html>