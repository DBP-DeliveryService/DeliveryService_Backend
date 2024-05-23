package com.deliveryapp.domain;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("Hello!!");
    }

//    @GetMapping("/test2")
//    public ResponseCustom<?> test2() {
//        return ResponseCustom.OK(new Message("a"));
//    }


}

