package org.huangge.userservice.controller;

import org.huangge.commonmodule.entity.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/login")
public class UserController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping(value = "/login")
    public String login() {

        String token = JwtUtil.getToken("123456");
        redisTemplate.opsForValue().set("token:"+token, token,60, TimeUnit.MINUTES);
        return token;

    }
}
