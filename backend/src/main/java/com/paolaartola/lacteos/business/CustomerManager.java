package com.paolaartola.lacteos.business;

import com.paolaartola.lacteos.entity.Customer;
import com.paolaartola.lacteos.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerManager {
    private final CustomerRepository customerRepository;

    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> all() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> update(Long id, Customer data) {
        return customerRepository.findById(id).map(actual -> {
            actual.setName(data.getName());
            actual.setEmail(data.getEmail());
            actual.setPhone(data.getPhone());
            return customerRepository.save(actual);
        });
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
} 