<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="lang" uri="/WEB-INF/tld/taglib.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
		<div class="content">
			<%@ include file="sidebar.jsp" %>
			
			<div class="main-stripe">
			<div class="user-name"><lang:message text="page.peoples" /></div>
			
		
			
			<div style="clear:both;    clear: both;    margin: 17px 7px;    width: 100%;    height: 1px;    border: lightgrey;"></div>

<c:if test="${users != null}">
	<c:forEach var="user" items="${users}">
		<div class="wall-post friend" data-id="<c:out value="${user.getId()}"/>">
			<div class="wall-post-author friend-name"><c:out value="${user.getFullName()}"/></div>

			<div class="friend-pic">
				<a href="/profile?id=${user.getId()}">
					<img src="http://placeimg.com/100/100/animals">
				</a>
			</div>

			<div class="wall-post-body"><lang:message text="happy.user" /> # ${user.getId()} </div>
		</div>
	</c:forEach>

</c:if>
			
			
			
			

			</div>
			
			
			

	</div>
<%@include file="footer.jsp" %>