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
<div class="container">
    <form action="/starting/apply" method="post">

        <textarea name="description" rows="3"></textarea>
        <br>
        <input type="hidden" name="userId" value="${userId}"/>
        <input type="hidden" name="serviceId" value="${serviceId}"/>
        <input type="hidden" name="type" value="${type}"/>
  >   <button class="btn btn-info" type="submit">Apply</button>

    </form>
</div>