package com.senai.primeiraaplicacaoweb.service;

import com.senai.primeiraaplicacaoweb.model.UserModel;
import com.senai.primeiraaplicacaoweb.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserModel save(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public Optional<UserModel> findById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

}
