package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;


@Service
@Transactional
public class UserServiceImp implements UserService {

@Autowired
UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User get(int id) {

        return userRepository.findById(id).get();
    }

    @Override
    public void update(User user, Integer id) {
        userRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("User"));
        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }


}
