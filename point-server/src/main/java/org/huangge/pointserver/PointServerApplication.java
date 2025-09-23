package org.huangge.pointserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.annotation.RequestScope;

@SpringBootApplication
@RequestScope
public class PointServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PointServerApplication.class, args);
    }

}
