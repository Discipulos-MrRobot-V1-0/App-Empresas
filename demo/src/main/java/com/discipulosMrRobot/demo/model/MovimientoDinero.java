package com.DiscipulosMrRobot.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="movimientoDinero")
public class MovimientoDinero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdMovimientoDinero;

    @ManyToOne
    @JoinColumn(name = "id_empresa",nullable = false)
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @Column(length = 100,nullable = false)
    private float monto;

    @Column(length = 150,nullable = false)
    private String concepto;

}
