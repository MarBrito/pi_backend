package com.grupo7.airbnbclone.controller;

import com.grupo7.airbnbclone.model.User;
import com.grupo7.airbnbclone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> searchById(@PathVariable Integer id){
        return ResponseEntity.ok(userService.searchUserById(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<User>> searchAll(){
        return ResponseEntity.ok(userService.searchAllUsers());
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user){
        ResponseEntity<User> response = null;
        if (user.getId() != null && userService.searchUserById(user.getId()).isPresent()){
            response = ResponseEntity.ok(userService.updateUser(user));
        }
        else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        if(userService.searchUserById(id).isPresent()){
            userService.deleteUser(id);
        }
        else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

}
