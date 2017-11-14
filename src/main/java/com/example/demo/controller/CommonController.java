package com.example.demo.controller;

import com.example.demo.common.Constants;
import com.example.demo.common.Result;
import com.example.demo.enums.Status;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j
public class CommonController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/detail")
    public String detail() {
        return "detail";
    }

    @RequestMapping("/login/{status}")
    @ResponseBody
    public Result login(@PathVariable String status) {
        Result result = new Result();
        log.info(status);
        result.setCode(Constants.SUCCESS.equals(status) ? Status.SUCCESS.getCode() : Status.FAILURE.getCode());
        return result;
    }
}
