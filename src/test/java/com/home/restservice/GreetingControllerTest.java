package com.home.restservice;

import com.home.algorithms.AlgorithmsApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest(classes = AlgorithmsApplication.class)

@AutoConfigureRestTestClient
class GreetingControllerTest {
    @Autowired
    private RestTestClient restTestClient;

    @Test
    void greetingShouldReturnDefaultMessage() {
        restTestClient.get().uri("/")
                .exchange()
                .expectBody(String.class)
                .isEqualTo("Greetings from Spring Boot!");
    }
}