package com.customerrest.app.controller;

import com.customerrest.app.entity.Customer;
import com.customerrest.app.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CustomerService service;

    @GetMapping("")
    public List<Customer> getAllCustomers(){
        logger.debug("Dohvacanje svih customera");
        List<Customer> list = service.getAllCustomers();
        return list;
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") int id){
        logger.debug("Dohvacanje customera koji ima id: "+id);
        Customer customer= service.getCustomerById(id);
        return customer;
    }

    @PostMapping("")
    public void createCustomer (@RequestBody Customer customer){
        logger.debug("Dodavanje novog customera");
        service.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer){
        logger.debug("Updateanje customera koji ima id: "+id);
        service.updateCustomerById(id, customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable("id") int id){
        logger.debug("Brisanje customera koji ima id: "+id);
        service.deleteCustomerById(id);
    }
}
