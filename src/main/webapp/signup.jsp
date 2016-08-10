<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="lang" uri="/WEB-INF/tld/taglib.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html class="no-js" lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title><lang:message text="login.title"/></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <link rel="stylesheet" href="css/normalize.min.css">
        <link rel="stylesheet" href="css/main.css">

        <script src="js/vendor/modernizr-2.8.3.min.js"></script>
    </head>
    <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
	<div class="wrapper login-wrapper">
        
		<div class="login-title">
		   <!-- <lang:message text="login.form-name" /> -->
		   <h1><lang:message text="registration.form-name" /></h1>
		   
		</div>

        <c:if test="${sessionScope.userId == null}">
        <c:forEach var="message" items="${messages}">
            <p><lang:message text="${'user.'.concat(message)}"/></p>
        </c:forEach>

		<form method="POST" class="signup login-form">
            <p><input type="text" name="email" placeholder="<lang:message text="login.email" />" /></p>
            <p><input type="text" name="firstName" placeholder="<lang:message text="login.firstname" />" /></p>
            <p><input type="text" name="lastName" placeholder="<lang:message text="login.lastname" />" /></p>
            <p><input type="password" name="password" placeholder="<lang:message text="login.password" />" /></p>
            <p><input type="submit" name="submit" value="<lang:message text="login.submit" />"/></p>
        </form>
        </c:if>

        <c:if test="${successSignUp != null}">
            <a href="/"><lang:message text="login.login" /></a>
        </c:if>

        <c:if test="${sessionScope.userId != null}">
            <p><lang:message text="signup.already"/></p>
            <a href="/"><lang:message text="profile.title" /></a>
        </c:if>

	</div>
        <a href="?lang=ru">RU</a> / <a href="?lang=en">EN</a>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')</script>

        <script src="js/plugins.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>