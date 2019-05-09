package com.servlet;

import com.dao.Dao;
import com.user.Information;
import com.user.Laboratory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DoSelectMyClass_stuServlet", urlPatterns = "/DoSelectMyClass_stuServlet")
public class DoSelectMyClass_stuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao myclass_studao = new Dao();
        List<Information> list = new ArrayList<Information>();

        HttpSession session = request.getSession();
        String stu_name = (String) session.getAttribute("session");

        list =  myclass_studao.SelectMyClass_stu(stu_name);
        request.setAttribute("search",list);
        request.getRequestDispatcher("/MyClass_stu.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
