<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="Pragma" content="no-cache">
  <meta http-equiv="Cache-Control" content="no-cache">
  <meta http-equiv="Expires" content="0">
  <title>登录</title>
  <link href="css/login.css" type="text/css" rel="stylesheet">
</head>
<body>

<div class="login">
  <div class="message">中北大学实验室预约系统登录</div>
  <div id="darkbannerwrap"></div>

  <form action="/DoLoginServlet" method="post" name="Login" >
    <input name="action" value="login" type="hidden">
    <input name="username" placeholder="用户名" required="" type="text">
    <hr class="hr15">
    <input name="password" placeholder="密码" required="" type="password">
    <hr class="hr15">
    <select name="type" id="type">
      <option value="">请选择身份</option>
      <option value="student">学生</option>
      <option value="teacher">教师</option>
      <option value="administrator">管理员</option>
    </select>
    <hr class="hr15">
    <input value="登录" style="width:100%;" type="submit">
    <div align="right">
      <a href="RegisterHome.jsp" style="border-bottom: none; color: #27A9E3;"  >注册</a>
    </div>
    <hr class="hr20">
    <!-- 帮助 <a onClick="alert('请联系管理员')">忘记密码</a> -->
  </form>


</div>


</body>
</html>