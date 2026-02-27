<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!DOCTYPE html>
<html>
<head>
<title>Admin Login</title>
</head>

<body>

	<h2>Admin Login</h2>

	<form action="adminLogin" method="post">

		<table>

			<tr>
				<td>Username :</td>
				<td><input type="text" name="username" required></td>
			</tr>

			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" required></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Login"></td>
			</tr>

		</table>

	</form>

	<br>

	<a href="index.jsp">Back to Home</a>

</body>
</html>
</body>
</html>