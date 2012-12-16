<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<script>
	$(document).ready(function() {
		jQuery(".tagManager").tagsManager();
        $('body').on('click','.activator',function(){
            $that=this;
            var $serviceid=$(this).parent().next().next().val();
            var $acttype=$(this).parent().next().next().next().val();
            var $servicetype=$(this).parent().next().next().next().next().val();
            var $reverseacttype='activate';
            var $btnclass=$(this).attr('class');
            var $reversebtnclass='btn btn-small btn-warning activator';
//            alert('$serviceid:'+$serviceid+' $acttype:'+$acttype+' $servicetype:'+$servicetype);
            if($acttype=='activate'){
               $reverseacttype='inactivate';
            }

            if($btnclass=='btn btn-small btn-warning activator'){
                $reversebtnclass='btn btn-small btn-success activator';
            }

            $.ajax({
                url: "/starting/service/able",
                type: "POST",
                data: {serviceid : $serviceid,acttype:$acttype,servicetype:$servicetype},
                success:function(data) {
                    $($that).parent().next().next().next().attr('value',$reverseacttype);
                    $($that).html($reverseacttype);
                    $($that).removeClass($btnclass);
                    $($that).addClass($reversebtnclass);
                }
            });


            return false;
        })
        $('body').on('click','.deleter',function(){
            var $that=this;
            var $serviceid=$(this).parent().next().val();
            var $servicetype=$(this).parent().next().next().next().val();

            $.ajax({
                url: "/starting/service/delete",
                type: "POST",
                data: {serviceid : $serviceid,servicetype:$servicetype},
                success:function(data) {
                    $($that).parent().parent().remove();
                }
            });
        })


	});
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
				<img src="/starting/static/img/${loggedInUser.avatar}.jpg" class="img-rounded"/>
			</div>
			<div class="span3" align="center">
				<h2>${loggedInUser.name} ${loggedInUser.surname}</h2>
				<%--<h4>City - Town - District</h4>--%>
				<div class="btn-group">
					<button class="btn">
						<a href="profile/edit">Edit Profile</a>
					</button>
				</div>
			</div>
			<div class="span3" align="center">
				<h3>Credit</h3>
				<h2>100</h2>
			</div>
			<div class="span3" align="center">
				<div class="well">
					<a href="messages.html">Messages</a><br> <a
						href="history.html">Service History</a>
				</div>
			</div>

			<!-- middle grid -->

		</div>

		<hr class="bs-docs-separator"></hr>

		<div class="row">
			<div class="span12" align="center">

				<h3>Recent Services</h3>

				<div class="row">
					<div class="span6">
						Offered Services
						<table class="table table-condensed">
							<thead>
								<tr>
									<th>Title</th>
								</tr>
							</thead>

							<tbody>

									<div class="accordion" id="accordion1">
								<c:forEach items="${offeredServices}" var="service">
									<tr>
										<td>
											<div class="accordion-group">
												<div class="accordion-heading">
													<div>
														<a class="accordion-toggle" data-toggle="collapse"
															data-parent="#accordion1"
															href="#collapseoffer${service.id}">${service.title}</a>
													</div>
												</div>

												<div id="collapseoffer${service.id}"
													class="accordion-body collapse">
													<div class="accordion-inner">
														<i>${service.tag}</i>
														<hr class="bs-docs-separator">
														${service.desc}
														<hr class="bs-docs-separator">
                                                        <fmt:formatDate dateStyle="short" value="${service.beginDate}"></fmt:formatDate> <fmt:formatDate dateStyle="short" value="${service.endDate}"></fmt:formatDate>
													</div>
												</div>
											</div>
										</td>
										<td><a class="btn btn-small btn-${service.enabled==true?'warning':'success'} activator" href="" type="button" rel="tooltip" title="Click to activate">${service.enabled==true?'Inactivate':'Activate'}</a></td>
                                        <td><a class="btn btn-small btn-danger deleter" type="button" rel="tooltip" title="Click to delete">Delete</a></td>
                                        <input type="hidden" name="serviceid" value="${service.id}"/>
                                        <input type="hidden" name="acttype" value="${service.enabled==true?'inactivate':'activate'}"/>
                                        <input type="hidden" name="servicetype" value="offer"/>
									</tr>
								</c:forEach>
									</div>


							</tbody>

						</table>
					</div>

					<div class="span6">
						Requested Services
						<table class="table table-condensed">
							<thead>
								<tr>
									<th>Title</th>
								</tr>
							</thead>

							<tbody>

								<div class="accordion" id="accordion2">
									<c:forEach items="${requestedServices}" var="service">
										<tr>
											<td>

												<div class="accordion-group">
													<div class="accordion-heading">
														<a class="accordion-toggle" data-toggle="collapse"
															data-parent="#accordion2" href="#collapse${service.id}">
															${service.title} </a>
													</div>

													<div id="collapse${service.id}"
														class="accordion-body collapse">
														<div class="accordion-inner">
															<i>${service.tag}</i>
															<hr class="bs-docs-setparator">
															${service.desc}
															<hr class="bs-docs-separator">
                                                            <fmt:formatDate dateStyle="short" value="${service.beginDate}"></fmt:formatDate> <fmt:formatDate dateStyle="short" value="${service.endDate}"></fmt:formatDate>
                                                        </div>
													</div>
												</div>

											</td>

                                            <td><a class="btn btn-small btn-${service.enabled==true?'warning':'success'} activator" href="" type="button" rel="tooltip" title="Click to activate">${service.enabled==true?'Inactivate':'Activate'}</a></td>
                                            <td><a class="btn btn-small btn-danger deleter" type="button" rel="tooltip" title="Click to delete">Delete</a></td>
                                            <input type="hidden" name="serviceid" value="${service.id}"/>
                                            <input type="hidden" name="acttype" value="${service.enabled==true?'inactivate':'activate'}"/>
                                            <input type="hidden" name="servicetype" value="request"/> </tr>

									</c:forEach>
								</div>

							</tbody>

						</table>
					</div>
				</div>
			</div>
		</div>

		<hr class="bs-docs-separator">

		<a class="btn btn-primary" href="/starting/createservice">Create
			New Service</a>

		<hr>

		<footer>
			<p>&copy; Cmpe 451</p>
		</footer>

	</div>
	<!-- /container -->

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<%--<script src="assets/js/jquery.js"></script>--%>
	<%--<script src="assets/js/bootstrap-transition.js"></script>--%>
	<%--<script src="assets/js/bootstrap-alert.js"></script>--%>
	<%--<script src="assets/js/bootstrap-modal.js"></script>--%>
	<%--<script src="assets/js/bootstrap-dropdown.js"></script>--%>
	<%--<script src="assets/js/bootstrap-scrollspy.js"></script>--%>
	<%--<script src="assets/js/bootstrap-tab.js"></script>--%>
	<%--<script src="assets/js/bootstrap-tooltip.js"></script>--%>
	<%--<script src="assets/js/bootstrap-popover.js"></script>--%>
	<%--<script src="assets/js/bootstrap-button.js"></script>--%>
	<%--<script src="assets/js/bootstrap-collapse.js"></script>--%>
	<%--<script src="assets/js/bootstrap-carousel.js"></script>--%>
	<%--<script src="assets/js/bootstrap-typeahead.js"></script>--%>

</body>
</html>

