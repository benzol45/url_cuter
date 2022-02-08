package com.example.urlcuter.Repository;

import com.example.urlcuter.Entity.UrlMapper;

import java.util.Optional;

public interface UrlRepository {
    Optional<UrlMapper> getUrlMapperByCutUrl(String cutUrl);
    boolean existCutUrl(String cutUrl);
    void addNewUrlMapper(UrlMapper urlMapper);

}
