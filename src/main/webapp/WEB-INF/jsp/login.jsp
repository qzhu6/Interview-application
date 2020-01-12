<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <h1>Log In</h1>
    <div class="container">
        <span style="color: red;"><c:out value="${LogIninformation}"></c:out></span>
        <form action="/auth/login?redirect=${param.redirect}" method="post">
            Name:<input type="text" name="username"><br>
            Password:<input type="password" name="password"><br>
            <input type="submit" value="login">
        </form>
    </div>
</div>
</body>
</html>