<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="lang" uri="/WEB-INF/tld/taglib.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="sidebar content">
    <div class="sidebar-menu-wrapper">
        <ul class="sidebar-menu">
            <li/><a href="/"><lang:message text="sidebar.home" /></a></li>
            <li/><a href="/messages.jsp"><lang:message text="sidebar.message" /></a></li>
            <li/><a href="/friends.jsp"><lang:message text="sidebar.friends" /></a></li>
            <li/><a href="/news.jsp"><lang:message text="sidebar.news" /></a></li>
            <li/><a href="/peoples"><lang:message text="sidebar.peoples" /></a></li>
        </ul>
    </div>

</div>
