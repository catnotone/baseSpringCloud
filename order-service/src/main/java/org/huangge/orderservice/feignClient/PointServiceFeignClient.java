package org.huangge.orderservice.feignClient;

import org.huangge.commonmodule.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "point-server")
public interface PointServiceFeignClient {


    @PostMapping(value = "/point/add")
    String add(@RequestBody Order order);
}
