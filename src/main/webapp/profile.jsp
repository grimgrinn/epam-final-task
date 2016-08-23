<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="lang" uri="/WEB-INF/tld/taglib.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

			<%@ include file="header.jsp" %>

		<div class="content">
			<%@ include file="sidebar.jsp" %>
			
			<div class="main-stripe">
			<div class="user-name"  data-user-id="${user.getId()}"><c:out value="${user.getFullName()}"/></div>
			
			<div class="user-pic">
				<img src="http://placeimg.com/200/300/animals">
			</div>
			
			<div class="user-info">
						<p><lang:message text="happy.user" /> # ${param.id} </p>
			</div>
			
			<div class="wall-post-new">
			<span style="display:block"><lang:message text="profile.watsap" /></span>
				<form action="/addwallpost" method="POST">

					<textarea style="resize:none; padding-left: 8px;    padding-top: 4px;" cols="70" rows="4" name="postBody" required></textarea>
					<input type="hidden" name="url" value="<c:out value="${requestScope['javax.servlet.forward.request_uri']}" />" />
					<input type="hidden" name="paramid" value="<c:out value="${param.id}" />" />
					<input  type = "submit" name="submit" class="wall-post-add send-button" value="<lang:message text="post.add" />" />

				</form>
			</div>

				<p>
					<c:if test="${postSuccess == true}"><lang:message text="wallpost.success" /></c:if>
				</p>

			<div style="clear:both;  margin: 17px 7px;    width: 100%;    height: 1px;    border: lightgrey;"></div>



			<c:forEach var="post" items="${posts}">
				<div class="wall-post wall-post-news" data-post-id="${post.getId()}" >
					<div class="wall-post-author ">
						<div class="news-pic">
							<a href="#">
								<img src="http://placeimg.com/50/50/animals">
							</a>
						</div>
						<span class="author-name">${post.getAuthor()}</span>  - ${post.getTime()}</div>
					<div class="wall-post-manage">

						<c:if test="${post.getUser() == sessionScope.userId || param.id == sessionScope.userId}">
							<%--<a href="/deleteWallPost?delpost=${post.getId()}&paramid=${param.id}&url=${requestScope['javax.servlet.forward.request_uri']}" class="wall-post-delete ">X</a>--%>
							<a href="#" class="wall-post-delete ">X</a>
							&nbsp;
							 <a class="wall-post-update wall-post-update-unpushed" href="#">U</a>
						</c:if>
					</div>
					<div class="wall-post-body">
							${post.getPost()}
					</div>
					<a class="send-update" href="#" style="display:none">SendUpdate</a>
				</div>
			</c:forEach>


				<div class="pagination-wrap">
					<c:if test="${currentPage > 1}">
						<a href="/page/<c:out value="${currentPage - 1}"/>" class="page prev"><<</a>
					</c:if>

					<ul class="pagination">
						<c:forEach var="page" begin="1" end="${numberOfPages}">
							<c:if test="${page == currentPage}">
								<span class="page current"><c:out value="${page}"/></span>
							</c:if>
							<c:if test="${page != currentPage}">
								<li><a href="/page/<c:out value="${page}"/>" class="page"><c:out value="${page}"/></a></li>
							</c:if>
						</c:forEach>
					</ul>

					<c:if test="${numberOfPages > currentPage}">
						<a href="/page/<c:out value="${currentPage + 1}"/>" class="page next">>></a>
					</c:if>
				</div>

			</div>
			
			
			

	</div>
		<%@ include file="footer.jsp" %>



