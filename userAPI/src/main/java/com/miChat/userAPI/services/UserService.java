package com.miChat.userAPI.services;


import com.miChat.userAPI.DTOs.UserCreateRequestBody;
import com.miChat.userAPI.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserModel> getAll();
    Optional<UserModel> getById(String id);
    UserModel create(UserCreateRequestBody body);
    Boolean delete (String id);
}
