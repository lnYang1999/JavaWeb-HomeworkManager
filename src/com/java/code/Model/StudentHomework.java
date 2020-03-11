package com.java.code.Model;

import java.util.Date;

public class StudentHomework {
    private long st_hw_id;
    private long st_id;
    private long hw_id;
    private String hw_title;
    private String hw_content;
    private String submit_content;
    private Date st_hw_create_time;
    private Date st_hw_update_time;

    public long getsthwId() { return st_hw_id; }

    public void setsthwId(long st_hw_id) {
        this.st_hw_id = st_hw_id;
    }

    public long getstId() {
        return st_id;
    }

    public void setstId(long st_id) { this.st_id = st_id; }

    public long gethwId() {
        return hw_id;
    }

    public void sethwId(long hw_id) {
        this.hw_id = hw_id;
    }

    public String gethwTitle() {
        return hw_title;
    }

    public void sethwTitle(String hw_title) {
        this.hw_title = hw_title;
    }

    public String gethwContent() {
        return hw_content;
    }

    public void sethwContent(String hw_content) {
        this.hw_content = hw_content;
    }

    public String getsubmitContent() {
        return submit_content;
    }

    public void setsubmitContent(String submit_content) {
        this.submit_content = submit_content;
    }

    public Date getsthwCreateTime() {
        return st_hw_create_time;
    }

    public void setsthwCreateTime(Date st_hw_create_time) {
        this.st_hw_create_time = st_hw_create_time;
    }

}
