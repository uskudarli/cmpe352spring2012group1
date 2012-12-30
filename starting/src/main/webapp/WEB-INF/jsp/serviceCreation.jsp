<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%-- Service Creation page --%>
<!DOCTYPE html>
<html>
<head>

<title>Service Creation</title>

<!-- Bootstrap -->

<link rel="stylesheet" type="text/css"
	href="/starting/static/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="/starting/static/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="/starting/static/css/bootstrap-tagmanager.css" />
<link rel="stylesheet" type="text/css"
	href="/starting/static/css/datepicker.css" />
<script src="/starting/static/js/jquery-1.7.1.min.js"></script>
<script src="/starting/static/js/bootstrap.js"></script>
<script src="/starting/static/js/bootstrap-tagmanager.js"></script>
<script src="/starting/static/js/bootstrap-datepicker.js"></script>
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

       });

    </script>

</head>

<body>

	<jsp:include page="headerUser.jsp"></jsp:include>
<body>
	<div class="container">
		<form>
			<label>Service Type</label>
			<div class="btn-group" data-toggle="buttons-radio">
				<a class="btn btn-primary" href="/starting/offer">Offer</a> <a
					class="btn btn-primary" href="/starting/request">Request</a>
			</div>
			<br>
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