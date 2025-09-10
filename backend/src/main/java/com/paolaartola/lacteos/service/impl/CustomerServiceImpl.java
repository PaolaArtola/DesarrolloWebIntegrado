package com.paolaartola.lacteos.service.impl;

import com.paolaartola.lacteos.business.CustomerManager;
import com.paolaartola.lacteos.dto.CustomerDTO;
import com.paolaartola.lacteos.entity.Customer;
import com.paolaartola.lacteos.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ClienteService {
    private final CustomerManager customerManager;

    public CustomerServiceImpl(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    @Override
    public List<CustomerDTO> all() {
        return customerManager.all().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(Long id) {
        Optional<Customer> opt = customerManager.findById(id);
        return opt.map(this::toDto).orElse(null);
    }

    @Override
    public CustomerDTO create(CustomerDTO dto) {
        Customer created = customerManager.create(toEntity(dto));
        return toDto(created);
    }

    @Override
    public CustomerDTO update(Long id, CustomerDTO dto) {
        return customerManager.update(id, toEntity(dto)).map(this::toDto).orElse(null);
    }

    @Override
    public void delete(Long id) {
        customerManager.delete(id);
    }

    private CustomerDTO toDto(Customer entity) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        return dto;
    }

    private Customer toEntity(CustomerDTO dto) {
        Customer entity = new Customer();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        return entity;
    }
} 