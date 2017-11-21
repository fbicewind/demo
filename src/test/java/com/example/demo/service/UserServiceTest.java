package com.example.demo.service;

import com.example.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private KotlinUserService kotlinUserService;

    @Test
    public void test(){
        User user = userService.findByUsername("test");
        System.out.println(user.toString());
    }

    @Test
    public void testKotlin(){
        User user = kotlinUserService.findByUsername("test");
        System.out.println(user.toString());
    }
}
