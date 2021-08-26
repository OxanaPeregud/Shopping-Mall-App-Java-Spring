<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<html>

<head>
    <title><fmt:message key="label.mall"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/table.css">
</head>

<body>

<button type="button" class="button"><a class="homepage" href="${pageContext.request.contextPath}/logout">
    <fmt:message key="label.signOut"/></a></button>

<%@include file="dropdown.jsp" %>

<div>
    <h1><fmt:message key="label.app"/></h1>
</div>

<div>

    <table id="customers">
        <caption><h2><fmt:message key="label.statistics"/></h2></caption>
        <tr>
            <th><fmt:message key="label.discount"/></th>
            <th><fmt:message key="label.count"/></th>
        </tr>

        <c:forEach var="discountStatisticsDto" items="${listStatistics}">
            <tr>
                <td><c:out value="${discountStatisticsDto.discount}"/></td>
                <td><c:out value="${discountStatisticsDto.count}"/></td>
            </tr>
        </c:forEach>
    </table>

</div>

</body>
</html>
