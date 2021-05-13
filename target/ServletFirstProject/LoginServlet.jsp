<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 5/14/2021
  Time: 1:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//w3c//DTD HTML 4.01 Transitional//En"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Login Success page</title>
</head>
<body>
<h3> Hi <%= request.getAttribute("user")  %>, Login successful.</h3>
<a href="login.html">Login Page</a>
</body>
</html>
