<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="tt" class="easyui-tabs"
		style="width: 1250px; background-color: #F2F4F8;">
		<form  action="./NoticeServlet" method="post">
			<c:if test="${empty notice }">
				<input type="hidden" name="oprationType" value="bgAddNotice" />
			</c:if>
			<c:if test="${not empty notice }">
				<input type="hidden" name="oprationType" value="bgUpdNotice" />
				<input type="hidden" name="id" value="${notice.id }" />
			</c:if>
			<table
				style="margin: auto; border-color: #406099; width: 1000px; background-color: #F2F4F8;"
				border="1" cellspacing="0">
				<tr>
					<td style="text-align: right;">公告标题：</td>
					<td><input type="text" name="name" value="${notice.name }" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">公告内容：</td>
					<td><textarea name="content"
							style="width: 300px; height: 180px;">${notice.content }</textarea></td>
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