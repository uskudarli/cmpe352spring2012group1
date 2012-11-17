<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>

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


<%--
<div class="container" style="margin-top: 64px">
    <div class="row">
        <div class="span4 offset4 well">
            <legend>Lütfen Giriş Yapınız</legend>

            <form method="POST" action="<c:url value='j_spring_security_check' />" accept-charset="UTF-8">
                <input type="text" id="j_username" class="span4" name="j_username" placeholder="İsim">
                <input type="password" id="j_password" class="span4" name="j_password" placeholder="Şifre">

                <br>
                <br>
                <button type="submit" name="submit" class="btn btn-info btn-block">Giriş</button>
            </form>
        </div>
    </div>
</div>
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Bootstrap, from Twitter</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <style type="text/css">
        body {
            padding-top: 60px;
            padding-bottom: 40px;
        }
    </style>


    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img\glyphicons-halflings.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img\glyphicons-halflings.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img\glyphicons-halflings.png">
    <link rel="apple-touch-icon-precomposed" href="img\glyphicons-halflings.png">
</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">Soda Project</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li><a href="#about">About</a></li>


                </ul>

                <form method="POST" action="<c:url value='j_spring_security_check' />" accept-charset="UTF-8" class="navbar-form pull-right">

                    <input type="text" id="j_username" class="span4" name="j_username" placeholder="Email">
                    <input type="password" id="j_password" class="span4" name="j_password" placeholder="Password">

                    <button type="submit" class="btn">Sign in</button>
                </form>

            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>

<div class="container">

    <!-- Main hero unit for a primary marketing message or call to action -->
    <div class="hero-unit">
        <div class="row">
            <div class="span3">
                <img src="social-soda.gif" class="img-rounded">
            </div>
            <div class="span7">
                <h2>Welcome to Soda!</h2>
                <p>The Soda (Social Dabster) Project is a Social Services Community which offers individuals the opportunity to share skills and needs, to help themselves while helping others. Every individual can supply useful services. The main principles of matching people are reciprocity and equality. The service exchange not only complements existing services but also promotes self-sufficiency and connection inside community.</p>
                <p><a class="btn btn-primary btn-large">Learn more &raquo;</a></p>
            </div>
        </div>
        <div class="row">
            <div class="span4 offset3">
                <h3>Take a look inside</h3>
                <p>Take a tour as a guest before registering into the system</p>
                <p><a class="btn" href="search.html">View details &raquo;</a></p>
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