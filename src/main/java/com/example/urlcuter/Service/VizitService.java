package com.example.urlcuter.Service;

import java.time.LocalDateTime;

public interface VizitService {
    void registerVizit(LocalDateTime eventDateTime, String cutUrl, String fullUrl, String clientID);
}
