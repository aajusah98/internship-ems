package com.internship.ems.controller;

import com.internship.ems.model.User;
import com.internship.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService service;

        @GetMapping("/users")
    public List<User> getAllUser(){
        return service.getAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping("/users")
    public User getUserById(@RequestBody User user){
        return service.save(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userinfo) {
        return service.updateUser(id, userinfo);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> removeUser(@PathVariable Long id){
        try {
            service.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
