package com.servlet;

import com.dao.Dao;
import com.user.Information;
import com.user.Laboratory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DoAppointmentTeacherServlet", urlPatterns = "/DoAppointmentTeacherServlet")
public class DoAppointmentTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");



        try{
            Dao lab = new Dao();

            String teacher_id = request.getParameter("teacher_id");
            String lab_id = request.getParameter("lab_name");
            //执行将信息表中的课程名插入到教师课表中
            lab.InsertCourseToTeacher(lab_id,teacher_id);

            request.getRequestDispatcher("/success_or_error/Appointment_success.jsp").forward(request,response);

        }catch (Exception e){
            e.printStackTrace();
        }







    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
