package com.sb.springboot.web;

import com.sb.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {

        return "hello";
    }

    @GetMapping("/hello/1")
    public String hello1() {

        return "1";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {

        return new HelloResponseDto(name,amount);
    }
}
