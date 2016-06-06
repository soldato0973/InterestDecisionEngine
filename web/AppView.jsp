<%@ page import="com.voyage.model.domain.*" %>

<!doctype html>
<html>

<head><title>Application Metadata</title></head>
<body>
<% Application app = (Application)request.getSession().getAttribute("application"); %>
<h3>Successful Application Creation</h3><br>

<div>Application Name: <%= app.getAppName() %> </div><br>    
<div>Vendor: <%= app.getAppVendor() %> </div><br>
<div>State: <%= app.getAppState() %> </div><br>
<div>Prod Name: <%= app.getAppProdName() %> </div><br>
<div>File Size: <%= app.getAppFileSize() %> </div><br>
<div>CheckSum: <%= app.getAppCheckSum() %> </div><br>
<div>Description: <%= app.getAppDescription() %> </div><br>
<div>URL: <%= app.getAppURL() %> </div><br>
<div>Contact Name: <%= app.getAppContactName() %> </div><br>
<div>Contact Email: <%= app.getAppContactEmail() %> </div><br>

<h3>IS a valid Application</h3><br>

<h3><a href="voyageapp.html">Would you like to add another Application?</a></h3>


</body>
</html>
