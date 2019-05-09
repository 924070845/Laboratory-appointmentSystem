<%--
  Created by IntelliJ IDEA.
  User: 92407
  Date: 2018/6/23
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>教师录入</title>
	<link rel="stylesheet" href="/css/Home.css">
	<script type="text/javascript" src="/js/HomePageJs.js"></script>
</head>
<body>



<%--头部--%>
<div align="center" name="Head">
	<jsp:include page="Head.jsp"/>
</div>

<div class="container">
	<div >

		<div align="center" >
			<h4><b>教师自主注册</b></h4>
			<form action="/DoInsertTeacherServlet" method="post" name="teacherInsert">
				<table style="text-align: right" class="table2">
					<tr>
						<td>教师号：</td>
						<td><input type="text" name="teacher_id" placeholder="请输入学号"/></td>
					</tr>
					<tr>
						<td>姓名：</td>
						<td><input type="text"     name="teacher_name" placeholder="请输入姓名"/></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="teacher_password" placeholder="请输入密码"/></td>
					</tr>
					<tr>
						<td>重复密码：</td>
						<td><input type="password"  name="teacher_password2" placeholder="请再次输入密码"/></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td style="text-align: left">
							<input type="radio" name="teacher_sex" value="男" />男&nbsp;
							<input type="radio" name="teacher_sex" value="女" />女
						</td>
					</tr>
					<tr>
						<td>所在院系：</td>
						<td><input type="text" name="teacher_dept" placeholder="请输入所在院系"/></td>
					</tr>
					<tr>
						<td>所带班级：</td>
						<td><input type="text" name="teacher_class" placeholder="请输入所带班级"/></td>
					</tr>
					<tr>
						<td>手机号码：</td>
						<td><input type="text" name="teacher_tel" placeholder="请输入手机号码"/></td>
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

	</div>

</div>

<%--尾部--%>
<div align="center" name="Head">
	<jsp:include page="Bottom.jsp"/>
</div>


</body>
</html>
