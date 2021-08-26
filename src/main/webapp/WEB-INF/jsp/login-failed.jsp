<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<html>

<head>
    <title><fmt:message key="label.login"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/login-style.css">
</head>

<h2 align="center">
    <fmt:message key="label.failed"/>
</h2>

<body class="text-center">

<form class="center" action="${pageContext.request.contextPath}/login" method="POST">

    <div class="imgcontainer">
        <img src="samuel.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
        <%--@declare id="username"--%><%--@declare id="password"--%>
        <label for="username"><b><fmt:message key="label.name"/></b></label>
        <label>
            <input type="text" placeholder="<fmt:message key="label.enterName"/>" name="username" required>
        </label>

        <label for="password"><b><fmt:message key="label.password"/></b></label>
        <label>
            <input type="password" placeholder="<fmt:message key="label.enterPassword"/>" name="password" required>
        </label>

        <button type="submit"><fmt:message key="label.signIn"/></button>
        <br>
        <div style="text-align: center;"><a href="${pageContext.request.contextPath}/sign-up-page">
            <fmt:message key="label.signUp"/></a></div>

    </div>

</form>

</body>
</html>
