package com.cellthinking.stock.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class TestController {

    @PostMapping("/login")
    public String testLogin(){
        return "hello,world";
    }
}
