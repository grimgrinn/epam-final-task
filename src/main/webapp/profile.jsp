<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="lang" uri="/WEB-INF/tld/taglib.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

			<%@ include file="header.jsp" %>

		<div class="content">
			<%@ include file="sidebar.jsp" %>
			
			<div class="main-stripe">
			<div class="user-name"><c:out value="${user.getFullName()}"/></div>
			
			<div class="user-pic">
				<img src="http://placeimg.com/200/300/animals">
			</div>
			
			<div class="user-info">
				${sessionScope.userId} --- ${sessionScope.userId}

						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.<p>
			</div>
			
			<div class="wall-post-new">
			<span style="display:block">Whatsapp?</span>
				<form action="/addwallpost" method="POST">

					<textarea style="resize:none; padding-left: 8px;    padding-top: 4px;" cols="70" rows="4" name="postBody"></textarea>
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
				<div class="wall-post wall-post-news">
					<div class="wall-post-author ">
						<div class="news-pic">
							<a href="#">
								<img src="http://placeimg.com/50/50/animals">
							</a>
						</div>
				<span class="author-name">${post.getAuthor()}</span>  - ${post.getTime()}</div>
					<div class="wall-post-manage">

							<c:if test="${post.getUser() == sessionScope.userId || param.id == sessionScope.userId}">		<a href="/deleteWallPost?id=${param.id}&delpost=${post.getId()}" class="wall-post-delete ">X</a></c:if>
					</div>
					<div class="wall-post-body">
							${post.getPost()}
					</div>
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



