package com.example.urlcuter.Service;

import com.example.urlcuter.Entity.UrlMapper;

public interface UrlService {
    String processingVizit(String cutUrl, String clientID);
    String getFullUrlByCutUrl(String cutUrl);
    void addNewUrlMapper(UrlMapper urlMapper);
}
