package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    @Cacheable(value = "allUsers")
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    public Page<User> findUsersByPage(Pageable pageable, User vo) {
        return userDao.findAll(pageable);
    }

    @Override
    @CacheEvict(value = "allUsers", allEntries = true)
    public void saveOrUpdateUser(User vo) {
        User user = null;
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        if (vo.getId() == 0){
            user = new User();
            BeanUtils.copyProperties(vo, user);
            user.setRole(1);
        }else{
            user = userDao.getOne(vo.getId());

        }
        user.setPassword(bc.encode(vo.getPassword()));
        userDao.save(user);
    }
}
