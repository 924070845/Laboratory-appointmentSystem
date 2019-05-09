package com.servlet;

import com.dao.Dao;
import com.user.Laboratory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DoDeleteLabServlet", urlPatterns = "/DoDeleteLabServlet")
public class DoDeleteLabServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Dao labdelete = new Dao();
            Laboratory lab = new Laboratory();

            String lab_id = request.getParameter("id");
            labdelete.DelectLab_fd(lab_id);
	        request.getRequestDispatcher("/DoSelectLabServlet").forward(request,response);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
