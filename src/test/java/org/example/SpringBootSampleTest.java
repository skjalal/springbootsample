package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringBootSampleTest {

    @Test
    void textContext() {
        assertTrue(1==1);
    }
}