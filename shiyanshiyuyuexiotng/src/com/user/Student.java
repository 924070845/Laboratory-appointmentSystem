package com.user;

public class Student {
    private String stu_id;
    private String stu_name;
    private String stu_password;
    private String stu_sex;
    private String stu_dept;
    private String stu_class;


    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public void setStu_sex(String stu_sex) {
        this.stu_sex = stu_sex;
    }

    public void setStu_dept(String stu_dept) {
        this.stu_dept = stu_dept;
    }

    public void setStu_class(String stu_class) {
        this.stu_class = stu_class;
    }

    public void setStu_password(String stu_password) {
        this.stu_password = stu_password;
    }


    public String getStu_id() {
        return stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public String getStu_sex() {
        return stu_sex;
    }

    public String getStu_dept() {
        return stu_dept;
    }

    public String getStu_class() {
        return stu_class;
    }

    public String getStu_password() {
        return stu_password;
    }
}
