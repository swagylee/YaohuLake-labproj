package com.example.demo.service;


import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    boolean addUser(User user);

    boolean deleteUser(Long userAccount);

    List<User> queryAllUsers();

    User queryUserByAccount(Long userAccount);


}
