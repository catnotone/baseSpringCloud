package org.huangge.pointserver.controller;

import org.huangge.commonmodule.entity.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/point")
public class PointController {

    @GetMapping(value = "/test")
    public String test() {
        return "test  app-point-service";
    }

    @PostMapping(value = "/add")
    public String add(@RequestBody Order order) {

        return "商品的名称3是"+ order.getName();
    }
}
