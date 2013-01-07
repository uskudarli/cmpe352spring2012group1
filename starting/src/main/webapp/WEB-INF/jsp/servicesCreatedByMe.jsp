<%--
  Created by IntelliJ IDEA.
  User: alperen
  Date: 02.01.2013
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row">
    <div class="span10" align="center">

        <h3>My Services</h3>
        <h5>
            <i>Services that I offer or request</i>
        </h5>

        <div class="row">
            <div class="span5">
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
                                                <fmt:formatDate dateStyle="short"
                                                                value="${service.beginDate}"></fmt:formatDate>
                                                <fmt:formatDate dateStyle="short"
                                                                value="${service.endDate}"></fmt:formatDate>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                                <td><span
                                        class="label label-${service.enabled==true?'success':'warning'}">${service.enabled==true?'A':'In'}</span></td>
                                <td><a class="btn btn-mini btn-inverse activator"
                                       title="Click to ${service.enabled==true?'inactivate':'activate'}"
                                       href="" type="button">${service.enabled==true?'Inactivate':'Activate'}</a></td>
                                <td><a class="btn btn-mini btn-inverse" data-response-target-sel="tr" href="/starting/offered/delete/${service.id}" type="button">Delete</a></td>
                                <input type="hidden" name="serviceid"
                                       value="${service.id}" />
                                <input type="hidden" name="acttype"
                                       value="${service.enabled==true?'Inactive':'Active'}" />
                                <input type="hidden" name="servicetype" value="offer" />
                            </tr>
                        </c:forEach>
                    </div>


                    </tbody>

                </table>
            </div>

            <div class="span5">
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
                                               data-parent="#accordion2"
                                               href="#collapse${service.id}"> ${service.title} </a>
                                        </div>

                                        <div id="collapse${service.id}"
                                             class="accordion-body collapse">
                                            <div class="accordion-inner">
                                                <i>${service.tag}</i>
                                                <hr class="bs-docs-setparator">
                                                ${service.desc}
                                                <hr class="bs-docs-separator">
                                                <fmt:formatDate dateStyle="short"
                                                                value="${service.beginDate}"></fmt:formatDate>
                                                <fmt:formatDate dateStyle="short"
                                                                value="${service.endDate}"></fmt:formatDate>
                                            </div>
                                        </div>
                                    </div>

                                </td>
                                <td><span class="label label-info">F</span></td>
                                <td><a class="btn btn-mini btn-inverse" type="button"
                                       rel="tooltip" title="Click to delete">Delete</a></td>

                                <td><span
                                        class="label label-${service.enabled==true?'success':'warning'}">${service.enabled==true?'A':'In'}</span></td>
                                <td><a class="btn btn-mini btn-inverse activator"
                                       title="Click to ${service.enabled==true?'inactivate':'activate'}"
                                        type="button">${service.enabled==true?'Inactivate':'Activate'}</a></td>
                                <td><a class="btn btn-mini btn-inverse" type="button"
                                       rel="tooltip" title="Click to delete" data-response-target-sel="tr" href="/starting/requested/delete/${service.id}">Delete</a></td>
                                <input type="hidden" name="serviceid"
                                       value="${service.id}" />
                                <input type="hidden" name="acttype"
                                       value="${service.enabled==true?'Inactive':'Active'}" />
                                <input type="hidden" name="servicetype" value="offer" />
                            </tr>

                        </c:forEach>
                    </div>

                    </tbody>

                </table>
            </div>
        </div>
    </div>
</div>