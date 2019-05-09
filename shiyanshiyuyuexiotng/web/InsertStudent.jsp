<%--
  Created by IntelliJ IDEA.
  User: 92407
  Date: 2018/6/23
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>学生注册</title>
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
			<h4><b>学生自主注册</b></h4>
			<form action="/DoInsertStuServlet" method="post" name="labInsert">
				<table style="text-align: right" class="table2">
					<tr>
						<td>学号：</td>
						<td><input type="text" name="stu_id" placeholder="请输入学号"/></td>
					</tr>
					<tr>
						<td>姓名：</td>
						<td><input type="text" name="stu_name" placeholder="请输入姓名"/></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="stu_password" placeholder="请输入密码"/></td>
					</tr>
					<tr>
						<td>重复密码：</td>
						<td><input type="password" name="stu_password2" placeholder="请再次输入密码"/></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td style="text-align: left"><input type="radio" name="stu_sex" value="男" />男&nbsp;
							<input type="radio" name="stu_sex" value="女" />女</td>
					</tr>
					<tr>
						<td>专业：</td>
						<td><input type="text" name="stu_dept" placeholder="请输入所在专业"/></td>
					</tr>
					<tr>
						<td>班级：</td>
						<td><input type="text" name="stu_class" placeholder="请输入所在班级"/></td>
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
