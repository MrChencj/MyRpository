<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
			var second;
			window.onload = function() {
				second = document.getElementById("second").innerText;

				setInterval("changSecond()", 1000);
			}

			function changSecond() {
				if(second == 0) {
					window.location.href = "../SearchServlet?oprationType=query";
				}
				second--;
				document.getElementById("second").innerText = second;
			}
			
		</script>
	</head>
	<body > 
		<p style="font-size: 20px;color: red;">提交成功</p>页面将在<span id="second">3</span>秒之后跳转到我的订单
	</body>
</html>