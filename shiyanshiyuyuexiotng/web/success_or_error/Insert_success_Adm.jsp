<%--
  Created by IntelliJ IDEA.
  User: 92407
  Date: 2018/5/10
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Insert_success</title>
</head>
<body>


<div align="center" name="Head">
	<jsp:include page="../Head.jsp"/>
</div>

<div class="container">
	<h4 align="center"><%=request.getParameter("username")%>&nbsp;&nbsp;录入成功</h4>


</div>

<%--尾部--%>
<div align="center" name="Head">
	<jsp:include page="../Bottom.jsp"/>
</div>



</body>
</html>
