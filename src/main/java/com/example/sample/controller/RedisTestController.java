package com.example.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/test-redis")
    public String testRedis() {
        try {
            redisTemplate.opsForValue().set("testKey", "HelloRedis");
            String value = redisTemplate.opsForValue().get("testKey");
            return "Redis Working → " + value;
        } catch (Exception ex) {
            return "Redis NOT working → " + ex.getMessage();
        }
    }
}
