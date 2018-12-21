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
		<form id="ff" action="./MenuServlet" method="post"
			enctype="multipart/form-data">

			<c:if test="${empty menu }">
				<input type="hidden" name="oprationType" value="bgAddMenu" />
			</c:if>
			<c:if test="${not empty menu }">
				<input type="hidden" name="oprationType" value="bgUpdMenu" />
				<input type="hidden" name="id" value="${menu.id }" />
			</c:if>
			<table
				style="margin: auto; border-color: #406099; width: 1000px; background-color: #F2F4F8;"
				border="1" cellspacing="0">
				<tr>
					<td style="text-align: right;">菜品名称：</td>
					<td><input type="text" name="name" value="${menu.name }" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">原料：</td>
					<td><input type="text" name="burden" value="${menu.burden }" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">市场价格：</td>
					<td><input type="text" name="price" value="${menu.price }" /></td>
				</tr>
				<c:if test="${not empty menu }">
					<tr>
						<td style="text-align: right;">市场销量：</td>
						<td><input type="text" name="sums" value="${menu.sums }" /></td>
					</tr>
				</c:if>
				<tr>
					<td style="text-align: right;">会员价格：</td>
					<td><input type="t" name="pricel" value="${menu.pricel }" /></td>
				</tr>
				<c:if test="${not empty menu }">
					<tr>
						<td style="text-align: right;">会员销量：</td>
						<td><input type="text" name="sumsl" value="${menu.sumsl }" /></td>
					</tr>
				</c:if>
				<tr>
					<td style="text-align: right;">说明：</td>
					<td><textarea name="brief"
							style="width: 300px; height: 180px;">${menu.brief }</textarea></td>
				</tr>
				<tr>
					<td style="text-align: right;">菜品类别：</td>
					<td><select name="typeId">
							<c:if test="${not empty menu }">
								<option value="${type.id }" selected="selected">${type.typename }</option>
							</c:if>
							<c:forEach items="${typeList }" var="type">
								<option value="${type.id }">${type.typename }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td style="text-align: right;">上传图片：</td>
					<td><input type="file" name="file" multiple="multiple" />
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;"><input
						type="submit" value="提交" onclick="submitForm()" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>