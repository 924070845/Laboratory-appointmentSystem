package com.servlet;

import com.dao.Dao;
import com.user.Student;
import com.user.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DoInsertTeacherServlet", urlPatterns = "/DoInsertTeacherServlet")
public class DoInsertTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //输出流
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");//这一句对字节流无效
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Teacher teacher = new Teacher();

        Dao teacherinsert = new Dao();

        //为user对象初始化值，不然则没有值可插入
        teacher.setTeacher_id      (request.getParameter("teacher_id"));
        teacher.setTeacher_name    (request.getParameter("teacher_name"));
        teacher.setTeacher_password(request.getParameter("teacher_password"));
        teacher.setTeacher_sex     (request.getParameter("teacher_sex"));
        teacher.setTeacher_dept    (request.getParameter("teacher_dept"));
        teacher.setTeacher_class   (request.getParameter("teacher_class"));
        teacher.setTeacher_tel     (request.getParameter("teacher_tel"));


        int rs = teacherinsert.InsertTeacher(teacher);
        if(rs!=0){
            request.getRequestDispatcher("/success_or_error/Insert_success.jsp?username="+teacher.getTeacher_name()).forward(request, response);
        }else {
            request.getRequestDispatcher("/success_or_error/Insert_error.jsp?").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
