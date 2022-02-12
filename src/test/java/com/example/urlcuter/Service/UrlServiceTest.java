package com.example.urlcuter.Service;

import com.example.urlcuter.Entity.UrlMapper;
import com.example.urlcuter.Repository.UrlRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
class UrlServiceTest {
    @Autowired
    UrlService urlService;
    @MockBean
    UrlRepository urlRepository;

    @Test
    void getFullUrlByCutUrl() {
        UrlMapper correct = new UrlMapper("g","google.com");
        when(urlRepository.getUrlMapperByCutUrl("g")).thenReturn(Optional.of(correct));

        UrlMapper expired = new UrlMapper("r","rabmler.ru");
        expired.setLiveTime(LocalDateTime.now().minusMonths(1));
        when(urlRepository.getUrlMapperByCutUrl("r")).thenReturn(Optional.of(expired));

        when(urlRepository.getUrlMapperByCutUrl("y")).thenReturn(Optional.empty());

        assertEquals("google.com",urlService.getFullUrlByCutUrl("g"));
        assertEquals("Exist",urlService.getFullUrlByCutUrl("r"));
        assertEquals("NotFound",urlService.getFullUrlByCutUrl("y"));

        verify(urlRepository,times(3)).getUrlMapperByCutUrl(anyString());
    }
}