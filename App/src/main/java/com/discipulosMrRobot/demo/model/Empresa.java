package com.discipulosMrRobot.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpresa;

    @Column(length = 50,nullable = false)
    private String nombreEmpresa;

    @Column(length = 30,nullable = false)
    private String direccion;

    @Column(length = 20,nullable = false)
    private String telefono;

    @Column(length = 20,nullable = false)
    private String nit;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private LocalDateTime fechaModificacion;

    //@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    //private List<Empleado> empleados;

}

