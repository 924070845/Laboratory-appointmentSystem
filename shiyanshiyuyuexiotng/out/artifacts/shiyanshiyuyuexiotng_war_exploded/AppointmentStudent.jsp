<%@ page import="com.dao.Dao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.user.Teacher" %><%--
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

	if (session.getAttribute("session")==null || type!=("student")){
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
		<h4><b>学生预约</b></h4>
		<div align="center" style="color: gray">*提示：下面选择指导老师，指导老师以预约号实验，按要求填写信息，预约详情请查看我的课表*</div>

		<form action="/DoAppointmentStudentServlet" method="post" >
			<table style="text-align: right" class="table2" >
				<tr>
					<td>选择指导老师：</td>
					<td>
						<select name="teacher_id" >
							<%Dao dao = new Dao();
								//查找教师名字+教师以预约的实验课名函数
								List<Teacher> list = dao.selectTeacherClass();
								for (Teacher teacher:list){
							%>
							<option style="width: 220px" value="<%=teacher.getTeacher_id()%>">
								<%=teacher.getTeacher_name()%>
								<%="+"%>
								<%=teacher.getCourse_name()%>
							</option>
							<%}%>
						</select>
					</td>
				</tr>
				<tr>
					<td>学号：</td>
					<td>
						<input type="text" name="student_id" placeholder="请输入您的学号"/>
					</td>
				</tr>

				<tr>
					<td>预约时段：</td>
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
