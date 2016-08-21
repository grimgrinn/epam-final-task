
<%@ taglib prefix="lang" uri="/WEB-INF/tld/taglib.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html class="no-js" lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title><lang:message text="login.title"/></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <link rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
        <link rel="stylesheet" href="<c:url value='/css/normalize.min.css'/>"/>

    </head>
    <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
        <div class="wrapper login-wrapper">

            <div class="login-title">
                <h1> <lang:message text="login.form-name" /></h1>

            </div>
            <c:if test="${successLogin == false}"><p><lang:message text="login.error" /></c:if>
            <c:if test="${sessionScope.user == null}">

                <form method="POST" action="/login" class="login-form">
                <p><input type="text" name="login" placeholder="<lang:message text="login.login" />"  /></p>
                <p><input type="password" name="password" placeholder="<lang:message text="login.password" />" /></p>
                    <input type="hidden" name="url" value="<c:out value="${requestScope['javax.servlet.forward.request_uri']}" />" />
                    <input type="submit" name="submit" value="<lang:message text="login.submit" />"/>
                </form>
                <div class="signup-link"><a href="/signup"><lang:message text="login.signup" /></a></div>
            </c:if>

            <c:if test="${sessionScope.user != null}">
                <lang:message text="login.welcome" />, <c:out value="${sessionScope.user.getFirstName()}" />! <br>
                <a href="/profile"><lang:message text="login.profile" /></a> | <a href="/logout"><lang:message text="login.logout" /></a>
            </c:if>
            <a href="?lang=ru">RU</a> / <a href="?lang=en">EN</a>
        </div>


        <script src="<c:url value='//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js'/>"></script>
        <script>window.jQuery || document.write('<script src="<c:url value='js/vendor/jquery-1.11.2.min.js'/>"><\/script>')</script>

        <script src="<c:url value='js/plugins.js'/>"></script>
        <script src="<c:url value='js/main.js'/>"></script>
    </body>
</html>

