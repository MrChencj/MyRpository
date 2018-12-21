<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.body {
	width: 600px;
	height: 300px;
	margin: auto;
	border-style: solid;
	border-width: 1px;
	border-color: red;
	border-radius: 15px;
	background-color: #FAEBD7;
}

.left {
	width: 260px;
	height: 160px;
	float: left;
	margin-left: 10px;
	margin-top: 80px;
	border-style: solid;
	border-width: 1px;
	border-color: red;
	border-radius: 10px;
	background-color: #F5F5DC;
}

.right {
	width: 310px;
	height: 160px;
	float: left;
	margin-left: 280px;
	margin-top: -160px;
	border-style: solid;
	border-width: 1px;
	border-color: red;
	border-radius: 10px;
	background-color: #F5F5DC;
}

.right ul li {
	list-style-type: none;
}

.right ul li a {
	text-decoration: none;
}
</style>
<script type="text/javascript">
	function out() {
		window.parent.frames["toop"].location.reload();
	}
</script>
</head>

<body onunload="out()">
	<form action="../UserServlet" method="post">
		<input type="hidden" name="oprationType" value="login" />
		<div class="body">
			<c:if test="${ empty sessionScope.user }">
				<p style="margin-top: 0px; margin-left: 100px">请先登录！</p>
			</c:if>
			<div class="left">
				<table align="center" style="line-height: 50px;">
					<tr>
						<td>用户名：</td>
						<td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="pwd" /></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center;"><input
							type="submit" value="登录" />&nbsp;&nbsp; <a href=""><input
								type="button" value="注册" /></a></td>
					</tr>
				</table>
			</div>
			<div class="right">
				<ul style="text-align: left; margin-left: -25px; line-height: 30px;">
					<li><img src="../img/cateitems.gif" />如果您已经是会员，请在左侧登录</li>
					<li><img src="../img/cateitems.gif" />如果您还没有注册会员, <a href="/apo/frontDesk/userRegister.jsp" target="mid"
						style="color: red;">点击这里注册</a></li>
					<li><img src="../img/cateitems.gif" />如果你忘记了密码, <a href=""
						style="color: green;">点击这里重新设置一个密码</a></li>
				</ul>
			</div>
		</div>
	</form>
	<hr color="#FFA500"
		style="border-width: 2px; float: left; width: 1100px; margin-top: 200px; margin-left: 220px" />
</body>
</html>