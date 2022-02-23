package com.example.websitenavigation.pojo;

import java.io.Serializable;

/**
 * t_homepage_website
 * @author 
 */
public class HomepageWebsite implements Serializable {
    private Integer siteId;

    private String name;

    private String link;

    private String boxShadow;

    private String icon;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getBoxShadow() {
        return boxShadow;
    }

    public void setBoxShadow(String boxShadow) {
        this.boxShadow = boxShadow;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}