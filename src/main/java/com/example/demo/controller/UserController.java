package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.enums.Status;
import com.example.demo.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
@Log4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("getAllUsers")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("getUserByPage")
    public Page<User> getUserByPage(User vo, @PageableDefault(sort = {"username"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return userService.findUsersByPage(pageable, vo);
    }

    @GetMapping("validateName")
    public Result validateName(String username){
        Result result = new Result();
        User user = userService.findByUsername(username);
        if (user == null){
            result.setCode(Status.SUCCESS.getCode());
        }else{
            result.setCode(Status.FAILURE.getCode());
        }
        return result;
    }

    @PostMapping("saveUser")
    public  Result saveuser(User vo){
        Result result = new Result();
        try{
            userService.saveOrUpdateUser(vo);
            result.setCode(Status.SUCCESS.getCode());
        } catch (Exception e) {
            log.error("Save User Error: ", e);
            result.setCode(Status.FAILURE.getCode());
        }
        return result;
    }
}
