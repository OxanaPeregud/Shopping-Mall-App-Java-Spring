<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<html>

<head>
    <title><fmt:message key="label.mall"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/table.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/link-style.css">
</head>

<body>

<br>
<br>
<br>

<div>

    <table id="customers">
        <caption><h2><fmt:message key="label.discounts"/></h2></caption>
        <tr>
            <th><fmt:message key="label.discount"/></th>
            <th><fmt:message key="label.discountStartDate"/></th>
            <th><fmt:message key="label.discountEndDate"/></th>
        </tr>

        <c:forEach var="discount" items="${listDiscountShops}">
            <tr>
                <td><c:out value="${discount.discount}"/></td>
                <td><c:out value="${discount.discountStartDate}"/></td>
                <td><c:out value="${discount.discountEndDate}"/></td>
            </tr>

        </c:forEach>
    </table>
</div>

<div class="link">
    <a href="javascript:history.back()"><fmt:message key="label.goBack"/></a>
</div>

</body>
</html>
