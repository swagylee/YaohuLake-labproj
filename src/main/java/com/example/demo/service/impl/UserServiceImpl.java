package com.example.demo.service.impl;


import java.util.List;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public UserServiceImpl() {
    }

    public boolean addUser(User user) {
        if (user.getUserPassword() != null && !"".equals(user.getUserPassword()) && user.getUserName() != null && !"".equals(user.getUserName())) {
            int effectnum = this.userDao.addUser(user);
            if (effectnum > 0) {
                return true;
            } else {
                throw new RuntimeException("插入用户信息失败");
            }
        } else {
            throw new RuntimeException("添加用户失败!,请重新输入注册信息。");
        }
    }

    public boolean deleteUser(Long userAccount) {
        int effectNum = this.userDao.deleteUser(userAccount);
        if (effectNum > 0) {
            return true;
        } else {
            throw new RuntimeException("删除用户失败!");
        }
    }

    public List<User> queryAllUsers() {
        return this.userDao.queryAllUsers();
    }

    public User queryUserByAccount(Long userAccount) {
        User user = this.userDao.queryUserByAccount(userAccount);
        if (user == null) {
            throw new RuntimeException("检索不到当前用户，请检查账户值是否合法。");
        } else {
            return user;
        }
    }
}
