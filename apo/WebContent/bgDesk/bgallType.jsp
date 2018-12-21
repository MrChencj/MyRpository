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
				<td colspan="11">类别信息列表</td>

			</tr>
			<tr>
				<th>类别ID</th>
				<th>类别名称</th>
				<th colspan="2"></th>
				
			</tr>
			<c:forEach items="${typeList }" var="type">
				<tr>
					<td>${type.id }</td>
					<td>${type.typename}</td>
					<td><a href="javascript:void(0)" onclick="openUrl('./TypeServlet?oprationType=bgUpdBeforeType&id=${type.id }' ,'类别详情')">修改</a></td>
					<td><a href="javascript:void(0)" onclick="openUrl('./TypeServlet?oprationType=bgDelType&id=${type.id}','类别信息列表') ">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="11"><div style="float: left; margin-left: 500px">
				<span style="font-weight: bold;">共${pageCount }页</span>
						<a href="javascript:void(0)"
							onclick="openUrl('./TypeServlet?oprationType=bgAllType&pageNum=1','首页')">首页</a>
						<c:forEach begin="2" end="${pageCount-1 }" step="1" var="num">
							<c:if test="${pageNum!=num }">
								<a href="javascript:void(0)"
							onclick= "openUrl('./TypeServlet?oprationType=bgAllType&pageNum=${num }','第${num }页')">
							</c:if>
						${num }
					<c:if test="${pageNum!=num }">
								</a>
							</c:if>
						</c:forEach>
						<a href="javascript:void(0)" onclick="openUrl('./TypeServlet?oprationType=bgAllType&pageNum=${pageCount}', ' 尾页  '  )  " >尾页</a>
					</div></td>
			</tr>
		</table>
	</div>

</body>
</html>