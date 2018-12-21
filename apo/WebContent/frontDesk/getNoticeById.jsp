<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center" style="text-align: center;width: 200px;height: 200px">
		<tr>
			<td style="font-size: 20px;font-weight: bold;">${notice.name }</td>
		</tr>
		<tr>
			<td >${notice.times}</td>
		</tr>
		<tr>
			<td>${notice.content }</td>
		</tr>
		<tr>
			<td><a href="MenuServlet?oprationType=getAllMenu">返回</a></td>
		</tr>
	</table>
	<hr color="#FFA500"
			style="border-width: 2px; float: left; width: 1100px; margin-top: 378px;margin-left: 225px" />
</body>
</html>