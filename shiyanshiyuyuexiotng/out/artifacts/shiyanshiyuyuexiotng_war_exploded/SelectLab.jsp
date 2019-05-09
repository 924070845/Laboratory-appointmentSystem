<%@ page import="java.util.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.user.Laboratory" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<title>SelectUser</title>
	<link rel="stylesheet" href="/css/Home.css">
	<script type="text/javascript" src="/js/HomePageJs.js"></script>
</head>
<body>

<%--头部--%>
<div align="center" name="Head">
	<jsp:include page="Head.jsp"/>
</div>

<div class="container">

	<table  align="center" width="800px" class="table3" >
		<tr>
			<hr width="800" style="color: #27A9E3">
			<%--这部分是不动的，表头--%>
			<th class="table3" align="center">ID</th>
			<th class="table3" align="center">实验室名称</th>
			<th class="table3" align="center">地址</th>
			<th class="table3" align="center">容量</th>
			<th class="table3" align="center">日期</th>
			<th class="table3" align="center">时段</th>
			<th class="table3" align="center">操作</th>
		</tr>

		<%

			List<Laboratory> userlist = (List<Laboratory>)request.getAttribute("lablist");
			Iterator<Laboratory> iter = userlist.iterator();

			while (iter.hasNext()){
				//再讲迭代器中的值取出来
				Laboratory lab = iter.next();
		%>
		<tr>
			<td class="table3" align="center"><%=lab.getLab_id()%></td>
			<td class="table3" align="center"><%=lab.getLab_name()%></td>
			<td class="table3" align="center"><%=lab.getLab_address()%></td>
			<td class="table3" align="center"><%=lab.getLab_count()%></td>
			<td class="table3" align="center"><%=lab.getLab_date()%></td>
			<td class="table3" align="center"><%=lab.getLab_tab()%></td>
			<td class="table3" align="center">
				<a href="../DoUpdateLabServlet?id=<%=lab.getLab_id()%>" style="color: black">修改</a>
				<a href="../DoDeleteLabServlet?id=<%=lab.getLab_id()%>" style="color: black">删除</a>

			</td>

		</tr>

		<%
			}
		%>

	</table>
</div>

<%--尾部--%>
<div align="center" name="Head">
	<jsp:include page="Bottom.jsp"/>
</div>




</body>
</html>
