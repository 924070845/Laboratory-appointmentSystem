package com.servlet;

import com.dao.Dao;
import com.user.Laboratory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DoUpdateLabServlet", urlPatterns = "/DoUpdateLabServlet")
public class DoUpdateLabServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Laboratory lab = new Laboratory();
        Dao labupdate = new Dao();

        lab.setLab_id(request.getParameter("id"));

        List<Laboratory> list = new ArrayList<Laboratory>();
        list = labupdate.SelectLabId_fd(lab);


        request.setAttribute("list",list);
        request.getRequestDispatcher("/UpdateLab.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
