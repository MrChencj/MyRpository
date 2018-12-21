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
<script type="text/javascript">
	
</script>
</head>
<body>
	<div id="tt" class="easyui-tabs"
		style="width: 1250px; background-color: #F2F4F8;">
		<form  action="./TypeServlet" method="post">
			<c:if test="${empty type }">
				<input type="hidden" name="oprationType" value="bgAddType" />
			</c:if>
			<c:if test="${not empty type }">
				<input type="hidden" name="oprationType" value="bgUpdType" />
				<input type="hidden" name="id" value="${type.id }" />
			</c:if>
			<table
				style="margin: auto; border-color: #406099; width: 1000px; background-color: #F2F4F8;"
				border="1" cellspacing="0">
				<tr>
					<td style="text-align: right;">菜品类别：</td>
					<td><input type="text" name="typename" value="${type.typename }" /></td>
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