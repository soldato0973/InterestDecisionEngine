<%@ page import="com.voyage.model.domain.*" %>

<!doctype html>
<html>

<head><title>Login</title></head>
<body>
<% User user = (User)request.getSession().getAttribute("user"); %>
<h3>Failed Login</h3><br>

<div>Username: <%= user.getUserName() %> </div><br>    
<div>Password: <%= user.getPassword() %> </div><br>

<h3>Is NOT a valid login</h3>

<h3><a href="login.html">Would you like to try to Login gain?</a></h3>

</body>
</html>
