<%--
  Created by IntelliJ IDEA.
  User: 92407
  Date: 2018/6/24
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>条件查询</title>
</head>
<body>
<%--头部--%>
<div align="center" name="Head">
	<jsp:include page="Head.jsp"/>
</div>

<div class="container">
	<div align="center"  >
		<h4><b>按条件查询预约信息</b></h4>
		<form action="/DoConditionSelectServlet" method="post" name="">
			<table style="text-align: right">
				<tr>
					<td style="text-align: left">
						<select name="condition_select" id="" style="width: 230px;height: 20px">
							<option value=""  style="width: 250px;height: 40px">请选择   </option>
							<option value="1" style="width: 250px;height: 40px">教师编号</option>
							<option value="2" style="width: 250px;height: 40px">学生编号</option>
							<option value="3" style="width: 250px;height: 40px">时间    </option>
							<option value="4" style="width: 250px;height: 40px">实验室编号</option>
						</select>
						&nbsp;&nbsp;&nbsp;
						<input type="text" placeholder="请输入查询值" name="value1">
						&nbsp;&nbsp;&nbsp;
						<input type="submit" name="submit"  value="查询"/>&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</div>

</div>

<%--尾部--%>
<div align="center" name="Head">
	<jsp:include page="Bottom.jsp"/>
</div>



</body>
</html>
