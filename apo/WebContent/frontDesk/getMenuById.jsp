<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center" border="1"
		style="width: 400px; height: 180px; border-color: red;">
		<tr>
			<td>菜单名称：</td>
			<td>${menu.name}</td>
		</tr>
		<tr>
			<td>原料：</td>
			<td>${menu.burden}</td>
		</tr>
		<tr>
			<td>市场单价：</td>
			<td>${menu.price}</td>
		</tr>
		<tr>
			<td>会员单价：</td>
			<td>${menu.pricel}</td>
		</tr>
		<tr>
			<td>说明：</td>
			<td>${menu.brief}</td>
		</tr>
		<tr>
			<td>菜品类别：</td>
			<td>${menu.typename}</td>
		</tr>
		<tr>
			<td height="150px">展示图片：</td>
			<td><img src="${menu.imgPath}" /></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;"><a href="MenuServlet?oprationType=getAllMenu">返回</a></td>
		</tr>
	</table>
</body>
</html>