<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 03.01.2024
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h2>Register</h2>
<form action="/register" method="post" >
    <label>Login</label><br>
    <input name = "login"/><br><br>
    <label>Password</label><br>
    <input type="password" name="password"/><br><br>
    <input type="submit" value="OK"/>
</form>
<input type="submit" value="Назад"
       onclick="window.location='index.jsp';" />
</body>
</html>