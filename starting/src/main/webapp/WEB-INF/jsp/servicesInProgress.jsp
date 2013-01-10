
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row">
    <div class="span10" align="center">

        <h3>Current Services</h3>

        <div class="row">
            <div class="span5">
                Services requested from me
                <table class="table table-condensed">
                    <thead align="center">
                    <tr>
                        <th>Title</th>
                    </tr>
                    </thead>

                    <tbody>

                    <div class="accordion" id="accordion5">
                        <c:forEach items="${currentServicesToDo}" var="service">
                            <tr>
                                <td>${service.users.name}</td>
                                <td>
                                    <div class="accordion-group">
                                        <div class="accordion-heading">
                                            <div>
                                                <a class="accordion-toggle" data-toggle="collapse"
                                                   data-parent="#accordion5"
                                                   href="#collapsecurrentToMe${service.serviceStatusBean.interactionId}">${service.title}</a>
                                            </div>
                                        </div>

                                        <div id="collapsecurrentToMe${service.serviceStatusBean.interactionId}"
                                             class="accordion-body collapse">
                                            <div class="accordion-inner">
                                                <hr class="bs-docs-separator">
                                                ${service.desc}
                                                <hr class="bs-docs-separator">
                                            </div>
                                        </div>
                                    </div>
                                </td>
                                <td><span class="label label-info">Waiting for confirmation</span></td>
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

                    <div class="accordion" id="accordion6">
                        <c:forEach items="${currentServicesWaiting}" var="service">
                            <tr>
                                <td>${service.users.name}</td>
                                <td>

                                    <div class="accordion-group">
                                        <div class="accordion-heading">
                                            <a class="accordion-toggle" data-toggle="collapse"
                                               data-parent="#accordion6"
                                               href="#collapsecurrentByMe${service.serviceStatusBean.interactionId}"> ${service.title} </a>
                                        </div>

                                        <div id="collapsecurrentByMe${service.serviceStatusBean.interactionId}"
                                             class="accordion-body collapse">
                                            <div class="accordion-inner">
                                                <hr class="bs-docs-setparator">
                                                ${service.desc}
                                                <hr class="bs-docs-separator">
                                            </div>
                                        </div>
                                    </div>

                                </td>
                                <td><span class="label label-info">Waiting for confirmation</span></td>
                                <td><a class="btn btn-small btn-success" href=""
                                       type="button" rel="tooltip"
                                       title="Click if you have taken the service"><i class="icon-thumbs-up icon-white"></i></a></td>
                                <td><a class="btn btn-small btn-danger" href=""
                                       type="button" rel="tooltip"
                                       title="Click if you have not taken the service as you agreed"><i class="icon-thumbs-down icon-white"></i></a></td>
                                
                            </tr>

                        </c:forEach>
                    </div>

                    </tbody>

                </table>
            </div>
        </div>
    </div>
</div>