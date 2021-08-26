<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<html>

<head>
    <title><fmt:message key="label.locale"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/locale.css">
</head>

<body>
<h1>
    <fmt:message key="label.chooseLocale"/>
</h1>

<div class="container">
    <button type="button" class="button" style="vertical-align:middle"><a
            href="${pageContext.request.contextPath}/locale?lang=en">
        <fmt:message key="label.lang.en"/></a>
    </button>
    <button type="button" class="button" style="vertical-align:middle"><a
            href="${pageContext.request.contextPath}/locale?lang=ru">
        <fmt:message key="label.lang.ru"/></a>
    </button>
</div>

<br>
<br>

<h2>
    <c:if test="${not empty param.sessionLocale}">
        <fmt:message key="label.changeLangSuccess"/>
        <button type="button" class="button1"><a href="${pageContext.request.contextPath}/map">
            <fmt:message key="label.startApp"/></a></button>
    </c:if>
</h2>

</body>
</html>
