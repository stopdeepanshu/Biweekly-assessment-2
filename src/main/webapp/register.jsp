<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Register</title>
</head>

<body>

	<h2>Customer Registration</h2>
	<%
	String msg = request.getParameter("msg");

	if (msg != null) {
	%>

	<p style ="color  : red;">
		<%=msg%>
	</p>

	<%
	}
	%>


	<form action="register" method="post">

		Name: <input type="text" name="name"> <br> <br>
		Email: <input type="text" name="email"> <br> <br>
		Phone: <input type="text" name="phone"> <br> <br>
		Password: <input type="password" name="password"> <br> <br>
		<input type="submit" value="Register">

	</form>

	<br>

	<a href="index.jsp">Home</a>

</body>
</html>