package com.servlet;

import com.dao.Dao;
import com.user.Laboratory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DoUpdateLabServlet_2", urlPatterns = "/DoUpdateLabServlet_2")
public class DoUpdateLabServlet_2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");//这一句对字节流无效
        response.setCharacterEncoding("UTF-8");

        Dao userupdate = new Dao();
        Laboratory lab = new Laboratory();


        lab.setLab_id     (request.getParameter("id"));
        lab.setLab_name   (request.getParameter("lab_name"));
        lab.setLab_address(request.getParameter("lab_address"));
        lab.setLab_count  (request.getParameter("lab_count"));
        lab.setLab_date   (request.getParameter("lab_date"));
        lab.setLab_tab    (request.getParameter("lab_tab"));

        int rs = userupdate.UpdateLab(lab);
        if (rs!=0){
            //成功修改
            request.getRequestDispatcher("/success_or_error/Update_success.jsp").forward(request,response);

            request.getRequestDispatcher("/success_or_error/Update_error.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
