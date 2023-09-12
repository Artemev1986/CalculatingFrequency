package com.example.calculatingfrequency;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FrequencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCalculateFrequency() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculateFrequency")
                        .param("inputString", "aaaaabcccc!@#$"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(7)))
                .andExpect(jsonPath("$.a").value(5))
                .andExpect(jsonPath("$.c").value(4))
                .andExpect(jsonPath("$.b").value(1))
                .andExpect(jsonPath("$.!").value(1))
                .andExpect(jsonPath("$.@").value(1))
                .andExpect(jsonPath("$.#").value(1))
                .andExpect(jsonPath("$.$").value(1))
                .andExpect(jsonPath("$.*", contains(5, 4, 1, 1, 1, 1, 1)));
    }
}
