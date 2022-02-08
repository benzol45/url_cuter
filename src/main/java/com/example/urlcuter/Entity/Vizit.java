package com.example.urlcuter.Entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

public class Vizit {
    LocalDateTime dateTime;
    String cutUrl;
    String fullUrl;
    UUID ClientID;

    public Vizit(LocalDateTime dateTime, String cutUrl, String fullUrl, UUID clientID) {
        this.dateTime = dateTime;
        this.cutUrl = cutUrl;
        this.fullUrl = fullUrl;
        ClientID = clientID;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Timestamp getDateTimeTimestamp() {
        return Timestamp.valueOf(dateTime);
    }

    public String getCutUrl() {
        return cutUrl;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public UUID getClientID() {
        return ClientID;
    }
}
