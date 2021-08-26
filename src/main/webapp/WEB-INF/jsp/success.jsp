<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<html>

<head>
    <meta charset="UTF-8">
    <title><fmt:message key="label.success"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/locale.css">
</head>

<body>

<h1>
    <fmt:message key="label.success"/>
</h1>

<div class="container">
    <button type="button" class="button" style="vertical-align:middle"><a
            href="${pageContext.request.contextPath}/login">
        <fmt:message key="label.signIn"/></a>
    </button>
</div>

</body>
</html>
