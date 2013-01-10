<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--
  Created by IntelliJ IDEA.
  User: alperen
  Date: 16.12.2012
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/starting/static/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="/starting/static/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="/starting/static/css/bootstrap-tagmanager.css" />
<link rel="stylesheet" type="text/css" href="/starting/static/css/datepicker.css" />
<link rel="stylesheet" type="text/css" href="/starting/static/css/bootstrap-editable.css">
<script src="/starting/static/js/jquery-1.7.1.min.js"></script>
<script src="/starting/static/js/bootstrap.js"></script>
<script src="/starting/static/js/bootstrap-tagmanager.js"></script>
<script src="/starting/static/js/bootstrap-datepicker.js"></script>
<script src="/starting/static/js/main.js"></script>
<script src="/starting/static/js/bootstrap-editable.js"></script>
<script>
    $(document).ready(function() {
        $('.applyform').submit(function(){
            alert("submitted");
            /*$('.applypop').popover('hide');*/
            return true;
        })
    })
    </script>
        <div class="container">
    <form action="/starting/apply" method="post" class="applyform">

        <textarea name="description" rows="3"></textarea>
        <br>
        <input type="hidden" name="userId" value="${userId}"/>
        <input type="hidden" name="serviceId" value="${serviceId}"/>
        <input type="hidden" name="type" value="${type}"/>
      <button class="btn btn-info" type="submit">Apply</button>

    </form>
</div>