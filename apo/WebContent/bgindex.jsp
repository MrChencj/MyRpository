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
	margin: auto;
	width: 1585px;
	height: 800px;
	background-color: #1D3647;
}

.body2 {
	float: left;
	margin-top: 50px;
	width: 1585px;
	height: 532px;
	background-image: url(bgimg/login_bg.jpg);
}

.table_body {
	float: left;
	margin-top: -200px;
	width: 500px;
	height: 532px;
}
</style>
<script>
	function checkdata() {
		return notnull("name", "账号") && notnull("password", "密码");
	}

	function notnull(field, msg) {
		var name = document.getElementsByName(field)[0];
		var message = document.getElementById("message");
		var rex = /^\s*$/;
		if (rex.test(name.value)) {
			message.innerHTML = "<font>" + msg + "不能为空</font>";
			return false;
		}
		return true;
	}
</script>
</head>

<body>
	<div class="body">
		<div class="body2">
			<p style="float: left; margin-left: 550px; margin-top: 120px;">
				<img src="bgimg/logo.png" />
			</p>
			<p
				style="float: left; margin-left: 550px; margin-top: 50px; font-size: 12px; color: gray;">
				<img src="bgimg/icon-mail2.gif" />客户服务邮箱：admin@apsfc.com
			</p>
			<p
				style="float: left; margin-left: -207px; margin-top: 66px; font-size: 12px; color: gray;">
				<img src="bgimg/icon-phone.gif" />官方网站：http://www.apsfc.com
			</p>
			<p
				style="color: gray; float: left; margin-top: 150px; margin-left: -300px; font-size: 20px; font-weight: 800px;">
				<span><img src="bgimg/icon-demo.gif" />使用说明</span> <span
					style="margin-left: 200px;"><img
					src="bgimg/icon-login-seaver.gif" />在线客服 </span>
			</p>
			<div
				style="width: 3px; height: 450px; background-image: url(bgimg/l1b3.gif); float: left; margin-top: -170px; margin-left: 100px;"></div>
			<form onsubmit="return checkdata();" action="AdminServlet"
				method="post">
				<input type="hidden" name="oprationType" value="login" />
				<div class="table_body">
					<span style="margin-left: 120px; margin-top: 70px; float: left;"
						id="message"></span>
					<c:if test="${not empty error }">
						<span style="margin-left: 120px; margin-top: 70px; float: left;">账户或密码错误,请重新输入！</span>
						<%session.removeAttribute("error"); %>
					</c:if>
					<table
						style="line-height: 30px; margin-left: 120px; margin-top: 100px;">
						<tr>
							<td colspan="2" style="font-weight: bold;">登陆网上订餐后台管理</td>
						</tr>
						<tr>
							<td>管理员：</td>
							<td><input type="text" name="name" /></td>
						</tr>
						<tr>
							<td>密码：</td>
							<td><input type="text" name="password" /></td>
						</tr>
						<tr>
							<td colspan="2" style="text-align: center;"><input
								type="checkbox" name="check" value="check" />5天内自动登陆</td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="提交" />&nbsp;&nbsp;<input
								type="reset" value="重置" /></td>
						</tr>
					</table>
				</div>
			</form>

		</div>
	</div>
</body>

</html>