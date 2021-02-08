package com.customerrest.app.controller;

import com.customerrest.app.entity.Customer;
import com.customerrest.app.entity.Users;
import com.customerrest.app.service.AdminService;
import com.customerrest.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AdminController {

    @Autowired
    AdminService service;

    @GetMapping("")
    public List<Users> getAllUsers(){
        List<Users> list = service.getAllUsers();
        return list;
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable("id") int id){
        Users user= service.getUsersById(id);
        return user;
    }

    @PostMapping("")
    public void createUser (@RequestBody Users user){
        service.createUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") int id, @RequestBody Users user){
        service.updateUserById(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") int id){
        service.deleteUserById(id);
    }
}

