<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.user.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>实验室信息修改</title>
</head>
<body>
<%--头部--%>
<div align="center" name="Head">
	<jsp:include page="Head.jsp"/>
</div>

<div class="container">

	<%

		Laboratory lab = new Laboratory();
		List<Laboratory> lablist = (List<Laboratory>)request.getAttribute("list");
		Iterator<Laboratory> iter = lablist.iterator();
		if (iter.hasNext()){
			lab = iter.next();
	%>

	<form action="../DoUpdateLabServlet_2?id=<%=lab.getLab_id()%>" method="post">
		<table>
			<h4><%=lab.getLab_name()%>&nbsp;&nbsp;修改信息</h4>
			<tr>
				<td>实验室名：</td>
				<td><input type="text" name="lab_name" value="<%=lab.getLab_name()%>"></td>
			</tr>
			<tr>
				<td>实验室地点：</td>
				<td><input type="text" name="lab_address" value="<%=lab.getLab_address()%>"/></td>
			</tr>
			<tr>
				<td>实验室可容纳人数：</td>
				<td><input type="text" name="lab_count" value="<%=lab.getLab_count()%>"/></td>
			</tr>
			<tr>
				<td>实验室开放日期：</td>
				<td><input type="text" name="lab_date" value="<%=lab.getLab_date()%>"/></td>
			</tr>
			<tr>
				<td>实验室开放时段：</td>
				<td style="text-align: left">
					<select name="lab_tab" id="">
						<option value="" style="width: 250px;height: 40px"><%=lab.getLab_tab()%></option>
						<option value="1" style="width: 250px;height: 40px">8:00-9:40</option>
						<option value="2" style="width: 250px;height: 40px">10:10-11:50</option>
						<option value="3" style="width: 250px;height: 40px">14:30-16:10</option>
						<option value="4" style="width: 250px;height: 40px">16:40-18:20</option>
						<option value="5" style="width: 250px;height: 40px">19:30-21:10</option>
					</select>
				</td>
			</tr>
			<tr>
			<tr>
				<td></td>
				<td>    <input type="submit" value="提交"/>	</td>
				<td>    <input type="reset" value="取消"/>	</td>
			</tr>
		</table>


	</form>
	<%
		}
	%>
</div>

<%--尾部--%>
<div align="center" name="Head">
	<jsp:include page="Bottom.jsp"/>
</div>





</body>
</html>
