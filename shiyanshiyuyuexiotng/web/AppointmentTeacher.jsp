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
		if (session.getAttribute("session")==null || type!="teacher"){

	%>
	<br>
	<h3 align="center">对不起，您没有权限登录该页面,请登录后操作。将在3秒后返回到主页...</h3>
	<br>
</div>
<%
	response.setHeader("refresh","3;URL=RegisterHome.jsp");
}else {

%>
<%--进入了session的控制范围--%>
<div class="container">
	<%--这是用户session的显示--%>
	<div class="user_xianshi">用户：<%=session.getAttribute("session")%> </div>
		<div class="container">

			<div align="center"  >
				<h4><b>教师预约</b></h4>
				<div align="center" style="color: gray">*提示：下面选择要去的实验室，每个实验室都有固定的开放时间，全天5个时间段由学生选择，详情请查看我的预约*</div>

				<form action="/DoAppointmentTeacherServlet" method="post" name="Insert">
					<table style="text-align: right" class="table2" >
						<tr>
							<td>实验室名：</td>
							<td>
								<select name="lab_name" >
									<%Dao dao = new Dao();
										List<Laboratory> list =dao.selectLabName();
										for (Laboratory lab:list){
									%>
									<option style="width: 220px" value="<%=lab.getLab_id()%>"><%=lab.getLab_name()%></option>
									<%}%>
								</select>
							</td>
						</tr>
						<tr>
							<td>教师号：</td>
							<td>
								<input type="text" name="teacher_id" placeholder="请输入您的教师号"/>
							</td>
						</tr>
						<tr>
						<tr>
							<td style="text-align: right">
								<input type="submit" name="submit" value="预约"/>&nbsp;&nbsp;&nbsp;
							</td>
							<td style="text-align: left">
								<input type="reset" name="reset" value="取消"/>
							</td>
						</tr>



						</tr>

					</table>

				</form>


			</div>


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
