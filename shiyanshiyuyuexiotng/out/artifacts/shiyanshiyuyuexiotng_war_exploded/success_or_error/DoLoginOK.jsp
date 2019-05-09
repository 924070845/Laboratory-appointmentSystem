<%@ page import="static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Name" %><%--
  Created by IntelliJ IDEA.
  User: 92407
  Date: 2018/5/8
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>OK</title>
</head>
<body>

<%--头部--%>
<div align="center" name="Head">
	<jsp:include page="../Head.jsp"/>
</div>

<div class="container">
<div align="center">
	<%
		response.setContentType("text/html;charset=utf-8");//这一句对字节流无效
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		out.print("欢迎"+session.getAttribute("session")+"登录");
	%>
</div>

</div>

<%--尾部--%>
<div align="center" name="Head">
	<jsp:include page="../Bottom.jsp"/>
</div>


</body>
</html>
