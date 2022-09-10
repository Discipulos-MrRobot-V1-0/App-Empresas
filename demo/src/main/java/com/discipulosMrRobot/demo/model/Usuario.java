package com.DiscipulosMrRobot.demo.model;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Data
@Entity
@Table(name="Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdUsuario;

    @Column(length = 50,nullable = false)
    private String nombreUsuario;

    @Column(length = 50,nullable = false)
    private String contraseña;

    @Column(length = 30,nullable = false)
    private String rol;

}
