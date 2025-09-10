package com.paolaartola.lacteos.service.impl;

import com.paolaartola.lacteos.business.ProviderManager;
import com.paolaartola.lacteos.dto.ProveedorDTO;
import com.paolaartola.lacteos.entity.Provider;
import com.paolaartola.lacteos.service.ProveedorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProviderServiceImpl implements ProveedorService {
    private final ProviderManager providerManager;

    public ProviderServiceImpl(ProviderManager providerManager) {
        this.providerManager = providerManager;
    }

    @Override
    public List<ProveedorDTO> all() {
        return providerManager.all().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ProveedorDTO findById(Long id) {
        Optional<Provider> opt = providerManager.findById(id);
        return opt.map(this::toDto).orElse(null);
    }

    @Override
    public ProveedorDTO create(ProveedorDTO dto) {
        Provider created = providerManager.create(toEntity(dto));
        return toDto(created);
    }

    @Override
    public ProveedorDTO update(Long id, ProveedorDTO dto) {
        return providerManager.update(id, toEntity(dto)).map(this::toDto).orElse(null);
    }

    @Override
    public void delete(Long id) {
        providerManager.delete(id);
    }

    private ProveedorDTO toDto(Provider entity) {
        ProveedorDTO dto = new ProveedorDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getNombre());
        dto.setContact(entity.getContacto());
        dto.setPhone(entity.getTelefono());
        return dto;
    }

    private Provider toEntity(ProveedorDTO dto) {
        Provider entity = new Provider();
        entity.setNombre(dto.getName());
        entity.setContacto(dto.getContact());
        entity.setTelefono(dto.getPhone());
        return entity;
    }
} 