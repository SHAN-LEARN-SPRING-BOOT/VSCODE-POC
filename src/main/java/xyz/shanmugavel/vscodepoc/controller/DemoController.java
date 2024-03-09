package xyz.shanmugavel.vscodepoc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring boot & Keycloak";
    }
    
    @GetMapping("/hello-2")
    public String hello2() {
        return "*******Hello from Spring boot & Keycloak - ADMIN******";
    }
    
}
