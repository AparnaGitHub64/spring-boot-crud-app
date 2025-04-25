package com.example.springBootCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springBootCrud.model.Customer;
import com.example.springBootCrud.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // methods to get all customers and customer by id
    // http://localhost:8080/customers
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    // http://localhost:8080/customers/1
    // this method returns an Optional<Customer> object
    // which may or may not contain a Customer object with the given id.
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // methods to save customer
    // http://localhost:8080/customers
    // this method returns a Customer object
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // methods to delete customer
    // http://localhost:8080/customers/1
    // this method returns void
    // it deletes the customer with the given id from the database.
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
