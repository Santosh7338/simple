package com.example.sample.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisDebugController {

    @Value("${spring.redis.host}") 
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String pass;

    @GetMapping("/redis-info")
    public String info(){
        return "Redis Host: " + host + " | Port: " + port + " | Password: " + pass;
    }
}
