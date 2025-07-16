package com.valverde.infraccionservice.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.valverde.infraccionservice.entity.Infraccion;
import com.valverde.infraccionservice.repository.InfraccionRepository;
import com.valverde.infraccionservice.service.InfraccionService;

@Service
public class InfraccionServiceImpl implements InfraccionService {
    @Autowired
    private InfraccionRepository infraccionRepository;

    @Override
    public List<Infraccion> getAll(Pageable pageable) {
        try {
            List<Infraccion> registros = infraccionRepository.findAll(pageable).getContent();
            return registros;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Infraccion getById(int id) {
        try {
            Infraccion registro = infraccionRepository.findById(id).orElseThrow();
            return registro;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Infraccion> getByDni(String dni, Pageable pageable) {
        List<Infraccion> registros = infraccionRepository.findByDni(dni, pageable);
        if (registros.isEmpty()) {
            // Solo lanza la excepción con el mensaje que tú quieres
            throw new RuntimeException("No se encontraron infracciones para el DNI: " + dni);
        }
        return registros;
    }



    @Override
    public Infraccion create(Infraccion infraccion) {
        try {
            Infraccion registro = infraccionRepository.save(infraccion);
            return registro;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Infraccion update(Infraccion infraccion) {
        try {
            Infraccion registro = infraccionRepository.findById(infraccion.getId()).orElseThrow();
            registro.setDni(infraccion.getDni());
            registro.setDescripcion(infraccion.getDescripcion());
            registro.setFecha(infraccion.getFecha());
            registro.setEstado(infraccion.getEstado());
            registro.setMontoMulta(infraccion.getMontoMulta());
            registro.setTipoInfraccion(infraccion.getTipoInfraccion());
            registro.setUbicacion(infraccion.getUbicacion());
            infraccionRepository.save(registro);
            return registro;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(int id) {
        try {
            infraccionRepository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
