<%--
  Created by IntelliJ IDEA.
  User: 92407
  Date: 2018/6/23
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>管理员注册</title>
	<link rel="stylesheet" href="/css/Home.css">
	<script type="text/javascript" src="/js/HomePageJs.js"></script>
</head>
<body>
<%--头部--%>
<div align="center" name="Head">
	<jsp:include page="Head.jsp"/>
</div>

<div class="container">
	<div>

		<div align="center"  >
			<h4><b>管理员自主注册</b></h4>
			<form action="/DoInsertAdmServlet" method="post" name="admInsert">
				<table style="text-align: right" class="table2" >
					<tr>
						<td>姓名：</td>
						<td><input type="text"     name="adm_name" placeholder="请输入姓名"/></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="adm_password" placeholder="请输入密码"/></td>
					</tr>
					<tr>
						<td>重复密码：</td>
						<td><input type="password"  name="dam_password2" placeholder="请再次输入密码"/></td>
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
