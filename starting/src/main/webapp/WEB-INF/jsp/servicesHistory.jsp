
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row">
    <div class="span10" align="center">

        <h3>History</h3>

        <div class="row">
            <div class="span5">
                <b>Services requested from me</b>
                <table class="table table-condensed">
                    

                    <tbody>

                    <div class="accordion" id="accordion7">
                        <c:forEach items="${historyOffered}" var="service">
                            <tr>
                                <td>
                                    <div class="accordion-group">
                                        <div class="accordion-heading">
                                            <div>
                                                <a class="accordion-toggle" data-toggle="collapse"
                                                   data-parent="#accordion7"
                                                   href="#collapsehistoryOffered${service.serviceStatusBean.interactionId}">${service.title}</a>
                                            </div>
                                        </div>

                                        <div id="collapsehistoryOffered${service.serviceStatusBean.interactionId}"
                                             class="accordion-body collapse">
                                            <div class="accordion-inner">
                                                <hr class="bs-docs-separator">
                                                ${service.desc}
                                                <hr class="bs-docs-separator">
                                            </div>
                                        </div>
                                    </div>
                                </td>
                              <!--  <td><span class="label label-success">Completed</span></td>
                                <td><span class="label label-important">Failed</span></td>
                                <td><span class="label label-warning">Rejected</span></td>-->
                                <td><span class="label label-warning">${service.serviceStatusBean.status}</span></td>
                            </tr>
                        </c:forEach>
                    </div>


                    </tbody>

                </table>
            </div>

            <div class="span5">
                <b>Services I requested</b>
                <table class="table table-condensed">
                    

                    <tbody>

                    <div class="accordion" id="accordion8">
                        <c:forEach items="${historyRequested}" var="service">
                            <tr>
                                <td>

                                    <div class="accordion-group">
                                        <div class="accordion-heading">
                                            <a class="accordion-toggle" data-toggle="collapse"
                                               data-parent="#accordion8"
                                               href="#collapsehistoryRequested${service.serviceStatusBean.interactionId}"> ${service.title} </a>
                                        </div>

                                        <div id="collapsehistoryRequested${service.serviceStatusBean.interactionId}"
                                             class="accordion-body collapse">
                                            <div class="accordion-inner">
                                                <hr class="bs-docs-setparator">
                                                ${service.desc}
                                                <hr class="bs-docs-separator">
                                            </div>
                                        </div>
                                    </div>

                                </td>
                               <!-- <td><span class="label label-success">Completed</span></td>
                                <td><span class="label label-important">Failed</span></td>
                                <td><span class="label label-warning">Rejected</span></td>-->
                                <td><span class="label label-warning">${service.serviceStatusBean.status}</span></td>
                            </tr>

                        </c:forEach>
                    </div>

                    </tbody>

                </table>
            </div>
        </div>
    </div>
</div>

