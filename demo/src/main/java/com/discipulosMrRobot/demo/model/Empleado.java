package com.DiscipulosMrRobot.demo.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="Empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdEmpleado;

    @ManyToOne
    @JoinColumn(name = "id_empresa",nullable = false)
    private Empresa empresa;

    @Column(length = 50,nullable = false)
    private String nombre;

    @Column(length = 50,nullable = false)
    private String correo;

    @Column(length = 50,nullable = false)
    private String rol;

}
