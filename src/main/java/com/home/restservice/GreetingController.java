package com.home.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
class GreetingController {
    private static final String template = "Ahoj, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(defaultValue = "Earth") String name) {
        return new Greeting(counter.incrementAndGet(), template.formatted(name));
    }
}
