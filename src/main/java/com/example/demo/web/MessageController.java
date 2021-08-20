package com.example.demo.web;

import com.example.demo.entity.Shop;
import com.example.demo.entity.UpdatingMessage;
import com.example.demo.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/yhl"})
public class MessageController {
    @Autowired
    MessageServiceImpl messageService;
    @RequestMapping(
            value = {"listallmessages"},
            method = {RequestMethod.GET}
    )
    private Map<String, Object> queryMessages() {
        Map<String, Object> modelMap = new HashMap();
        List<UpdatingMessage> list = this.messageService.listAllMessagesByTime();
        modelMap.put("success", list);
        return modelMap;
    }

    @RequestMapping(
            value = {"createMessage"},
            method = {RequestMethod.POST}
    )
    private Map<String, Object> createMessage(@RequestBody(required = false) UpdatingMessage message){
        Map<String, Object> data = new HashMap();
        data.put("success", this.messageService.insertNewMessage(message));
        return data;
    }

}
