package com.paolaartola.lacteos.service;

import com.paolaartola.lacteos.dto.CustomerDTO;

import java.util.List;

public interface ClienteService {
    List<CustomerDTO> all();
    CustomerDTO findById(Long id);
    CustomerDTO create(CustomerDTO dto);
    CustomerDTO update(Long id, CustomerDTO dto);
    void delete(Long id);
} 