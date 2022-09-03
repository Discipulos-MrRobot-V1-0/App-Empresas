package com.discipulosMrRobot.demo.model2;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Data
@Entity
@Table(name = "Empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleado;

    @Column(length = 60,nullable = false)
    private String nombre;

    @Column(length = 50,nullable = false)
    private String correo;

    @Column(length = 50,nullable = false)
    private String empresa;

    @Column(length = 50,nullable = false)
    private String rol;

}
