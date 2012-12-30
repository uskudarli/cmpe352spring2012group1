<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>
   <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="brand" href="#">Soda</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
                <li><a href="/starting/profile">Profile</a></li>
                <li><a href="/starting/search">Search for Services</a></li>
                <li><a href="/starting/createservice">Offer/Request Services</a></li>
                <li><a href="/starting/about">Help</a></li>
            </ul>
              <ul class="nav pull-right">
                  <li><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>
              </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>