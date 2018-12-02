package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get")
    public List<User> getAllUser(){

        return userService.getAllUser();

    }
    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Integer id){

        return userService.get(id);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable(value="id") Integer id, @RequestBody User user){

        userService.update(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value="id") Integer id){

        userService.deleteById(id);
    }



}
