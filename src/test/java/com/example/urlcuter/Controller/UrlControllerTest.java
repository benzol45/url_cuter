package com.example.urlcuter.Controller;

import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.not;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.example.urlcuter.Entity.UrlMapper;
import com.example.urlcuter.Repository.UrlRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
@Sql(value = {"classpath:cleanShema.sql","classpath:shema.sql","classpath:testData.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "classpath:cleanShema.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class UrlControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void addUrl() throws Exception{
        mockMvc.perform(post("/url").param("datetime","").param("full_url","http://test_url")).andDo(print()).
                andExpect(status().isOk()).
                andExpect(content().string(containsString("full_url")));
    }

    @Test
    void deleteCutUrl() throws Exception {
        mockMvc.perform(get("/url/")).andDo(print()).
                andExpect(status().isOk()).
                andExpect(content().string(containsString("remove_test")));

        mockMvc.perform(get("/url/delete/remove")).andDo(print()).
                andExpect(status().is3xxRedirection()).
                andExpect(redirectedUrl("/url"));

        mockMvc.perform(get("/url/")).andDo(print()).
                andExpect(status().isOk()).
                andExpect(content().string(not(containsString("remove_test"))));
    }
}