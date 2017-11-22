package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDao extends JpaRepository<User, Integer>, PagingAndSortingRepository<User, Integer> {

    public User findByUsername(String username);

}
