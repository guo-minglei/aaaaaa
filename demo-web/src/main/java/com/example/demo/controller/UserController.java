package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public boolean save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping
    public boolean update(@RequestBody User user) {
        return userService.updateById(user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return userService.removeById(id);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }

    @GetMapping("/page")
    public Page<User> page(@RequestParam(defaultValue = "1") Integer current,
                          @RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(required = false) String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (username != null && !username.isEmpty()) {
            queryWrapper.like("username", username);
        }
        return userService.page(new Page<>(current, size), queryWrapper);
    }
} 