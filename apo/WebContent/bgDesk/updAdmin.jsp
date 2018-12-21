<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div id="tt" class="easyui-tabs"
		style="width: 1250px; background-color: #F2F4F8;">
		<form  action="./AdminServlet" method="post">
		<input type="hidden" name="oprationType" value="updAdmin"/>
		<input type="hidden" name="id" value="${admin.id}"/>
			<table
				style="margin: auto; border-color: #406099; width: 1000px; background-color: #F2F4F8;"
				border="1" cellspacing="0">
				<tr>
					<td style="text-align: center;" colspan="2">更改管理员信息</td>
				</tr>
				<tr>
					<td style="text-align: right;">管理员账号：</td>
					<td><input type="text" name="name" value="${admin.name }" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">管理员密码：</td>
					<td><input type="text" name="password" value="${admin.password }" /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;"><input
						type="submit" value="提交" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>