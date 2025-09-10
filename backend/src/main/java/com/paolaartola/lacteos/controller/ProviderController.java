package com.paolaartola.lacteos.controller;

import com.paolaartola.lacteos.dto.ProveedorDTO;
import com.paolaartola.lacteos.service.ProveedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {
    private final ProveedorService proveedorService;

    public ProviderController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public List<ProveedorDTO> all() {
        return proveedorService.all();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorDTO> findById(@PathVariable Long id) {
        ProveedorDTO dto = proveedorService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProveedorDTO> create(@RequestBody ProveedorDTO dto) {
        ProveedorDTO created = proveedorService.create(dto);
        return ResponseEntity.created(URI.create("/api/providers/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDTO> update(@PathVariable Long id, @RequestBody ProveedorDTO dto) {
        ProveedorDTO updated = proveedorService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        proveedorService.delete(id);
        return ResponseEntity.noContent().build();
    }
} 