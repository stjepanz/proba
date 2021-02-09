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
        try {
            List<Users> userList = (List<Users>) repository.findAll();
            return userList;
        }
        catch (Exception e){
            return null;
        }
    }

    public Users getUsersById (int id){
        try {
            Optional<Users> user = repository.findById(id);
            return user.get();
        }
        catch (Exception e){
            return null;
        }
    }

    public void createUser(Users user) {
        if (user.getUsername()!=null && user.getPassword()!= null && user.getRoles()!=null){
            repository.save(user);
        }

    }

    public void updateUserById (int id, Users user) {
        Optional<Users> odlUser = repository.findById(id);
        Users newUser = new Users(user.getUsername(), user.getPassword(), user.getRoles());
        if (user.getUsername()==null){newUser.setUsername(odlUser.get().getUsername());}
        if (user.getPassword()==null){newUser.setPassword(odlUser.get().getPassword());}
        if (user.getRoles()==null){newUser.setRoles(odlUser.get().getRoles());}
        newUser.setId(id);
        repository.save(newUser);
    }


    public void deleteUserById(int id){
        try {
            Optional<Users> user = repository.findById(id);
            repository.deleteById(id);
        }
        catch (Exception e){}
    }
}

