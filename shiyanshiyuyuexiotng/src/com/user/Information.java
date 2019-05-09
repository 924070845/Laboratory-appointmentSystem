package com.user;


public class Information {
    private String lab_id;
    private String lab_name;
    private String lab_tab;
    private String teacher_id;
    private String teacher_name;
    private String course_id;
    private String lab_date;
    private int lab_num;
    private int lab_count;
    private String lab_address;
    private String course_name;

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setLab_address(String lab_address) {
        this.lab_address = lab_address;
    }

    public String getLab_address() {
        return lab_address;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public int getLab_count() {
        return lab_count;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public void setLab_count(int lab_count) {
        this.lab_count = lab_count;
    }

    public void setLab_id(String lab_id) {
        this.lab_id = lab_id;
    }

    public void setLab_name(String lab_name) {
        this.lab_name = lab_name;
    }

    public void setLab_tab(String lab_tab) {
        this.lab_tab = lab_tab;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public void setLab_date(String lab_date) {
        this.lab_date = lab_date;
    }

    public void setLab_num(int lab_num) {
        this.lab_num = lab_num;
    }

    public String getLab_id() {
        return lab_id;
    }

    public String getLab_name() {
        return lab_name;
    }

    public String getLab_tab() {
        return lab_tab;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public String getLab_date() {
        return lab_date;
    }

    public int getLab_num() {
        return lab_num;
    }

    public String accountDate(String tab) {
        switch (tab) {
            case "1":
                return "8:00-10:00";
            case "2":
                return "10:00-12:00";
            case "3":
                return "14:00-16:00";
            case "4":
                return "16:00-18:00";
            case "5":
                return "19:00-21:00";
            default:
                return null;
        }
    }
}
