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
		<form action="./SearchServlet" method="post">
			<table align="center" border="1" cellspacing="0" style="border-color: red; width: 500px;line-height: 30px;">
				<input type="hidden" name="oprationType" value="query" />
				<tr>
					<td>按菜品名称查询</td>
					<td><input type="text" name="menuName" /></td>
				</tr>
				<tr>
					<td>按销售日期查询</td>
					<td><input type="date" name="orderTime" /><input type="submit" value="" style="width: 73px;height: 35px ;background-image: url(/apo/img/orderquery_button.gif);" /> </td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="/apo/SearchServlet?oprationType=getOrderByUserId&id=${user.id }" style="color: red;">我的所有订单</a>
						&nbsp;
						<a href="/apo/SearchServlet?oprationType=getOrderByUserIdNo&id=${user.id }"" style="color: blue;">未派送订单</a>
						&nbsp;
						<a href="/apo/SearchServlet?oprationType=getOrderByUserIdYes&id=${user.id }"" style="color: green;"> 已派送订单</a>
					</td>
				</tr>
			</table>
		</form>

		<br />
		<br />
		<br />
		<br />

		<table align="center" border="1" cellspacing="0" style="border-color: red">
		<tr><td colspan="9" style="font-weight: bold;font-size: 16px ;text-align: center;">订单查询结果列表</td></tr>
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
					<td><c:if test="${order.send eq true }">是</c:if>
					<c:if test="${order.send eq false }">否</c:if>
					</td>
					
				</tr>
			</c:forEach>
		</table>
	</body>

</html>