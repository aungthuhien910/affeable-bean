package com.example.relationshipexample.dao;

import com.example.relationshipexample.ds.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer,Integer> {
}
