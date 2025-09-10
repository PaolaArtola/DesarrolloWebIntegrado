package com.paolaartola.lacteos.service.impl;

import com.paolaartola.lacteos.business.ProviderManager;
import com.paolaartola.lacteos.dto.ProviderDTO;
import com.paolaartola.lacteos.entity.Provider;
import com.paolaartola.lacteos.service.ProviderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProviderServiceImpl implements ProviderService {
    private final ProviderManager providerManager;

    public ProviderServiceImpl(ProviderManager providerManager) {
        this.providerManager = providerManager;
    }

    @Override
    public List<ProviderDTO> all() {
        return providerManager.all().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ProviderDTO findById(Long id) {
        Optional<Provider> opt = providerManager.findById(id);
        return opt.map(this::toDto).orElse(null);
    }

    @Override
    public ProviderDTO create(ProviderDTO dto) {
        Provider created = providerManager.create(toEntity(dto));
        return toDto(created);
    }

    @Override
    public ProviderDTO update(Long id, ProviderDTO dto) {
        return providerManager.update(id, toEntity(dto)).map(this::toDto).orElse(null);
    }

    @Override
    public void delete(Long id) {
        providerManager.delete(id);
    }

    private ProviderDTO toDto(Provider entity) {
        ProviderDTO dto = new ProviderDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setContact(entity.getContact());
        dto.setPhone(entity.getPhone());
        return dto;
    }

    private Provider toEntity(ProviderDTO dto) {
        Provider entity = new Provider();
        entity.setName(dto.getName());
        entity.setContact(dto.getContact());
        entity.setPhone(dto.getPhone());
        return entity;
    }
} 