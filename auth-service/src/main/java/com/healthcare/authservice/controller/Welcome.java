package com.healthcare.authservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Controller ke methods ka return value direct JSON (ya plain text) ke form mein client ko bhejna.
@RequestMapping("/api/v1/admin/")
public class Welcome {

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

}
