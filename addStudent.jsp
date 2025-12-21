<html>
<head>
<title>Add Student</title>
<script src="js/validation.js"></script>
</head>
<body>

<h2>Add Student</h2>

<form action="StudentServlet" method="post" onsubmit="return validateForm()">
Name: <input type="text" name="name" id="name"><br><br>
Email: <input type="text" name="email" id="email"><br><br>
<input type="submit" value="Save">
</form>

</body>
</html>
