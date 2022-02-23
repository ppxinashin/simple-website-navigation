package com.example.websitenavigation.pojo;

import java.io.Serializable;

/**
 * t_mark
 * @author 
 */
public class Mark implements Serializable {
    private Long id;

    private String title;

    private String mark;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}