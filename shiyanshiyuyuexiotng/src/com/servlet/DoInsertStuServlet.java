package com.servlet;

import com.dao.Dao;
import com.user.Laboratory;
import com.user.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DoInsertStuServlet", urlPatterns = "/DoInsertStuServlet")
public class DoInsertStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //输出流
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");//这一句对字节流无效
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Student stu = new Student();

        Dao stuinsert = new Dao();

        //为user对象初始化值，不然则没有值可插入
        stu.setStu_id      (request.getParameter("stu_id"));
        stu.setStu_name    (request.getParameter("stu_name"));
        stu.setStu_password(request.getParameter("stu_password"));
        stu.setStu_sex     (request.getParameter("stu_sex"));
        stu.setStu_dept    (request.getParameter("stu_dept"));
        stu.setStu_class   (request.getParameter("stu_class"));


        int rs = stuinsert.InsertStu(stu);
        if(rs!=0){
            request.getRequestDispatcher("/success_or_error/Insert_success.jsp?username="+stu.getStu_name()).forward(request, response);
        }else {
            request.getRequestDispatcher("/success_or_error/Insert_error.jsp?").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
