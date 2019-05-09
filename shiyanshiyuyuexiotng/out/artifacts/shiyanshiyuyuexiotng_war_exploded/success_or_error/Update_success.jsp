<%--
  Created by IntelliJ IDEA.
  User: 92407
  Date: 2018/5/11
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Update_success</title>
</head>
<body>
%--头部--%>
<div align="center" name="Head">
	<jsp:include page="../Head.jsp"/>
</div>

<div class="container">
	<%
		out.println("修改成功，将在3秒后跳转到查询页面");
		response.setHeader("refresh","2,URL=DoSelectLabServlet");
	%>

</div>

<%--尾部--%>
<div align="center" name="Head">
	<jsp:include page="../Bottom.jsp"/>
</div>


</body>
</html>
