package com.example.demo.handler;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    public GlobalExceptionHandler() {
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    private Map<String, Object> exceptionHandler(HttpServletRequest req, Exception e) {
        Map<String, Object> modelMap = new HashMap();
        modelMap.put("success", false);
        modelMap.put("errMsg", e.getMessage());
        return modelMap;
    }
}

