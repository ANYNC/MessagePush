package com.anyn.messagePush.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @RequestMapping("test")
    private String testa() {
        return "aaaaa";
    }
}
