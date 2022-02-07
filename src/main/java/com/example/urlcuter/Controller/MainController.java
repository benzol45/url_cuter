package com.example.urlcuter.Controller;

import com.example.urlcuter.Service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/cut")
public class MainController {
    private final UrlService urlService;

    @Autowired
    public MainController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/{cutUrl}")
    public String getMain(@PathVariable String cutUrl){
        return "redirect://" + urlService.getFullUrlByCutUrl(cutUrl);
    }
}
