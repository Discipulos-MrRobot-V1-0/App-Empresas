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
public class MovimientoDTO {
    private Integer idMovimiento;
    private Integer idEmpresa;
    private Integer idEmpleado;
    private Integer monto;
    private String concepto;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}
