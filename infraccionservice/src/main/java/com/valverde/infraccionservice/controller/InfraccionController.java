package com.valverde.infraccionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valverde.infraccionservice.entity.Infraccion;
import com.valverde.infraccionservice.service.InfraccionService;

@RestController
@RequestMapping("infracciones")
public class InfraccionController {
    @Autowired
    private InfraccionService infraccionService;

    @GetMapping
    public ResponseEntity<List<Infraccion>> getAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Infraccion> infracciones = infraccionService.getAll(pageable);
        return new ResponseEntity<>(infracciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Infraccion> getById(@PathVariable(name = "id") int id) {
        Infraccion infraccion = infraccionService.getById(id);
        return new ResponseEntity<>(infraccion, HttpStatus.OK);
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<?> getByDni(
            @PathVariable(name = "dni") String dni,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            List<Infraccion> infracciones = infraccionService.getByDni(dni, pageable);
            return new ResponseEntity<>(infracciones, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Infraccion> create(@RequestBody Infraccion infraccion) {
        Infraccion createdInfraccion = infraccionService.create(infraccion);
        return new ResponseEntity<>(createdInfraccion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Infraccion> update(@PathVariable(name = "id") int id, @RequestBody Infraccion infraccion) {
        infraccion.setId(id);
        Infraccion updatedInfraccion = infraccionService.update(infraccion);
        return new ResponseEntity<>(updatedInfraccion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") int id) {
        infraccionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
