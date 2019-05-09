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
    <title>预约教室</title>
    <link rel="stylesheet" href="/css/Home.css">
    <script type="text/javascript" src="/js/HomePageJs.js"></script>
</head>
<body>

<%--头部--%>
<div align="center" name="Head">
    <jsp:include page="Head.jsp"/>
</div>

<div class="container">
    <table  align="center" width="800px" class="table3" >

        <tr>
            <hr width="800" style="color: #27A9E3">
            <%--这部分是不动的，表头--%>
            <th class="table3" align="center">实验室编号</th>
            <th class="table3" align="center">实验室名称</th>
            <th class="table3" align="center">地址</th>
            <th class="table3" align="center">日期</th>
            <th class="table3" align="center">时段</th>
        </tr>

        <%
            List<Information> list= (List<Information>) request.getAttribute("search");
            Iterator<Information> iter = list.iterator();

            while (iter.hasNext()){
                //再讲迭代器中的值取出来
                Information lab = iter.next();
        %>
        <tr>
            <td class="table3" align="center"><%=lab.getLab_id()%></td>
            <td class="table3" align="center"><%=lab.getLab_name()%></td>
            <td class="table3" align="center"><%=lab.getLab_address()%></td>
            <td class="table3" align="center"><%=lab.getLab_date()%></td>
            <td class="table3" align="center"><%=lab.getLab_tab()%></td>
        </tr>

        <%
            }
        %>

    </table>

</div>

<%--尾部--%>
<div align="center" name="Head">
    <jsp:include page="Bottom.jsp"/>
</div>






</body>
</html>