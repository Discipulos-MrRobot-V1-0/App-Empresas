package com.DiscipulosMrRobot.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPerfil;

    @OneToOne
    @JoinColumn(name = "id_usuario",nullable = false)
    private Usuario usuario;

    @Column(length = 50,nullable = false)
    private String imagen;

    @Column(length = 50,nullable = false)
    private String telefono;



}
