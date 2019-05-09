package com.servlet;

import com.dao.Dao;
import com.user.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DoInsertLabServlet", urlPatterns = "/DoInsertLabServlet")
public class DoInsertLabServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //输出流
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");//这一句对字节流无效
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Laboratory lab = new Laboratory();

        Dao labinsert = new Dao();

        //为user对象初始化值，不然则没有值可插入
        lab.setLab_id     (request.getParameter("lab_id"));
        lab.setLab_name   (request.getParameter("lab_name"));
        lab.setLab_address(request.getParameter("lab_address"));
        lab.setLab_count  (request.getParameter("lab_count"));
        lab.setLab_date   (request.getParameter("lab_date"));
        lab.setLab_tab    (request.getParameter("lab_tab"));


        int rs = labinsert.InsertLab(lab);
        if(rs!=0){
            request.getRequestDispatcher("/success_or_error/Insert_success_Adm.jsp?username="+lab.getLab_name()).forward(request, response);
        }else {
            request.getRequestDispatcher("/success_or_error/Insert_error.jsp?").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
