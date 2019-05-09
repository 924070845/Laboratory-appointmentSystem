package com.user;

public class Administrator {
    private  String adm_id;
    private  String adm_name;
    private  String adm_password;

    public void setAdm_id(String adm_id) {
        this.adm_id = adm_id;
    }
    public void setAdm_password(String adm_password){
        this.adm_password = adm_password;
    }
    public void setAdm_name(String adm_name) {
        this.adm_name = adm_name;
    }

    public String getAdm_id() {
        return adm_id;
    }
    public String getAdm_password(){
        return adm_password;
    }
    public String getAdm_name() {
        return adm_name;
    }

}
