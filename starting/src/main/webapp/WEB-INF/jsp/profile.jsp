<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- This is the main profile page of a unique user --%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Soda Profile</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css"
	href="/starting/static/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="/starting/static/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="/starting/static/css/bootstrap-tagmanager.css" />
<script src="/starting/static/js/jquery-1.7.1.min.js"></script>
<script src="/starting/static/js/bootstrap.js"></script>
<script src="/starting/static/js/bootstrap-tagmanager.js"></script>
<script src="/starting/static/js/main.js"></script>

    <script>
	$(document)
			.ready(function(){
                bindAjaxForm();
                bindAnchorForFormSubmit();
			    jQuery(".tagManager").tagsManager();
						$('body')
								.on(
										'click',
										'.activator',
										function() {
											$that = this;
											var $serviceid = $(this).parent()
													.next().next().val();
											var $acttype = $(this).parent()
													.next().next().next().val();
											var $servicetype = $(this).parent()
													.next().next().next()
													.next().val();
											var $reverseacttype = 'Active';
											var $title = 'Click to activate';
											var $btnclass = $(this).attr(
													'class');
                                            var $label = $(this).parent().prev().children(0).attr('class');
                                            var $reverselabel = 'label label-warning';
                                            var $letter = $(this).parent().prev().children(0).text();
                                            var $reverseletter = 'In';
											var $reversebtnclass = 'btn btn-mini btn-inverse activator';
											//            alert('$serviceid:'+$serviceid+' $acttype:'+$acttype+' $servicetype:'+$servicetype);
											if ($acttype == 'Active') {
												$title = "Click to inactivate";
												$reverseacttype = 'Inactive';
											}

											if ($btnclass == 'btn btn-mini btn-inverse activator') {
												$reversebtnclass = 'btn btn-mini btn-inverse activator';
											}
                                            if($label=='label label-warning'){
                                               $reverselabel = 'label label-success';
                                            }
                                            if($letter=='In'){
                                                $reverseletter = 'A';
                                            }

											$
													.ajax({
														url : "/starting/service/able",
														type : "POST",
														data : {
															serviceid : $serviceid,
															acttype : $acttype,
															servicetype : $servicetype
														},
														success : function(data) {
															$($that)
																	.parent()
																	.next()
																	.next()
																	.next()
																	.attr(
																			'value',
																			$reverseacttype);
															$($that)
																	.html(
																			$reverseacttype);
															$($that)
																	.removeClass(
																			$btnclass);
															$($that)
																	.addClass(
																			$reversebtnclass);
															$($that).attr(
																	'title',
																	$title);
                                                           $($that).parent().prev().children(0).html($reverseletter);
                                                           $($that).parent().prev().children(0).removeClass($label);
                                                           $($that).parent().prev().children(0).addClass($reverselabel);
														}
													});

											return false;
										})})






</script>
<!-- Le styles -->
<%--<link href="assets/css/bootstrap.css" rel="stylesheet">--%>
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}
</style>
<%--<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">--%>
</head>

<body>

	<jsp:include page="headerUser.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="span3">
				<img src="static/img/${loggedInUser.avatar}.jpg" class="img-rounded">
			</div>
			<div class="span3" align="center">
				<h2>${loggedInUser.name} ${loggedInUser.surname}</h2>
				<%--<h4>City - Town - District</h4>--%>
				<a class="btn btn-inverse" href="profile/edit">Edit Profile</a>
			</div>
			<div class="span3" align="center">
				<h3>Credit</h3>
				<span class="badge badge-info" style="font-size: 20px">100</span>
			</div>
			<div class="span3" align="center">
				<div class="well">
					<a href="messages.html">Messages</a><br><br>
                                        <a class="btn btn-primary" href="/starting/createservice">Create New Service</a>
                
				</div>
			</div>

			<!-- middle grid -->
                                                
		</div>
                        
		<hr class="bs-docs-separator">

		<div class="tabbable tabs-left">
			<!-- Only required for left/right tabs -->
			<ul class="nav nav-tabs">
				<li class="active"><a href="#tab1" data-toggle="tab">Services I created</a></li>
				<li><a href="#tab2" data-toggle="tab">Pending Services</a></li>
				<li><a href="#tab3" data-toggle="tab">Current Services</a></li>
				<li><a href="#tab4" data-toggle="tab">History</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="tab1">
					<jsp:include page="servicesCreatedByMe.jsp"></jsp:include>
				</div>
				<div class="tab-pane" id="tab2">
					<jsp:include page="pendingApplies.jsp"></jsp:include>
				</div>
				<div class="tab-pane" id="tab3">
                    <jsp:include page="servicesInProgress.jsp"></jsp:include>
				</div>
				<div class="tab-pane" id="tab4">
                    <jsp:include page="servicesHistory.jsp"></jsp:include>
				</div>
			</div>
		</div>

		<hr>

		<footer>
			<p>&copy; Cmpe451 Group1 Fall2012</p>
		</footer>

	</div>

</body>
</html>

