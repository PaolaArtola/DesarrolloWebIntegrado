package com.paolaartola.lacteos.business;

import com.paolaartola.lacteos.entity.Provider;
import com.paolaartola.lacteos.repository.ProviderRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProviderManager {
    private final ProviderRepository providerRepository;

    public ProviderManager(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public List<Provider> all() {
        return providerRepository.findAll();
    }

    public Optional<Provider> findById(Long id) {
        return providerRepository.findById(id);
    }

    public Provider create(Provider provider) {
        return providerRepository.save(provider);
    }

    public Optional<Provider> update(Long id, Provider data) {
        return providerRepository.findById(id).map(actual -> {
            actual.setName(data.getName());
            actual.setContact(data.getContact());
            actual.setPhone(data.getPhone());
            return providerRepository.save(actual);
        });
    }

    public void delete(Long id) {
        providerRepository.deleteById(id);
    }
} 