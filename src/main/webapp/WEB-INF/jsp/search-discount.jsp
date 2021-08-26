<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<html>

<head>
    <title><fmt:message key="label.search"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/search-style.css">
</head>

<body>

<form name="minimumDiscount" action="${pageContext.request.contextPath}/user/discounts/search-result" method="post">

    <div class="flex">
        <div>
            <div class="input-group">
                <label>
                    <input type="text" name="minimumDiscount" placeholder="<fmt:message key="label.enterDiscount"/>"/>
                </label>
                <input class="button1" type="submit" value="<fmt:message key="label.find"/>" name="find"/>
            </div>
        </div>
    </div>

</form>

</body>
</html>
