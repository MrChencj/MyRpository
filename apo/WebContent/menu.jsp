<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
.div {
	width: 1100px;
	margin: auto;
	height: 110px;
}

a {
	text-decoration: none;
}

.top_logo {
	width: 211px;
	height: 84px;
	background-image: url(img/1257477260.gif);
}

.top_menu {
	float: right;
	margin-top: -84px;
	width: 395px;
	height: 25px;
	background-image: url(img/topmenu_bg.jpg);
}

.top_menu ul li {
	float: left;
	margin-top: -11px;
}

.menu {
	float: right;
	margin-top: -45px;
	width: 800px;
	height: 50px;
}

.menu ul li {
	float: left;
	width: 87px;
	height: 41px;
	line-height: 40px;
	margin-top: -4px;
	margin-left: 20px;
	background-image: url(img/menu.jpg);
	text-align: center;
}

.user {
	width: 400px;
	height: 30px;
	float: right;
	margin-top: -68px;
	margin-left: 200px;
	text-align: center;
	line-height: 5px;
	color: #ED6212;
}
</style>
<script type="text/javascript">
	function out() {
		window.parent.frames["toop"].location.reload();
	}
</script>
</head>

<body>
	<div class="div">
		<div class="top_logo"></div>
		<div class="top_menu">
			<ul style="list-style-type: none; font-size: 14px;">
				<li><a href="frontDesk/userLogin.jsp" target="mid" style="color:gray; ">会员登录|</a></li>
				<li><a href="frontDesk/userRegister.jsp" target="mid" style="color:gray;">会员注册|</a></li>
				<li ><a href="UserServlet?oprationType=logout" target="mid" style="color:gray;" onclick="out()">注销登录|</a></li>
				<li><a href="frontDesk/shippingGuide.html" target="mid" style="color:gray;">配送说明|</a></li>
				<li><a href="frontDesk/aboutUs.html" target="mid" style="color:gray;">关于我们|</a></li>
			</ul>
		</div>
		<div class="menu">
			<ul style="list-style-type: none; font-size: 16px;">
				<li><a href="MenuServlet?oprationType=getAllMenu" style="color: white;" target="mid">首页</a></li>
				<li><a href="frontDesk/shoppingCar.jsp" style="color: white;" target="mid">我的餐车</a></li>
				<li><a href="frontDesk/order.jsp" style="color: white;" target="mid">我的订单</a></li>
				<li><a href="UserServlet?oprationType=userCenter&id=${user.id }" style="color: white;" target="mid" style="color: white;">用户中心</a></li>
				<li><a href="frontDesk/shippingGuide.html" style="color: white;" target="mid">配送说明</a></li>
				<li><a href="frontDesk/aboutUs.html" style="color: white;" target="mid">关于我们</a></li>
				<li><a href="UserServlet?oprationType=logout" target="mid"  onclick="out()" style="color: white;">注销登录</a></li>
			</ul>
		</div>
		<div class="user">
			<c:if test="${not empty user }">
				<p>亲爱的${user.name }你好,欢迎光临！</p>
			</c:if>
		</div>
		<hr color="red" style="border-width: 2px;" />
	</div>
</body>
</html>