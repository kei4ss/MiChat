package com.miChat.userAPI.controllers;

import com.miChat.userAPI.DTOs.UserCreateRequestBody;
import com.miChat.userAPI.models.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private List<UserModel> users = new ArrayList<>();
    private int nextId = 1;

    @GetMapping
    public ResponseEntity<List<UserModel>> getAll(){
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<UserModel> create(@RequestBody UserCreateRequestBody newUser){
        UserModel newModelUser = newUser.toModel(nextId++);
        users.add(newModelUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(newModelUser);
    }
}
