<%--
  Created by IntelliJ IDEA.
  User: 92407
  Date: 2018/6/23
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>头部</title>
	<link rel="stylesheet" href="/css/Home.css">
	<script type="text/javascript" src="/js/HomePageJs.js"></script>
</head>
<body>
<%--菜单栏--%>
<div class="h_top" style="height: 100px;width: 100%">
	<div>
		<div><h1 id="title" align="center">中北大学实验室预约系统</h1></div>
		<div class="user_xianshi"><a href="index.jsp" style="color: midnightblue">登录</a> </div>
	</div>
</div>
<div class="h_daohang">
	<table id="daohang" >
		<tr style="height: 50px" align="center">
			<td class="head_w_width"><a href="RegisterHome.jsp">主页</a></td>
			<td class="head_w_width"><a href="ConditionSelect.jsp">查看实验室信息</a></td>
			<td class="head_w_width"><a href="AppointmentTeacher.jsp">教师预约</a></td>
			<td class="head_w_width"><a href="AppointmentStudent.jsp">学生预约</a></td>
			<td class="head_w_width"><a href="/DoSelectMyClass_YES_NO">我的课程</a></td>

		</tr>
	</table>
</div>
</body>
</html>
