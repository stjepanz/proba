package com.customerrest.app.controller;

import com.customerrest.app.entity.Customer;
import com.customerrest.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping("")
    public List<Customer> getAllCustomers(){
        List<Customer> list = service.getAllCustomers();
        return list;
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") int id){
        Customer customer= service.getCustomerById(id);
        return customer;
    }

    @PostMapping("")
    public void createCustomer (@RequestBody Customer customer){
        service.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer){
        service.updateCustomerById(id, customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable("id") int id){
        service.deleteCustomerById(id);
    }
}
