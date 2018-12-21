<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
			function checkpassword(field) {
				var pwd = document.getElementsByName(field)[0];
				var rex = /^[0-9a-zA-Z]{6,16}$/;
				var accmsg = document.getElementById("pd");
				if(rex.test(pwd.value)) {
					accmsg.innerText = "";
				} else {
					accmsg.innerHTML = "<font color='red' style='font-size: 10px;'>密码必须是6~16为大小下的字母，数字组成</font>";
				}
			}

			function checkRePassWord() {
				var pwd = document.getElementsByName("pwd")[0];
				var repwd = document.getElementsByName("repwd")[0];
				if(pwd.value == repwd.value) {
					return true;
				} else {
					alert("密码不一致");
					return false;
				}
			}

			function notnull(field) {
				var name = document.getElementsByName(field)[0];
				var rex = /^\s*$/;
				if(rex.test(name.value)) {
					alert(msg + "不能为空");
					return false;
				}
				return true;
			}

			function checkdata() {
				return notnull("name") && notnull("pwd") && notnull("realName") && notnull("sex") && notnull("birthday") && notnull("card") && notnull("address") && notnull("tel") && notnull("email") && notnull("code") && checkRePassWord();
			}
			function out() {
				window.parent.frames["toop"].location.reload();
			}
		</script>
	</head>

	<body onunload="out()">
		<form onsubmit="checkdata()" action="/apo/UserServlet" method="post" >
		<c:if test="${empty user }">
		<input type="hidden" name="oprationType" value="addUser"/>
		</c:if>
		<c:if test="${not empty user }">
		<input type="hidden" name="oprationType" value="updUser"/>
		<input type="hidden" name="id" value="${user.id }"/>
		</c:if>
		<table align="center" border="1" cellspacing="0" style="width: 800px;height: 400px; border-color: red;">
			<tr>
				<td colspan="3" style="text-align: center;font-weight: bold;">请填写用户信息(带<img src="/apo/img/43.gif" />为必填项)</td>

			</tr>
			<tr>
				<td style="text-align: right;">用户名：</td>
				<td><input type="text" name="name" value="${user.name }"/></td>
				<td><img src="/apo/img/43.gif" />你用来登录的用户名</td>
			</tr>
			<tr>
				<td style="text-align: right;">密码：</td>
				<td><input type="password" name="pwd" value="${user.pwd }" onblur="checkpassword(this.name)" /><span id="pd"></span></td>
				<td><img src="/apo/img/43.gif" />长度必须大于5个小于16个字符，只能为英语、数字</td>
			</tr>
			<tr>
				<td style="text-align: right;">确认密码：</td>
				<td><input type="password" name="repwd" value="${user.pwd }" onblur="checkRePassWord()" /></td>
				<td><img src="/apo/img/43.gif" />请将输入的密码再次输入</td>
			</tr>
			<tr>
				<td style="text-align: right;">真实姓名：</td>
				<td><input type="text" name="realName" value="${user.realName}"/></td>
				<td><img src="/apo/img/43.gif" />请填写您的真实姓名</td>
			</tr>
			<tr>
				<td style="text-align: right;">性别：</td>
				<td>男：<input type="radio" name="sex" value="true"<c:if test="${user.sex}"> checked="checked"</c:if> />女：<input type="radio" name="sex" value="false" <c:if test="${user.sex eq '1' }">checked="checked" </c:if> /></td>
				<td><img src="/apo/img/43.gif" />请填写您的真实信息</td>
			</tr>
			<tr>
				<td style="text-align: right;">生日：</td>
				<td><input type="date" name="birthday" value="${fn:substring(user.birthday,0,10)}"/></td>
				<td><img src="/apo/img/43.gif" />请填写您的真实年龄</td>
			</tr>
			<tr>
				<td style="text-align: right;">身份证号：</td>
				<td><input type="text" name="card" value="${user.card }"/></td>
				<td><img src="/apo/img/43.gif" />请填写您的真实信息</td>
			</tr>
			<tr>
				<td style="text-align: right;">家庭住址：</td>
				<td><input type="text" name="address" value="${user.address }"/></td>
				<td><img src="/apo/img/43.gif" />请填写您的真实信息</td>
			</tr>
			<tr>
				<td style="text-align: right;">电话号码：</td>
				<td><input type="text" name="tel" value="${user.tel }"/></td>
				<td><img src="/apo/img/43.gif" />请填写您的真实信息(格式为02487654321或13987654321)</td>
			</tr>
			<tr>
				<td style="text-align: right;">电子邮箱：</td>
				<td><input type="email" name="email" value="${user.email }" /></td>
				<td><img src="/apo/img/43.gif" />请填写您有效的邮件地址，以便我们为您提供有效的服务。</td>
			</tr>
			<tr>
				<td style="text-align: right;">邮政编码：</td>
				<td><input type="text" name="code" value="${user.code }"/></td>
				<td><img src="/apo/img/43.gif" />请填写您的真实信息(格式为000000)</td>
			</tr>

			<tr>
				<td colspan="3" style="text-align: center;"><input type="submit" value="提交" /> <input type="reset" value="重置" /></td>

			</tr>
		</table>
		</form>
	</body>

</html>