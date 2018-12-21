<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="tt" class="easyui-tabs" style="width: 1250px;">
		<table 
			style="text-align: center; border-color: #6D85B1; background-color: #F2F4F8; width: 1250px"
			border="1" cellspacing="0">
			<tr>
				<td colspan="11">本日销售额统计</td>

			</tr>
			<tr>
				<th>菜品名称</th>
				<th>内容</th>
				<th>发帖时间</th>
				
			</tr>
			<c:forEach items="${noticeList }" var="notice">
				<tr>
					<td>${notice.name }</td>
					<td>${notice.content}</td>
					<td>${notice.times}</td>
					<td><a href="javascript:void(0)" onclick="openUrl('./NoticeServlet?oprationType=bgUpdBeforeNotice&id=${notice.id }' ,'类别详情')">修改</a></td>
					<td><a href="javascript:void(0)" onclick="openUrl('./NoticeServlet?oprationType=bgDelNotice&id=${notice.id}','通告信息列表') ">删除</a></td>
				</tr>
			</c:forEach>
			
		</table>
	</div>

</body>
</html>