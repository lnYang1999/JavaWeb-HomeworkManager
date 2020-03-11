package com.java.code.Jdbc;

import com.java.code.Model.Homework;
import com.java.code.Model.Student;
import com.java.code.Model.StudentHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkJdbc {

    public static void main(String[] args) {
        String a ="1";
        List<StudentHomework> list = selectAll(a);
        for (StudentHomework sthw : list){
            System.out.println(sthw.gethwId());
        }
        Homework hw = showHomeworkDetails(a);
        System.out.println(hw.gethwTitle());
    }

    private static String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=Asia/Shanghai";

    private static String driverName = "com.mysql.cj.jdbc.Driver";


    /**
     * 从student_homework表读取指定作业id 的所有记录，即某次作业的所有提交记录
     * @return 返回结果list
     */
    public static List<StudentHomework> selectAll(String hw_id) {

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "SELECT * FROM student_homework where hw_id="+hw_id;

        List<StudentHomework> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, "root", "12345ysp")) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    //获取执行结果
                    while (resultSet.next()) {
                        StudentHomework sh = new StudentHomework();
                        sh.setsthwId(resultSet.getLong("st_hw_id"));
                        sh.setstId(resultSet.getLong("st_id"));
                        sh.sethwId(resultSet.getLong("hw_id"));
                        sh.sethwTitle(resultSet.getString("hw_title"));
                        sh.sethwContent(resultSet.getString("hw_content"));
                        sh.setsubmitContent(resultSet.getString("submit_content"));
                        sh.setsthwCreateTime(resultSet.getTimestamp("st_hw_create_time"));
                        list.add(sh);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 向homework表添加作业记录
     * @param homework  将要添加的homework
     * @return true=>成功否则失败
     */
    public static boolean addHomework(Homework homework){

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "insert into homework (hw_id,hw_title,hw_content,hw_create_time) values(?,?,?,?)";

        int resultSet = 0;
        try (Connection connection = DriverManager.getConnection(url, "root", "12345ysp")) {
            try (PreparedStatement ps = connection.prepareStatement(sqlString)) {
                ps.setLong(1,homework.gethwId());
                ps.setString(2,homework.gethwTitle());
                ps.setString(3,homework.gethwContent());
                ps.setTimestamp(4,new Timestamp(homework.gethwCreateTime().getTime()));
                resultSet = ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet > 0;
    }

    /**
     * 向student表添加学生
     * @param student 将要添加的student
     * @return true成功否则失败
     */
    public static boolean addStudent(Student student){

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "insert into student (st_id,st_name,st_create_time) values(?,?,?)";

        int resultSet = 0;
        try (Connection connection = DriverManager.getConnection(url, "root", "12345ysp")) {
            try (PreparedStatement ps = connection.prepareStatement(sqlString)) {
                ps.setLong(1,student.getstId());
                ps.setString(2,student.getstName());
                ps.setTimestamp(3,new Timestamp(student.getstCreateTime().getTime()));
                resultSet = ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet > 0;
    }

    /**
     *从homework表读取所有作业记录
     * @return  结果list
     */
    public static List<Homework> showHomework(){

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "SELECT * FROM homework";

        List<Homework> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, "root", "12345ysp")) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    //获取执行结果
                    while (resultSet.next()) {
                        Homework homework = new Homework();
                        homework.sethwId(resultSet.getLong("hw_id"));
                        homework.sethwTitle(resultSet.getString("hw_title"));
                        homework.sethwContent(resultSet.getString("hw_content"));
                        list.add(homework);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    /**
     * 从homework表读取指定id的作业详细内容
     * @param hw_id 作业id
     * @return 作业对象homework
     */
    public static Homework showHomeworkDetails(String hw_id){

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "SELECT * FROM homework WHERE hw_id=" + hw_id;

        Homework homework = new Homework();
        try (Connection connection = DriverManager.getConnection(url, "root", "12345ysp")) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    //获取执行结果
                    while (resultSet.next()) {
                        homework.sethwId(resultSet.getLong("hw_id"));
                        homework.sethwTitle(resultSet.getString("hw_title"));
                        homework.sethwContent(resultSet.getString("hw_content"));
                        homework.sethwCreateTime(resultSet.getTimestamp("hw_create_time"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return homework;
    }

    /**
     * 向student_homework表提交作业
     * @param studentHomework 作业
     * @return true成功否则失败
     */
    public static boolean addStudentHomework(StudentHomework studentHomework){

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "insert into student_homework (st_id,hw_id," +
                "hw_title,hw_content,submit_content,st_hw_create_time) values(?,?,?,?,?,?)";

        int resultSet = 0;

        try (Connection connection = DriverManager.getConnection(url, "root", "12345ysp")) {
            try (PreparedStatement ps = connection.prepareStatement(sqlString)) {
                ps.setLong(1,studentHomework.getstId());
                ps.setLong(2,studentHomework.gethwId());
                ps.setString(3,studentHomework.gethwTitle());
                ps.setString(4,studentHomework.gethwContent());
                ps.setString(5,studentHomework.getsubmitContent());
                ps.setTimestamp(6,new Timestamp(studentHomework.getsthwCreateTime().getTime()));
                resultSet = ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet > 0;
    }

}
