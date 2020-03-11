package com.java.code.Servlet;

import com.java.code.Jdbc.StudentHomeworkJdbc;
import com.java.code.Model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//设置编码，以防表单提交的内容乱码

        Student student = new Student();
        student.setstId(Long.parseLong(req.getParameter("st_id")));
        student.setstName(req.getParameter("st_name"));
        Date date = new Date();
        student.setstCreateTime(date);

        boolean result = StudentHomeworkJdbc.addStudent(student);

        req.setAttribute("isOK", result);  //用来判断是否添加作业成功
        req.setAttribute("type","addStudent");
        req.getRequestDispatcher("result.jsp").forward(req,resp);
    }
}