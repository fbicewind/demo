package com.example.demo.service.impl

import com.example.demo.dao.UserDao
import com.example.demo.entity.User
import com.example.demo.service.KotlinUserService
import org.springframework.stereotype.Service

@Service
class KotlinUserServiceImpl(val userDao: UserDao) : KotlinUserService {

    override fun findByUsername(username: String): User {
        return userDao.findByUsername(username)
    }
}