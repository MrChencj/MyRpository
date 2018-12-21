<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.right_bottom {
	width: 380px;
	margin:auto;
	background-image: url(/apo/img/bg.jpg);
}
</style>
</head>
<body>
	<div class="right_bottom">
		<p
			style="font-size: 22px; color: #FFA500; margin-left: 120px; margin-top: 5px;">餐厅公告</p>
		<p style="margin-left: 260px; margin-top: -40px;">
			<a href="/apo/frontDesk/getAllNotice.jsp" target="mid"
				style="text-decoration: none; color: black">更多>></a>
		</p>
			<table border="0" style="line-height: 14px; width: 450px;margin: auto;">
				<c:forEach items="${sessionScope.noticeList }" var="list">
					<tr>
						<td><img src="/apo/img/cateitems.gif" /></td>
						<td><a
							href="/apo/NoticeServlet?oprationType=getNoticeById&id=${list.id }"
							target="mid">${list.name}</a></td>
						<td>${list.content}</td>
						<td>${list.times}</td>
					</tr>
				</c:forEach>
			</table>
	</div>
</body>
</html>