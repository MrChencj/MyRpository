<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<table align="center" border="1" cellspacing="0"
			style="text-align: center; border-color: #6D85B1; background-color: #F2F4F8; width: 1250px"
			border="1" cellspacing="0">
			<tr>
				<td colspan="11"
					style="font-weight: bold; font-size: 16px; text-align: center;">订单查询结果列表</td>
			</tr>
			<tr>
				<th>菜品名称</th>
				<th>真实姓名</th>
				<th>订购电话</th>
				<th>派送地址</th>
				<th>订购数量</th>
				<th>单价(元)</th>
				<th>合计(元)</th>
				<th>订购时间</th>
				<th>是否派送</th>
				<th colspan="2">确认订单</th>

			</tr>
			<c:forEach items="${orderList }" var="order">
				<tr>
					<td>${order.menuName}</td>
					<td>${order.userName }</td>
					<td>${order.userTel }</td>
					<td>${order.userAddress }</td>
					<td>${order.orderSum }</td>
					<td>${order.price }</td>
					<td>${order.count }</td>
					<td>${order.orderTime }</td>
					<td><c:if test="${order.send eq true }">是</c:if> <c:if
							test="${order.send eq false }">否</c:if></td>
					<c:if test="${order.send eq false }">
						<td><a href="javascript:void(0)"
							onclick="openUrl('./OrderServlet?oprationType=bgUpdOrder&id=${order.id}','销售订单查询结果列表')">确认</a>
						</td>
						<td><a href="">取消</a></td>
					</c:if>
					<c:if test="${order.send eq true }">
						<td colspan="2"><a href="javascript:void(0)"
							onclick="openUrl('./OrderServlet?oprationType=bgDelOrder&id=${order.id}','销售订单查询结果列表')">取消</a></td>
					</c:if>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>