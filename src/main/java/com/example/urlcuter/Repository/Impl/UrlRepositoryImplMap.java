package com.example.urlcuter.Repository.Impl;

import com.example.urlcuter.Repository.UrlRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UrlRepositoryImplMap implements UrlRepository {
    private static Map<String,String> data = new HashMap<>();

    static {
        data.put("g","google.com");
        data.put("y","yandex.ru");
        data.put("gm","gmail.com");
    }

    @Override
    public Optional<String> getFullUrlByCutUrl(String cutUrl) {
        return data.get(cutUrl)!=null?
                Optional.of(data.get(cutUrl)):
                Optional.empty();
    }

    @Override
    public boolean existCutUrl(String cutUrl) {
        return data.containsKey(cutUrl);
    }

    @Override
    public void addNewUrlPair(String cutUrl, String fullUrl) {
        data.put(cutUrl,fullUrl);
    }
}
