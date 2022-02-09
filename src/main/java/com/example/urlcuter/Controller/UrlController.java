package com.example.urlcuter.Controller;

import com.example.urlcuter.Entity.UrlMapper;
import com.example.urlcuter.Service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Controller
public class UrlController {
    private final UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/url")
    public String getAdd(Model model){
        //TODO Добавить авторизацию
        List<UrlMapper> urlMappers = urlService.getAllUrlMappers();
        model.addAttribute("urlMappers",urlMappers);

        return "add";
    }

    @PostMapping("/url")
    public String addUrl(@RequestParam("datetime")String datetime, @RequestParam("full_url")String full_url, Model model) {
        LocalDateTime ldt;
        if (!datetime.equals("")) {
            ldt = LocalDateTime.parse(datetime, DateTimeFormatter.ISO_DATE_TIME);
        } else {
            ldt = null;
        }

        UrlMapper urlMapper = new UrlMapper(null,full_url);
        urlMapper.setLiveTime(ldt);
        urlService.addNewUrlMapper(urlMapper);
        model.addAttribute("addedUrlMapper",urlMapper);

        List<UrlMapper> urlMappers = urlService.getAllUrlMappers();
        model.addAttribute("urlMappers",urlMappers);

        return "add";
    }

    @GetMapping("/url/delete/{cutUrl}")
    public String deleteCutUrl(@PathVariable("cutUrl") String cutUrl) {
        urlService.removeByCutUrl(cutUrl);

        return "redirect:/url";
    }
}
