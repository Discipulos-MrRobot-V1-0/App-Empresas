package com.DiscipulosMrRobot.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="Empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdEmpresa;

    @Column(length = 50,nullable = false)
    private String nombreEmpresa;

    @Column(length = 50,nullable = false)
    private String direccion;

    @Column(length = 50,nullable = false)
    private String telefono;

    @Column(length = 50,nullable = false)
    private String nit;
}
