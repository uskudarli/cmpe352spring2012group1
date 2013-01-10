<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
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
        <script src="/starting/static/js/jquery.limit-1.2.source.js"></script>
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
        submitValidation();
	});
</script>

</head>

<body>
	<jsp:include page="headerUser.jsp"></jsp:include>
<body>
	<div class="container" align="left" class="span6">
		<form action="/starting/offer" method="post" id="createform">
			<label><strong>Offer Service</strong></label>
			<div class="btn-group" data-toggle="buttons-radio">
				<%--<button type="button" class="btn"><a href="offer.jsp">Offer</a></button>--%>
				<%--<button type="button" class="btn"><a href="request.jsp">Request</a></button>--%>
			</div>
			<br>

			<!-- <form>
		<label>Limit demonstration</label>
		<div class="width-hack-input">
			<span class="w">
				<textarea type="text" class="input">Lorem Ipsum is simply dummy text of the printing and  typesetting industry. Lorem Ipsum has been the industry's standard dummy.</textarea>
			</span>
			<p>You have <span id="charsLeft"></span> chars left.</p>
		</div>
	</form -->


			<input type="hidden" name="userId" value="${loggedInUser.userId}">

			<label>Service Name</label> <input id="title" class="span6"
				type="text" name="servicename" required="" /> <span
				class="help-inline label label-inverse" id="titlecharsLeft"></span>

			<script>
				$('#title').limit('70', '#titlecharsLeft');
			</script>

			<label>Description</label>
			<textarea id="desc" class="span6" rows="2" name="description"
				required=""></textarea>
			<span class="help-inline label label-inverse" id="desccharsLeft"></span>

			<script>
				$('#desc').limit('500', '#desccharsLeft');
			</script>

			<label>Tags</label> <input type="text" name="tags" placeholder="Tags"
				class="tagManager" /> <label>Location</label> <select name="city"
				id="city">
                <option value="-1" >Please Choose...</option>
				<c:forEach items="${cities}" var="city">
					<option value="${city.id}">${city.name}</option>
				</c:forEach>
			</select>
			<br> <br> <select name="town" id="town" disabled="disabled">
			</select> <img src="/starting/static/img/loading.gif" hidden="hidden" class="towngif" />
			<br> <br> <select name="district" id="district"
				disabled="disabled">
			</select><img src="/starting/static/img/loading.gif" hidden="hidden" class="districtgif" />
            <br> <br> <label>Start Date:</label><input type="text"
				class="span2" name="begindate" required="" value="" id="dp1">
			<br> <label>End Date:</label><input type="text" class="span2"
				name="enddate" required="" value="" id="dp2"> <br> <br>
            <label>Duration:</label>
            <select name="duration">
                <option selected="selected" value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
            </select>

			<table class="table">
				<thead>

					<tr>
						<td>#</td>
						<td>Monday</td>
						<td>Tuesday</td>
						<td>Wednesday</td>
						<td>Thursday</td>
						<td>Friday</td>
						<td>Saturday</td>
						<td>Sunday</td>



					</tr>

				</thead>

				<tbody>

					<tr>

						<td>Beginning</td>


						<td>
							<div class="input-append bootstrap-timepicker-component">
								<input type="text" name="timeinterval1"
									class="timepicker-default input-small"> <span
									class="add-on"> <i class="icon-time"></i>
								</span>
							</div>
						</td>


						<td>
							<div class="input-append bootstrap-timepicker-component">
								<input type="text" name="timeinterval3"
									class="timepicker-default input-small"> <span
									class="add-on"> <i class="icon-time"></i>
								</span>
							</div>
						</td>

						<td>
							<div class="input-append bootstrap-timepicker-component">
								<input type="text" name="timeinterval5"
									class="timepicker-default input-small"> <span
									class="add-on"> <i class="icon-time"></i>
								</span>
							</div>
						</td>


						<td>
							<div class="input-append bootstrap-timepicker-component">
								<input type="text" name="timeinterval7"
									class="timepicker-default input-small"> <span
									class="add-on"> <i class="icon-time"></i>
								</span>
							</div>
						</td>

						<td>
							<div class="input-append bootstrap-timepicker-component">
								<input type="text" name="timeinterval9"
									class="timepicker-default input-small"> <span
									class="add-on"> <i class="icon-time"></i>
								</span>
							</div>
						</td>

						<td>
							<div class="input-append bootstrap-timepicker-component">
								<input type="text" name="timeinterval11"
									class="timepicker-default input-small"> <span
									class="add-on"> <i class="icon-time"></i>
								</span>
							</div>
						</td>


						<td>
							<div class="input-append bootstrap-timepicker-component">
								<input type="text" name="timeinterval13"
									class="timepicker-default input-small"> <span
									class="add-on"> <i class="icon-time"></i>
								</span>
							</div>
						</td>

					</tr>

					<tr>

						<td>End</td>

						<td>
							<div class="input-append bootstrap-timepicker-component">
								<input type="text" name="timeinterval2"
									class="timepicker-default input-small"> <span
									class="add-on"> <i class="icon-time"></i>
								</span>
							</div>
						</td>


						<td>
							<div class="input-append bootstrap-timepicker-component">
								<input type="text" name="timeinterval4"
									class="timepicker-default input-small"> <span
									class="add-on"> <i class="icon-time"></i>
								</span>
							</div>
						</td>

						<td>
							<div class="input-append bootstrap-timepicker-component">
								<input type="text" name="timeinterval6"
									class="timepicker-default input-small"> <span
									class="add-on"> <i class="icon-time"></i>
								</span>
							</div>
						</td>


						<td>
							<div class="input-append bootstrap-timepicker-component">
								<input type="text" name="timeinterval8"
									class="timepicker-default input-small"> <span
									class="add-on"> <i class="icon-time"></i>
								</span>
							</div>
						</td>

						<td>
							<div class="input-append bootstrap-timepicker-component">
								<input type="text" name="timeinterval10"
									class="timepicker-default input-small"> <span
									class="add-on"> <i class="icon-time"></i>
								</span>
							</div>
						</td>

						<td>
							<div class="input-append bootstrap-timepicker-component">
								<input type="text" name="timeinterval12"
									class="timepicker-default input-small"> <span
									class="add-on"> <i class="icon-time"></i>
								</span>
							</div>
						</td>


						<td>
							<div class="input-append bootstrap-timepicker-component">
								<input type="text" name="timeinterval14"
									class="timepicker-default input-small"> <span
									class="add-on"> <i class="icon-time"></i>
								</span>
							</div>
						</td>

					</tr>

				</tbody>

			</table>

			<button type="submit" class="btn btn-primary"
				data-loading-text="Submitting...">Submit</button>
		</form>

		<hr>

		<footer>
			<p>&copy; Cmpe 451 Group1 Fall2012</p>
		</footer>
	</div>

	<script>
		$(function() {

			var startDate = new Date(2012, 1, 20);
			var endDate = new Date(2012, 1, 25);

			$('#dp1')
					.datepicker()
					.on(
							'changeDate',
							function(ev) {
								if (ev.date.valueOf() > endDate.valueOf()) {
									$('#alert')
											.show()
											.find('strong')
											.text(
													'The start date can not be greater then the end date');
								} else {
									$('#alert').hide();
									startDate = new Date(ev.date);
									$('#startDate')
											.text($('#dp1').data('date'));
								}
								$('#dp1').datepicker('hide');
							});
			$('#dp2')
					.datepicker()
					.on(
							'changeDate',
							function(ev) {
								if (ev.date.valueOf() < startDate.valueOf()) {
									$('#alert')
											.show()
											.find('strong')
											.text(
													'The end date can not be less then the start date');
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


