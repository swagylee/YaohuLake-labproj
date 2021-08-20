package com.example.demo.service;

import com.example.demo.entity.UpdatingMessage;

import java.util.List;

public interface MessageService {
    int insertNewMessage(UpdatingMessage message);
    List<UpdatingMessage> listAllMessagesByTime();
}
