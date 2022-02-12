package com.example.urlcuter.Controller;

import com.example.urlcuter.Entity.UrlMapper;
import com.example.urlcuter.Repository.UrlRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class UrlControllerTest {

    @MockBean
    UrlRepository urlRepository;

    @Test
    void addUrl() {
        when(urlRepository.existCutUrl(anyString())).thenReturn(false);

    }

    @Test
    void deleteCutUrl() {
    }
}