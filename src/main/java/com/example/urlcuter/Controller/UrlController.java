package com.example.urlcuter.Controller;

import com.example.urlcuter.Entity.UrlMapper;
import com.example.urlcuter.Service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Controller
@RequestMapping("/url")
public class UrlController {
    UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    public void addUrl(@RequestParam("datetime")String datetime) {
        System.out.println(datetime);
        if (!datetime.equals("")) {
            LocalDateTime ldt = LocalDateTime.parse(datetime, DateTimeFormatter.ISO_DATE_TIME);
        } else {
            LocalDateTime ldt = null;
        }
    }

    @GetMapping("/delete/{cutUrl}")
    public void deleteCutUrl(@PathVariable("cutUrl") String cutUrl) {
        //TODO Реализовать удалиен ссылки
        throw new IllegalArgumentException("Не реализовано");
    }
}
