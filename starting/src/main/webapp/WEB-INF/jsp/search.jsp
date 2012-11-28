<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>
<!DOCTYPE html>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Soda Profile</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

      <link rel="stylesheet" type="text/css" href="/starting/static/css/bootstrap.css" />
      <link rel="stylesheet" type="text/css" href="/starting/static/css/bootstrap-responsive.css" />
      <link rel="stylesheet" type="text/css" href="/starting/static/css/bootstrap-tagmanager.css" />
      <link rel="stylesheet" type="text/css" href="/starting/static/css/datepicker.css" />
      <script src="/starting/static/js/jquery-1.7.1.min.js"></script>
      <script src="/starting/static/js/bootstrap.js"></script>
      <script src="/starting/static/js/bootstrap-tagmanager.js"></script>
      <script src="/starting/static/js/bootstrap-datepicker.js"></script>
      <script src="/starting/static/js/main.js"></script>

      <script>
          $(document).ready(function() {
              jQuery(".tagManager").tagsManager();
              townUtil();
          });
      </script>

    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="brand" href="#">Soda</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li><a href="home.html">Home</a></li>
              <li class="active"><a href="profile.jsp">Profile</a></li>
              <li><a href="search.jsp">Search for Services</a></li>
              <li><a href="offer.jsp">Offer Services</a></li>
              <li><a href="help.html">Help</a></li>
            </ul>
              <ul class="nav pull-right">
                  <li><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></li>
              </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">
      <form action="/starting/search" method="post">
          <label><strong>City:</strong></label>
          <select name="city" id="city" required="required">
              <c:forEach items="${cities}" var="city">
                  <option value="${city.id}" >${city.name}</option>
              </c:forEach>
          </select>
          <label><strong>Town:</strong></label>
              <select name="town" id="town" disabled="disabled">
                  <option value="0">You can choose</option>
              </select>
              <p>You don't have to choose town, but you must choose city!</p>
        <br>
        <%--<button type="submit" class="btn">I'm Feeling Lucky</button>--%>
            <label><strong>Start Date:</strong></label><input type="text" class="span2" name="begindate" value="" id="dp1">
            <br>
            <label><strong>End Date:</strong></label><input type="text" class="span2" name="enddate" value="" id="dp2">
            <br>
            <input type="radio" name="searchType" value="requested_services" checked="checked"> I want to see requested services
            <br>
            <input type="radio" name="searchType" value="offered_services" > I want to see offered services
            <br>
            <br>
            <label>Search:</label>
            <input type="text" name="tags" placeholder="Search" class="tagManager"/>
        <br>

        <button type="submit" class="btn">Search</button>
      </form>
      
      <br>

    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <c:if test="${requestedServices!=null}">
    <table class="table table-condensed">
        <thead>
        <tr>
            <th>Title</th>
            <th>Begin Date</th>
            <th>End Date</th>
        </tr>
        </thead>
        <tbody>
        <div class="accordion" id="accordion3">
        <c:forEach items="${requestedServices}" var="service">
            <tr>
                <td>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" href="#collapserequest${service.id}">
                                        ${service.title}
                                </a>
                            </div>
                            <div id="collapserequest${service.id}" class="accordion-body collapse">
                                <div class="accordion-inner">
                                        ${service.desc}
                                        ${service.tag}
                                </div>
                            </div>
                        </div>
                </td>
                <td>${service.beginDate}</td>
                <td>${service.endDate}</td>
            </tr>
        </c:forEach>
        </div>
        </tbody>

    </table>

    </c:if>

    <c:if test="${offeredServices!=null}">
    <table class="table table-condensed">
        <thead>
        <tr>
            <th>Title</th>
            <th>Begin Date</th>
            <th>End Date</th>
        </tr>
        </thead>
        <tbody>
        <div class="accordion" id="accordion3">
        <c:forEach items="${offeredServices}" var="service">
            <tr>
                <td>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" href="#collapseoffer${service.id}">
                                        ${service.title}
                                </a>
                            </div>
                            <div id="collapseoffer${service.id}" class="accordion-body collapse">
                                <div class="accordion-inner">
                                        ${service.desc}
                                        ${service.tag}
                                </div>
                            </div>
                        </div>
                </td>
                <td>${service.beginDate}</td>
                <td>${service.endDate}</td>
            </tr>
        </c:forEach>
        </div>
        </tbody>

    </table>

    </c:if>

    <br>
    <hr class="bs-docs-separator"></hr>
    <footer>
        <p>&copy; Cmpe451 Group1 Fall2012</p>
    </footer>

    <script>

        $(function(){

            var startDate = new Date(2012,1,20);
            var endDate = new Date(2012,1,25);

            $('#dp1').datepicker()
                    .on('changeDate', function(ev){
                        if (ev.date.valueOf() > endDate.valueOf()){
                            $('#alert').show().find('strong').text('The start date can not be greater then the end date');
                        } else {
                            $('#alert').hide();
                            startDate = new Date(ev.date);
                            $('#startDate').text($('#dp1').data('date'));
                        }
                        $('#dp1').datepicker('hide');
                    });
            $('#dp2').datepicker()
                    .on('changeDate', function(ev){
                        if (ev.date.valueOf() < startDate.valueOf()){
                            $('#alert').show().find('strong').text('The end date can not be less then the start date');
                        } else {
                            $('#alert').hide();
                            endDate = new Date(ev.date);
                            $('#endDate').text($('#dp2').data('date'));
                        }
                        $('#dp2').datepicker('hide');

                    });
        });
    </script>

  </body>
</html>
