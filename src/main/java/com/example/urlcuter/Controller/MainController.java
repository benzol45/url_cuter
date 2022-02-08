package com.example.urlcuter.Controller;

import com.example.urlcuter.Service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


@Controller
@RequestMapping("/cut")
public class MainController {
    private final UrlService urlService;

    @Autowired
    public MainController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/{cutUrl}")
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
}
