package xyz.shanmugavel.vscodepoc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping("/hello")
    @PreAuthorize("hasRole('sb-user-role')")
    public String hello() {
        return "Hello from Spring boot & Keycloak";
    }
    
    @GetMapping("/hello-2")
    @PreAuthorize("hasRole('sb-admin-role')")
    public String hello2() {
        return "*******Hello from Spring boot & Keycloak - ADMIN******";
    }
    
}
