package com.example.urlcuter.Controller;

import com.example.urlcuter.Entity.UrlMapper;
import com.example.urlcuter.Service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller
public class MainController {
    private final UrlService urlService;

    @Autowired
    public MainController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/cut/{cutUrl}")
    public String getMain(@PathVariable String cutUrl, @CookieValue(name = "ClientID", defaultValue = "") String clientID, HttpServletResponse httpServletResponse){
        if (clientID.equals("")) {
            clientID = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("ClientID", clientID);
            cookie.setPath("/");
            cookie.setMaxAge(365*24*60*60);
            httpServletResponse.addCookie(cookie);
        }

        String goTo = urlService.processingVizit(cutUrl,clientID);
        return "redirect:" + goTo;
    }

    @GetMapping("/add")
    public String getAdd(Model model){
        //TODO Добавить авторизацию
        List<UrlMapper> urlMappers = urlService.getAllUrlMappers();
        model.addAttribute("urlMappers",urlMappers);

        model.addAttribute("addedUrlMapper",new UrlMapper("t","test"));

        return "add";
    }
}
