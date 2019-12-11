<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./form" method="post">
	<table>
		<tr>
			<td>ID</td>
			<td><input name="id" id="id" type="number"></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input name="name" id="name" type="text"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input name="password" id="password" type="password"></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><input name="gender" id="gender" type="text"></td>
		</tr>
		<tr>
			<td><input type="reset" value="Reset"></td>
			<td><input type="submit" value="Register"></td>
		</tr>
		<tr>
			<td>DOJ</td>
			<td><input type="date" name="doj"></td>
		</tr>
	</table>
</form>

</body>
</html>