package com.dao;

import com.conn.Conn;
import com.user.Administrator;
import com.user.Student;
import com.user.Teacher;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoLogin {



    //学生验证用户和密码
    public int Dologin_stu(Student stu) {
        ResultSet rs = null;
        Conn conn = new Conn();
        Connection dbc = conn.getConn();
        PreparedStatement pst = null;
        int count = 0;

        try{
            String sql_selectNameAndPassword = "SELECT stu_password FROM student WHERE stu_name=? ";
            pst = dbc.prepareStatement(sql_selectNameAndPassword);
            pst.setString(1,stu.getStu_name());
            rs = pst.executeQuery();

            while (rs.next()){
                String password = rs.getString("stu_password");
                if (rs.getString("stu_password").equals(stu.getStu_password())){
                    count = 1;
                }else {
                    count = 0;
                }
            }
        }catch(Exception e){
            System.out.println("判断失败");
            e.printStackTrace();
        }
        return count;
    }

    //教师验证用户和密码
    public int Dologin_teacher(Teacher teacher) {
        ResultSet rs = null;
        Conn conn = new Conn();
        Connection dbc = conn.getConn();
        PreparedStatement pst = null;
        int count = 0;

        try{
            String sql_selectNameAndPassword = "SELECT teacher_password FROM teacher WHERE teacher_name=? ";
            pst = dbc.prepareStatement(sql_selectNameAndPassword);
            pst.setString(1,teacher.getTeacher_name());
            rs = pst.executeQuery();

            while (rs.next()){
                if (rs.getString("teacher_password").equals(teacher.getTeacher_password())){
                    count = 1;
                }else {
                    count = 0;
                }
            }
        }catch(Exception e){
            System.out.println("判断失败");
            e.printStackTrace();
        }
        return count;
    }

    //管理员验证用户和密码
    public int Dologin_adm(Administrator adm) {
        ResultSet rs = null;
        Conn conn = new Conn();
        Connection dbc = conn.getConn();
        PreparedStatement pst = null;
        int count = 0;

        try{
            String sql_selectNameAndPassword = "SELECT adm_password FROM administrator WHERE adm_name=? ";
            pst = dbc.prepareStatement(sql_selectNameAndPassword);
            pst.setString(1,adm.getAdm_name());
            rs = pst.executeQuery();

            while (rs.next()){
                if (rs.getString("adm_password").equals(adm.getAdm_password())){
                    count = 1;
                }else {
                    count = 0;
                }
            }
        }catch(Exception e){
            System.out.println("判断失败");
            e.printStackTrace();
        }
        return count;
    }
}
