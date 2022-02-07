package com.example.urlcuter.Entity;

import java.util.Date;

public class UrlMapper {
    private String cutUrl;
    private String fullUrl;
    private Date liveTime;

    public UrlMapper(String cutUrl, String fullUrl, Date liveTime) {
        this.cutUrl = cutUrl;
        this.fullUrl = fullUrl;
        this.liveTime = liveTime;
    }

    public String getCutUrl() {
        return cutUrl;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public Date getLiveTime() {
        return liveTime;
    }
}
