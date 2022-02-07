package com.example.urlcuter.Controller;

import com.example.urlcuter.Service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    public String getMain(@PathVariable String cutUrl, @CookieValue(name = "ClientID", defaultValue = "") String ClientID, HttpServletResponse httpServletResponse){
        if (ClientID.equals("")) {
            Cookie cookie = new Cookie("ClientID", UUID.randomUUID().toString());
            cookie.setMaxAge(1000);
            httpServletResponse.addCookie(cookie);
        } else
            System.out.println(ClientID);

        return "redirect://" + urlService.getFullUrlByCutUrl(cutUrl);
    }
}
