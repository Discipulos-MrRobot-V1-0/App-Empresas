package com.discipulosMrRobot.demo.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpresaDTO {
    private Integer idEmpresa;
    private String nombreEmpresa;
    private String direccion;
    private String telefono;
    private String nit;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    //private List<Empleado> empleados;
}
