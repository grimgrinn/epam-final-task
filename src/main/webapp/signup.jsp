<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="lang" uri="/WEB-INF/tld/taglib.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title><lang:message text="signup.title"/></title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="/style/normalize.css" type="text/css">
    <link rel="stylesheet" href="/style/style.css" type="text/css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
</head>
<body>
<div class="wrapper">
    <%@ include file="header.jsp" %>
    <div class="middle">
        <h1><lang:message text="signup.header"/></h1>
        <c:if test="${sessionScope.userId == null}">
            <c:forEach var="message" items="${messages}">
                <p><lang:message text="${'user.'.concat(message)}"/></p>
            </c:forEach>

        <form method="POST" class="signup">
            <input type="text" name="email" placeholder="<lang:message text="user.email"/>" />
            <input type="text" name="firstName" placeholder="<lang:message text="user.firstname"/>" />
            <input type="text" name="lastName" placeholder="<lang:message text="user.lastname"/>" />
            <input type="password" name="password" placeholder="<lang:message text="user.password" />" />
            <input type="submit" name="submit" />
        </form>
        </c:if>
        <c:if test="${sessionScope.userId != null}">
            <p><lang:message text="signup.already"/></p>
            <a href="/"><lang:message text="profile.title" /></a>
        </c:if>
    </div>
    <%@ include file="footer.jsp" %>
</div>
<script src="/js/script.js"></script>
</body>
</html>