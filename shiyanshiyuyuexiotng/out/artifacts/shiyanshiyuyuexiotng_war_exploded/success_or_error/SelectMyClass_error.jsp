<%@ page import="com.dao.Dao" %>
<%@ page import="com.user.Information" %>
<%@ page import="java.util.List" %>
<%@ page import="com.user.Laboratory" %><%--
  Created by IntelliJ IDEA.
  User: 92407
  Date: 2018/6/25
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>教师的预约页</title>
</head>
<body>
<%--头部--%>
<div align="center" name="Head">
	<jsp:include page="../Head.jsp"/>
</div>



<%--进行session权限判断，无权限者不得入内--%>
<div class="container">

	<br>
	<h3 align="center">对不起，您没有权限登录该页面,请登录后操作。将在3秒后返回到主页...</h3>
	<%
		response.setHeader("refresh","3;URL=RegisterHome.jsp");
	%>

	<br>
</div>
<%--出了session的控制范围--%>




<%--尾部--%>
<div align="center" name="Head">
	<jsp:include page="../Bottom.jsp"/>
</div>
</body>
</html>
