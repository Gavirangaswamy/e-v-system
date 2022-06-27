<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Signup Page</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="https://kit.fontawesome.com/2c135d6bdb.js" crossorigin="anonymous"></script>
</head>
<body>
    <header>
       <h1>GRS</h1>
       <div class="signup"><a href="login.jsp" ><i class="fas fa-sign-in-alt"></i></a></div>
    </header>
    
    <form class="middle-container" action="save.do" method="post">
        <h1 class="form-heading">Register Here</h1>
        <p id="message"></p>
        <label for="firstname">Firstname :</label><br>
        <input type="text" name="firstName" placeholder="Enter your Firstname" required id="fName">
        <label for="lastname">Lastname :</label><br>
        <input type="text" name="lastName" placeholder="Enter your Lastname" required id="lName">
        <label for="DOB">Date of Birth :</label><br>
        <input type="date" name="dob" placeholder="Enter your DOB" required id="dob">
        <label for="lastname">City :</label><br>
        <input type="text" name="city" placeholder="Enter your city" required id="city">
        <label for="email">Email :</label><br>
        <input type="email" name="email" placeholder="Enter your email" id="email" required>
        <label for="phone">Mobile Number :</label><br>
        <input type="tel" name="mobile" placeholder="Enter your Mobile Number" id="phone" required>
        <label for="userName">Username :</label><br>
        <input type="text" name="userName" placeholder="Enter your Username" required id="userName">
        <label for="DOB">Date of 1st Dose :</label><br>
        <input type="date" name="dose1" placeholder="Enter your DOB" required id="dose1">
        <label for="DOB">Date of 2nd Dose :</label><br>
        <input type="date" name="dose2" placeholder="Enter your DOB" required id="dose2">
        <label for="password">Password :</label><br>
        <input type="password" placeholder="Enter your Password" id="pass" name="password" required>
        <p id="pmsg">Password is <span id="strength"></span></p>
        <label for="cnfpassword">Confirm Password :</label>
        <input type="password" placeholder="Enter your Password" id="cnfpassword" name="confirmPassword" required>
        <div class="checkbox" ><input type="checkbox" class="check-box" required><span class="signup-span">I agree terms and conditions.</span></div>
        <input class="reg-btn" type="submit" onclick="regValidation()" value="Register">
        <input class="reg-btn" type="reset"  value="Clear">
    </form>
    <footer>
        <small>© 2022 Gavirangaswamy D G.</small>
    </footer>
    <script type="text/javascript" src="js/main.js"></script>
</body>
</html>