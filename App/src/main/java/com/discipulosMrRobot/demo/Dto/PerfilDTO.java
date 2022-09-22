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
public class PerfilDTO {
    private Integer idPerfil;
    private String idEmpleado;
    private String imagen;
    private String telefono;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}
