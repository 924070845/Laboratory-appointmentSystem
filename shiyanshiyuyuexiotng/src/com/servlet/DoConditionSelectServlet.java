package com.servlet;

import com.dao.Dao;

import com.user.Information;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DoConditionSelectServlet", urlPatterns = "/DoConditionSelectServlet")
public class DoConditionSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String type =  request.getParameter("condition_select");
        String value = request.getParameter("value1");

        if (type.equals("1")){
            Dao dao=new Dao();
            List<Information> list=dao.SelectLab_teacher_id(value);
            System.out.println(1);
            if (list!=null){
                request.setAttribute("search",list);
                request.getRequestDispatcher("/doSearchStyle.jsp").forward(request,response);

            }
            else {
                response.getWriter().write("用户信息不存在");
                request.getRequestDispatcher("/SearchStyle.jsp").forward(request,response);

            }

        }
        if (type.equals("2")){
            Dao dao=new Dao();
            List<Information> list=dao.SelectLab_student_id(value);
            System.out.println(2);
            if (list!=null){
                request.setAttribute("search",list);
                request.getRequestDispatcher("/doSearchStyle.jsp").forward(request,response);

            }
            else {
                response.getWriter().write("用户信息不存在");
                request.getRequestDispatcher("/SearchStyle.jsp").forward(request,response);

            }

        }
        if (type.equals("3")){
            Dao dao=new Dao();
            List<Information> list=dao.SelectLab_date_id(value);
            System.out.println(3);
            if (list!=null){
                request.setAttribute("search",list);
                request.getRequestDispatcher("/doSearchStyle.jsp").forward(request,response);

            }
            else {
                response.getWriter().write("用户信息不存在");
                request.getRequestDispatcher("/SearchStyle.jsp").forward(request,response);

            }

        }
        if (type.equals("4")){
            Dao dao=new Dao();
            List<Information> list=dao.SelectLab_lab_id(value);
            System.out.println(4);
            if (list!=null){
                request.setAttribute("search",list);
                request.getRequestDispatcher("/doSearchStyle.jsp").forward(request,response);

            }
            else {
                response.getWriter().write("用户信息不存在");
                request.getRequestDispatcher("/SearchStyle.jsp").forward(request,response);

            }

        }



//        request.getRequestDispatcher("/SelectLab.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
