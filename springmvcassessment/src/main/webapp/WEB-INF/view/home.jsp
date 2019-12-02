<%@ page import="com.tyss.springmvcassessment.dto.RetailerBean" %>
<%@ page import="com.tyss.springmvcassessment.dto.Product" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%
   		RetailerBean bean = (RetailerBean)session.getAttribute("bean");
   %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="./updatepassword">Update Password</a>
<a href="./totalamount">Total Amount</a>
<a href="./getorder" style="float: right;">Get My Orders</a>
<h2>Welcome <%=bean.getName() %></h2>
<fieldset>
	<legend>Search Product by Product Id</legend>
	<form action="./search">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="number" name="pid"></td>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>
</fieldset>
<%
	Product product = (Product)request.getAttribute("product");
%>
<%
if(product!=null){
%>
<table>
			<tr>
				<th>Pid</th>
				<th>PName</th>
				<th>Price</th>
				
			</tr>
			<tr>
				<td><%=product.getPid() %></td>
				<td><%=product.getPname()%></td>
				<td><%=product.getPriceperproduct()%></td>
			</tr>
</table>
<%
}
%>
<h3>${msg}</h3>

<fieldset>
	<legend>Place order here</legend>
	<form action="./doorder">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="number" name="pid"></td>
				
			</tr>
			<tr>
				<td>PName:</td>
				<td><input type="text" name="pname"></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="number" name="priceperunit"></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input type="number" name="quantity"></td>
				<td><input type="submit" value="order"></td>
			</tr>
		</table>
	</form>
</fieldset>


</body>
</html>