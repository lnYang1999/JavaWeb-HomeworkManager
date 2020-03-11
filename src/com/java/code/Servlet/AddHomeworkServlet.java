package com.java.code.Servlet;

import com.java.code.Jdbc.StudentHomeworkJdbc;
import com.java.code.Model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addHomework")
public class AddHomeworkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");//设置编码，以防表单提交的内容乱码

        Homework homework = new Homework();

        homework.sethwId(Long.parseLong(req.getParameter("hw_id")));
        homework.sethwTitle(req.getParameter("hw_title"));
        homework.sethwContent(req.getParameter("hw_content"));
        Date date = new Date();
        homework.sethwCreateTime(date);

        boolean result = StudentHomeworkJdbc.addHomework(homework);

        req.setAttribute("isOK", result);    //用来判断是否添加作业成功
        req.setAttribute("type","addHomework");
        req.getRequestDispatcher("result.jsp").forward(req,resp);
    }
}
