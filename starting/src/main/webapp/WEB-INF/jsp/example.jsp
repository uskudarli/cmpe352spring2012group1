<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" type="text/css" href="/starting/staticContent/css/bootstrap.css" />
        <title>Spring MVC Example</title>
    </head>
    <body>
        <h2>Welcome to the Example Spring MVC page</h2>
        <h3>The message text is:</h3>
        <p>${message}</p>
        <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
    </body>
</html>