package com.servlet;

import com.dao.Dao;
import com.user.Information;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DoSelectMyClass_teacherServlet", urlPatterns = "/DoSelectMyClass_teacherServlet")
public class DoSelectMyClass_teacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao myclass_teacherdao = new Dao();
        List<Information> list = new ArrayList<Information>();

        HttpSession session = request.getSession();
        String teacher_name = (String) session.getAttribute("session");

        list =  myclass_teacherdao.SelectMyClass_teacher(teacher_name);
        request.setAttribute("search",list);
        request.getRequestDispatcher("/MyClass_teacher.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
