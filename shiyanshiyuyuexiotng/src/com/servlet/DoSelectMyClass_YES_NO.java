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

@WebServlet(name = "DoSelectMyClass_YES_NO", urlPatterns = "/DoSelectMyClass_YES_NO")
public class DoSelectMyClass_YES_NO extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String type = (String) session.getAttribute("type");

        if (type.equals("student")){
            request.getRequestDispatcher("/DoSelectMyClass_stuServlet").forward(request,response);

        }else if (type.equals("teacher")){
            request.getRequestDispatcher("/DoSelectMyClass_teacherServlet").forward(request,response);

        }else {
            request.getRequestDispatcher("/success_or_error/SelectMyClass_error.jsp").forward(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
