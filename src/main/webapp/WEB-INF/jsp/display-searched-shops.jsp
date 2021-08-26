<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<html>

<head>
    <title><fmt:message key="label.mall"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/table.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/hidden-hint.css">
</head>

<body>

<button type="button" class="button"><a class="homepage" href="${pageContext.request.contextPath}/logout">
    <fmt:message key="label.signOut"/></a></button>

<%@include file="dropdown.jsp" %>
<br>
<br>
<br>
<%@include file="search-shop.jsp" %>
<%@include file="search-discount.jsp" %>

<div>

    <table id="customers">
        <caption><h2><fmt:message key="label.shops"/></h2></caption>
        <tr>
            <th><fmt:message key="label.shopName"/></th>
            <th><fmt:message key="label.location"/></th>
            <th><fmt:message key="label.email"/></th>
            <th><fmt:message key="label.mobile"/></th>
            <th><fmt:message key="label.shopDescription"/></th>
        </tr>

        <c:forEach var="shop" items="${listShops}">
            <tr>
                <c:if test="${shop != null}">
                    <input type="hidden" name="id" value="<c:out value='${shop.id}' />"/>
                </c:if>

                <td><c:out value="${shop.name}"/></td>
                <td><c:out value="${shop.location}"/></td>
                <td><c:out value="${shop.email}"/></td>
                <td><c:out value="${shop.mobile}"/></td>
                <td><c:out value="${shop.description}"/></td>
            </tr>
        </c:forEach>
    </table>

    <br>

    <button type="button" class="button"><a class="homepage"
                                            href="${pageContext.request.contextPath}/user/shops/full-list">
        <fmt:message key="label.allShops"/></a></button>

</div>
</body>
</html>
