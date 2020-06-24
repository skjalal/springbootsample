package org.example.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IndexControllerTest {

    private static final String INDEX = "This is Spring boot application";
    private static final String URL = "/api/index";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    IndexController indexController;

    @Test
    void index() {
        String index = indexController.index();
        Assertions.assertEquals(INDEX, index);
    }

    @Test
    void indexMvc() throws Exception {
        mockMvc.perform(get(URL))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(INDEX)));
    }
}