package com.example.urlcuter.Service.Impl;

import com.example.urlcuter.Repository.UrlRepository;
import com.example.urlcuter.Service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {
    private final UrlRepository urlRepository;

    @Autowired
    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public String getFullUrlByCutUrl(String cutUrl) {
        return urlRepository.getFullUrlByCutUrl(cutUrl).orElse("noLink");
    }
}
