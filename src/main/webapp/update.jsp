<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="lang" uri="/WEB-INF/tld/taglib.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="header.jsp" %>

<div class="content">
    <%@ include file="sidebar.jsp" %>

    <form class="update-from" action="/updatePost">
        <textarea style="resize:none; padding-left: 8px;    padding-top: 4px;" cols="70" rows="4" name="UpdatePostBody" required >

            <c:out value="${param.updatedPostBody}"/>

        </textarea>

        <input  type="hidden" name="paramid" value="${param.paramid}">
        <input  type="hidden" name="url" value="${param.url}">
        <input  type="hidden" name="postId" value="${param.postId}">

        <input class="wall-post-add send-button" type="submit" name="submitUpdate" value="<lang:message text="update.send"/>">

    </form>

</div>
<%@ include file="footer.jsp" %>
