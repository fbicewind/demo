package com.example.demo.controller;

import com.example.demo.entity.User;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j
public class CommonController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/detail")
    public String detail() {
        return "detail";
    }

    @GetMapping("/test")
    public String test(User user){
        log.info(user.getUsername());
        return "detail";
    }
}
