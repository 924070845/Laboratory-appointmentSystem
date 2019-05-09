package com.servlet;

import com.dao.DoLogin;
import com.user.Administrator;
import com.user.Student;
import com.user.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DoLoginServlet", urlPatterns = "/DoLoginServlet")
public class DoLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");//这一句对字节流无效
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        //将登录时获取的权限信息对应到相应人群的表，再考虑检查
        String t = request.getParameter("type");

        if (t.equals("student")){


            Student student = new Student();
            student.setStu_name    (request.getParameter("username"));
            student.setStu_password(request.getParameter("password"));


            DoLogin user_login = new DoLogin();
            int rs = user_login.Dologin_stu(student);
            if (rs!=0){
                HttpSession session = request.getSession();
                session.setAttribute("session",student.getStu_name());
                session.setAttribute("type","student");
                response.sendRedirect("/RegisterHome.jsp");
            }else{
                response.sendRedirect("/success_or_error/DoLoginFALSE.jsp");

            }

        }


        //教师登录
        if (t.equals("teacher")){

            Teacher teacher = new Teacher();
            teacher.setTeacher_name    (request.getParameter("username"));
            teacher.setTeacher_password(request.getParameter("password"));


            DoLogin user_login = new DoLogin();
            int rs = user_login.Dologin_teacher(teacher);
            if (rs!=0){
                HttpSession session = request.getSession();
                session.setAttribute("session",teacher.getTeacher_name());
                session.setAttribute("type","teacher");
                response.sendRedirect("/RegisterHome.jsp");
            }else{
                response.sendRedirect("/success_or_error/DoLoginFALSE.jsp");

            }
        }

        //管理员登录
        if (t.equals("administrator")){

            Administrator adm = new Administrator();
            adm.setAdm_name(request.getParameter("username"));
            adm.setAdm_password(request.getParameter("password"));

            DoLogin user_login = new DoLogin();
            int rs = user_login.Dologin_adm(adm);
            if (rs!=0){
                HttpSession session = request.getSession();
                session.setAttribute("session",adm.getAdm_name());
                session.setAttribute("type","administrator");
                response.sendRedirect("/AdmInsertLabM.jsp");
            }else{
                response.sendRedirect("/success_or_error/DoLoginFALSE.jsp");

            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
