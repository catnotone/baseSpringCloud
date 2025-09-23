package org.huangge.orderservice.controller;

import org.huangge.commonmodule.entity.Order;
import org.huangge.orderservice.feignClient.PointServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
@RefreshScope
public class OrderController {
    @Value("${config.info}")
    private String info;

    @Autowired
    private PointServiceFeignClient feignClient;

    @GetMapping(value = "/test")
    public String test()
    {
        return "test  app-order-service";
    }

    @GetMapping(value = "/test/getNacosInfo")
    public String getNacosInfo() {
        return info;
    }

    @PostMapping(value = "/addShop")
    public String addShop() {
        Order order = new Order();
        order.setName("打掉");
        order.setId("123");
        String msg = feignClient.add(order);
        return msg;
    }
}
