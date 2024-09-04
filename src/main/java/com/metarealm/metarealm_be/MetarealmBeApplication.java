package com.metarealm.metarealm_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // FeignClient 활성화
public class MetarealmBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetarealmBeApplication.class, args);
    }

}
