package com.user;

public class Teacher {
    private String teacher_id;
    private String teacher_name;
    private String teacher_password;
    private String teacher_sex;
    private String teacher_dept;
    private String teacher_class;
    private String teacher_tel;
    private String course_name;

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public void setTeacher_tel(String teacher_tel) {
        this.teacher_tel = teacher_tel;
    }

    public void setTeacher_sex(String teacher_sex) {
        this.teacher_sex = teacher_sex;
    }

    public void setTeacher_dept(String teacher_dept) {
        this.teacher_dept = teacher_dept;
    }

    public void setTeacher_class(String teacher_class) {
        this.teacher_class = teacher_class;
    }

    public void setTeacher_password(String teacher_password) {
        this.teacher_password = teacher_password;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public String getTeacher_tel() {
        return teacher_tel;
    }

    public String getTeacher_sex() {
        return teacher_sex;
    }

    public String getTeacher_dept() {
        return teacher_dept;
    }

    public String getTeacher_class() {
        return teacher_class;
    }

    public String getTeacher_password() {
        return teacher_password;
    }
}
