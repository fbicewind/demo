package com.example.demo.service

import com.example.demo.entity.User

interface KotlinUserService {

    fun findByUsername(username: String): User
}