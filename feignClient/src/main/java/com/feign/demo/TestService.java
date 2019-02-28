package com.feign.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="RIBBON-CLIENT")
public interface TestService {

    @RequestMapping("/test")
    String test();
}
