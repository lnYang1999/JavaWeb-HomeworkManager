<%@ page import="com.java.code.Model.Homework" %>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/3/9
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%--提交我的作业--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业管理系统-提交作业</title>
</head>
<body>
<h2 style="text-align: center; color: #2418DA; font-family: '仿宋';">提交作业</h2>
<div align="center">
    <form method="post" action="${pageContext.request.contextPath}/submit">

        <table align="center" style="line-height: 40px; font-family: '华文楷体'; border: 2px solid #1927F5;">

            <%
                Homework hw = (Homework) request.getAttribute("homework");
            %>
            <tr>
                <th width="30%">作业标题:</th>
                <td width="70%"><%=hw.gethwTitle()%></td>
            </tr>
            <tr>
                <th width="30%">作业内容:</th>
                <td width="70%"><%=hw.gethwContent()%></td>
            </tr>

            <tr>
                <th width="30%">学号：</th>
                <td><input type="text" name="st_id" maxlength="20" size="40" value="${param.st_id}"></td>
            </tr>
            <input type="hidden" name="hw_id" value="<%=hw.gethwId()%>">
            <input type="hidden" name="hw_title" value="<%=hw.gethwTitle()%>">
            <input type="hidden" name="hw_content" value="<%=hw.gethwContent()%>">
            <tr>
                <th width="30%">提交内容：</th>
                <td width="70%"><textarea name="submit_content" cols="40" rows="10" value="${param.submit_content}"></textarea></td>
            </tr>
            <tr style="border: none">
                <td align="center"><input type="reset" value="清空"></td>
                <td align="center"><input type="submit" value="提交"></td>
            </tr>
        </table>

    </form>
</div>
<h2 style="font-family: '华文宋体'; text-align: center; color: #112CEB;"><a href="jsp/Student.jsp">返回学生操作界面</a></h2>
</body>
</html>
