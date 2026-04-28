package com.miChat.userAPI.services.impl;

import com.miChat.userAPI.DTOs.UserCreateRequestBody;
import com.miChat.userAPI.models.UserModel;
import com.miChat.userAPI.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final List<UserModel> userRepository = new ArrayList<>();
    private int nextId = 1;

    @Override
    public List<UserModel> getAll() {
        return List.copyOf(userRepository);
    }

    @Override
    public Optional<UserModel> getById(Long id) {
        return userRepository.stream().filter(u->u.getId()==id).findFirst();
    }

    @Override
    public UserModel create(UserCreateRequestBody body) {
        if(body.getName().isEmpty() || body.getName().isBlank()){
            throw  new IllegalArgumentException("'name' field is required!");
        }
        UserModel user = body.toModel(nextId++);
        userRepository.add(user);
        return user;
    }

    @Override
    public Boolean delete(Long id) {
        Optional<UserModel> user = userRepository.stream().filter(p->p.getId()==id).findFirst();
        return userRepository.remove(user.orElse(null));
    }
}
