package org.huangge.userservice.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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

    @GetMapping(value = "/testSlowTime")
    public String testSlowTime() throws InterruptedException {

        TimeUnit.SECONDS.sleep(1L);
        return "shui 1 miao";

    }

    @GetMapping(value = "/errorException")
    public String errorException() {

        int i = 1 / 0;
        return "error";

    }

    @GetMapping(value = "/RedisHoot")
    @SentinelResource(value = "RedisHoot",blockHandler = "limitCode")
    public String downLevel(@RequestParam(value = "id",required = false) String id, @RequestParam(value = "name",required = false) String name) {
        System.out.println("统计一次");
        return "热点限制情况" + id;

    }

    public String limitCode(String id, String name, BlockException ex) {
        return "这就是限流";
    }
}
