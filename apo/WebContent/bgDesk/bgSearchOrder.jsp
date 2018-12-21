<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/apo/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/apo/easyui/themes/icon.css">
<script type="text/javascript" src="/apo/easyui/jquery.min.js"></script>
<!-- <script type="text/javascript" src="/apo/easyui/jquery.easyui.min.js"></script> -->

</head>

<!-- action="SearchServlet" -->
<body>
	<div id="tt" class="easyui-tabs"
		style="width: 1250px; background-color: #F2F4F8;">
		<form id="ff" action="SearchServlet" method="post" onsubmit="upd();">
			<input type="hidden" name="oprationType" value="bgQuery" />
			<table align="center" border="1" cellspacing="0"
				style="text-align: center; border-color: #6D85B1; background-color: #F2F4F8; width: 1250px; margin: auto;"
				border="1" cellspacing="0">

				<tr>
					<td style="text-align: right;">按用户姓名查询</td>
					<td style="text-align: left;"><input type="text"
						name="userName" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">按菜品名称查询</td>
					<td style="text-align: left;"><input type="text"
						name="menuName" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">按销售日期查询</td>
					<td style="text-align: left;"><input
						class="easyui-validatebox" type="date" name="orderTime" /><a
						href="javascript:void(0)"><input type="submit" value=""
							style="width: 73px; height: 35px; background-image: url(img/orderquery_button.gif);" /></a>
					</td>
				</tr>
			</table>
		</form>

		<br /> <br />

		<table align="center" border="1" cellspacing="0"
			style="text-align: center; border-color: #6D85B1; background-color: #F2F4F8; width: 1250px"
			border="1" cellspacing="0">
			<tr>
				<td colspan="9"
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

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>