<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Forgot Password</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="https://kit.fontawesome.com/2c135d6bdb.js" crossorigin="anonymous"></script>
</head>
<body>
    <header>
       <h1>GRS</h1>
      <div class="signup"><a href="login.jsp"><img src="images/login.png" alt=""></a></div>
    </header>
   <div class="middle-container">
    <form action="sendotp.do" method="post">
        <h1 class="form-heading">Reset Password Here</h1>
        <label for="username">Username :</label>
        <input type="text" name="username" placeholder="Enter your Username" required id="username">
        <label for="email">Email :</label>
        <input type="email" name="email" placeholder="Enter your Email" required id="email">
        <input class="btn" type="submit"  value="Send OTP"><br>
    </form>
    </div>
    <footer>
        <small>© 2022 Gavirangaswamy D G.</small>
    </footer>
</body>
</html>