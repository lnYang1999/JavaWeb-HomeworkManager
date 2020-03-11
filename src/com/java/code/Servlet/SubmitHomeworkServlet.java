package com.java.code.Servlet;

import com.java.code.Jdbc.StudentHomeworkJdbc;
import com.java.code.Model.Homework;
import com.java.code.Model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet("/submit")
public class SubmitHomeworkServlet extends HttpServlet {
    /**
     * get请求用来展示作业详细信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hw_id = req.getParameter("hw_id");
        //读取指定id的作业内容详细信息
        Homework homework = StudentHomeworkJdbc.showHomeworkDetails(hw_id);//访问数据库
        req.setAttribute("homework",homework);
        req.getRequestDispatcher("jsp/submitHomework.jsp").forward(req,resp); //展示内容
    }


    /**
     *post请求用来提交作业，记录到数据库中
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");//设置编码，以防表单提交的内容乱码

        StudentHomework studentHomework = new StudentHomework();

        studentHomework.setstId(Long.parseLong(req.getParameter("st_id")));
        studentHomework.sethwId(Long.parseLong(req.getParameter("hw_id")));
        studentHomework.sethwTitle(req.getParameter("hw_title"));
        studentHomework.sethwContent(req.getParameter("hw_content"));
        studentHomework.setsubmitContent(req.getParameter("submit_content"));
        Date date = new Date();
        studentHomework.setsthwCreateTime(date);

        boolean result = StudentHomeworkJdbc.addStudentHomework(studentHomework);

        req.setAttribute("isOK", result);   //用于判断是否提交成功
        req.setAttribute("type","addStudentHomework");
        req.getRequestDispatcher("result.jsp").forward(req,resp);
    }
}
