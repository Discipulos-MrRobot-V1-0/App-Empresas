package com.discipulosMrRobot.demo.model2;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Data
@Entity
@Table(name = "Empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpresa;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_movimiento", nullable = false)
    private MovimientoDinero movimiento;

    @Column(length = 50,nullable = false)
    private String nombreEmpresa;

    @Column(length = 30,nullable = false)
    private String direccion;

    @Column(length = 20,nullable = false)
    private String telefono;

    @Column(length = 20,nullable = false)
    private String nit;

}

