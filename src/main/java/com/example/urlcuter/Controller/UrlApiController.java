package com.example.urlcuter.Controller;

import com.example.urlcuter.Entity.UrlMapper;
import com.example.urlcuter.Service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
public class UrlApiController {
    //TODO Добавить авторизацию по токену
    private final UrlService urlService;

    @Autowired
    public UrlApiController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    public void addUrl(@RequestBody UrlMapper urlMapper) {
        urlService.addNewUrlMapper(urlMapper);
    }

    @DeleteMapping
    public void removeUrl(@RequestBody UrlMapper urlMapper) {
        urlService.removeByCutUrl(urlMapper.getCutUrl());
    }
}
