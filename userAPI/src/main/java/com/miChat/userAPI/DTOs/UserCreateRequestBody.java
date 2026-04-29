package com.miChat.userAPI.DTOs;

import com.miChat.userAPI.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserCreateRequestBody {
    private String name;
    private String email;
    private String password;

    public UserModel toModel(){
        return new UserModel(name, email, password);
    }
}
