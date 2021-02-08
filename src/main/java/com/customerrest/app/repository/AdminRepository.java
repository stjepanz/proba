package com.customerrest.app.repository;

import com.customerrest.app.entity.Customer;
import com.customerrest.app.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Users, Integer> {
}
