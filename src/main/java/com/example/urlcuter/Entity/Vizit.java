package com.example.urlcuter.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Vizit {
    LocalDateTime dateTime;
    UUID ClientID;
    String cutUrl;

    public Vizit(LocalDateTime dateTime, UUID clientID, String cutUrl) {
        this.dateTime = dateTime;
        ClientID = clientID;
        this.cutUrl = cutUrl;
    }
}
