package com.bpe.zookeeper.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class TestSample {

    @Test
    public void sample() throws Exception {
        assertEquals("yes", "no", "This should fail");
    }
    
}
