package com.java.code.Model;

import java.util.Date;

public class Student {
    private Long st_id;
    private String st_name;
    private Date st_create_time;
    private Date st_update_time;

    public Long getstId() {
        return st_id;
    }

    public void setstId(Long st_id) {
        this.st_id = st_id;
    }

    public String getstName() {
        return st_name;
    }

    public void setstName(String st_name) {
        this.st_name = st_name;
    }

    public Date getstCreateTime() {
        return st_create_time;
    }

    public void setstCreateTime(Date st_create_time) {
        this.st_create_time = st_create_time;
    }
}
