package com.example.boot.bootdemo.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GlobalErrorController implements ErrorController {
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {

        Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object exception = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        if (statusCode != null && (Integer) statusCode == HttpStatus.NOT_FOUND.value()) {
            Map<String, Object> modeMap = new HashMap<String, Object>();
            modeMap.put("title", "NOT FOUND");
            modeMap.put("imageBase64", "");
            modeMap.put("explanation", exception);
            modeMap.put("linkHref", "http://www.google.com");
            modeMap.put("linkText", "首页");
            model.addAllAttributes(modeMap);
        }
        return "error";
    }
}
