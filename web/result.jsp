<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/3/9
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%--显示添加作业、学生、提交作业结果--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>操作结果</title>
</head>
<body>
<%
    String type = (String)request.getAttribute("type");
    boolean isOK = (boolean)request.getAttribute("isOK");
    if (type.equals("addHomework")){

        if (isOK){
%>

<p style="margin: 50px; font-family: '华文宋体'; font-size: 50px; color: darkorange; text-align: center;"><%="添加作业成功!"%></p>

<%
}else{
%>

<p style="margin: 50px; font-family: '华文宋体'; font-size: 50px; color: darkorange; text-align: center;"><%="添加作业失败!!!"%></p>

<%
    }
}else if (type.equals("addStudent")){
    if (isOK){
%>

<p style="margin: 50px; font-family: '华文宋体'; font-size: 50px; color: darkorange; text-align: center;"><%="添加学生成功!"%></p>

<%
}else{
%>

<p style="margin: 50px; font-family: '华文宋体'; font-size: 50px; color: darkorange; text-align: center;"><%="已有学生信息!无法添加!"%></p>

<%
    }
}else if (type.equals("addStudentHomework")){
    if (isOK){
%>

<p style="margin: 50px; font-family: '华文宋体'; font-size: 50px; color: darkorange; text-align: center;"><%="作业提交成功!"%></p>

<%
}else {
%>

<p style="margin: 50px; font-family: '华文宋体'; font-size: 50px; color: darkorange; text-align: center;"><%="作业提交失败!"%></p>

<%
        }
    }
%>
<h2 style="font-family: '华文宋体'; text-align: center; color: #112CEB;"><a href="index.jsp">返回首页</a></h2>
</body>
</html>