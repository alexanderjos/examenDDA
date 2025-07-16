package com.valverde.infraccionservice.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "infracciones")
public class Infraccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String dni;
    @Column(nullable = false)
    private String fecha;
    @Column(nullable = false)
    private String tipoInfraccion;
    @Column(nullable = false)
    private String ubicacion;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private Double montoMulta;
    @Column(nullable = false)
    private String estado;

}
