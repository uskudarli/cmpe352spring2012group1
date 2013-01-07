<%--
  Created by IntelliJ IDEA.
  User: alperen
  Date: 02.01.2013
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row">
    <div class="span10" align="center">

        <h3>Pending Services</h3>

        <div class="row">
            <div class="span5">
                Services requested from me
                <table class="table table-condensed">
                    <thead>
                    <tr>
                        <th>Title</th>
                    </tr>
                    </thead>

                    <tbody>

                    <div class="accordion" id="accordion3">
                        <c:forEach items="${pendingServicesByMe}" var="service">
                            <tr>
                                <td>${service.users.name}</td>
                                <td>
                                    <div class="accordion-group">
                                        <div class="accordion-heading">
                                            <div>
                                                <a class="accordion-toggle" data-toggle="collapse"
                                                   data-parent="#accordion3"
                                                   href="#collapsependingByMe${service.serviceStatusBean.interactionId}">${service.title}</a>
                                            </div>
                                        </div>

                                        <div id="collapsependingByMe${service.serviceStatusBean.interactionId}"
                                             class="accordion-body collapse">
                                            <div class="accordion-inner">
                                                <hr class="bs-docs-separator">
                                                ${service.desc}
                                            </div>
                                        </div>
                                    </div>
                                </td>
                                <td><a class="btn btn-small btn-success" data-response-target-sel="tr" href="/starting/action/approve/${service.serviceStatusBean.interactionId}"
                                       type="button" rel="tooltip" title="Click to approve">Approve</a></td>
                                <td><a class="btn btn-small btn-danger" type="button"
                                       rel="tooltip" title="Click to reject" data-response-target-sel="tr" href="/starting/action/reject/${service.serviceStatusBean.interactionId}">Reject</a></td>
                                <td><span class="label label-info">In Progress</span></td>
                            </tr>
                        </c:forEach>
                    </div>


                    </tbody>

                </table>
            </div>

            <div class="span5">
                Services I requested
                <table class="table table-condensed">
                    <thead>
                    <tr>
                        <th>Title</th>
                    </tr>
                    </thead>

                    <tbody>

                    <div class="accordion" id="accordion4">
                        <c:forEach items="${pendingServicesToMe}" var="service">
                            <tr>
                                <td>${service.users.name}</td>
                                <td>

                                    <div class="accordion-group">
                                        <div class="accordion-heading">
                                            <a class="accordion-toggle" data-toggle="collapse"
                                               data-parent="#accordion4"
                                               href="#collapsependingToMe${service.serviceStatusBean.interactionId}"> ${service.title} </a>
                                        </div>

                                        <div id="collapsependingToMe${service.serviceStatusBean.interactionId}"
                                             class="accordion-body collapse">
                                            <div class="accordion-inner">
                                                <hr class="bs-docs-setparator">
                                                ${service.desc}
                                                <hr class="bs-docs-separator">
                                            </div>
                                        </div>
                                    </div>

                                </td>

                                <td><span class="label label-warning">Waiting
																for response</span></td>
                                <td><a class="btn btn-small btn-inverse"
                                       type="button" rel="tooltip"
                                       title="Click to cancel the request" data-response-target-sel="tr" href="/starting/action/cancel/${service.serviceStatusBean.interactionId}">Cancel</a></td>
                            </tr>

                        </c:forEach>
                    </div>

                    </tbody>

                </table>
            </div>
        </div>
    </div>
</div>