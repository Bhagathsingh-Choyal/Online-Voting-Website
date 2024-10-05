<%@page import="java.util.List"%>
<%@page import="com.jsp.model.Candidate"%>
<%@page import="com.jsp.model.Voter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./VoterDashboard.css">
</head>
<body>
	<header>
		<div class="logo">
			<img src="./images/vote_logo.jpg" alt="Logo"> <span
				class="name">VoteApp</span>
		</div>
		<% Voter v = (Voter)request.getAttribute("vtr"); %>
		<nav>
			<ul>
				<li><a href="./index.jsp
				">Home</a></li>
				<li><a href="">Welcome <%=v.getVotername().toUpperCase()%></a></li>
				<li><a href="./index.jsp">Logout</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<section class="Dashboard">
			<div>
				<h1>Voter Dashboard</h1>
			</div>
		</section>

		<div class="container">
			<div class="userdetails">
				<h2>Your Details:</h2>
				<div class="voterpic">
					<img width="100%" height="100%" src="./Voterimage/<%=v.getVotername().split(" ")[0] %>.jpg" alt="">
				</div>
				<table>
					<tr>
						<td>Id:</td>
						<td><%=v.getVoterid() %></td>
					</tr>
					<tr>
						<td>Name:</td>
						<td><%=v.getVotername() %></td>
					</tr>
					<tr>
						<td>Email Id:</td>
						<td><%=v.getEmailid() %></td>
					</tr>
					<tr>
						<td>Phone No:</td>
						<td><%=v.getPhonenumber() %></td>
					</tr>
					<tr>
						<td>Status:</td>
						<td><%=v.getStatus()%></td>
					</tr>
				</table>
			</div>
			<div class="voting">
				<% if(v.getStatus().equalsIgnoreCase("no"))
					{
				%>
				<h2><%=v.getVotername()+ "You Have To Vote" %></h2>
				<h3>Do Voting</h3>
				<% }
				else
				{%>
				<h2><%= "You Have Already Voted" %></h2>
				<form>
				<%}
					List<Candidate> clist = (List)request.getAttribute("allcandi");
					if(clist!=null)
					{
						for(Candidate cnd : clist)
						{
				%> 	
						<input type="hidden">
				<label> <input type = "radio" name="candidate" value="<%=cnd.getCid()%>"> <%=cnd.getName() %></label>
				<%
						}
						if(v.getStatus().equalsIgnoreCase("no"))
						{
					%>
					<button type="submit">Vote</button>
					<%}
					}
					else
					{%>
						<h2 style="color: red;">No Candidate Are Participating</h2>
					<%}
					%>
				</form>
			</div>
		</div>
	</main>
	<footer>
		<p>&copy; 2024 VoteApp. All rights reserved.</p>
	</footer>
</body>
</html>