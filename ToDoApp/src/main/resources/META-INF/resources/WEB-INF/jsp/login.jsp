<html>
<head>
    <title>ToDo App</title>
    <link href="webjars\bootstrap\5.1.3\css\bootstrap.min-jsf.css" rel="stylesheet">
    
</head>
<body>
    <div class="container">
    <p>Hello, Welcome to Login page!</p>
    <form method="post">
        Name: <input type="text" name="name">
        Password: <input type="password" name="password">
        <input type="submit">
    </form>
    <pre>${errorMessage}</pre>
    </div>
    <script src="webjars\bootstrap\5.1.3\js\bootstrap.js"></script>
    <script src="webjars\jquery\3.6.0\jquery.js"></script>
</body>
</html>