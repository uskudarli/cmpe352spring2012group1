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




<%--<form name='f' action="<c:url value='j_spring_security_check' />"
      method='POST'>

    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='j_username' value=''>
            </td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='j_password' />
            </td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit"
                                   value="submit" />
            </td>
        </tr>
        <tr>
            <td colspan='2'><input name="reset" type="reset" />
            </td>
        </tr>
    </table>

</form>--%>
</body>
</html>