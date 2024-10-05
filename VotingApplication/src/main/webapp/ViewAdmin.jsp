<%@page import="com.jsp.model.Admin"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="ViewAdmin.css">
</head>
<body>
	<header>
		<div class="logo">
			<img src="./images/vote_logo.jpg" alt="Logo"> <span
				class="name">VoteApp</span>
		</div>
		<nav>
			<ul>
				<li><a href="./practice.html">Home</a></li>
				<li><a href="./practice2.html">Welcome Admin</a></li>
				<li><a href="./practice.html">View Admins</a></li>
				<li><a href="./practice.html">View Voters</a></li>
				<li><a href="./practice.html">View Candidates</a></li>
				<li><a href="./practice.html">Log-Out</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<%
		List<Admin> list = (List<Admin>) session.getAttribute("viewadmindetails");
		%>
		<h1>View Admins</h1>
		<section class="Dashboard">
			<div>
				<form action="viewadmin">
					<table>
						<thead>
							<tr>
								<th>Admin ID</th>
								<th>Name</th>
								<th>Email</th>
							</tr>
						</thead>
						<%
						for (Admin admin : list) {
						%>
						<tbody>
							<tr>
								<td><%=admin.getAdminid() %></td>
								<td><%=admin.getAdminName() %></td>
								<td><%=admin.getEmailid()%></td>
							</tr>
						</tbody>
						<%} %>
					</table>
				</form>
			</div>
		</section>
	</main>
	<footer>
		<p>&copy; 2024 VoteApp. All rights reserved.</p>
	</footer>
</body>
</html>