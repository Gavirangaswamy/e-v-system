<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="https://kit.fontawesome.com/2c135d6bdb.js" crossorigin="anonymous"></script>
</head>
<body>
    <header>
       <h1>GRS</h1>
       <div class="login"><a href="register.jsp"><i class="fas fa-user-plus"></i></a></div>
    </header>
   <div class="middle-container">
    <form action="login.do" method="post">
        <h1 class="form-heading">Login Here</h1>
        <p id="login"></p>
        <label for="username">Username :</label>
        <input type="text" name="userName" placeholder="Enter your Username" required name="username">
        <label for="password">Password :</label><br>
        <input type="password" name="password" placeholder="Enter your Password" required name="password">
        <a class="fpassword" href="forgot-password.jsp">Forgot Password?</a>
        <input class="btn" type="submit" value="Login">
    </form>
    </div>
    <footer>
        <small>© 2022 Gavirangaswamy D G.</small>
    </footer>
</body>
</html>m