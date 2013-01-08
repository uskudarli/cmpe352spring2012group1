<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>
<%--<script src="/starting/static/js/bootstrap-alert.js"></script>--%>
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
                    <li><a href="/starting/about">About</a></li>
                </ul>
                <ul class="nav">
                    <li><a href="/starting/signup">Sign Up</a></li>
                </ul>

                <form method="post" action="<c:url value='j_spring_security_check' />" accept-charset="UTF-8" class="navbar-form pull-right">
                    <input type="text" id="j_username" name="j_username" placeholder="Email">
                    <input type="password" id="j_password" name="j_password" placeholder="Password">
                    <button type="submit" class="btn">Sign in</button>
                </form>
                
            </div><!--/.nav-collapse -->
        </div>
    </div>
                                <%--<div id = "loginerror" class="span5 offset7" align="right"></div>--%>
                <%--<script>
                bootstrap_alert = function() {}
                bootstrap_alert.alert = function() {
                            $('#loginerror').html('<div align="center" class="alert alert-error"><a class="close" data-dismiss="alert">×</a>Wrong user name or password.</div>')
                        }

                if(${error}) {
                            bootstrap_alert.alert();
                }
                </script>--%>​
</div>
                