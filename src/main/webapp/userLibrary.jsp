<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.books_logic.Book" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books</title>
</head>
<body>
<h2>Books List</h2>
<table border="1px solid black">
    <tr><th>ID</th><th>Title</th><th>Author</th><th>Description</th><th>Quantity</th></tr>
    <c:forEach var="book" items="${books}">
        <tr><td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.description}</td>
            <td>${book.quantity}</td>
            </tr>
    </c:forEach>
</table>
<br><input type="submit" value="Log out"
           onclick="window.location='/logout';" />
</body>
</html>