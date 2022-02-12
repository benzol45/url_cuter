package com.example.urlcuter.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
@Sql(value = {"classpath:cleanShema.sql","classpath:shema.sql","classpath:testData.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "classpath:cleanShema.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class MainControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void getMainCorrectRedirect() throws Exception{
        mockMvc.perform(get("/cut/g")).andDo(print()).
                andExpect(status().is3xxRedirection()).
                andExpect(redirectedUrl("//google.com"));
    }

    @Test
    void getMainNotFoundRedirect() throws Exception {
        mockMvc.perform(get("/cut/r")).andDo(print()).
                andExpect(status().is3xxRedirection()).
                andExpect(redirectedUrl("/NotFound.html"));
    }

    @Test
    void getMainExistRedirect() throws Exception {
        mockMvc.perform(get("/cut/y")).andDo(print()).
                andExpect(status().is3xxRedirection()).
                andExpect(redirectedUrl("/Exist.html"));
    }
}