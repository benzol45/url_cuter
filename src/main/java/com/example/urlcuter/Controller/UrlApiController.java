package com.example.urlcuter.Controller;

import com.example.urlcuter.Entity.UrlMapper;
import com.example.urlcuter.Service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/url")
public class UrlApiController {
    UrlService urlService;

    @Autowired
    public UrlApiController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    public void addUrl(@RequestBody UrlMapper urlMapper) {
        urlService.addNewUrlMapper(urlMapper);
    }
}
