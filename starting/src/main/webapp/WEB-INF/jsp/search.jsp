<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
      <link rel="stylesheet" type="text/css" href="/starting/static/css/bootstrap-editable.css">
      <script src="/starting/static/js/jquery-1.7.1.min.js"></script>
      <script src="/starting/static/js/bootstrap.js"></script>
      <script src="/starting/static/js/bootstrap-tagmanager.js"></script>
      <script src="/starting/static/js/bootstrap-datepicker.js"></script>
      <script src="/starting/static/js/main.js"></script>
      <script src="/starting/static/js/bootstrap-editable.js"></script>
      <script>
          $(document).ready(function() {
              jQuery(".tagManager").tagsManager();
//              $('.btn-danger').popover();
              townUtil();
              myAjaxSubmit();
              $('.applypop').bind('click',function(){
                 var that=this;
                 var $url=$(that).attr('data-load');
                  $(that).unbind('click');
                  $.ajax({
                      url: $url,
                      type: "GET",
                      success:function(data) {
//                          var $popoverdata=html(data);
                         $(that).popover({content:data}).popover('show');
//                          alert($(that).attr("class"));
                      }

                  });
                  return false;
              });

              $('#searchform').submit(function() {
                  var $selectedCity = $('#city').find('option:selected').attr('value');
                  if($selectedCity=="-1" || $selectedCity==undefined){
                      alert("please select city!");
                      return false;
                  }
                  if($('.myTag').find('span').text()==""){
                      alert("Please insert tag");
                      return false;
                  }
                  return true;
              });

              $('input:radio').on('click',function(){
                  if($(this).val()=="requested_services"){
                     $('#everyone').removeAttr('disabled');
                  }
                  else if($(this).val()=="offered_services"){
                      $('#everyone').attr('disabled','disabled');
                  }
              })

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
  
  <jsp:include page="headerUser.jsp"></jsp:include>

    <div class="container">
      <form action="/starting/search" method="post" id="searchform">
          <label><strong>City:</strong></label>
          <select name="city" id="city" required="required">
                  <option value="-1" >Please Choose...</option>
              <c:forEach items="${cities}" var="city">
                  <option value="${city.id}" >${city.name}</option>
              </c:forEach>
          </select>
          <label><strong>Town:</strong></label>
              <select name="town" id="town" disabled="disabled">
                  <option value="0">You can choose</option>
              </select><img src="/starting/static/img/loading.gif" hidden="hidden" class="towngif">
              <p>You don't have to choose town, but you must choose city!</p>
        <br>
        <%--<button type="submit" class="btn">I'm Feeling Lucky</button>--%>
            <label><strong>Start Date:</strong></label><input type="text" required="" class="span2" name="begindate" value="" id="dp1">
            <br>
            <label><strong>End Date:</strong></label><input type="text" required="" class="span2" name="enddate" value="" id="dp2">
            <br>
            <input type="radio" name="searchType" value="requested_services" checked="checked"> I want to see requested services
            <br>
            <input type="radio" name="searchType" value="offered_services" > I want to see offered services
            <br>
            <br>
            <label class="checkbox">
              <input id="everyone" name="serviceeveryone" value="1" type="checkbox"> Service everyone
            </label>
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
        <div class="accordion" id="accordion1">
        <c:forEach items="${requestedServices}" var="service" varStatus="status">
            <tr>
                <td>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion1" href="#collapserequest${service.id}">
                                        ${service.title}
                                </a>
                            </div>
                            <div id="collapserequest${service.id}" class="accordion-body collapse">
                                <div class="accordion-inner">
                                        ${service.desc}
                                        ${service.tag}
                                            <br>
                                            M:${timesRequest[status.index][0]}
                                            <br>
                                            T:${timesRequest[status.index][1]}
                                            <br>
                                            W:${timesRequest[status.index][2]}
                                            <br>
                                            Th:${timesRequest[status.index][3]}
                                            <br>
                                            Fr:${timesRequest[status.index][4]}
                                            <br>
                                            Sat:${timesRequest[status.index][5]}
                                            <br>
                                            Sun:${timesRequest[status.index][6]}
                                </div>
                            </div>
                        </div>
                </td>
                <td><fmt:formatDate dateStyle="short" value="${service.beginDate}"></fmt:formatDate></td>
                <td><fmt:formatDate dateStyle="short" value="${service.endDate}"></fmt:formatDate></td>
                <td>
                <c:if test="${loggedInUser!=null}">
                <a class="applylink">Apply</a>
                <div hidden="hidden">
                    <br>
                    <textarea rows="2" name="description" cols="2"></textarea>
                    <br>
                    <a href="/starting/apply/request/${service.id}/${loggedInUser.userId}/" class="btn btn-success submitlink">Submit</a>
                </div>
                 </c:if>
                </td>
                <input type="hidden" value="${service.id}"/>
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
        <div class="accordion" id="accordion2">
        <c:forEach items="${offeredServices}" var="service" varStatus="status">
            <tr>
                <td>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseoffer${service.id}">
                                        ${service.title}
                                </a>
                            </div>
                            <div id="collapseoffer${service.id}" class="accordion-body collapse">
                                <div class="accordion-inner">
                                        ${service.desc}
                                        ${service.tag}
                                            <br>
                                        M:${timesOffer[status.index][0]}
                                            <br>
                                        T:${timesOffer[status.index][1]}
                                            <br>
                                        W:${timesOffer[status.index][2]}
                                            <br>
                                        Th:${timesOffer[status.index][3]}
                                            <br>
                                        Fr:${timesOffer[status.index][4]}
                                            <br>
                                        Sat:${timesOffer[status.index][5]}
                                            <br>
                                        Sun:${timesOffer[status.index][6]}


                                </div>
                            </div>
                        </div>
                </td>
                <td><fmt:formatDate value="${service.beginDate}"></fmt:formatDate></td>
                <td><fmt:formatDate value="${service.endDate}"></fmt:formatDate></td>
                <td>
                    <c:if test="${loggedInUser!=null}">
                    <a class="applylink">Apply</a>
                    <div hidden="hidden">
                        <br>
                        <textarea rows="2" name="description" cols="2"></textarea>
                        <br>
                        <a href="/starting/apply/offer/${service.id}/${loggedInUser.userId}/" class="btn btn-success submitlink">Submit</a>
                    </div>
                </c:if>
                </td>
                </td>
                <input type="hidden" value="${service.id}"/>
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
