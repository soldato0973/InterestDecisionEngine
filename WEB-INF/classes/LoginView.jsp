<%@ page import="com.voyage.model.domain.*" %>

<!doctype html>
<html>

<head><title>Login</title></head>
<body>
<% User user = (User)request.getSession().getAttribute("user"); %>
<h3>Successful Login</h3><br>

<div>Username: <%= user.getUserName() %> </div><br>    
<div>Password: <%= user.getPassword() %> </div><br>

<h3>IS a valid Login</h3><br>

<h3><a href="voyageapp.html">Would you like to add an Application?</a></h3>


</body>
</html>
