package com.servlet;

import com.dao.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DoAppointmentStudentServlet", urlPatterns = "/DoAppointmentStudentServlet")
public class DoAppointmentStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");



        try{
            Dao teacher = new Dao();

//            String teacher_id = request.getParameter("teacher_id");
//            String course_name = request.getParameter("course_name");

            String teacher_id = request.getParameter("teacher_id");
            String student_id = request.getParameter("student_id");
            String course_tab = request.getParameter("lab_tab");




            //执行将信息表中的课程名插入到教师课表中
            teacher.InsertCourseToStudent(teacher_id,student_id,course_tab);

            request.getRequestDispatcher("/success_or_error/Appointment_success.jsp").forward(request,response);

        }catch (Exception e){
            e.printStackTrace();
        }







    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
