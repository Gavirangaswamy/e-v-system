<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Reset Password</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="https://kit.fontawesome.com/2c135d6bdb.js" crossorigin="anonymous"></script>
</head>
<body>
    <header>
       <h1>GRS</h1>
      <div class="signup"><a href="login.jsp"><i class="fas fa-sign-in-alt"></i></a></div>
    </header>
   <div class="middle-container">
    <form action="reset.do" method="post">
        <h1 class="form-heading">Reset Password Here</h1>
        <input type="hidden" value= "${email}" name = "email">
        <label for="otp">One Time Password :</label><br>
        <input type="number" name="otp" placeholder="Enter your One Time Password" required id="otp">
        <label for="password">Password :</label><br>
        <input type="password" name="password" placeholder="Enter your Old Password" required id="password">
        <label for="password">Confirm Password :</label><br>
        <input type="password" name="cnfpassword" placeholder="Enter your New Password" required id="password">
        <input class="btn" type="submit"  value="Reset Password">
    </form>
    </div>
    <footer>
        <small>© 2022 Gavirangaswamy D G.</small>
    </footer>
</body>
</html>