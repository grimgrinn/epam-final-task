<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="lang" uri="/WEB-INF/tld/taglib.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${sessionScope.user == null}">
    <div class="login-title">
        <lang:message text="login.form-name" />
    </div>
    <c:if test="${successLogin == false}"><p>Invalid login or password</p></c:if>
    <form method="POST" action="/login" class="login-form">
        <input type="text" name="login" placeholder="<lang:message text="login.login" />" />
        <input type="password" name="password" placeholder="<lang:message text="login.password" />" />
        <input type="hidden" name="url" value="<c:out value="${requestScope['javax.servlet.forward.request_uri']}" />" />
        <input type="submit" name="submit" />
    </form>
    <div class="signup-link"><a href="/signup"><lang:message text="login.signup" /></a></div>
</c:if>
<c:if test="${sessionScope.user != null}">
    <lang:message text="login.welcome" />, <c:out value="${sessionScope.user.getFirstName()}" />! <br>
    <a href="/profile"><lang:message text="login.profile" /></a> | <a href="/logout"><lang:message text="login.logout" /></a>
</c:if>
