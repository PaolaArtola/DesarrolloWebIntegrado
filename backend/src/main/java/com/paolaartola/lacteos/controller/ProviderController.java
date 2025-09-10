package com.paolaartola.lacteos.controller;

import com.paolaartola.lacteos.dto.ProviderDTO;
import com.paolaartola.lacteos.service.ProviderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {
    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping
    public List<ProviderDTO> all() {
        return providerService.all();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderDTO> findById(@PathVariable Long id) {
        ProviderDTO dto = providerService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProviderDTO> create(@RequestBody ProviderDTO dto) {
        ProviderDTO created = providerService.create(dto);
        return ResponseEntity.created(URI.create("/api/providers/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProviderDTO> update(@PathVariable Long id, @RequestBody ProviderDTO dto) {
        ProviderDTO updated = providerService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        providerService.delete(id);
        return ResponseEntity.noContent().build();
    }
} 