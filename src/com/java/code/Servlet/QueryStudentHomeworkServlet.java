package com.java.code.Servlet;

import com.java.code.Jdbc.StudentHomeworkJdbc;
import com.java.code.Model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/queryStudentHomework")
public class QueryStudentHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hw_id = req.getParameter("hw_id");
        //从数据库读取指定作业id的所有记录
        List<StudentHomework> list = StudentHomeworkJdbc.selectAll(hw_id);//访问数据库
        req.setAttribute("list",list);
        req.getRequestDispatcher("jsp/homeworkDetail.jsp").forward(req,resp); //展示数据
    }
}
