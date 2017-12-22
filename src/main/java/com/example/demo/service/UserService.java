package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    public User findByUsername(String username);

    public List<User> findAllUsers();

    public Page<User> findUsersByPage(Pageable pageable, User vo);

    public void saveOrUpdateUser(User vo);

}
