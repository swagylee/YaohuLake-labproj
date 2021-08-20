package com.example.demo.service.impl;

import com.example.demo.dao.MessageDao;
import com.example.demo.entity.UpdatingMessage;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageDao dao;
    @Transactional
    public int insertNewMessage(UpdatingMessage message) {
        int effectedNum = this.dao.insertNewMessage(message);
        if (effectedNum > 0) {
            return effectedNum;
        } else {
            throw new RuntimeException("加入菜品信息失败");
        }
    }


    @Override
    public List<UpdatingMessage> listAllMessagesByTime() {
        return dao.listAllMessagesByTime();
    }
}
