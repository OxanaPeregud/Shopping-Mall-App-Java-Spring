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
<br>
<br>
<br>
<%@include file="search-shop.jsp" %>

<div>

    <table id="customers">
        <caption><h2><fmt:message key="label.shops"/></h2></caption>
        <tr>
            <th><fmt:message key="label.shopName"/></th>
            <th><fmt:message key="label.location"/></th>
            <th><fmt:message key="label.email"/></th>
            <th><fmt:message key="label.mobile"/></th>
            <th><fmt:message key="label.info"/></th>
            <th><fmt:message key="label.info"/></th>
        </tr>

        <c:forEach var="shop" items="${listShops}">
            <tr>
                <c:if test="${shop != null}">
                    <input type="hidden" name="id" value="<c:out value='${shop.id}' />"/>
                </c:if>

                <td>
                    <div class="tooltip"><c:out value="${shop.name}"/>
                        <span class="tooltiptext">${shop.description}</span>
                    </div>
                </td>

                <td><c:out value="${shop.location}"/></td>
                <td><c:out value="${shop.email}"/></td>
                <td><c:out value="${shop.mobile}"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/user/shops/info?id=<c:out value='${shop.id}' />">
                        <fmt:message key="label.fullShopInfo"/></a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/user/shops/discounts?id=<c:out value='${shop.id}' />">
                        <fmt:message key="label.shopDiscounts"/></a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
