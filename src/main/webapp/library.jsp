<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.books_logic.models.Book" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books</title>
</head>
<body>
<h2>Books List</h2>
<p><a href='<c:url value="/library/add" />'>Create new</a></p>
<table border="1px solid black">
    <tr><th>ID</th><th>Title</th><th>Author</th><th>Description</th><th>Quantity</th><th></th></tr>
    <c:forEach var="book" items="${books}">
        <tr><td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.description}</td>
            <td>${book.quantity}</td>
            <td>
                <a href='<c:url value="/library/edit?id=${book.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/library/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${book.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
            </tr>
    </c:forEach>
</table>
<br><input type="submit" value="Log out"
       onclick="window.location='/logout';" />
</body>
</html>