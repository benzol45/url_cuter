package com.example.urlcuter.Service.Impl;

import com.example.urlcuter.Entity.UrlMapper;
import com.example.urlcuter.Repository.UrlRepository;
import com.example.urlcuter.Service.UrlService;
import com.example.urlcuter.Service.VizitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
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
    public String processingVizit(String cutUrl, String clientID) {
        String goTo="";

        String fullUrl = getFullUrlByCutUrl(cutUrl);
        if (fullUrl.equals("NotFound")) {
            goTo = "/NotFound.html";
        } else if (fullUrl.equals("Exist")) {
            goTo = "/Exist.html";
        } else {
            goTo = "//"+fullUrl;
        }

        //TODO реализовать
        vizitService.registerVizit(LocalDateTime.now(),cutUrl, fullUrl, clientID);

        return goTo;
    }

    @Override
    public String getFullUrlByCutUrl(String cutUrl) {
        Optional<UrlMapper> optionalUrlMapper = urlRepository.getUrlMapperByCutUrl(cutUrl);
        if (optionalUrlMapper.isPresent()) {
            UrlMapper urlMapper = optionalUrlMapper.get();

            if (urlMapper.getLiveTime()!=null && urlMapper.getLiveTime().compareTo(LocalDateTime.now())<0) {
                return "Exist";
            }

            return urlMapper.getFullUrl();

        } else {

            return "NotFound";
        }
    }

    @Override
    public void addNewUrlMapper(UrlMapper urlMapper) {
        //TODO Реализовать генерацию короткой ссылки и подставлять в объяект
        if (!urlRepository.existCutUrl(urlMapper.getCutUrl())) {
            urlRepository.addNewUrlMapper(urlMapper);
        }
    }

    @Override
    public List<UrlMapper> getAllUrlMappers() {
        return urlRepository.getAllUrlMappers();
    }
}
