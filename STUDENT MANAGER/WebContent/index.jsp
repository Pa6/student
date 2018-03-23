<!DOCTYPE html>
<html>
<head>
<title>Login and registration</title>
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-1.8.2.js"></script>
<script src="js/jquery-ui-1.10.3.custom.js"></script>
<script>
$(function() {
  $( "#tabs" ).tabs();
});
</script>
</head>
<body>
<div class="wrapper">   
<div class="container">
<div id="tabs">
  <ul>
    <li><a href="#login">Login</a></li>
    <li><a href="#register">Sign up</a></li>
  </ul>
  <div id="login">
        <% 
        if("Invalid Email or password".equals((String)session.getAttribute("error"))){ %>
                <h6> Invalid Email or password. Please try again.</h6>
        <%} %>
    <form method="post" action="LoginServlet">
        <label for="username">Username:</label>
        <br/>
        <input type="text" name="username" id="username"/>
        <br/>
        <label for="password">Password:</label>
        <br/>
        <input type="password" name="password" id="password"  />
        <br/>
        <br/>
        <input type="submit" value="Login">
    </form>
  </div>
  <div id="register">
        <form method="post" action="SignUpServlet">
         <label for="studentid">StudentID:</label><br/>
        <input type="text" name="studentid" id="studentid" />
        <br/>
        <label for="name">Name:</label><br/>
        <input type="text" name="name" id="name" />
        <br/>
        <label for="username">Username:</label><br/>
        <input type="text" name="username" id="username" />
        <br/>
        <label for="password">Password:</label><br/>
        <input type="password" name="password" id="password" />
        <br/>
        <label for="email">Email:</label><br/>
        <input type="email" name="email" id="email" />
        <br/>
         <label for="department">Department:</label><br/>
        <select name="department" id="department">
                <option value="it_dept">IT Dept</option>
                <option value="eng">Engineering</option>
        </select>
        <br/>
        <label for="status">Status:</label><br/>
        <select name="status" id="status">
                <option value="admin">Admin</option>
                <option value="student">Student</option>
        </select>
        <br/>
        <br/>
        <input type="submit" value="Register">
        </form>
  </div>
</div>
</div>
</div>
</body>
</html>