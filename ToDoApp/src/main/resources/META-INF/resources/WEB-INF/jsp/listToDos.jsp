<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1>Your ToDo's </h1>
    <table class="table">
        <thead>
        <tr>
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
                <td>${todo.userName}</td>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.completed}</td>
                <td><a href="update-todo?id=${todo.id}" class="btn btn-info">Update</a></td>
                <td><a href="delete-todo?id=${todo.id}" class=" btn btn-warning">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add ToDo</a>
</div>
<%@ include file="common/footer.jspf" %>