<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.body {
	width: 1100px;
	height: 590px;
	margin: auto;
}

.left {
	width: 700px;
	height: 579px;
	float: left;
}

</style>
<script type="text/javascript">
	function out() {
		window.parent.frames["top"].location.reload();
	}
</script>
</head>
<body >
	<div class="body" >
		<div class="left">
			<input type="hidden" name="oprationType" value="getAllMenu" />
			<c:forEach items="${menuList }" var="menu">
				<div style="width: 350px; height: 160px; float: left;">
					<a href="MenuServlet?oprationType=getMenuById&id=${menu.id }" target="mid"><div style="width: 158px; height: 140px;border-style: solid;border-color: black;border-width: 1px; float: left;background-image: url(${menu.imgPath}); " >
							</div></a>
					<div>
						<table cellpadding="0"
							style="width: 190px; height: 160px; font-size: 14px; text-align: left;">
							<tr>
								<td>菜名：</td>
								<td>${menu.name}</td>
							</tr>
							<tr>
								<td>市场价格：</td>
								<td>${menu.price}</td>
							</tr>
							<tr>
								<td>会员价格：</td>
								<td>${menu.pricel}</td>
							</tr>
							<tr style="line-height: 50px; text-align: start;">
								<td>配料：</td>
								<td>${menu.burden}</td>
							</tr>
							<tr>
								<td>菜名类型：</td>
								<td>${menu.typename}</td>
							</tr>
						</table>
					</div>
					<div
						style="width: 77px; height: 20px; float: left; margin-top: -20px; margin-left: 20px;">
						<a href="ShoppingCarServlet?oprationType=add&id=${menu.id }" onclick="out()"><img src="img/cart.png" /></a>
					</div>
				</div>
			</c:forEach>
			<div style="float: left; margin-left: 300px">
				<a href="MenuServlet?oprationType=getAllMenu&pageNum=1">首页</a>
				<c:forEach begin="1" end="${pageCount }" step="1" var="num">
					<c:if test="${pageNum!=num }">
						<a href="MenuServlet?oprationType=getAllMenu&pageNum=${num }">
					</c:if>
						${num }
					<c:if test="${pageNum!=num }">
						</a>
					</c:if>
				</c:forEach>
				<a href="MenuServlet?oprationType=getAllMenu&pageNum=${ pageCount}">尾页</a>

			</div>
		</div>

		<iframe width="380px" height="160px" 
			src="NoticeServlet?oprationType=getAllNotice" frameborder="0"
			scrolling="no">
		</iframe>
		<iframe width="380px" height="160px"
			src="/apo/frontDesk/shoppingCar.jsp" frameborder="0"
			scrolling="no">
		</iframe>
		<iframe width="390px" height="300px"
			src="MenuServlet?oprationType=getSumsl" frameborder="0"
			scrolling="no"> </iframe>

		<hr color="#FFA500"
			style="border-width: 2px; float: left; width: 1100px; margin-top: -40px;" />
	</div>

</body>
</html>