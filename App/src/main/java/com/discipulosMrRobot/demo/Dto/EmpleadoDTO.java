package com.discipulosMrRobot.demo.Dto;

import com.discipulosMrRobot.demo.model.Rol;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpleadoDTO {
    private Integer idEmpleado;
    private Rol rol;
    private Integer idEmpresa;
    private String nombre;
    private String correo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}
