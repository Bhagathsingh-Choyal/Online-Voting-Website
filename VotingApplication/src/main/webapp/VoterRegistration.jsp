<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Voter Registration</title>
<link rel="stylesheet" href="./VotersRegistration.css">
</head>
<body>
	<header>
		<div class="logo">
			<img src="./images/vote_logo.jpg" alt="Logo"> <span
				class="name">VoteApp</span>
		</div>
		<nav>
			<ul>
				<li><a href="./index.jsp">Home</a></li>
				<li><a href="./VoterRegistration.jsp">New Voter
						Registration</a></li>
				<li><a href="./VoterLogin.jsp">Voter Signin</a></li>
				<li><a href="./AdminLogin.jsp">Admin Signin</a></li>
				<li><a href="./About.jsp">About</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<div class="bigcontainer">
			<div class="imagecontainer">
				<img src="./images/voterregistrationimage.png" alt="Leftimage">
			</div>
			<div class="formcontainer">
				<div class="container">
					<h2>Voter Registration</h2>
					<form id="registrationForm" action="voterregistration"
						method="post" enctype="multipart/form-data">
						<div class="inputbox">
							<label for="name">Name:</label> <input type="text" id="name"
								name="name" required>
						</div>
						<div class="inputbox">
							<label for="email">Email ID:</label> <input type="email"
								id="email" name="email" required>
						</div>
						<div class="inputbox">
							<%
							String msg1 = (String) session.getAttribute("inv");
							if (msg1 != null && msg1.equals("Invalid Password")) {
							%>
							<span style="color: red"><%=msg1%></span>
							<%
							}
							%>
							<label for="password">Password:</label> <input type="password"
								id="password" name="password" required>
						</div>
						<div class="inputbox">
							<%
							String msg2 = (String) session.getAttribute("inv");
							if (msg2 != null && msg2.equals("Invalid PhoneNumber")) {
							%>
							<span style="color: red"><%=msg2%></span>
							<%
							}
							%>
							<label for="phone">Phone Number:</label> <input type="tel"
								id="phone" name="phone" required>
						</div>
						<div class="inputbox">
							<label for="address">Address:</label>
							<textarea id="address" name="address" required></textarea>
						</div>
						<div class="inputbox">
							<%
							String msg = (String) session.getAttribute("inv");
							if (msg != null && msg.equals("Invalid Age")) {
							%>
							<span style="color: red"><%=msg%></span>
							<%
							}
							%>
							<label for="age">Age:</label> <input type="number" id="age"
								name="age" required>
						</div>
						<div class="inputbox">
                            <label for="age">image:</label>
                            <input type="file" name="image" required>
                        </div>
						<div class="inputbox">
							<input type="submit" class="button" value="Register">
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>

	<footer>
		<p>&copy; 2024 VoteApp. All rights reserved.</p>
	</footer>
</body>
</html>
