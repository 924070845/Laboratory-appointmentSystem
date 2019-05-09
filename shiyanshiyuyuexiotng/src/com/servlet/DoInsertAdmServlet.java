package com.servlet;

import com.dao.Dao;
import com.user.Administrator;
import com.user.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DoInsertAdmServlet", urlPatterns = "/DoInsertAdmServlet")
public class DoInsertAdmServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //输出流
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");//这一句对字节流无效
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Administrator adm = new Administrator();

        Dao adminsert = new Dao();

        adm.setAdm_name    (request.getParameter("adm_name"));
        adm.setAdm_password(request.getParameter("adm_password"));

        int rs = adminsert.InsertAdm(adm);
        if(rs!=0){
            request.getRequestDispatcher("/success_or_error/Insert_success.jsp?username="+adm.getAdm_name()).forward(request, response);
        }else {
            request.getRequestDispatcher("/success_or_error/Insert_error.jsp?").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
