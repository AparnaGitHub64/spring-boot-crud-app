package com.example.springBootCrud.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springBootCrud.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    // Custom query methods can be defined here if needed

    // Built-in CRUD Methods You Get for Free:
    // Here are some useful methods you get automatically from CrudRepository:

    // Method Description
    // ------------------------
    // save(entity) Insert or update a customer
    // findById(id) Find customer by ID (returns Optional<Customer>)
    // findAll() Get a list of all customers
    // deleteById(id) Delete customer by ID
    // delete(entity) Delete a specific customer object
    // existsById(id) Check if a customer exists by ID
    // count() Returns total number of records

}
