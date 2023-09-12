package com.example.calculatingfrequency;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FrequencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCalculateFrequencyWithMixedInput() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculateFrequency")
                        .param("inputString", "abcABC1!23!!!@#"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.a").value(1))
                .andExpect(jsonPath("$.b").value(1))
                .andExpect(jsonPath("$.c").value(1))
                .andExpect(jsonPath("$.A").value(1))
                .andExpect(jsonPath("$.B").value(1))
                .andExpect(jsonPath("$.C").value(1))
                .andExpect(jsonPath("$.1").value(1))
                .andExpect(jsonPath("$.2").value(1))
                .andExpect(jsonPath("$.3").value(1))
                .andExpect(jsonPath("$.!").value(4))
                .andExpect(jsonPath("$.@").value(1))
                .andExpect(jsonPath("$.#").value(1));
    }
}
