package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
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
}
