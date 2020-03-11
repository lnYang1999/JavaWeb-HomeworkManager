<%@ page import="com.java.code.Model.StudentHomework" %>
<%@ page import="com.java.code.Jdbc.StudentHomeworkJdbc" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: litterboy
  Date: 2020/3/8
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%--作业详情--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业管理系统-查看学生作业详细信息</title>
</head>
<body>
<h2 style="text-align: center; color: #2418DA; font-family: '仿宋';">作业详细内容</h2>
<table align="center" style="line-height: 40px; font-family: '华文楷体'; border: 2px solid #1927F5;">

    <tr bgcolor="aqua">
        <th width="10%">学号</th>
        <th width="10%">作业编号</th>
        <th width="20%">作业标题</th>
        <th width="40%">学生提交内容</th>
        <th width="20%">创建时间</th>
    </tr>
    <%
        List<StudentHomework> list = (List<StudentHomework>)request.getAttribute("list");

        if (list == null || list.size() <= 0){
            out.print("None data");
        }else {
            for (StudentHomework sh : list) {
    %>
    <tr>
        <td width="10%"><%=sh.getstId()%></td>
        <td width="10%"><%=sh.gethwId()%></td>
        <td width="20%" style="word-break: break-all;word-wrap: break-word"><%=sh.gethwTitle()%></td>
        <td width="40%" style="word-break: break-all;word-wrap: break-word"><%=sh.getsubmitContent()%></td>
        <td width="20%"><%=sh.getsthwCreateTime()%></td>
    </tr>
    <%
            }
        }
    %>

</table>

<h2 style="font-family: '华文宋体'; text-align: center; color: #112CEB;"><a href="jsp/Teacher.jsp">返回老师操作界面</a></h2>
</body>
</html>
