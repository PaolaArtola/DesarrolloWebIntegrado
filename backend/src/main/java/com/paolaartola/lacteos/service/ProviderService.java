package com.paolaartola.lacteos.service;

import com.paolaartola.lacteos.dto.ProviderDTO;

import java.util.List;

public interface ProviderService {
    List<ProviderDTO> all();
    ProviderDTO findById(Long id);
    ProviderDTO create(ProviderDTO dto);
    ProviderDTO update(Long id, ProviderDTO dto);
    void delete(Long id);
} 