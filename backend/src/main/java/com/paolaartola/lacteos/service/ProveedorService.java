package com.paolaartola.lacteos.service;

import com.paolaartola.lacteos.dto.ProveedorDTO;

import java.util.List;

public interface ProveedorService {
    List<ProveedorDTO> all();
    ProveedorDTO findById(Long id);
    ProveedorDTO create(ProveedorDTO dto);
    ProveedorDTO update(Long id, ProveedorDTO dto);
    void delete(Long id);
} 