package com.example.demo.dao;

import com.example.demo.entity.User;

import java.util.List;

public interface UserDao {
    int addUser(User user);

    int deleteUser(Long userAccount);

    List<User> queryAllUsers();

    User queryUserByAccount(Long userAccount);

    List<User> getUsersOrders();
}

