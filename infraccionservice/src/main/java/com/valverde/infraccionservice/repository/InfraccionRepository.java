package com.valverde.infraccionservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.domain.Pageable;
import com.valverde.infraccionservice.entity.Infraccion;
@Repository
public interface InfraccionRepository extends JpaRepository <Infraccion, Integer>{
    //buscar por dni
    List<Infraccion> findByDni(String dni, Pageable pageable);
}
