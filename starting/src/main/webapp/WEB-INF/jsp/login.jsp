<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>

<%-- This page is the welcome page of our project --%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%--must be included--%>
    <link rel="stylesheet" type="text/css" href="/starting/static/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="/starting/static/css/bootstrap-responsive.css" />
    <script src="/starting/static/js/jquery-1.7.1.min.js"></script>
    <script src="/starting/static/js/bootstrap.js"></script>

    <%--<%@ include file="/staticContent/css/bootstrap.css" %>--%>
    <title>Login Page</title>

</head>
<body>

    <jsp:include page="header.jsp"/>

    <div class="container">

        <!-- Main hero unit for a primary marketing message or call to action -->
        <div class="hero-unit">
            <div class="row">
                <div class="span3">
                    <img src="static/img/socialsoda.gif" class="img-rounded">
                </div>
                <div class="span7">
                    <h2>Welcome to Soda!</h2>
                    <p>The Soda (Social Dabster) Project is a Social Services Community which offers individuals the opportunity to share skills and needs, to help themselves while helping others. Every individual can supply useful services. The main principles of matching people are reciprocity and equality. The service exchange not only complements existing services but also promotes self-sufficiency and connection inside community.</p>
                   <p><a class="btn btn-primary" href="/starting/about">Learn more &raquo;</a></p>
                </div>
            </div>
            <div class="row">
                <div class="span7 offset3">
                    <h3>Take a look!</h3>
                    <p>You can search for services without registration.</p>
                    <p><a class="btn" href="/starting/search">Take Me to Search Page &raquo;</a></p>
                </div>
            </div>
        </div>
        <hr>

        <footer>
            <p>&copy; Cmpe451 Group1 Fall2012</p>
        </footer>

    </div> <!-- /container -->


</body>
</html>





</body>
</html>