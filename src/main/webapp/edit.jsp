<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit book</title>
</head>
<body>
<h3>Edit book</h3>
<form method="post">
    <input type="hidden" value="${book.id}" name="id" />
    <label>Title</label><br>
    <input name="title" value="${book.title}" /><br><br>
    <label>Author</label><br>
    <input name="author" value="${book.author}" /><br><br>
    <label>Description</label><br>
    <input name="description" value="${book.description}" /><br><br>
    <label>quantity</label><br>
    <input name="quantity" value="${product.quantity}" type="number" min="0" /><br><br>
    <input type="submit" value="Send" />
</form>
</body>
</html>