<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Policy</title>
</head>

<body>

	<h2>Add Policy</h2>

	<%
	String msg = request.getParameter("msg");

	if (msg != null) {
	%>

	<p style="color: red;">
		<%=msg%>
	</p>

	<%
	}
	%>


	<form action="policy" method="post">

		Policy Name: <input type="text" name="name"> <br>
		<br> Premium: <input type="text" name="premium"> <br>
		<br> Duration (Years): <input type="text" name="duration">
		<br>
		<br> <input type="submit" value="Save">

	</form>

	<br>

	<a href="adminHome.jsp">Back</a>

</body>
</html>