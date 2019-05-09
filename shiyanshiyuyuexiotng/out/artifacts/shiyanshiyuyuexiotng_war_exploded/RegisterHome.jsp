<%--
  Created by IntelliJ IDEA.
  User: 92407
  Date: 2018/6/23
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>注册导航</title>
	<link rel="stylesheet" href="/css/Home.css">
	<script type="text/javascript" src="/js/HomePageJs.js"></script>
</head>
<body>

<%--头部--%>
<div align="center" name="Head">
	<jsp:include page="Head.jsp"/>
</div>





<%--进行session权限判断，无权限者不得入内--%>
<div class="container">
	<%--判断session权限以及锁定用户--%>
	<%
		response.setContentType("text/html;charset=utf-8");//这一句对字节流无效
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		if (session.getAttribute("session")==null){
	%>
	<br>
	<%--<h3 align="center">对不起，您没有权限登录该页面。请登录后操作，将在3秒后返回到主页...</h3>--%>
		<div class="user_xianshi">用户：<a href="index.jsp" style="color: midnightblue">未登录</a> </div>
		<div id="w_zhuce">

			<table id="zhuce" align="center">
				<tr align="center">
					<td class="mode" id="mode1"><a href="InsertAdm.jsp">管理员注册</a></td>
					<td class="mode" id="mode2"><a href="InsertTeacher.jsp">教师注册</a></td>
					<td class="mode" id="mode3"><a href="InsertStudent.jsp">学生注册</a></td>

				</tr>
			</table>

		</div>
	<br>
</div>
<%
}else{
%>
<%--进入了session的控制范围--%>
<div class="container">
	<%--这是用户session的显示--%>
	<div class="user_xianshi">用户：<%=session.getAttribute("session")%> </div>
		<div id="w_zhuce">

			<table id="zhuce" align="center">
				<tr align="center">
					<td class="mode" id="mode1"><a href="InsertAdm.jsp">管理员注册</a></td>
					<td class="mode" id="mode2"><a href="InsertTeacher.jsp">教师注册</a></td>
					<td class="mode" id="mode3"><a href="InsertStudent.jsp">学生注册</a></td>

				</tr>
			</table>

		</div>
	<%
			//		out.print("欢迎"+session.getAttribute("session")+"登录");
		}

	%>
</div>
<%--出了session的控制范围--%>




<%--尾部--%>
<div align="center" name="Head">
	<jsp:include page="Bottom.jsp"/>
</div>

</body>
</html>
