<%@ page import="com.voyage.model.domain.*" %>

<!doctype html>
<html>

<head><title>Release Metadata</title></head>
<body>
<% Release rel = (Release)request.getSession().getAttribute("release"); %>
<h3>Successful Release Creation</h3><br>

<div>Release Name: <%= rel.getReleaseName() %> </div><br>    
<div>Number: <%= rel.getReleaseNumber() %> </div><br>
<div>Type: <%= rel.getReleaseType() %> </div><br>

<h3>IS a valid Release</h3><br>

<h3><a href="voyagerel.html">Would you like to add another Release?</a></h3>


</body>
</html>
