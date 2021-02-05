package com.customerrest.app.service;

import com.customerrest.app.entity.Customer;
import com.customerrest.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public List<Customer> getAllCustomers() {
        List<Customer> customerList = (List<Customer>) repository.findAll();
        return customerList;
    }

    public Customer getCustomerById (int id){
        Optional<Customer> customer = repository.findById(id);
        return customer.get();
    }

    public void createCustomer(Customer customer){
        repository.save(customer);
    }

    public void updateCustomerById (int id, Customer customer) {
        Customer newCustomer = new Customer(customer.getFirstName(), customer.getLastName(), customer.getEmail());
        newCustomer.setId(id);
        repository.save(newCustomer);
    }


    public void deleteCustomerById(int id){
        Optional<Customer> customer = repository.findById(id);
        repository.deleteById(id);
    }
}
