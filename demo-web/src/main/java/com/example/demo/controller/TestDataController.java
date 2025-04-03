package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestDataController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/init-data")
    public String initData() {
        // 只有没有数据时才添加
        if (userService.count() == 0) {
            // 添加测试用户1
            User user1 = new User();
            user1.setUsername("admin");
            user1.setPassword("123456");
            user1.setEmail("admin@example.com");
            userService.save(user1);
            
            // 添加测试用户2
            User user2 = new User();
            user2.setUsername("test");
            user2.setPassword("123456");
            user2.setEmail("test@example.com");
            userService.save(user2);
            
            return "成功添加测试数据";
        }
        
        return "已存在数据，无需初始化";
    }
} 