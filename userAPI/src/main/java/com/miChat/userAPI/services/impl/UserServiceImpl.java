package com.miChat.userAPI.services.impl;

import com.miChat.userAPI.DTOs.UserCreateRequestBody;
import com.miChat.userAPI.models.UserModel;
import com.miChat.userAPI.repositories.UserRepository;
import com.miChat.userAPI.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> getById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public UserModel create(UserCreateRequestBody body) {
        if(body.getName().isEmpty() || body.getName().isBlank()){
            throw  new IllegalArgumentException("'name' field is required!");
        }
        return userRepository.save(body.toModel());
    }

    @Override
    public Boolean delete(String id) {
        Optional<UserModel> user = userRepository.findById(id);
        if(user.isEmpty()) return false;

        userRepository.delete(user.get());
        return true;
    }
}
