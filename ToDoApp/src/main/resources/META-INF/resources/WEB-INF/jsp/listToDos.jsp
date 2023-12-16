<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>ToDo App</title>
    <link href="webjars\bootstrap\5.1.3\css\bootstrap.min-jsf.css" rel="stylesheet">
</head>
<body>
    <div class="container">
    <p>Hello ${name}!</p>
    <hr>
    <h1>Your ToDo's </h1>
    <table class="table">
        <thead>
            <tr>
                <th>id</th>
                <th>user</th>
                <th>description</th>
                <th>target completion</th>
                <th>is done</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.userName}</td>
                <td>${todo.description}</td>
                <td>${todo.date}</td>
                <td>${todo.completed}</td>
                <td> <a href="update-todo?id=${todo.id}" class="btn btn-info">Update</a> </td>
                <td> <a href="delete-todo?id=${todo.id}" class=" btn btn-warning">Delete</a> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add ToDo</a>    
    </div>
    <script src="webjars\bootstrap\5.1.3\js\bootstrap.js"></script>
    <script src="webjars\jquery\3.6.0\jquery.js"></script>
</body>
</html>