package com.miChat.userAPI.controllers;

import com.miChat.userAPI.DTOs.UserCreateRequestBody;
import com.miChat.userAPI.models.UserModel;
import com.miChat.userAPI.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserModel>> getById(@PathVariable Long id){
        Optional<UserModel> user = userService.getById(id);
        return user.isPresent()?ResponseEntity.ok(user):ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<UserModel> create(@RequestBody UserCreateRequestBody body){                // <- @RequestBody get the data of request's body
        try {
            UserModel newUser = userService.create(body);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }catch (IllegalArgumentException e){
            System.out.printf("Error: %s\n", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    // ENDPOINT: /api/users/9
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){                                          // <- @PathVariable get the URL's vars
        boolean deleted = userService.delete(id);
        return deleted?ResponseEntity.noContent().build():ResponseEntity.notFound().build();
    }
}
