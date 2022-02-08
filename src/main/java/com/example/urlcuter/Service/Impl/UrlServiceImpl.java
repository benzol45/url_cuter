package com.example.urlcuter.Service.Impl;

import com.example.urlcuter.Entity.UrlMapper;
import com.example.urlcuter.Repository.UrlRepository;
import com.example.urlcuter.Service.UrlService;
import com.example.urlcuter.Service.VizitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
public class UrlServiceImpl implements UrlService {
    private final UrlRepository urlRepository;
    private final VizitService vizitService;

    @Autowired
    public UrlServiceImpl(UrlRepository urlRepository, VizitService vizitService) {
        this.urlRepository = urlRepository;
        this.vizitService = vizitService;
    }

    @Override
    public String getFullUrlByCutUrl(String cutUrl, String clientID) {
        vizitService.registerVizit(cutUrl, clientID);
        Optional<UrlMapper> optionalUrlMapper = urlRepository.getUrlMapperByCutUrl(cutUrl);
        if (optionalUrlMapper.isPresent()) {
            UrlMapper urlMapper = optionalUrlMapper.get();

            if (urlMapper.getLiveTime()!=null && urlMapper.getLiveTime().compareTo(LocalDateTime.now())<0) {
                return "exist";
            }

            return urlMapper.getFullUrl();

        } else {

            return "404page";
        }
    }

    @Override
    public void addNewUrlMapper(UrlMapper urlMapper) {
        urlRepository.addNewUrlMapper(urlMapper);
    }
}
