package model;

import lombok.Data;

import javax.persistence.*;

public class Empresa {
    @Id@Data
    @Entity
    @Table(name="Empresa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpresa;
    @Column(length = 50,nullable = false)
    private String nombreEmpresa;
    @Column(length = 50,nullable = false)
    private String direccion;
    @Column(length = 50,nullable = false)
    private String telefono;
    @Column(length = 50,nullable = false)
    private String nit;


}
