<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./AdminLogin.css">
    <title>Admin Login</title>
</head>
<body>
    <header>
        <div class="logo">
            <img src="./images/vote_logo.jpg" alt="Logo">
            <span class="name">VoteApp</span>
        </div>
        <nav>
            <ul>
                <li><a href="./index.jsp">Home</a></li>
                <li><a href="./VoterRegistration.jsp">New Voter Registration</a></li>
                <li><a href="./VoterLogin.jsp">Voter Signin</a></li>
                <li><a href="./AdminLogin.jsp">Admin Signin</a></li>
                <li><a href="./About.jsp">About</a></li>
            </ul>
        </nav>
    </header>

    <main>
    <div class="maincontainer">
        <div class="imagecontainer">
            <img src="./images/adminloginimage.webp" alt="Left Image">
        </div>
        <div class="logincontainer">
            <h2>Admin Login</h2>
            <form action="adminlogin">
                <div class="inputbox">
                    <label for="email">Enter your Email:</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="inputbox">
                    <label for="password">Enter your Password:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div class="inputbox">
                    <input type="submit" class="button" value="Login">
                </div>
            </form>
        </div>
    </div>
</main>
<footer>
    <p>&copy; 2024 VoteApp. All rights reserved.</p>
</footer>
</body>
</html>
