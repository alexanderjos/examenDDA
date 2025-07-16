package com.valverde.infraccionservice.service;
import com.valverde.infraccionservice.entity.Infraccion;
import org.springframework.data.domain.Pageable;
import java.util.List;
public interface InfraccionService {
    public List<Infraccion> getAll(Pageable pageable);
    public Infraccion getById(int id);
    public List<Infraccion> getByDni(String dni, Pageable pageable);
    public Infraccion create(Infraccion infraccion);
    public Infraccion update(Infraccion infraccion);
    public void delete(int id);
}
