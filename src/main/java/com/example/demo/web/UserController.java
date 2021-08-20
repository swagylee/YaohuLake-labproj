package com.example.demo.web;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.entity.User;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/yhl"})
public class UserController {
    @Autowired
    UserServiceImpl userService;

    public UserController() {
    }

    @RequestMapping(
            value = {"listallusers"},
            method = {RequestMethod.GET}
    )
    private Map<String, Object> queryUsers() {
        Map<String, Object> modelMap = new HashMap();
        List<User> list = this.userService.queryAllUsers();
        modelMap.put("success", list);
        return modelMap;
    }

    @RequestMapping(
            value = {"listoneuser"},
            method = {RequestMethod.GET}
    )
    private User queryUserByAccount(Long account) {
        User user = this.userService.queryUserByAccount(account);
        return user;
    }

//    @RequestMapping(
//            value = {"listorders"},
//            method = {RequestMethod.GET}
//    )
//    private Map<String, Object> listUsersOrders() {
//        Map<String, Object> modelMap = new HashMap();
//        List<User> list = this.userService.getUsersOrders();
//        modelMap.put("success", list);
//        return modelMap;
//    }

    @RequestMapping(
            value = {"adduser"},
            method = {RequestMethod.POST}
    )
    private void addUser(@RequestBody User user) {
        this.userService.addUser(user);
    }

    @RequestMapping(
            value = {"deleteuser"},
            method = {RequestMethod.POST}
    )
    private void deleteUserByAccount(Long account) {
        this.userService.deleteUser(account);
    }
}
