package com.customerrest.app.service;

import com.customerrest.app.entity.Customer;
import com.customerrest.app.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CustomerRepository repository;

    public List<Customer> getAllCustomers() {
        try {
        List<Customer> customerList = (List<Customer>) repository.findAll();
        return customerList;
        }
        catch (Exception e){
            logger.debug("Baza je prazna");
            return null;
        }
    }

    public Customer getCustomerById (int id){
        try {
            Optional<Customer> customer = repository.findById(id);
            return customer.get();
        }
        catch (Exception e){
            logger.debug("Customera koji ima id: " + id +" ne postoji");
            return null;
        }
    }

    public void createCustomer(Customer customer){
        if (customer.getFirstName()!=null && customer.getLastName()!= null && customer.getEmail()!=null) {
            repository.save(customer);
        }
    }

    public void updateCustomerById (int id, Customer customer) {
        Optional<Customer> oldCustomer = repository.findById(id);
        Customer newCustomer = new Customer(customer.getFirstName(), customer.getLastName(), customer.getEmail());
        if (customer.getFirstName()==null){newCustomer.setFirstName(oldCustomer.get().getFirstName());}
        if (customer.getLastName()==null){newCustomer.setFirstName(oldCustomer.get().getLastName());}
        if (customer.getEmail()==null){newCustomer.setFirstName(oldCustomer.get().getEmail());}
        newCustomer.setId(id);
        repository.save(newCustomer);
    }


    public void deleteCustomerById(int id){
        try {
            Optional<Customer> customer = repository.findById(id);
            repository.deleteById(id);
        }
        catch (Exception e){
            logger.debug("Customer koji ima id: " + id +" ne postoji");
        }
    }
}
