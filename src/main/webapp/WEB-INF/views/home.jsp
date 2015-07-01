<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Library Home Page</title>
    <link rel="stylesheet" href="/scripts/css/main.css" type="text/css"/>
</head>
<body>
<div id="login">
    Welcome to Biblioteca!
    <form action="<c:url value='j_spring_security_check' />" method="post">

        <div class="login_input">
            <input type="text" required name='j_username'>
            <span class="highlight"></span>
            <span class="bar"></span>
            <label>Name</label>
        </div>

        <div class="login_input">
            <input type="password" required name='j_password'>
            <span class="highlight"></span>
            <span class="bar"></span>
            <label>Password</label>
        </div>

        <div>
            <input class="login_button" type="submit" value="Log In">
        </div>
    </form>
</div>

</body>
</html>