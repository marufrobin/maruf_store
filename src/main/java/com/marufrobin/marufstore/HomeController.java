package com.marufrobin.marufstore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    private  String appName;

    @Value("${app.page-size}")
    private int pageSize;

    @RequestMapping("/")
    public String index() {
        System.out.println("App Name: " + appName);
        System.out.println("Page size: " + pageSize);
        return "index.html";
    }
}
