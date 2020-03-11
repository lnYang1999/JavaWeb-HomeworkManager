package com.java.code.Servlet;

import com.java.code.Jdbc.StudentHomeworkJdbc;
import com.java.code.Model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showHomework")
public class ShowHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从数据库读取所有作业记录
        List<Homework> list = StudentHomeworkJdbc.showHomework();

        req.setAttribute("list",list);

        req.getRequestDispatcher("jsp/queryStudentHomework.jsp").forward(req,resp);
    }
}
