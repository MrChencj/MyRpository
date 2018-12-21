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

</head>
<body>
	<div id="tt" class="easyui-tabs" style="width: 1250px;">
		<table 
			style="text-align: center; border-color: #6D85B1; background-color: #F2F4F8; width: 1250px"
			border="1" cellspacing="0">
			<tr>
				<td colspan="11">菜单信息列表</td>

			</tr>
			<tr>
				<th>菜单名称</th>
				<th>展示图片</th>
				<th>原料</th>
				<th>类型</th>
				<th>说明</th>
				<th>市场价格</th>
				<th>市场销售数量</th>
				<th>会员单价</th>
				<th>会员价销售数量</th>
			</tr>
			<c:forEach items="${menuList }" var="menu">
				<tr>
					<td>${menu.name }</td>
					<td><img style="width: 50px; height: 50px"
						src="${menu.imgPath }" /></td>
					<td>${menu.burden}</td>
					<td>${menu.typename}</td>
					<td>${menu.brief }</td>
					<td>${menu.price }</td>
					<td>${menu.sums }</td>
					<td>${menu.pricel }</td>
					<td>${menu.sumsl }</td>
					<td><a href="javascript:void(0)" onclick="openUrl('./MenuServlet?oprationType=bgUpdBeforeMenu&id=${menu.id }' ,'菜单详情')">修改</a></td>
					<td><a href="javascript:void(0)" onclick="openUrl('./MenuServlet?oprationType=bgDelMenu&id=${menu.id}','菜单信息列表') ">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="11"><div style="float: left; margin-left: 500px">
				<span style="font-weight: bold;">共${pageCount }页</span>
						<a href="javascript:void(0)"
							onclick="openUrl('./MenuServlet?oprationType=bgGetAllMenu&pageNum=1','首页')">首页</a>
						<c:forEach begin="2" end="${pageCount-1 }" step="1" var="num">
							<c:if test="${pageNum!=num }">
								<a href="javascript:void(0)"
							onclick= "openUrl('./MenuServlet?oprationType=bgGetAllMenu&pageNum=${num }','第${num }页')">
							</c:if>
						${num }
					<c:if test="${pageNum!=num }">
								</a>
							</c:if>
						</c:forEach>
						<a href="javascript:void(0)" onclick="openUrl('./MenuServlet?oprationType=bgGetAllMenu&pageNum=${pageCount}', ' 尾页  '  )  " >尾页</a>
						
					</div></td>
			</tr>

		</table>
	</div>

</body>
</html>