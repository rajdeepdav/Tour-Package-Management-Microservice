package com.example.tourbackend.controller;

import com.example.tourbackend.entity.TourPackage;
import com.example.tourbackend.repository.TourPackageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
public class TourPackageController {

    private final TourPackageRepository repository;

    public TourPackageController(TourPackageRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public TourPackage create(@RequestBody TourPackage tourPackage) {
        return repository.save(tourPackage);
    }

    @GetMapping
    public List<TourPackage> getAll(@RequestParam(required = false) String location) {
        if (location != null) {
            return repository.findByLocationContainingIgnoreCase(location);
        }
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourPackage> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
