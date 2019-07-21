package com.example.boot.bootdemo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Map HandleError(MissingServletRequestParameterException e) {
        log.warn("Missing Request Parameter", e);
        Map<String, Object> map = new HashMap<String, Object>(2, 1F);
        map.put("error_code", "0001");
        map.put("message", "miss request parameter");
        return map;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public Map handleError(NoHandlerFoundException e) {
        log.warn("No Handler Found", e);
        Map<String, Object> map = new HashMap<String, Object>(2, 1F);
        map.put("error_code", "0002");
        map.put("message", "no handler found...");
        return map;
    }
}
