<%@ page import="com.java.code.Model.Homework" %>
<%@ page import="com.java.code.Jdbc.StudentHomeworkJdbc" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/3/9
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%--查看我的作业--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业管理系统-查看我的作业</title>
    <script>
        function show(hw_id) {
            let homework = document.getElementById('homeworkId')
            homework.setAttribute("value",hw_id)
            let sub = document.getElementById('sub')
            sub.submit()
        }
    </script>
</head>
<body>
<h2 style="text-align: center; color: #2418DA; font-family: '仿宋';">我的作业</h2>
<form id="sub" method="get" action="${pageContext.request.contextPath}/submit">
    <input id="homeworkId" name="hw_id" type="hidden">
    <table align="center" width="960" border="1" style="line-height: 40px; font-family: '华文楷体';">
        <tr>
            <th>作业号</th>
            <th>作业标题</th>
            <th>作业内容</th>
            <th></th>
        </tr>
        <%
            List<Homework> list = StudentHomeworkJdbc.showHomework();
            if (list == null || list.size() <= 0){
                out.print("None data");
            }else {
                for (Homework homework : list) {
        %>
        <tr>
            <td><%=homework.gethwId()%></td>
            <td><%=homework.gethwTitle()%></td>
            <td><%=homework.gethwContent()%></td>
            <td><input type="button" value="提交作业" onclick="show(<%=homework.gethwId()%>)"> </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</form>
<h2 style="font-family: '华文宋体'; text-align: center; color: #112CEB;"><a href="Student.jsp">返回学生操作界面</a></h2>
</body>
</html>
