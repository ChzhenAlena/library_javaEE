<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create book</title>
</head>
<body>
<h3>New book</h3>
<form method="post">
    <label>Title</label><br>
    <input name="title"/><br><br>
    <label>Author</label><br>
    <input name="author"/><br><br>
    <label>Description</label><br>
    <input name="description"/><br><br>
    <label>Quantity</label><br>
    <input name="quantity" type="number" min="0" /><br><br>
    <input type="submit" value="Save" />
</form>
</body>
</html>