package com.example.bankservice.controller;

import com.example.bankservice.service.BankFrontService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BankController.class)
public class BankControllerTest {

    @MockBean
    BankFrontService service;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();
    private String bankJson;

    @Before
    public void setUp() throws Exception {

        BigDecimal balance = new BigDecimal(300);

        bankJson = mapper.writeValueAsString(balance);

        Mockito.when(service.getBalance(100)).thenReturn(balance);

    }

    @Test
    public void getBalance() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/100"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(bankJson));
    }

    @Test
    public void creditAccountBalance() throws Exception{
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.put("/admin")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8");

        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status()
                .isOk());

    }
}