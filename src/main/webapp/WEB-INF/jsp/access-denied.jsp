<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<html>

<head>
    <title><fmt:message key="label.accessDenied"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/locale.css">
</head>

<body>

<h1>
    <fmt:message key="label.accessDenied"/>
</h1>

<div class="container">
    <button type="button" class="button" style="vertical-align:middle"><a href="javascript:history.back()">
        <fmt:message key="label.goBack"/></a>
    </button>
    <button type="button" class="button" style="vertical-align:middle">
        <a href="${pageContext.request.contextPath}/login"><fmt:message key="label.signIn"/></a>
    </button>
</div>

</body>
</html>
