package com.example.urlcuter.Service;

import com.example.urlcuter.Entity.UrlMapper;

public interface UrlService {
    String getFullUrlByCutUrl(String cutUrl, String clientID);
    void addNewUrlMapper(UrlMapper urlMapper);
}
