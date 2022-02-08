package com.example.urlcuter.Service.Impl;

import com.example.urlcuter.Entity.UrlMapper;
import com.example.urlcuter.Repository.UrlRepository;
import com.example.urlcuter.Service.UrlService;
import com.example.urlcuter.Service.VizitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlServiceImpl implements UrlService {
    private final UrlRepository urlRepository;
    private final VizitService vizitService;
    private final Environment environment;

    @Autowired
    public UrlServiceImpl(UrlRepository urlRepository, VizitService vizitService, Environment environment) {
        this.urlRepository = urlRepository;
        this.vizitService = vizitService;
        this.environment = environment;
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
        //TODO отрезать http,https, ://
        urlMapper.setCutUrl(generateNewCutUrl());
        urlRepository.addNewUrlMapper(urlMapper);
    }

    @Override
    public List<UrlMapper> getAllUrlMappers() {
        return urlRepository.getAllUrlMappers();
    }

    @Override
    public void removeByCutUrl(String cutUrl) {
        if (urlRepository.existCutUrl(cutUrl)) {
            urlRepository.removeByCutUrl(cutUrl);
        }
    }

    private String generateNewCutUrl() {
        int lenght = environment.getProperty("urlcuter.link-lenght",Integer.class);
        Random random = new Random();

        String candidat;
        boolean isNewUrl;
        do {
            candidat = "";
            for (int i=0;i<lenght;i++) {
                int rand = random.nextInt(36);
                if (rand<10) {
                    candidat=candidat+Integer.toString(rand);
                } else {
                    int charcode=rand-10+97;
                    candidat=candidat+(char)charcode;
                }
            }

            isNewUrl = !urlRepository.existCutUrl(candidat);
        } while (!isNewUrl);

        return candidat;
    }
}
