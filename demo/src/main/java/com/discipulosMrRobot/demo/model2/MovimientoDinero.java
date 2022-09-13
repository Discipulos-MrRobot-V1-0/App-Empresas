package com.discipulosMrRobot.demo.model2;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Data
@Entity
@Table(name = "MovimientoDinero")
public class MovimientoDinero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMovimiento;

    @OneToMany
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;

    @OneToMany
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @Column(length = 20,nullable = false)
    private int monto;

    @Column(length = 50,nullable = false)
    private String concepto;

}
