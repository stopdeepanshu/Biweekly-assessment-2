<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*,org.insurancecomp.entity.Policy"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Policies</title>
</head>

<body align="center">

	<%
	List<Policy> list = (List<Policy>) request.getAttribute("policies");

	String admin = (String) session.getAttribute("admin");

	Integer cid = (Integer) session.getAttribute("cid");
	%>

	<h2>Policies</h2>

	<table border="1">

		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Premium</th>
			<th>Duration</th>

			<%
			if (cid != null) {
			%>
			<th>Buy</th>
			<%
			}
			%>

		</tr>

		<%
		for (Policy p : list) {
		%>

		<tr>

			<td>
				<%-- <%=p.getId()%> --%>
			</td>

			<td><%=p.getPolicyName()%></td>

			<td><%=p.getPremium()%></td>

			<td><%=p.getDuration()%></td>


			<%
			if (cid != null) {
			%>

			<td>

				<form action="purchase" method="post">

					<input type="hidden" name="pid" value="<%-- <%=p.getId()%> --%>">

					<input type="submit" value="Buy">

				</form>

			</td>

			<%
			}
			%>


		</tr>

		<%
		}
		%>

	</table>

</body>
</html>