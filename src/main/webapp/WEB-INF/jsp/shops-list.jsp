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

    <form action="${pageContext.request.contextPath}/admin/shops/delete-list" method="post">
        <table id="customers">

            <caption><h2><fmt:message key="label.allShops"/></h2></caption>
            <tr>
                <th>ID</th>
                <th><fmt:message key="label.shopName"/></th>
                <th><fmt:message key="label.location"/></th>
                <th><fmt:message key="label.email"/></th>
                <th><fmt:message key="label.mobile"/></th>
                <th><fmt:message key="label.info"/></th>
                <th><fmt:message key="label.info"/></th>
                <th><fmt:message key="label.info"/></th>
                <th><fmt:message key="label.info"/></th>
            </tr>

            <c:forEach var="shop" items="${listShops}">
                <tr>
                    <td><c:out value="${shop.id}"/></td>
                    <td>
                        <div class="tooltip"><c:out value="${shop.name}"/>
                            <span class="tooltiptext">${shop.description}</span>
                        </div>
                    </td>

                    <td><c:out value="${shop.location}"/></td>
                    <td><c:out value="${shop.email}"/></td>
                    <td><c:out value="${shop.mobile}"/></td>

                    <td>
                        <a href="${pageContext.request.contextPath}/admin/shops/edit?id=<c:out value='${shop.id}'/>">
                            <fmt:message key="label.edit"/></a>
                    </td>
                    <td>
                        <label><input type="checkbox" name="deleteShop"
                                      value="${shop.id}"><fmt:message key="label.delete"/></label>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/shops/set-discount?id=<c:out value='${shop.id}'/>">
                            <fmt:message key="label.newDiscount"/></a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/user/shops/discounts?id=<c:out value='${shop.id}'/>">
                            <fmt:message key="label.shopDiscounts"/></a>
                    </td>
                </tr>
            </c:forEach>

            <tr class="right">
                <td>
                    <input type="submit" value="<fmt:message key="label.delete"/>"/>
                </td>
            </tr>

        </table>
    </form>

    <c:if test="${lastPageNo >= 1}">
        <c:forEach var="i" begin="0" end="${lastPageNo-1}">
            <button type="button" class="button2">
                <a class="pages" href="${pageContext.request.contextPath}/user/shops/full-list?pageNo=${i}">
                        ${i+1}</a></button>
        </c:forEach>
    </c:if>

    <c:if test="${lastPageNo < 1}">
        <c:forEach var="i" begin="0" end="${lastPageNo}">
            <button type="button" class="button2">
                <a class="pages" href="${pageContext.request.contextPath}/user/shops/full-list?pageNo=${i}">
                        ${i+1}</a></button>
        </c:forEach>
    </c:if>

</div>
</body>
</html>
