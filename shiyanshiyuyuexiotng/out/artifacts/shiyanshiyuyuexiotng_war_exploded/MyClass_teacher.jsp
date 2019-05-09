<%@ page import="java.util.List" %>
<%@ page import="com.user.Information" %>
<%@ page import="com.user.Laboratory" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/6/29
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的课程</title>
    <link rel="stylesheet" href="/css/Home.css">
    <script type="text/javascript" src="/js/HomePageJs.js"></script>
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

        if (session.getAttribute("session")==null || type!=("teacher")){
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
        <div align="center">
            <h4 align="center"><b>我的课程</b></h4>
            <table  align="center" width="800px" class="table3" >

                <tr>
                    <hr width="800" style="color: #27A9E3">
                    <%--这部分是不动的，表头--%>
                    <th class="table3" align="center">课程名</th>
                    <th class="table3" align="center">实验室名称</th>
                    <th class="table3" align="center">地址</th>
                    <th class="table3" align="center">日期</th>

                </tr>

                <%
                    List<Information> list= (List<Information>) request.getAttribute("search");
                    Iterator<Information> iter = list.iterator();

                    while (iter.hasNext()){
                        //再讲迭代器中的值取出来
                        Information lab = iter.next();
                %>
                <tr>
                    <td class="table3" align="center"><%=lab.getCourse_name()%></td>
                    <td class="table3" align="center"><%=lab.getLab_name()%></td>
                    <td class="table3" align="center"><%=lab.getLab_address()%></td>
                    <td class="table3" align="center"><%=lab.getLab_date()%></td>
                </tr>

                <%
                    }
                %>

            </table>

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