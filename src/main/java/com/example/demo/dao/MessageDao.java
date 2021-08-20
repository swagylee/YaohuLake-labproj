package com.example.demo.dao;

import com.example.demo.entity.UpdatingMessage;

import java.util.List;

public interface MessageDao {
    int insertNewMessage(UpdatingMessage message);
    List<UpdatingMessage> listAllMessagesByTime();
}
