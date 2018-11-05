package io.neko.statisticsservice.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.neko.statisticsservice.dto.TransactionRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testCreateTransactionWithValidDate() throws Exception {
        TransactionRequest request = new TransactionRequest(10.0, Instant.now().toEpochMilli());

        mockMvc.perform(post("/transactions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsBytes(request)))
            .andExpect(status().isCreated())
            .andExpect(content().string(""));
    }

    @Test
    public void testCreateTransactionWithInvalidDate() throws Exception {
        TransactionRequest request = new TransactionRequest(10.0, 0);

        mockMvc.perform(post("/transactions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsBytes(request)))
            .andExpect(status().isNoContent())
            .andExpect(content().string(""));
    }

}
