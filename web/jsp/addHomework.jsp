<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/3/9
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%--添加作业页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业管理系统-添加作业</title>
</head>
<body>
<div align="center">
    <h2 style="font-family: '仿宋'; color: #1509CA; text-align: center;">新作业</h2>
    <form action="${pageContext.request.contextPath}/addHomework" method="post">
        <table align="center" style="line-height: 40px; font-family: '华文楷体';">
            <tr>
                <td nowrap="nowrap">作业ID：</td>
                <td><input name="hw_id" type="text" required="required" value="${param.hw_id}" size="40" maxlength="20"></td>
            </tr>
            <tr>
                <td nowrap="nowrap">作业标题：</td>
                <td><input name="hw_title" type="text" required="required" value="${param.hw_title}" size="40" maxlength="20"></td>
            </tr>
            <tr>
                <td nowrap="nowrap">作业内容：</td>
                <td><textarea name="hw_content" cols="40" rows="10" required="required" value="${param.hw_content}"></textarea></td>
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
