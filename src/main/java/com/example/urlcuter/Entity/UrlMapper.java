package com.example.urlcuter.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.time.LocalDateTime;


public class UrlMapper {
    private String cutUrl;
    private String fullUrl;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime liveTime;

    public UrlMapper(String cutUrl, String fullUrl) {
        this.cutUrl = cutUrl;
        this.fullUrl = fullUrl;
    }

    public String getCutUrl() {
        return cutUrl;
    }

    public void setCutUrl(String cutUrl) {
        this.cutUrl = cutUrl;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public LocalDateTime getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(LocalDateTime liveTime) {
        this.liveTime = liveTime;
    }

    public Timestamp getLiveTimeTimestamp() {
        if (liveTime!=null) {
            return Timestamp.valueOf(liveTime);
        } else {
            return null;
        }
    }

    public String getLiveTimePresentation() {
        if (liveTime!=null) {
            return liveTime.toString();
        } else {
            return "";
        }
    }

    public void setLiveTimeTimestamp(Timestamp liveTimeTimestamp) {
        this.liveTime = liveTimeTimestamp.toLocalDateTime();
    }
}
