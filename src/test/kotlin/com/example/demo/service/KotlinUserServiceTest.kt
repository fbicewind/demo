package com.example.demo.service

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class KotlinUserServiceTest {

    @Autowired
    lateinit var userService: UserService
    @Autowired
    lateinit var kotlinUserService: KotlinUserService

    @Test
    fun findByUsername() {
        val username = "test"
        val user = userService.findByUsername(username)
        println(user.toString())
    }

    @Test
    fun findUsingKotlin(){
        val username = "test"
        val user = kotlinUserService.findByUsername(username)
        println(user.toString())
    }
}