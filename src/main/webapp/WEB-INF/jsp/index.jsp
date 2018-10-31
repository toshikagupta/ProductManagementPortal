<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<title>First Web Application</title>
</head>

<body>
    <font color="red">${errorMessage}</font>
    <form method="post">
        Name : <input type="text" name="id" />
        Password : <input type="password" name="password" /> 
        <input type="submit" />
    </form>
</body>

</html>