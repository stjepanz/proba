package com.customerrest.app.service;

import com.customerrest.app.entity.Customer;
import com.customerrest.app.entity.Users;
import com.customerrest.app.repository.AdminRepository;
import com.customerrest.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {



    @Autowired
    AdminRepository repository;

    public List<Users> getAllUsers() {
        List<Users> userList = (List<Users>) repository.findAll();
        return userList;
    }

    public Users getUsersById (int id){
        Optional<Users> user = repository.findById(id);
        return user.get();
    }

    public void createUser(Users user){
        repository.save(user);
    }

    public void updateUserById (int id, Users user) {
        Users newUser = new Users(user.getUsername(), user.getPassword(), user.getRoles());
        newUser.setId(id);
        repository.save(newUser);
    }


    public void deleteUserById(int id){
        Optional<Users> user = repository.findById(id);
        repository.deleteById(id);
    }
}

