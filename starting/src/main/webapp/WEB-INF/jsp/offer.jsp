<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>
<!DOCTYPE html>
    <html>
    <head>
   
      <title>Offer</title>
     
      <!-- Bootstrap -->

        <link rel="stylesheet" type="text/css" href="/starting/static/css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="/starting/static/css/bootstrap-responsive.css" />
        <link rel="stylesheet" type="text/css" href="/starting/static/css/bootstrap-tagmanager.css" />
        <link rel="stylesheet" type="text/css" href="/starting/static/css/datepicker.css" />
        <link rel="stylesheet" type="text/css" href="/starting/static/css/timepicker.css" />
        <script src="/starting/static/js/jquery-1.7.1.min.js"></script>
        <script src="/starting/static/js/bootstrap.js"></script>
        <script src="/starting/static/js/bootstrap-tagmanager.js"></script>
        <script src="/starting/static/js/bootstrap-datepicker.js"></script>
        <script src="/starting/static/js/bootstrap-timepicker.js"></script>
        <script src="/starting/static/js/main.js"></script>
    </head>
 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>

    <script type="text/javascript">
      $(document).ready(function() {
          jQuery(".tagManager").tagsManager();
          $('.timepicker-default').timepicker();
          townUtil();
          districtUtil();
       });

    </script>

  </head>

  <body>
  
  <jsp:include page="headerUser.jsp"></jsp:include>
   
    <body>
      <div class="container" align="left" class="span6">
        <form action="/starting/offer" method="post">
            <label><strong>Offer Service</strong></label> 
            <div class="btn-group" data-toggle="buttons-radio">
            <%--<button type="button" class="btn"><a href="offer.jsp">Offer</a></button>--%>
            <%--<button type="button" class="btn"><a href="request.jsp">Request</a></button>--%>
            </div>
            <br>

            <input type="hidden" name="userId" value="${loggedInUser.userId}">

            <label>Service Name</label>
            <input class="span6" type="text" name="servicename" required=""/>

            <label>Description</label>
            <textarea class="span6" rows="2" name="description" required=""></textarea>
             
            <label>Tags</label> 
            <input type="text" name="tags" placeholder="Tags" class="tagManager"/>

            <label>Location</label> 
      
            <select name="city" id="city">
                <c:forEach items="${cities}" var="city">
                    <option value="${city.id}" >${city.name}</option>
                </c:forEach>
            </select>
            <br>
            <br>
            <select name="town" id="town" disabled="disabled">
            </select>
            <br>
            <br>
            <select name="district" id="district" disabled="disabled">
            </select>
            <br>
            <br>
            <label>Start Date:</label><input type="text" class="span2" name="begindate" required="" value="" id="dp1">
            <br>
            <label>End Date:</label><input type="text" class="span2" name="enddate" required="" value="" id="dp2">
            <br>
            <br>

            <table class="table">
                <thead>

                  <tr>
                    <td>#</td>
                    <td>   Monday  </td>
                    <td>   Tuesday </td>
                    <td>   Wednesday </td>
                    <td>   Thursday   </td>
                    <td>   Friday  </td>
                    <td>   Saturday   </td>
                    <td>   Sunday </td>



                  </tr>

                </thead>

                <tbody>

                  <tr>  

                    <td>
                      Beginning    
                    </td>


                    <td>
                      <div class="input-append bootstrap-timepicker-component">
                      <input type="text" name="timeinterval1" required="" class="timepicker-default input-small">
                      <span class="add-on">
                      <i class="icon-time"></i>
                      </span>
                      </div>
                    </td> 

                   
                    <td>
                      <div class="input-append bootstrap-timepicker-component">
                      <input type="text" name="timeinterval3" required="" class="timepicker-default input-small">
                      <span class="add-on">
                      <i class="icon-time"></i>
                      </span>
                      </div>
                    </td>

                    <td>
                      <div class="input-append bootstrap-timepicker-component">
                      <input type="text" name="timeinterval5" required="" class="timepicker-default input-small">
                      <span class="add-on">
                      <i class="icon-time"></i>
                      </span>
                      </div>
                    </td> 

                   
                    <td>
                      <div class="input-append bootstrap-timepicker-component">
                      <input type="text" name="timeinterval7" required="" class="timepicker-default input-small">
                      <span class="add-on">
                      <i class="icon-time"></i>
                      </span>
                      </div>
                    </td>   
                    
                    <td>
                      <div class="input-append bootstrap-timepicker-component">
                      <input type="text" name="timeinterval9" required="" class="timepicker-default input-small">
                      <span class="add-on">
                      <i class="icon-time"></i>
                      </span>
                      </div>
                    </td>

                    <td>
                      <div class="input-append bootstrap-timepicker-component">
                      <input type="text" name="timeinterval11" required="" class="timepicker-default input-small">
                      <span class="add-on">
                      <i class="icon-time"></i>
                      </span>
                      </div>
                    </td> 

                   
                    <td>
                      <div class="input-append bootstrap-timepicker-component">
                      <input type="text" name="timeinterval13" required="" class="timepicker-default input-small">
                      <span class="add-on">
                      <i class="icon-time"></i>
                      </span>
                      </div>
                    </td>                                      

                  </tr>                        
                     
                  <tr>  

                    <td>
                      End
                    </td>

                    <td>
                      <div class="input-append bootstrap-timepicker-component">
                      <input type="text" name="timeinterval2" required="" class="timepicker-default input-small">
                      <span class="add-on">
                      <i class="icon-time"></i>
                      </span>
                      </div>
                    </td> 

                   
                    <td>
                      <div class="input-append bootstrap-timepicker-component">
                      <input type="text" name="timeinterval4" required="" class="timepicker-default input-small">
                      <span class="add-on">
                      <i class="icon-time"></i>
                      </span>
                      </div>
                    </td>

                    <td>
                      <div class="input-append bootstrap-timepicker-component">
                      <input type="text" name="timeinterval6" required="" class="timepicker-default input-small">
                      <span class="add-on">
                      <i class="icon-time"></i>
                      </span>
                      </div>
                    </td> 

                   
                    <td>
                      <div class="input-append bootstrap-timepicker-component">
                      <input type="text" name="timeinterval8" required="" class="timepicker-default input-small">
                      <span class="add-on">
                      <i class="icon-time"></i>
                      </span>
                      </div>
                    </td>   
                    
                    <td>
                      <div class="input-append bootstrap-timepicker-component">
                      <input type="text" name="timeinterval10" required="" class="timepicker-default input-small">
                      <span class="add-on">
                      <i class="icon-time"></i>
                      </span>
                      </div>
                    </td>

                    <td>
                      <div class="input-append bootstrap-timepicker-component">
                      <input type="text" name="timeinterval12" required="" class="timepicker-default input-small">
                      <span class="add-on">
                      <i class="icon-time"></i>
                      </span>
                      </div>
                    </td> 

                   
                    <td>
                      <div class="input-append bootstrap-timepicker-component">
                      <input type="text" name="timeinterval14" required="" class="timepicker-default input-small">
                      <span class="add-on">
                      <i class="icon-time"></i>
                      </span>
                      </div>
                    </td>                                      

                  </tr>                                                                   

                </tbody> 

            </table>

          <button type="submit" class="btn btn-primary" data-loading-text="Submitting...">Submit</button>
        </form>

        <hr>





        <footer>
        <p>&copy; Cmpe 451 Group1 Fall2012</p>
        </footer>
      </div>

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


