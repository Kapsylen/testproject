package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUser();

    public User get(int id);

    public void update(User user, Integer id);

    public void deleteById(int id);

}
