package com.example.websitenavigation.pojo;

import java.io.Serializable;

/**
 * t_search
 * @author 
 */
public class Search implements Serializable {
    private Integer searchId;

    private String name;

    private String icon;

    private String searchlink;

    private String searchname;

    private String color;

    private String placeholder;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getSearchId() {
        return searchId;
    }

    public void setSearchId(Integer searchId) {
        this.searchId = searchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSearchlink() {
        return searchlink;
    }

    public void setSearchlink(String searchlink) {
        this.searchlink = searchlink;
    }

    public String getSearchname() {
        return searchname;
    }

    public void setSearchname(String searchname) {
        this.searchname = searchname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}