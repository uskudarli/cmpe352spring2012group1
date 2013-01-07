<%--
&lt;%&ndash;
  Created by IntelliJ IDEA.
  User: alperen
  Date: 02.01.2013
  Time: 22:36
  To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row">
    <div class="span10" align="center">

        <h3>History</h3>

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
                                                <i>${service.tag}</i>
                                                <hr class="bs-docs-separator">
                                                ${service.desc}
                                                <hr class="bs-docs-separator">
                                            </div>
                                        </div>
                                    </div>
                                </td>
                              &lt;%&ndash;  <td><span class="label label-success">Completed</span></td>
                                <td><span class="label label-important">Failed</span></td>
                                <td><span class="label label-warning">Rejected</span></td>
                              &ndash;%&gt;  <td><span class="label label-warning">${service.serviceStatusBean.status}</span></td>
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
                                                <i>${service.tag}</i>
                                                <hr class="bs-docs-setparator">
                                                ${service.desc}
                                                <hr class="bs-docs-separator">
                                            </div>
                                        </div>
                                    </div>

                                </td>
                             &lt;%&ndash;   <td><span class="label label-success">Completed</span></td>
                                <td><span class="label label-important">Failed</span></td>
                                <td><span class="label label-warning">Rejected</span></td>
                             &ndash;%&gt;   <td><span class="label label-warning">${service.serviceStatusBean.status}</span></td>
                            </tr>

                        </c:forEach>
                    </div>

                    </tbody>

                </table>
            </div>
        </div>
    </div>
</div>
--%>
