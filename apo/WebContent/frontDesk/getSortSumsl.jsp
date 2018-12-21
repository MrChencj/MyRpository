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
	float: left;
	width: 380px;
	height: 200px;
	margin: 5px;
	background-image: url(img/dingcanweekmenu.jpg);
}
</style>
</head>
<body>
	<div class="right_bottom">
		<p
			style="font-size: 22px; color: #FFA500; margin-left: 120px; margin-top: 5px;">销售排行榜</p>
		<table border="0" style="line-height:13px ;width:300px">
			<c:forEach items="${menuListAll }" var="list">
				<tr>
					<td><img src="img/cateitems.gif" /></td>
					<td>${list.name}</td>
					<td style="text-align: right;">已销售${list.sumsl}次</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>