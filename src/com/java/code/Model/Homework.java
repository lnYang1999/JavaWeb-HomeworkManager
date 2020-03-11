package com.java.code.Model;

import java.util.Date;

public class Homework {
    private Long hw_id;
    private String hw_title;
    private String hw_content;
    private Date hw_create_time;
    private Date hw_update_time;


    public Long gethwId() {
        return hw_id;
    }

    public void sethwId(Long hw_id) {
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

    public Date gethwCreateTime() {
        return hw_create_time;
    }

    public void sethwCreateTime(Date hw_create_time) { this.hw_create_time = hw_create_time; }
}
