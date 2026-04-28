package com.miChat.userAPI.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserModel {
    private int id;
    private String name;
    private String email;
    private String password;
    private boolean active;
}
