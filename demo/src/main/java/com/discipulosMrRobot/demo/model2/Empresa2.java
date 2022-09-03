package com.discipulosMrRobot.demo.model2;

import lombok.Data;

import javax.persistence.*;

@Data

public class Empresa2 {
    @Id
    private int idEmpresa;
    @Column(length = 50,nullable = false)
    private String nombreEmpresa;
    @Column(length = 30,nullable = false)
    private String direccion;
    @Column(length = 20,nullable = false)
    private String telefono;
    @Column(length = 20,nullable = false)
    private String nit;

}

