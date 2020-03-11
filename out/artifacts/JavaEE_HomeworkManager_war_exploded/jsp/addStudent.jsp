<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/3/9
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%--添加学生页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业管理系统-添加学生</title>
</head>
<body>
<div align="center">
    <h2 style="font-family: '仿宋'; color: #1509CA; text-align: center;">新学生</h2>
    <form action="${pageContext.request.contextPath}/addStudent" method="post">
        <table align="center" style="line-height: 40px; font-family: '华文楷体';">
            <tr>
                <td>学号：</td>
                <td><input type="number" name="st_id" maxlength="20" size="40" value="${param.st_id}"></td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="st_name" maxlength="20" size="40" value="${param.st_name}"></td>
            </tr>
            <tr align="center">
                <th><input type="reset" value="清空"></th>
                <td><input type="submit" value="提交"> </td>
            </tr>
        </table>
    </form>
</div>
<h2 style="font-family: '华文宋体'; text-align: center; color: #112CEB;"><a href="Teacher.jsp">返回老师操作界面</a></h2>
</body>
</html>
