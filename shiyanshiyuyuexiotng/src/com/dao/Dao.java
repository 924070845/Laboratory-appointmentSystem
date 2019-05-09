package com.dao;

import com.conn.Conn;
import com.user.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Dao {

    //管理员录入实验室信息
    public int InsertLab(Laboratory lab){
        int rs = 0;

        Conn conn = new Conn();
        Connection dbc = conn.getConn();

        PreparedStatement pst = null;

        try{

            String sql_insert = "INSERT INTO laboratory(lab_id,lab_name,lab_address,lab_count,lab_date,lab_tab)VALUES(?,?,?,?,?,?)";
            pst = dbc.prepareStatement(sql_insert);
            pst.setString(1,lab.getLab_id());
            pst.setString(2,lab.getLab_name());
            pst.setString(3,lab.getLab_address());
            pst.setString(4,lab.getLab_count());
            pst.setString(5,lab.getLab_date());
            pst.setString(6,lab.getLab_tab());
            rs = pst.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }



        return rs;
    }

    //学生信息录入函数
    public int InsertStu(Student stu){
        int rs = 0;

        Conn conn = new Conn();
        Connection dbc = conn.getConn();

        PreparedStatement pst = null;
        try{

            String sql_insert = "INSERT INTO student(stu_id,stu_name,stu_password,stu_sex,stu_dept,stu_class)VALUES(?,?,?,?,?,?)";
            pst = dbc.prepareStatement(sql_insert);
            pst.setString(1,stu.getStu_id());
            pst.setString(2,stu.getStu_name());
            pst.setString(3,stu.getStu_password());
            pst.setString(4,stu.getStu_sex());
            pst.setString(5,stu.getStu_dept());
            pst.setString(6,stu.getStu_class());
            rs = pst.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return rs;
    }

    //教师信息的录入函数
    public int InsertTeacher(Teacher teacher){
        int rs = 0;

        Conn conn = new Conn();
        Connection dbc = conn.getConn();

        PreparedStatement pst = null;
        try{

            String sql_insert = "INSERT INTO teacher(teacher_id,teacher_name,teacher_password,teacher_sex,teacher_dept,teacher_class,teacher_tel)VALUES(?,?,?,?,?,?,?)";
            pst = dbc.prepareStatement(sql_insert);
            pst.setString(1,teacher.getTeacher_id());
            pst.setString(2,teacher.getTeacher_name());
            pst.setString(3,teacher.getTeacher_password());
            pst.setString(4,teacher.getTeacher_sex());
            pst.setString(5,teacher.getTeacher_dept());
            pst.setString(6,teacher.getTeacher_class());
            pst.setString(7,teacher.getTeacher_tel());
            rs = pst.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    //管理员信息的录入函数
    public int InsertAdm(Administrator adm){
        int rs = 0;

        Conn conn = new Conn();
        Connection dbc = conn.getConn();

        PreparedStatement pst = null;
        try{

            String sql_insert = "INSERT INTO administrator(adm_name,adm_password)VALUES(?,?)";
            pst = dbc.prepareStatement(sql_insert);
            pst.setString(1,adm.getAdm_name());
            pst.setString(2,adm.getAdm_password());
            rs = pst.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    //查询实验室信息函数
    public List<Laboratory> SelectLab_fd(){
        //返回值是一个数组形式的值,查询函数不需要参数传入
        //但这里我们将对象的值封装起来，存到List中，所以返回值也是List<User>
        List<Laboratory> userlist = new ArrayList<Laboratory>();
        ResultSet rs = null;

        try{
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();

            //SQL语句
            String sql_select= "SELECT * FROM laboratory";
            PreparedStatement pst = bdc.prepareStatement(sql_select);
            rs = pst.executeQuery();//查询专用语句,这样的话，就可以用数据库的原生函数，如.next()


            //将查询到的值，也就是一组User的对象放入List中，这样就不用每次需要时
            //与数据库交互，节省的时间和空间
            while (rs.next()){
                Laboratory lab = new Laboratory();
                //因为一条一条的数据其实是在User层定义好的.java 中的属性的封装，所以用User的对象来接受值
                lab.setLab_id     (rs.getString("lab_id"));
                lab.setLab_name   (rs.getString("lab_name"));
                lab.setLab_address(rs.getString("lab_address"));
                lab.setLab_count  (rs.getString("lab_count"));
                lab.setLab_date   (rs.getString("lab_date"));
                lab.setLab_tab    (rs.getString("lab_tab"));


                //最后将user接受到的封装值加入到list中去
                userlist.add(lab);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return userlist;
    }

    //查询实验室ID函数
    public List<Laboratory> SelectLabId_fd(Laboratory lab){
        List<Laboratory> lablist = new ArrayList<Laboratory>();
        ResultSet rs = null;

        try{
            Conn conn = new Conn();
            Connection dbc = conn.getConn();
            String sql_selectId = "SELECT * FROM laboratory WHERE lab_id = ?";
            PreparedStatement pst = dbc.prepareStatement(sql_selectId);
            pst.setString(1, lab.getLab_id());
            rs = pst.executeQuery();
            while (rs.next()){
                lab.setLab_id     (rs.getString("lab_id"));
                lab.setLab_name   (rs.getString("lab_name"));
                lab.setLab_address(rs.getString("lab_address"));
                lab.setLab_count  (rs.getString("lab_count"));
                lab.setLab_date   (rs.getString("lab_date"));
                lab.setLab_tab    (rs.getString("lab_tab"));
                lablist.add(lab);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return lablist;

    }

    //删除数据函数
    public int DelectLab_fd(String id){
        int rs = 0;
        try{
            Conn dbc = new Conn();
            Connection conn = dbc.getConn();
            String sql_delect = "DELETE  FROM laboratory WHERE lab_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql_delect);
            pst.setString(1,id);

            rs = pst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

        return rs;
    }

    //更新数据
    public int UpdateLab(Laboratory lab){
        int rs=0;
        try{
            Conn dbc = new Conn();
            Connection conn = dbc.getConn();
            String sql_update = "update laboratory " +
                    "set lab_name=?,lab_address=?,lab_count=?,lab_date=?,lab_tab=? " +
                    "where lab_id=?";
            PreparedStatement pst = conn.prepareStatement(sql_update);
            pst.setString(1, lab.getLab_name());
            pst.setString(2, lab.getLab_address());
            pst.setString(3, lab.getLab_count());
            pst.setString(4, lab.getLab_date());
            pst.setString(5, lab.getLab_tab());
            pst.setString(6, lab.getLab_id());
            rs=pst.executeUpdate();

            System.out.println(pst);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    //按教师编号查询
    public List<Information> SelectLab_teacher_id(String tno){
        //返回值是一个数组形式的值,查询函数不需要参数传入
        //但这里我们将对象的值封装起来，存到List中，所以返回值也是List<User>
        List<Information> inforlist1 = new ArrayList<Information>();
        ResultSet rs = null;

        try{
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();

            String sql_select2 = " select * from information,laboratory\n" +
                    "WHERE information.lab_id=laboratory.lab_id  \n" +
                    "AND information.teacher_id=?";

            PreparedStatement pst = bdc.prepareStatement(sql_select2);
            pst.setString(1,tno);
            rs = pst.executeQuery();//查询专用语句,这样的话，就可以用数据库的原生函数，如.next()
            while (rs.next()){
                Information infor2 = new Information();

                infor2.setLab_id        (rs.getString("lab_id"));
                infor2.setLab_name      (rs.getString("lab_name"));
                infor2.setTeacher_id    (rs.getString("teacher_id"));
                infor2.setLab_date      (rs.getString("lab_date"));
                infor2.setCourse_id     (rs.getString("course_id"));
                infor2.setLab_tab       (rs.getString("lab_tab"));
                infor2.setLab_address   (rs.getString("lab_address"));

                inforlist1.add(infor2);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return inforlist1;
    }

    //按学生编号查询
    public List<Information> SelectLab_student_id(String sno){
        List<Information> inforlist2 = new ArrayList<Information>();
        ResultSet rs = null;

        try{
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();

            String sql_select = " select * from information,student,laboratory\n" +
                    "WHERE information.stu_id=student.stu_id\n" +
                    "AND information.lab_id=laboratory.lab_id\n" +
                    "AND information.stu_id=?";

            PreparedStatement pst = bdc.prepareStatement(sql_select);
            pst.setString(1,sno);
            rs = pst.executeQuery();

            while (rs.next()){
                Information infor = new Information();

                infor.setLab_id        (rs.getString("lab_id"));
                infor.setLab_name      (rs.getString("lab_name"));
                infor.setTeacher_id    (rs.getString("teacher_id"));
                infor.setLab_date      (rs.getString("lab_date"));
                infor.setCourse_id     (rs.getString("course_id"));
                infor.setLab_tab       (rs.getString("lab_tab"));
                infor.setLab_address   (rs.getString("lab_address"));
//                infor.setTeacher_name  (rs.getString("teacher_name"));


                //最后将user接受到的封装值加入到list中去
                inforlist2.add(infor);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return inforlist2;
    }

    //按时间查询
    public List<Information> SelectLab_date_id(String dateno){

        List<Information> inforlist = new ArrayList<Information>();
        ResultSet rs = null;

        try{
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();

            String sql_select = "select * from information,laboratory \n" +
                    "WHERE information.lab_id=laboratory.lab_id\n" +
                    "AND information.lab_date=?";

            PreparedStatement pst = bdc.prepareStatement(sql_select);
            pst.setString(1,dateno);
            rs = pst.executeQuery();//查询专用语句,这样的话，就可以用数据库的原生函数，如.next()

            System.out.println(pst);
            //将查询到的值，也就是一组User的对象放入List中，这样就不用每次需要时
            //与数据库交互，节省的时间和空间
            while (rs.next()){
                Information infor = new Information();

                infor.setLab_id        (rs.getString("lab_id"));
                infor.setLab_name      (rs.getString("lab_name"));
                infor.setLab_date      (rs.getString("lab_date"));
                infor.setCourse_id     (rs.getString("course_id"));
                infor.setLab_tab       (rs.getString("lab_tab"));
                infor.setLab_address   (rs.getString("lab_address"));

                inforlist.add(infor);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return inforlist;
    }

    //按实验室编号查
    public List<Information> SelectLab_lab_id(String labno){
        List<Information> inforlist3 = new ArrayList<Information>();
        ResultSet rs = null;

        try{
            Conn conn = new Conn();
            Connection bdc = conn.getConn();

            String sql_select2 = "select * from information,laboratory \n" +
                    "WHERE information.lab_id=laboratory.lab_id\n" +
                    " AND information.lab_id=?";

            PreparedStatement pst = bdc.prepareStatement(sql_select2);
            pst.setString(1,labno);
            rs = pst.executeQuery();//查询专用语句,这样的话，就可以用数据库的原生函数，如.next()
            while (rs.next()){
                Information infor2 = new Information();

                infor2.setLab_id        (rs.getString("lab_id"));
                infor2.setLab_name      (rs.getString("lab_name"));
                infor2.setTeacher_id    (rs.getString("teacher_id"));
                infor2.setLab_date      (rs.getString("lab_date"));
                infor2.setCourse_id     (rs.getString("course_id"));
                infor2.setLab_tab       (rs.getString("lab_tab"));
                infor2.setLab_address   (rs.getString("lab_address"));
                //最后将user接受到的封装值加入到list中去
                inforlist3.add(infor2);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return inforlist3;
    }

    //查询实验室名
    public List<Laboratory> selectLabName(){
        List<Laboratory> lablist = new ArrayList<Laboratory>();
        ResultSet rs = null;

        try{
            Conn conn = new Conn();
            Connection dbc = conn.getConn();
            String sql_selectId = "SELECT * FROM laboratory ";
            PreparedStatement pst = dbc.prepareStatement(sql_selectId);

            rs = pst.executeQuery();


            while (rs.next()){
                Laboratory lab = new Laboratory();
                lab.setLab_id     (rs.getString("lab_id"));
                lab.setLab_name   (rs.getString("lab_name"));
                lab.setLab_date   (rs.getString("lab_date"));
                lab.setLab_address(rs.getString("lab_address"));

                lablist.add(lab);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return lablist;

    }

    //将信息表中的课程名插入到教师课表中
    public int InsertCourseToTeacher(String id,String teacher_id){
        int rs = 0;
        System.out.println(id);
        Conn conn = new Conn();
        Connection dbc = conn.getConn();


        PreparedStatement pst = null;
        try{
            String sql_update = "update tc set " +
                    "course_name=(SELECT course_name FROM information WHERE lab_id=?)" +
                    " where teacher_id=?";
            pst = dbc.prepareStatement(sql_update);

            pst.setString(1,id);
            pst.setString(2,teacher_id);
            rs = pst.executeUpdate();


        }
        catch(Exception e){
            e.printStackTrace();
        }



        return rs;
    }

    //查询老师名字和已预约的课名，返回值就
    public List<Teacher> selectTeacherClass() {
        List<Teacher> tlist = new ArrayList<Teacher>();
        ResultSet rs = null;

        try{
            Conn conn = new Conn();
            Connection dbc = conn.getConn();
            String sql_select = "SELECT * FROM tc,teacher WHERE tc.teacher_id=teacher.teacher_id";
            PreparedStatement pst = dbc.prepareStatement(sql_select);

            rs = pst.executeQuery();


            while (rs.next()){
                Teacher teacher = new Teacher();

                teacher.setTeacher_id(rs.getString("teacher_id"));
                teacher.setTeacher_name(rs.getString("teacher_name"));
                teacher.setCourse_name(rs.getString("course_name"));

                tlist.add(teacher);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return tlist;

    }

    //将信息表中的课程名插入到教师课表中
    public int InsertCourseToStudent(String id,String student_id,String course_tab){
        int rs = 0;
        System.out.println(id);
        Conn conn = new Conn();
        Connection dbc = conn.getConn();


        PreparedStatement pst = null;
        try{
            String sql_update = "update sc set \n" +
                    "course_name=(SELECT course_name \n" +
                    "FROM tc\n" +
                    "WHERE teacher_id=?)\n" +
                    ", course_tab=?\n" +
                    "where student_id=?";
            pst = dbc.prepareStatement(sql_update);

            pst.setString(1,id);
            pst.setString(2,course_tab);
            pst.setString(3,student_id);
            rs = pst.executeUpdate();

            System.out.println(pst);

        }
        catch(Exception e){
            e.printStackTrace();
        }



        return rs;
    }

    //查询学生课表
    public List<Information> SelectMyClass_stu(String stu_name){
        //返回值是一个数组形式的值,查询函数不需要参数传入
        //但这里我们将对象的值封装起来，存到List中，所以返回值也是List<User>
        List<Information> inforlist1 = new ArrayList<Information>();
        ResultSet rs = null;

        try{
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();

            String sql_select2 = "SELECT sc.course_name,\n" +
                    "laboratory.lab_address,\n" +
                    "laboratory.lab_date,\n" +
                    "sc.course_tab,\n" +
                    "laboratory.lab_name\n" +
                    "FROM information ,sc,laboratory\n" +
                    "WHERE\tinformation.course_id=sc.course_id\n" +
                    "AND information.lab_id=laboratory.lab_id\n" +
                    "AND information.course_id=(\n" +
                    "SELECT course_id FROM student,sc \n" +
                    "WHERE student.stu_id = sc.student_id  \n" +
                    "AND stu_name=?\n" +
                    ")\n";

            PreparedStatement pst = bdc.prepareStatement(sql_select2);
            pst.setString(1,stu_name);
            rs = pst.executeQuery();//查询专用语句,这样的话，就可以用数据库的原生函数，如.next()

            System.out.println(pst);
            while (rs.next()){
                Information infor = new Information();

                infor.setCourse_name   (rs.getString("course_name"));
                infor.setLab_name      (rs.getString("lab_name"));
                infor.setLab_address   (rs.getString("lab_address"));
                infor.setLab_date      (rs.getString("lab_date")   );
                infor.setLab_tab       (rs.getString("course_tab") );

                inforlist1.add(infor);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return inforlist1;
    }

    //查询教师课表
    public List<Information> SelectMyClass_teacher(String teacher_name){
        //返回值是一个数组形式的值,查询函数不需要参数传入
        //但这里我们将对象的值封装起来，存到List中，所以返回值也是List<User>
        List<Information> inforlist1 = new ArrayList<Information>();
        ResultSet rs = null;

        try{
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();

            String sql_select2 = "SELECT tc.course_name,\n" +
                    "laboratory.lab_address,\n" +
                    "laboratory.lab_date,\n" +
                    "laboratory.lab_name\n" +
                    "FROM tc,laboratory,information\n" +
                    "WHERE information.lab_id=laboratory.lab_id\n" +
                    "AND information.course_id=tc.course_id\n" +
                    "AND tc.teacher_id=(\n" +
                    "SELECT teacher.teacher_id FROM teacher \n" +
                    "WHERE teacher.teacher_name=?\n" +
                    ")";

            PreparedStatement pst = bdc.prepareStatement(sql_select2);
            pst.setString(1,teacher_name);
            rs = pst.executeQuery();//查询专用语句,这样的话，就可以用数据库的原生函数，如.next()

            System.out.println(pst);
            while (rs.next()){
                Information infor = new Information();

                infor.setCourse_name   (rs.getString("course_name"));
                infor.setLab_name      (rs.getString("lab_name"));
                infor.setLab_address   (rs.getString("lab_address"));
                infor.setLab_date      (rs.getString("lab_date")   );

                inforlist1.add(infor);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return inforlist1;
    }
}


