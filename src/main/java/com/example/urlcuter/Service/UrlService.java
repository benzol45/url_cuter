package com.example.urlcuter.Service;

import com.example.urlcuter.Entity.UrlMapper;

import java.util.List;

public interface UrlService {
    String processingVizit(String cutUrl, String clientID);
    String getFullUrlByCutUrl(String cutUrl);
    void addNewUrlMapper(UrlMapper urlMapper);
    List<UrlMapper> getAllUrlMappers();
    void removeByCutUrl(String cutUrl);
}
