<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<html>

<head>
    <title><fmt:message key="label.signUpForm"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/sign-up-style.css">
    <script src="${pageContext.request.contextPath}/js/password-confirm.js"></script>
</head>

<body>

<form action="${pageContext.request.contextPath}/sign-up-new" style="border:1px solid #ccc" class="center" method="POST">
    <div class="container">
        <%--@declare id="username"--%>
        <%--@declare id="password"--%>
        <%--@declare id="role"--%>
        <%--@declare id="psw-repeat"--%>
        <h1><fmt:message key="label.signUpForm"/></h1>
        <p><fmt:message key="label.fillForm"/></p>
        <hr>

        <label for="username"><b><fmt:message key="label.name"/></b></label>
        <label>
            <input type="text" placeholder="<fmt:message key="label.enterName"/>" name="username" required>
        </label>

        <label for="password"><b><fmt:message key="label.password"/></b></label>
        <label>
            <input type="password" placeholder="<fmt:message key="label.enterPassword"/>" name="password" id="password"
                   onchange='check_pass();' required>
        </label>

        <label for="psw-repeat"><b><fmt:message key="label.repeatPassword"/></b></label>
        <label>
            <input type="password" placeholder="<fmt:message key="label.repeatPassword"/>"
                   name="psw-repeat" id="confirm_password"
                   onchange='check_pass();' required>
            <span id='message'></span>
        </label>

        <br>
        <br>

        <label for="role"><b><fmt:message key="label.selectRole"/></b></label>&nbsp;&nbsp;&nbsp;&nbsp;
        <label for="roleDropMenu"></label>
        <select id="roleDropMenu" name="role">
            <option value="user"><fmt:message key="label.user"/></option>
            <option value="admin"><fmt:message key="label.admin"/></option>
        </select>

        <div class="clearfix">
            <button type="submit" name="submit" value="registration" id="submit"
                    disabled class="signupbtn"><fmt:message key="label.signUp"/></button>
        </div>
    </div>
</form>

</body>
</html>
