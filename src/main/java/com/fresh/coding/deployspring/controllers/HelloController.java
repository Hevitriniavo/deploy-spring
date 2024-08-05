package com.fresh.coding.deployspring.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/hello")
public class HelloController {
    private final String msg;

    public HelloController(@Value("${greeting.msg}") String msg) {
        this.msg = msg;
    }

    @RequestMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> greeting() {
        return Map.of("message", msg);
    }
}
