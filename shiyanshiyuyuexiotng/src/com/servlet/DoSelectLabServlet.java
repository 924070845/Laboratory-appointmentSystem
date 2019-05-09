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

@WebServlet(name = "DoSelectLabServlet", urlPatterns = "/DoSelectLabServlet")
public class DoSelectLabServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao labdao = new Dao();
        List<Laboratory> lablist = new ArrayList<Laboratory>();
        lablist =  labdao.SelectLab_fd();
        request.setAttribute("lablist",lablist);
        request.getRequestDispatcher("/SelectLab.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
