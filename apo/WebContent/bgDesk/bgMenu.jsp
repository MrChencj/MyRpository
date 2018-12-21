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
<script type="text/javascript" src="/apo/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="bgDesk/js/search.js"></script>
<style type="text/css">
ul li {
	list-style-type: none;
	width: 182px;
	height: 30px;
	text-align: center;
}

ul li a {
	text-decoration: none;
	color: black;
}
</style>
<script type="text/javascript">
	function openUrl(url, title) {
		$(function() {
			$('#tt').tabs('add', {
				title : title,
				content : 'Tab Body',
				closable : true,
				href : url,
				tools : [ {
					iconCls : 'icon-mini-refresh',
					handler : function() {
						alert('refresh');
					}
				} ]
			});

		});
	}
	
</script>
</head>

<body class="easyui-layout">
	<div data-options="region:'north',split:false"
		style="height: 70px; background-image: url(./bgimg/top-right.gif);">
		<img src="/apo/bgimg/logo.gif" /> <a
			href="AdminServlet?oprationType=logOut"
			style="float: right; margin-right: 100px; margin-top: 10px;"><img
			src="./bgimg/out.gif" /></a>
		<div
			style="width: 500px; height: 35px; float: right; margin-right: 400px; margin-top: 5px">
			<marquee>
				<font style="color: white; size: 14px">管理员：${admin.name}你好，欢迎你的登录使用!</font>
			</marquee>
		</div>
	</div>
	<div data-options="region:'west',split:false"
		style="width: 300px; background: #eee;">
		<ul style="line-height: 30px;">
			<li style="font-weight: bold;">菜单管理</li>
			<li><img src="/apo/bgimg/menu_topline.gif" /></li>
			<li style="background-image: url(./bgimg/menu_bgs.gif);"><a
				href="javascript:void(0)"
				onclick="openUrl('./MenuServlet?oprationType=bgAddMenuBefore','添加新菜单')">添加新菜单</a></li>
			<li style="background-image: url(./bgimg/menu_bgs.gif);"><a
				href="javascript:void(0)"
				onclick="openUrl('./MenuServlet?oprationType=bgGetAllMenu','菜单信息列表')">菜单信息列表</a></li>
			<li style="font-weight: bold;">菜单类别管理</li>
			<li><img src="/apo/bgimg/menu_topline.gif" /></li>
			<li style="background-image: url(./bgimg/menu_bgs.gif);"><a
				href="javascript:void(0)"
				onclick="openUrl('bgDesk/bgaddType.jsp','添加新类型')">添加新类型</a></li>
			<li style="background-image: url(./bgimg/menu_bgs.gif);"><a
				href="javascript:void(0)"
				onclick="openUrl('./TypeServlet?oprationType=bgAllType','类别信息列表')">类别信息列表</a></li>
			<li style="font-weight: bold;">公告信息管理</li>
			<li><img src="/apo/bgimg/menu_topline.gif" /></li>
			<li style="background-image: url(./bgimg/menu_bgs.gif);"><a
				href="javascript:void(0)"
				onclick="openUrl('bgDesk/bgaddNotice.jsp','添加新通告')">添加新通告</a></li>
			<li style="background-image: url(./bgimg/menu_bgs.gif);"><a
				href="javascript:void(0)"
				onclick="openUrl('./NoticeServlet?oprationType=bgAllNotice','通告信息列表')">通告信息列表</a></li>
			<li style="font-weight: bold;">销售订单管理</li>
			<li><img src="/apo/bgimg/menu_topline.gif" /></li>
			<li style="background-image: url(./bgimg/menu_bgs.gif);"><a
				href="javascript:void(0)"
				onclick="openUrl('./SearchServlet?oprationType=bgQueryAllOrder','销售订单查询结果列表')">销售订单列表</a></li>
			<li style="background-image: url(./bgimg/menu_bgs.gif);"><a
				href="javascript:void(0)"
				onclick="openUrl('./SearchServlet?oprationType=bgQuery','销售订单查询')">销售订单查询</a></li>
			<li style="background-image: url(./bgimg/menu_bgs.gif);"><a
				href="javascript:void(0)"
				onclick="openUrl('./SearchServlet?oprationType=bgQueryOrderToDay','本日销售统计')">本日销售统计</a></li>
			<li style="font-weight: bold;"><a href="javascript:void(0)"
				onclick="openUrl('./AdminServlet?oprationType=updBeforeAdmin&id=${admin.id}','系统用户管理')">系统用户管理</a></li>
			<li style="font-weight: bold;"><a
				href="AdminServlet?oprationType=logOut">注销退出</a></li>
		</ul>

	</div>
	<div data-options="region:'center'"
		style="padding: 5px; background: #eee;">
		<div id="tt" class="easyui-tabs"></div>
	</div>
</body>
</html>