<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<style type="text/css">
			.body{
				width: 400px;
				height: 200px;
				margin: auto;
				background-image: url(/apo/img/dingcanche.jpg);
			}
			.body2{
				float: left;
				width: 400px;
				height: 200px;
				margin-top: 50px;
				background-color:#FFC0CB ;
			}
		</style>
	</head>
	<body>
		<div class="body">
			<div class="body2">
			<p style="font-size: 20px;font-weight: bold;float: left;margin-left: 110px;margin-top: -40px;color:#FBB93C ">我的餐车</p>
			<a href="/apo/frontDesk/shoppingCar.jsp" target="mid" style="float:left;text-decoration: none;margin-left: 300px;margin-top: -40px">详情>></a>
				<table align="center" border="1" cellspacing="0" style="width: 400px;">
		<tr>
			<th>名称</th>
			<th>单价</th>
			<th>选购数量</th>
			<th>小计</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${sessionScope.shoppingList }" var="list">
			<tr>
				<td>${list.name }</td>
				<td>${list.price }</td>
				<td>${list.sum }</td>
				<td>${list.price*list.sum }</td>
				<td><a
					href="/apo/ShoppingCarServlet?oprationType=increment&id=${list.id }"><img src="/apo/img/plus.gif"/></a>
					<a href="/apo/ShoppingCarServlet?oprationType=reduce&id=${list.id }"><img src="/apo/img/reduceicon_enabled.gif"/></a>
					<a href="/apo/ShoppingCarServlet?oprationType=remove&id=${list.id }"><img src="/apo/img/pic22.gif"/></a></td>

			</tr>
		</c:forEach>
		<tr>
			<td colspan="2">数量</td>
			<td>${sessionScope.sum }</td>
			<td>总额</td>
			<td>${sessionScope.priceCountSum }</td>
		<tr>
		<tr>
		<td colspan="4" style="text-align: center;"><a href="/apo/OrderServlet?oprationType=addOrder" target="mid">提交</a></td>
		</tr>
	</table>
			</div>
	
	</div>
</body>
</html>