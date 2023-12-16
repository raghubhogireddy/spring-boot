<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="webjars\bootstrap\5.1.3\css\bootstrap.min-jsf.css" rel="stylesheet">
    <title>Add ToDo</title>
</head>
<body>
    <div class="container">
        <h1>Enter ToDo details</h1>
        <form:form method="post" modelAttribute="toDo">
            Description: <form:input type="text" name="description" required="required" path="description"/>
            <form:errors path="description" cssClass="text-danger"/>
            <form:input  type="hidden" name="id" path="id" />
            <form:input  type="hidden" name="completed" path="completed" />
            <input type="submit" class="btn btn-success">
        </form:form>
    </div>
    <script src="webjars\bootstrap\5.1.3\js\bootstrap.js"></script>
    <script src="webjars\jquery\3.6.0\jquery.js"></script>
</body>
</html>