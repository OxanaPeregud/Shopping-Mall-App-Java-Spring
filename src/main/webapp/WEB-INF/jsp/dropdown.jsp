<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<html>

<head>
    <title><fmt:message key="label.mall"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dropdown-menu.css">
</head>

<body>

<label class="dropdown">
    <div class="dd-button">
        <fmt:message key="label.menu"/>
    </div>

    <input type="checkbox" class="dd-input" id="test">

    <ul class="dd-menu">
        <li>
            <a href="${pageContext.request.contextPath}/user/shops/full-list">
                <fmt:message key="label.allShops"/></a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/user/discounts/full-list">
                <fmt:message key="label.allDiscounts"/></a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/admin/shops/add"><fmt:message key="label.newShop"/></a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/user/discounts/actual">
                <fmt:message key="label.searchActualDiscount"/></a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/user/discounts/discount-statistics">
                <fmt:message key="label.statistics"/></a>
        </li>
    </ul>
</label>

</body>
</html>
