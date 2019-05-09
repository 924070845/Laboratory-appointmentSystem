<%--
  Created by IntelliJ IDEA.
  User: 92407
  Date: 2018/6/23
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>管理员_录入实验室信息</title>
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
		Object type = session.getAttribute("type");

		if (session.getAttribute("session")==null || type!=("administrator")){
	%>
	<br>
	<h3 align="center">对不起，您没有权限登录该页面。请登录后操作，将在3秒后返回到主页...</h3>
	<br>
</div>
<%
	response.setHeader("refresh","3;URL=RegisterHome.jsp");
}else{

%>
<%--进入了session的控制范围--%>
<div class="container">
	<%--这是用户session的显示--%>
	<div class="user_xianshi">用户：<%=session.getAttribute("session")%> </div>
		<div align="center"  >
			<h4><b>管理员录入实验室信息</b></h4>
			<form action="/DoInsertLabServlet" method="post" name="labInsert">
				<table style="text-align: right">
					<tr>
						<td>实验室编号：</td>
						<td><input type="text" name="lab_id" placeholder="请输入实验室编号"/></td>
					</tr>
					<tr>
						<td>实验室名称：</td>
						<td><input type="text" name="lab_name" placeholder="请输入实验室名称"/></td>
					</tr>
					<tr>
						<td>实验室地点：</td>
						<td><input type="text" name="lab_address" placeholder="请输入实验室地点"/></td>
					</tr>
					<tr>
						<td>实验室可容纳人数：</td>
						<td><input type="text" name="lab_count" placeholder="请输入实验室可容纳人数"/></td>
					</tr>
					<tr>
						<td>实验室开放日期：</td>
						<td><input type="text" name="lab_date" placeholder="请输入实验室开放日期"/></td>
					</tr>
					<tr>
						<td>实验室开放时段：</td>
						<td style="text-align: left">
							<select name="lab_tab" id="">
								<option value="" style="width: 250px;height: 40px">请选择</option>
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
						<td style="text-align: right">
							<input type="submit" name="submit" value="确认"/>&nbsp;&nbsp;&nbsp;
						</td>
						<td style="text-align: left">
							<input type="reset" name="reset" value="取消"/>
						</td>
					</tr>



					</tr>

				</table>

			</form>


		</div>
		<div align="center">
			<a href="../DoSelectLabServlet">
				<h5 align="center" style="color: midnightblue">点击此处查询所有用户信息</h5>\
			</a>
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
